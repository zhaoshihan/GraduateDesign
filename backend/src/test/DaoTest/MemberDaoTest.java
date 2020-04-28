package DaoTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ssm.config.AppConfig;
import ssm.dao.IMemberDao;
import ssm.dao.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class MemberDaoTest {
    @Autowired
    private IMemberDao memberDao;

    @Test
    public void testSelect() {
        Member member = memberDao.getMemberById(1);
        assertEquals(member.getUsername(),"zhangsan");
        assertEquals(member.getPassword(), "123456");
        assertEquals(member.getNickname(), "张三");
        assertEquals(member.getGender(), "男");
        assertEquals(member.getCity(), "武汉");
        assertEquals(member.getAddress(), "洪山街道");
        assertEquals(member.getPostcode(), "430072");
        assertEquals(member.getPhoneNumber(), "15612345678");
        assertEquals(member.getEmail(), "zhangsan@qq.com");


        member = memberDao.getMemberByUsername("lisi");
        assertEquals(member.getId(), 2);
        assertEquals(member.getPassword(), "111111");
        assertEquals(member.getNickname(), "李四");
        assertEquals(member.getGender(), "女");
        assertEquals(member.getCity(), "北京");
        assertEquals(member.getAddress(), "长安街道");
        assertEquals(member.getPostcode(), "100010");
        assertEquals(member.getPhoneNumber(), "19312345678");
        assertEquals(member.getEmail(), "lisi@163.com");
    }

    @Test
    public void testAddMember() {
        Member member = new Member();
        member.setUsername("wangwu");
        member.setPassword("666666");
        member.setNickname("王五");
        member.setGender("男");
        member.setCity("上海");
        member.setAddress("浦东街道");
        member.setPostcode("200120");
        member.setPhoneNumber("13912345678");
        member.setEmail("wangwu@126.com");

        int influence_row = memberDao.addMember(member);
        assertEquals(influence_row, 1);

        long new_id = member.getId();

        member = memberDao.getMemberById(new_id);
        assertEquals(member.getUsername(), "wangwu");
    }

//    @Test
//    public void testGetAll(){
//        List<Member> members = memberDao.getAllMembers();
//        for(Member member:members)
//        {
//            System.out.println(member.getName());
//        }
//    }
//
//    @Test
//    public void testAdd()
//    {
//        Member member = new Member();
//        member.setId(100);
//        member.setName("hehe");
//        member.setGender('f');
//        member.setCity("Beijing");
//        member.setAddress("ChangAn Street");
//        member.setPostCode("12345678");
//        member.setPhoneNumber("12345678");
//        member.setEmail("7777@qq.com");
//        member.setAccount("test");
//        member.setPassWord("123");
//        memberDao.addMember(member);
//        Member selectMember = memberDao.getMemberById(100);
//        assertEquals(selectMember.getName(),"hehe");
//    }
//
//    @Test
//    public void testUpdate()
//    {
//        Member member = memberDao.getMemberById(1);
//        member.setPassWord("6666");
//        memberDao.updateMember(member);
//        Member newMember = memberDao.getMemberById(1);
//        assertEquals(newMember.getPassWord(), "6666");
//    }
//
//    @Test
//    public void testDelete()
//    {
//        Member member = memberDao.getMemberById(1);
//        memberDao.deleteMember(member);
//    }

}

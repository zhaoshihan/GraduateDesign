package DaoTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ssm.config.AppConfig;
import ssm.dao.IMemberDao;
import ssm.dao.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class MemberDaoTest {
    @Resource
    private IMemberDao memberDao;

    @Test
    public void testSelect() {
        Member member = memberDao.getMemberById(1);
        assertEquals("zhangsan", member.getUsername());
        assertEquals("123456", member.getPassword());
        assertEquals("张三", member.getNickname());
        assertEquals("男", member.getGender());
        assertEquals("武汉", member.getCity());
        assertEquals("洪山街道", member.getAddress());
        assertEquals("430072", member.getPostcode());
        assertEquals("15612345678", member.getPhoneNumber());
        assertEquals("zhangsan@qq.com", member.getEmail());


        member = memberDao.getMemberByUsername("lisi");
        assertEquals(2, member.getId());
        assertEquals("111111", member.getPassword());
        assertEquals("李四", member.getNickname());
        assertEquals("女", member.getGender());
        assertEquals("北京", member.getCity());
        assertEquals("长安街道", member.getAddress());
        assertEquals("100010", member.getPostcode());
        assertEquals("19312345678", member.getPhoneNumber());
        assertEquals("lisi@163.com", member.getEmail());
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
        assertEquals(1, influence_row);

        long new_id = member.getId();

        member = memberDao.getMemberById(new_id);
        assertEquals("wangwu", member.getUsername());
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

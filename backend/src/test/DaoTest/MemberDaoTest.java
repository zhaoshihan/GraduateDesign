package DaoTest;

import ssm.dao.IMemberDao;
import ssm.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
@Transactional
public class MemberDaoTest {
    @Autowired
    private IMemberDao memberDao;

    @Test
    public void testSelect()
    {
        Member member = memberDao.getMemberById(1);
        assertEquals(member.getUserName(),"test_user_name");
        member = memberDao.getMemberByUsername("test_user_name");
        assertEquals(member.getPassword(), "123456");
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
//        member.setPassword("123");
//        memberDao.addMember(member);
//        Member selectMember = memberDao.getMemberById(100);
//        assertEquals(selectMember.getName(),"hehe");
//    }
//
//    @Test
//    public void testUpdate()
//    {
//        Member member = memberDao.getMemberById(1);
//        member.setPassword("6666");
//        memberDao.updateMember(member);
//        Member newMember = memberDao.getMemberById(1);
//        assertEquals(newMember.getPassword(), "6666");
//    }
//
//    @Test
//    public void testDelete()
//    {
//        Member member = memberDao.getMemberById(1);
//        memberDao.deleteMember(member);
//    }

}

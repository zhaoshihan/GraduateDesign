package ServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import ssm.config.AppConfig;
import ssm.entity.Member;
import ssm.service.IMemberService;
import ssm.util.TokenUtil;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = { AppConfig.class },
        loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
@Transactional
public class MemberServiceTest {
    @Autowired
    private IMemberService memberService;

    @Test
    public void signTokenTest() {
        Member member = new Member();
        member.setUserName("test_user_name");
        member.setPassWord("123456");
        String token = memberService.signToken(member);
        assertNotEquals(token, null);

        System.out.println("generate token = " + token);

        String expected_token = TokenUtil.sign("test_user_name", "123456");

        assertEquals(token, expected_token);
    }


}
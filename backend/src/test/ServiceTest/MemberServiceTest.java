package ServiceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import ssm.config.AppConfig;
import ssm.dao.entity.Member;
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
        member.setId(100);
//        member.setPassword("123456");
        String token = memberService.signToken(member);
        assertNotEquals(null, token);

//        System.out.println("generate token = " + token);

        String expected_token = TokenUtil.sign(100);

        assertEquals(expected_token, token);
    }


}

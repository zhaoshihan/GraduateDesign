package DaoTest;

import ssm.dao.ICommentDao;
import ssm.entity.Comment;
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
public class CommentDaoTest {
    @Autowired
    private ICommentDao commentDao;

    @Test
    public void testSelect() {
        Comment comment = commentDao.getCommentById(1);
        assertEquals(comment.getGrade(), 2);

        comment = commentDao.getCommentById(2);
        assertEquals(comment.getContent(), "another test for content");
    }
}

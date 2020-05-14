package DaoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ssm.config.AppConfig;
import ssm.dao.ICommentDao;
import ssm.dao.entity.Comment;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class CommentDaoTest {
    @Resource
    ICommentDao commentDao;

    @Test
    public void selectComment() {
        Comment comment = commentDao.getCommentById(1, 1);
        assertEquals("我喜欢红楼梦", comment.getContent());
        assertEquals(5, comment.getGrade());

        List<Comment> commentList = commentDao.getRelatedCommentsByUserId(2);
        assertEquals(2, commentList.size());
    }

    @Test
    public void addComment() {
        Comment comment = new Comment();
        comment.setMemberID(1);
        comment.setBookID(10);
        comment.setContent("我喜欢普希金的诗歌");
        comment.setGrade((byte)5);

        commentDao.addComment(comment);

        Comment addedComment = commentDao.getCommentById(10, 1);

        assertEquals(comment.getContent(), addedComment.getContent());
        assertEquals(comment.getGrade(), addedComment.getGrade());
    }
}

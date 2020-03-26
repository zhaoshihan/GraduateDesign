package DaoTest;

import ssm.dao.IBookDao;
import ssm.entity.Book;
import ssm.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:old_config/spring-mybatis.xml"})
@Transactional
public class BookDaoTest {
    @Autowired
    private IBookDao bookDao;

    @Test
    public void testSelect() {
        Book book = bookDao.getBookById(1);
        assertEquals(book.getProfilePath(), "/test/book/profile_path");

        List<Comment> list = bookDao.getRelatedCommentsById(1);
        assertEquals(list.size(), 2);
    }
}

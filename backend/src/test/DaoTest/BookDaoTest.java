package DaoTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ssm.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.dao.IBookDao;
import ssm.dao.entity.Book;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
public class BookDaoTest {
    @Resource
    private IBookDao bookDao;

    private static final String DATE_PATTERN = "dd/MM/yyyy";

    @Test
    public void TestSelect() {
        Book book = bookDao.getBookById(1);

        assertEquals("红楼梦", book.getBookname());
        assertEquals("曹雪芹", book.getAuthor());
        assertEquals("古典文学", book.getCategory());
        assertEquals("中国", book.getNation());

        DateFormat format = new SimpleDateFormat(DATE_PATTERN);
        assertEquals(format.format(Date.valueOf("1791-01-01")), format.format(book.getPublishDate()));

        assertEquals(new BigDecimal("100.00"), book.getPrice());

        assertEquals(2, book.getCommentNumber());
    }

    @Test
    public void TestSelectAll() {
        List<Book> bookList = bookDao.getAllBooks();

        assertEquals(2, bookList.size());
    }
}

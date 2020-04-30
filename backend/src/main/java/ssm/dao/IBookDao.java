package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.dao.entity.Book;

import java.util.List;

@Repository
public interface IBookDao {
    Book getBookById(@Param("id") long id);
    List<Book> getAllBooks();
}

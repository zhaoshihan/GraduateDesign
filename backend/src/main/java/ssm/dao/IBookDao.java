package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.dao.entity.Book;
import ssm.dao.entity.Comment;

import java.util.List;

@Repository
public interface IBookDao {
    Book getBookById(@Param("id") int id);
    List<Comment> getRelatedCommentsById(@Param("id") int id);
}

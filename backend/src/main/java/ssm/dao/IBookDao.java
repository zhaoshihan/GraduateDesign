package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Book;
import ssm.entity.Comment;

import java.util.List;

@Repository
public interface IBookDao {
    Book getBookById(@Param("id") int id);
    List<Comment> getRelatedCommentsById(@Param("id") int id);
}

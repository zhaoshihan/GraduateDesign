package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.dao.entity.Comment;

import java.util.List;

@Repository
public interface ICommentDao {
    Comment getCommentById(@Param("bookId") long bookId, @Param("userId") long userId);

    List<Comment> getRelatedCommentsByUserId(@Param("userId") long userId);
}

package ssm.dao;

import org.apache.ibatis.annotations.Param;
import ssm.entity.Comment;

public interface ICommentDao {
    Comment getCommentById(@Param("bookId") int bookId, @Param("userId") int userId);

}

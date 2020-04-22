package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.entity.Comment;

@Repository
public interface ICommentDao {
    Comment getCommentById(@Param("bookId") int bookId, @Param("userId") int userId);

}

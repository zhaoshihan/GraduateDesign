package ssm.service.impl;
import org.springframework.stereotype.Service;
import ssm.dao.ICommentDao;
import ssm.dao.entity.Comment;
import ssm.service.ICommentService;

import javax.annotation.Resource;
import java.util.List;

@Service("CommentService")
public class CommentService implements ICommentService {
    @Resource
    private ICommentDao commentDao;

    @Override
    public Comment getCommentById(long bookId, long userId) {
        return commentDao.getCommentById(bookId, userId);
    }

    @Override
    public List<Comment> getRelatedCommentsByUserId(long userId) {
        return commentDao.getRelatedCommentsByUserId(userId);
    }

}

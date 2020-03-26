package ssm.service.impl;
import org.springframework.stereotype.Service;
import ssm.dao.ICommentDao;
import ssm.entity.Comment;
import ssm.service.ICommentService;

import javax.annotation.Resource;

@Service("CommentService")
public class CommentService implements ICommentService {
    @Resource
    private ICommentDao commentDao;

    @Override
    public Comment getCommentById(int bookId, int userId) {
        return commentDao.getCommentById(bookId, userId);
    }

}

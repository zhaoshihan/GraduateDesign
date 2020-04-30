package ssm.service;

import ssm.dao.entity.Comment;

import java.util.List;

public interface ICommentService {
    public Comment getCommentById(long bookId, long userId);
    public List<Comment> getRelatedCommentsByUserId(long userId);

}

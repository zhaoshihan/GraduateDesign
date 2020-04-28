package ssm.service;

import ssm.dao.entity.Comment;

public interface ICommentService {
    public Comment getCommentById(int bookId, int userId);

}

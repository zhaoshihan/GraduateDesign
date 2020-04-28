package ssm.service;

import ssm.dao.entity.Book;
import ssm.dao.entity.Comment;

import java.util.List;

public interface IBookService {
    public Book getBookById(int id);
    public List<Comment> getRelatedCommentsById(int id);
}

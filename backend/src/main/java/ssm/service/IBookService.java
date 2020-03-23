package ssm.service;

import ssm.entity.Book;
import ssm.entity.Comment;

import java.util.List;

public interface IBookService {
    public Book getBookById(int id);
    public List<Comment> getRelatedCommentsById(int id);
}

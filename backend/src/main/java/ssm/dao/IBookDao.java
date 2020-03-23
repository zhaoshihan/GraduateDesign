package ssm.dao;

import ssm.entity.Book;
import ssm.entity.Comment;

import java.util.List;

public interface IBookDao {
    Book getBookById(int id);
    List<Comment> getRelatedCommentsById(int id);
}

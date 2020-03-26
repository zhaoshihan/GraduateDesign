package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.IBookDao;
import ssm.entity.Book;
import ssm.entity.Comment;
import ssm.service.IBookService;

import javax.annotation.Resource;
import java.util.List;

@Service("BookService")
public class BookService implements IBookService {
    @Resource
    private IBookDao bookDao;


    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public List<Comment> getRelatedCommentsById(int id) {
        return bookDao.getRelatedCommentsById(id);
    }

}

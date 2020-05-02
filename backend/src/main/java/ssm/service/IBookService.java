package ssm.service;

import ssm.dao.entity.Book;

import java.util.List;

public interface IBookService {
    public Book getBookById(long id);

    public List<Book> getAllBooks();

//    public Map<String, Object> getLoginReturnMap(List<Book> bookList);

}

package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.IBookDao;
import ssm.dao.entity.Book;
import ssm.service.IBookService;

import javax.annotation.Resource;
import java.util.List;

@Service("BookService")
public class BookService implements IBookService {
    @Resource
    private IBookDao bookDao;

    @Override
    public Book getBookById(long id) {
        return bookDao.getBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

//    @Override
//    public Map<String, Object> getLoginReturnMap(List<Book> bookList) {
//        Map<String, Object> res = new HashMap<>();
//
//
////        JsonArrayBuilder res = Json.createArrayBuilder();
////        for(Book book : bookList) {
////            res.add(Json.createObjectBuilder()
////                    .add("id", book.getId())
////                    .add("bookname", book.getBookname())
////                    .add("author", book.getAuthor())
////                    .add("category", book.getCategory())
////                    .add("nation", book.getNation())
////                    .add("publishDate", book.getPublishDate().toString())
////                    .add("price", book.getPrice())
////                    .add("description", book.getDescription())
////
////                    .add("averageGrade", book.getAverageGrade())
////                    .add("commentNumber", book.getCommentNumber())
////            );
////        }
//
//        return res;
//    }

}

package ssm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ssm.dao.entity.Book;
import ssm.service.IBookService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:8080")
public class BookRestController {
    @Resource
    private IBookService bookService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity getBookList() {
        List<Book> bookList = bookService.getAllBooks();

        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
}

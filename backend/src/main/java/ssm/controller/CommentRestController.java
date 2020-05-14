package ssm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssm.dao.entity.Comment;
import ssm.service.ICommentService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:8080")
public class CommentRestController {
    @Resource
    ICommentService commentService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestBody Comment comment) {
        if (commentService.addComment(comment)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/{userID}", method = RequestMethod.GET)
    public ResponseEntity getCommentListByUserId(@PathVariable("userID") long userID) {
        List<Comment> commentList = commentService.getRelatedCommentsByUserId(userID);

        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }


}

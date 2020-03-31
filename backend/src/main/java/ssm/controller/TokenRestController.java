package ssm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ssm.util.TokenUtil;

@RestController
@RequestMapping("/token")
@CrossOrigin(origins = "*")
public class TokenRestController {

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity tokenCheck(@RequestHeader("auth_token") String auth) {
        System.out.println("auth string = " + auth);
        boolean result = TokenUtil.verify(auth);
        if (result) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}

package ssm.controller;

import ssm.dao.entity.Member;
import ssm.service.IMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080")
public class MemberRestController {
    @Resource
    private IMemberService memberService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity memberLogin(@RequestBody Member member){
        String username = member.getUsername();
        String password = member.getPassword();

        if(memberService.memberExist(username, password)){
            member = memberService.getMemberByUsername(username);

            String token = memberService.signToken(member);

            Map<String, Object> res = memberService.getLoginReturnMap(member, token);

            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity memberRegister(@RequestBody Member member){
        if (memberService.addMember(member)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else return new ResponseEntity(HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public ResponseEntity getCurrentUser(@RequestHeader(value = "Authorization") String token) {
        long userId = memberService.getUserIdFromToken(token);

        Member member = memberService.getMemberById(userId);

        if (member != null) {
            Map<String, Object> res = memberService.getRegetUserReturnMap(member);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        else return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

//    @RequestMapping(value="/query/{id}", method= RequestMethod.GET)
//    public ResponseEntity<Member> getMemberById(@PathVariable("id") int id) {
//        Member member = this.memberService.getMemberById(id);
//        if (member != null) {
//            return new ResponseEntity<>(member, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

//    @RequestMapping(value = "/query/all",method = RequestMethod.GET)
//    public ResponseEntity<List<Member>> getAllMembers(){
//        List<Member> members = memberService.getAllMembers();
//        if (members.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(members, HttpStatus.OK);
//    }
//
//    @RequestMapping(value="/add", method= RequestMethod.POST)
//    public ResponseEntity addMember(@RequestBody Member member) {
//        Member memberExist = memberService.getMemberById(member.getId());
//        if (memberExist != null) {
//            return  new ResponseEntity(HttpStatus.CONFLICT);
//        }else{
//            boolean result = memberService.addMember(member);
//            if (result){
//                return new ResponseEntity(HttpStatus.OK);
//            }
//            else{
//                return new ResponseEntity(HttpStatus.FORBIDDEN);
//            }
//        }
//    }
//
//    @RequestMapping(value="/delete", method= RequestMethod.POST)
//    public ResponseEntity deleteMember(@RequestBody Member member) {
//        Member memberExist = memberService.getMemberById(member.getId());
//        if (memberExist != null) {
//            boolean result = memberService.deleteMember(member);
//            if (result){
//                return new ResponseEntity(HttpStatus.OK);
//            }
//            else{
//                return new ResponseEntity(HttpStatus.FORBIDDEN);
//            }
//        } else {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public ResponseEntity updateMember(@RequestBody Member member){
//        Member currentMember = memberService.getMemberById(member.getId());
//        HttpStatus httpStatus;
//        if (currentMember != null) {
//            boolean result = memberService.updateMember(member);
//            if (result) {
//                httpStatus = HttpStatus.OK;
//            } else {
//                httpStatus = HttpStatus.FORBIDDEN;
//            }
//            return new ResponseEntity(httpStatus);
//        } else {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//    }
}

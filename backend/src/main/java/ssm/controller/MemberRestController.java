package ssm.controller;

import ssm.entity.Member;
import ssm.service.IMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "*")
public class MemberRestController {
    @Resource
    private IMemberService memberService;

//    private String[] getFromBASE64(String authorization){
//        if (authorization != null && authorization.toLowerCase().startsWith("basic")) {
//            // Authorization: Basic base64credentials
//            String base64Credentials = authorization.substring("Basic".length()).trim();
//            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
//            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
//            // credentials = username:password
//            return credentials.split(":", 2);
//        }
//        else return null;
//    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity<Member> checkMember(@RequestBody Member member){
        System.out.println("in check method");

        if (member != null){
            String username = member.getUserName();
            String password = member.getPassword();

            Member memberExist = this.memberService.getMemberByUsername(username);
            if(memberExist != null && password.equals(memberExist.getPassword())){
                memberExist.setUserName(null);
                memberExist.setPassword(null);
                return new ResponseEntity<>(memberExist, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value="/query/{id}", method= RequestMethod.GET)
    public ResponseEntity<Member> getMemberById(@PathVariable("id") int id) {
        Member member = this.memberService.getMemberById(id);
        if (member != null) {
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

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

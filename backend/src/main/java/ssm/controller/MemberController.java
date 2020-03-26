package ssm.controller;

import ssm.entity.Member;
import ssm.service.IMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
public class MemberController {
    @Resource
    private IMemberService memberService;

    @RequestMapping("/findMember")
    public String findMember(Model model){
        int id = 1;
        Member member = this.memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "index";
    }
}

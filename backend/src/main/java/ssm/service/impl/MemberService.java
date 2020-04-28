package ssm.service.impl;
import org.springframework.stereotype.Service;
import ssm.dao.IMemberDao;
import ssm.dao.entity.Member;
import ssm.service.IMemberService;
import ssm.util.TokenUtil;

import javax.annotation.Resource;

@Service("MemberService")
public class MemberService implements IMemberService {
    @Resource
    private IMemberDao memberDao;

    @Override
    public Member getMemberById(int id) {
        return memberDao.getMemberById(id);
    }

    @Override
    public Member getMemberByUsername(String username) {
        return memberDao.getMemberByUsername(username);
    }

    @Override
    public boolean memberExist(String username, String password) {
        Member existMember = memberDao.getMemberByUsername(username);
        return existMember != null && password.equals(existMember.getPassword());
    }

    @Override
    public String signToken(Member member) {
        if (member != null) {
            String username = member.getUsername();
            String password = member.getPassword();

            return TokenUtil.sign(username, password);
        }
        return null;
    }

    @Override
    public String getUserNameFromToken(String token) {
        if (TokenUtil.verify(token)) {
            return TokenUtil.getUserName(token);
        }
        return null;
    }

    @Override
    public boolean addMember(Member member) {
        return memberDao.addMember(member) > 0;
    }


//    @Override
//    public Member getMemberByAccount(String account){
//        return memberDao.getMemberByAccount(account);
//    }
//
//    @Override
//    public boolean addMember(Member member){
//        return memberDao.addMember(member) > 0;
//    }
//
//    @Override
//    public boolean updateMember(Member member){
//        return memberDao.updateMember(member) > 0;
//    }
//
//    @Override
//    public boolean deleteMember(Member member){
//        return memberDao.deleteMember(member) > 0;
//    }
//
//    @Override
//    public List<Member> getAllMembers(){
//        return memberDao.getAllMembers();
//    }
}

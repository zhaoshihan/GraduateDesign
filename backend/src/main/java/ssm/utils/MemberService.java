package ssm.utils;
import org.springframework.stereotype.Service;
import ssm.dao.IMemberDao;
import ssm.entity.Member;
import ssm.service.IMemberService;

import javax.annotation.Resource;

@Service("MemberService")
public class MemberService implements IMemberService {
    @Resource
    private IMemberDao memberDao;

    @Override
    public Member getMemberById(int id){
        return memberDao.getMemberById(id);
    }

    @Override
    public Member getMemberByUsername(String username) {
        return memberDao.getMemberByUsername(username);
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

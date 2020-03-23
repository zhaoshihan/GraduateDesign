package ssm.service;
import ssm.entity.Member;

import java.util.List;

public interface IMemberService {

    public Member getMemberById(int id);
    public Member getMemberByUsername(String username);
//    public Member getMemberByAccount(String account);
//    public List<Member> getAllMembers();
//    public boolean addMember(Member member);
//    public boolean updateMember(Member member);
//    public boolean deleteMember(Member member);
}

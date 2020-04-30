package ssm.service;
import ssm.dao.entity.Member;

import java.util.Map;

public interface IMemberService {

    public Member getMemberById(int id);

    public Member getMemberByUsername(String username);

    public boolean memberExist(String username, String password);

    public String signToken(Member member);

    public Map<String, Object> getReturnMapObject(Member member, String token);

    public String getUserNameFromToken(String token);

    public boolean addMember(Member member);

//    public Member getMemberByAccount(String account);
//    public List<Member> getAllMembers();
//    public boolean addMember(Member member);
//    public boolean updateMember(Member member);
//    public boolean deleteMember(Member member);
}

package ssm.service;
import ssm.dao.entity.Member;

import java.util.Map;

public interface IMemberService {

    public Member getMemberById(long id);

    public Member getMemberByUsername(String username);

    public boolean memberExist(String username, String password);

    public String signToken(Member member);

    public Map<String, Object> getLoginReturnMap(Member member, String token);

    public Map<String, Object> getRegetUserReturnMap(Member member);

    public long getUserIdFromToken(String token);

    public boolean addMember(Member member);

//    public Member getMemberByAccount(String account);
//    public List<Member> getAllMembers();
//    public boolean addMember(Member member);
//    public boolean updateMember(Member member);
//    public boolean deleteMember(Member member);
}

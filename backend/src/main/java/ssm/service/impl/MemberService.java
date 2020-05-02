package ssm.service.impl;
import org.springframework.stereotype.Service;
import ssm.dao.IMemberDao;
import ssm.dao.entity.Member;
import ssm.service.IMemberService;
import ssm.util.TokenUtil;

import javax.annotation.Resource;


//import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

@Service("MemberService")
public class MemberService implements IMemberService {
    @Resource
    private IMemberDao memberDao;

    @Override
    public Member getMemberById(long id) {
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
            long userId = member.getId();

            return TokenUtil.sign(userId);
        }
        return null;
    }

    @Override
    public Map<String, Object> getLoginReturnMap(Member member, String token) {
        Map<String, Object> res = new HashMap<>();

        res.put("token", token);
        Map<String, Object> user = getRegetUserReturnMap(member);

        res.put("user", user);

//        JsonObjectBuilder res = Json.createObjectBuilder();
//        res.add("token", token);
//        res.add("user", Json.createObjectBuilder()
//                .add("id", member.getId())
//                .add("nickname", member.getNickname())
//                .add("gender", member.getGender())
//                .add("city", member.getCity())
//                .add("address", member.getAddress())
//                .add("phoneNumber", member.getPhoneNumber())
//                .add("postcode", member.getPostcode())
//                .add("email", member.getEmail())
//        );

        return res;
    }

    @Override
    public Map<String, Object> getRegetUserReturnMap(Member member) {
        Map<String, Object> res = new HashMap<>();
        res.put("id", member.getId());
        res.put("nickname", member.getNickname());
        res.put("gender", member.getGender());
        res.put("city", member.getCity());
        res.put("address", member.getAddress());
        res.put("phoneNumber", member.getPhoneNumber());
        res.put("postcode", member.getPostcode());
        res.put("email", member.getEmail());

        return res;
    }

    @Override
    public long getUserIdFromToken(String token) {
        if (TokenUtil.verify(token)) {
            return TokenUtil.getUserId(token);
        }
        return -1;
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

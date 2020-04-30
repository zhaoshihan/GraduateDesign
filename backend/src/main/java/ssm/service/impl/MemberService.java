package ssm.service.impl;
import org.springframework.stereotype.Service;
import ssm.dao.IMemberDao;
import ssm.dao.entity.Member;
import ssm.service.IMemberService;
import ssm.util.TokenUtil;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

//import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

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

            return TokenUtil.sign(username);
        }
        return null;
    }

    @Override
    public Map<String, Object> getReturnMapObject(Member member, String token) {
        Map<String, Object> res = new HashMap<>();
        res.put("token", token);

        Map<String, Object> user = new HashMap<>();
        user.put("id", member.getId());
        user.put("nickname", member.getNickname());
        user.put("gender", member.getGender());
        user.put("city", member.getCity());
        user.put("address", member.getAddress());
        user.put("phoneNumber", member.getPhoneNumber());
        user.put("postcode", member.getPostcode());
        user.put("email", member.getEmail());

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

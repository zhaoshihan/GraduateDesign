package ssm.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String city;
    private String address;
    private String postcode;
    private String phoneNumber;
    private String email;
}

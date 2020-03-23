package ssm.entity;

public class Member {
    private String userName;
    private String password;
    private String nickName;
    private String profilePath;

    public Member() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user_name) {
        this.userName = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nick_name) {
        this.nickName = nick_name;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profile_path) {
        this.profilePath = profile_path;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", profilePath='" + profilePath + '\'' +
                '}';
    }
}

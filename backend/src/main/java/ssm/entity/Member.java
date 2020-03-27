package ssm.entity;

public class Member {
    private int id;
    private String userName;
    private String passWord;
    private String nickName;
    private String profilePath;

    public Member() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user_name) {
        this.userName = user_name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", profilePath='" + profilePath + '\'' +
                '}';
    }
}

package ssm.dao;


import org.apache.ibatis.annotations.Param;
import ssm.entity.Member;

public interface IMemberDao {
    Member getMemberById(@Param("id") int id);
    Member getMemberByUsername(@Param("username") String username);

    // 返回值int仍然为插入影响的行数，数据库内部自增id值被封装到参数对象中
    int addMember(@Param("member") Member member);
}

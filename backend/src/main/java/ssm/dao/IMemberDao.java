package ssm.dao;


import org.apache.ibatis.annotations.Param;
import ssm.entity.Member;

public interface IMemberDao {
    Member getMemberById(@Param("id") int id);
    Member getMemberByUsername(@Param("username") String username);
}

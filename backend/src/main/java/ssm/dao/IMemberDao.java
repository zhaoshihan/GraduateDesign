package ssm.dao;


import ssm.entity.Member;

public interface IMemberDao {
    Member getMemberById(int id);
    Member getMemberByUsername(String username);
}

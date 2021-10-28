package java5.assignment.dao;

import java.util.List;

import java5.assignment.entity.User;

public interface UserDAO {
	public List<User> getListUser();
	public boolean saveUser(User user);
	public boolean updateUser(User user);
	public void deleteUser(String id);
	public User detailUser(String id);
	public boolean checkId(String id);
}

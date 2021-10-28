package java5.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java5.assignment.dao.UserDAO;
import java5.assignment.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	public List<User> getListUser(){
		return userDAO.getListUser();
	}
	public boolean saveUser(User user) {
		return userDAO.saveUser(user);
	}
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}
	public void deleteUser(String id) {
		userDAO.deleteUser(id);
	}
	public User detailUser(String id) {
		return userDAO.detailUser(id);
	}
	public boolean checkId(String id) {
		return userDAO.checkId(id);
	}
}

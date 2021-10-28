package java5.assignment.test;

import static org.testng.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java5.assignment.dao.StaffDAO;
import java5.assignment.dao.UserDAO;
import java5.assignment.entity.Staff;
import java5.assignment.entity.User;

@ContextConfiguration(locations = { 
		"spring-config-dao.xml",
		"spring-config-hibernate.xml"
})
public class UserDAOTest extends AbstractTestNGSpringContextTests{
	private User user;
	
	@Autowired
	private UserDAO userDAO;
	
	@BeforeTest
	static public void setUpBeforeClass() throws Exception {
		
	}
//
	@AfterTest
	static public void tearDownAfterClass() throws Exception {
	}
	@BeforeMethod
	public void beforeMethod() {
		user = new User();
	}
	@Parameters({"username", "password", "fullname"})
	@Test
	public void addUser1(@Optional() String username, @Optional String password, @Optional String fullname,
			@Optional String expected) {
		boolean actual;
		user.setUsername(username);
		user.setPassword(password);
		user.setFullname(fullname);
		
		actual = userDAO.saveUser(user);
		assertEquals(actual, expected);
		
	}
	@AfterMethod
	public void afterMethod() {
		try {
			userDAO.deleteUser(user.getUsername());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

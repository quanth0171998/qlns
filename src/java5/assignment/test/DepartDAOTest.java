package java5.assignment.test;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import java5.assignment.dao.DepartDAO;
import java5.assignment.entity.Depart;
import java5.assignment.entity.Staff;

@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class DepartDAOTest extends AbstractTestNGSpringContextTests{
	private Depart depart;
	
	@Autowired
	private DepartDAO departDAO;
	
	@BeforeTest
	public void setUp() {

	}

	@AfterTest
	public void tearDown() {

	}

	@BeforeMethod
	public void beforeMethod() {
		depart = new Depart();
	}

	@AfterMethod()
	public void AfterMethod() {
		try {
			departDAO.deleteDepart(depart.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// kiem tra truong ma nhan vien

	@Parameters({ "id", "name", 
			"expected" })
	@Test(description = "Kiem tra truong ma phòng ban")
	public void addStaff1(@Optional() String id, @Optional() String name, @Optional() boolean expected)
			throws ParseException {
		boolean actual;
		depart.setId(id);
		depart.setName(name);
		actual = departDAO.insertDepart(depart);
		assertEquals(actual, expected);
	}
	public Date ConversionStringtoSqlDate(String date) throws ParseException {
		try {
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy"); // New Pattern
			java.util.Date dateutil = sdf1.parse(date); // Returns a Date format object with the pattern
			java.sql.Date sqlStartDate = new java.sql.Date(dateutil.getTime());
			return sqlStartDate;
		} catch (Exception e) {
			return null;
		}
		
	}
}

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

import java5.assignment.dao.StaffDAO;
import java5.assignment.entity.Depart;
import java5.assignment.entity.Staff;

@ContextConfiguration(locations = { "spring-config-dao.xml", "spring-config-hibernate.xml" })
public class StaffDAOTest extends AbstractTestNGSpringContextTests {
	private Staff staff;
	@Autowired
	private StaffDAO staffDAO;

	@BeforeTest
	public void setUp() {

	}

	@AfterTest
	public void tearDown() {

	}

	@BeforeMethod
	public void beforeMethod() {
		staff = new Staff();
		staff.setGender(true);
		staff.setNotes("chưa có nhận xét");
		staff.setSalary(10000f);
	}

	@AfterMethod()
	public void AfterMethod() {
		try {
			staffDAO.deleteStaff(staff.getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// kiem tra truong ma nhan vien

	@Parameters({ "id", "name", "gender", "birthday", "photo", "email", "phone", "salary", "notes", "departId",
			"expected" })
	@Test(description = "Kiem tra truong ma nhan vien")
	public void addStaff1(@Optional() String id, @Optional() String name, @Optional() boolean gender,
			@Optional() String birthday, @Optional() String photo, @Optional() String email, @Optional String phone,
			@Optional() Float salary, @Optional() String notes, @Optional String departId, @Optional() boolean expected)
			throws ParseException {
		boolean actual;
		staff.setId(id);
		staff.setName(name);
		staff.setGender(gender);
		staff.setBirthday(new Date(birthday));
		staff.setPhoto(photo);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setSalary(salary);
		staff.setNotes(notes);
		staff.setDepart(new Depart(departId));
		actual = staffDAO.insertStaff(staff);
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

	// kiem tra truong email
	@Parameters({ "id", "name", "gender", "birthday", "photo", "email", "phone", "salary", "notes", "departId",
			"expected" })
	@Test(description = "Kiem tra truong ma nhan vien")
	public void addStaff2(@Optional() String id, @Optional() String name, @Optional() boolean gender,
			@Optional() String birthday, @Optional() String photo, @Optional() String email, @Optional String phone,
			@Optional() Float salary, @Optional() String notes, @Optional String departId, @Optional() boolean expected)
			throws ParseException {
		boolean actual;
		staff.setId(id);
		staff.setName(name);
		staff.setGender(gender);
		staff.setBirthday(new Date(birthday));
		staff.setPhoto(photo);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setSalary(salary);
		staff.setNotes(notes);
		staff.setDepart(new Depart(departId));
		actual = staffDAO.insertStaff(staff);
		assertEquals(actual, expected);
	}

	// kiem tra truong sdt
	@Parameters({ "id", "name", "gender", "birthday", "photo", "email", "phone", "salary", "notes", "departId",
			"expected" })
	@Test(description = "Kiem tra so dien thoai")
	public void addStaff3(@Optional() String id, @Optional() String name, @Optional() boolean gender,
			@Optional() String birthday, @Optional() String photo, @Optional() String email, @Optional String phone,
			@Optional() Float salary, @Optional() String notes, @Optional String departId, @Optional() boolean expected)
			throws ParseException {
		boolean actual;
		staff.setId(id);
		staff.setName(name);
		staff.setGender(gender);
		staff.setBirthday(new Date(birthday));
		staff.setPhoto(photo);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setSalary(salary);
		staff.setNotes(notes);
		staff.setDepart(new Depart(departId));
		actual = staffDAO.insertStaff(staff);
		long idThread = Thread.currentThread().getId();
		System.out.println(idThread);
		assertEquals(actual, expected);
	}

	// kiem tra truong lương
	@Parameters({ "id", "name", "gender", "birthday", "photo", "email", "phone", "salary", "notes", "departId",
			"expected" })
	@Test(description = "Kiem tra luong")
	public void addStaff4(@Optional() String id, @Optional() String name, @Optional() boolean gender,
			@Optional() String birthday, @Optional() String photo, @Optional() String email, @Optional String phone,
			@Optional() Float salary, @Optional() String notes, @Optional String departId, @Optional() boolean expected)
			throws ParseException {
		boolean actual;
		staff.setId(id);
		staff.setName(name);
		staff.setGender(gender);
		staff.setBirthday(new Date(birthday));
		staff.setPhoto(photo);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setSalary(salary);
		staff.setNotes(notes);
		staff.setDepart(new Depart(departId));
		actual = staffDAO.insertStaff(staff);
		long idThread = Thread.currentThread().getId();
		System.out.println(idThread);
		assertEquals(actual, expected);
	}

	// Kiểm tra lương là chữ
	@Parameters({ "id", "name", "gender", "birthday", "photo", "email", "phone", "salary", "notes", "departId",
			"expected" })
	@Test(description = "Kiem tra luong", expectedExceptions = { NumberFormatException.class })
	public void addStaff5(@Optional() String id, @Optional() String name, @Optional() boolean gender,
			@Optional() String birthday, @Optional() String photo, @Optional() String email, @Optional String phone,
			@Optional() Float salary, @Optional() String notes, @Optional String departId, @Optional() boolean expected)
			throws ParseException {
		boolean actual;
		staff.setId(id);
		staff.setName(name);
		staff.setGender(gender);
		staff.setBirthday(new Date(birthday));
		staff.setPhoto(photo);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setSalary(salary);
		staff.setNotes(notes);
		staff.setDepart(new Depart(departId));
		actual = staffDAO.insertStaff(staff);
		long idThread = Thread.currentThread().getId();
		System.out.println(idThread);
		assertEquals(actual, expected);
	}

	// Kiểm tra trường mã phòng ban
	@Parameters({ "id", "name", "gender", "birthday", "photo", "email", "phone", "salary", "notes", "departId",
			"expected" })
	@Test(description = "Kiem tra luong")
	public void addStaff6(@Optional() String id, @Optional() String name, @Optional() String gender,
			@Optional() String birthday, @Optional() String photo, @Optional() String email, @Optional String phone,
			@Optional() Float salary, @Optional() String notes, @Optional String departId, @Optional() boolean expected)
			throws ParseException {
		boolean actual;
		staff.setId(id);
		staff.setName(name);
		staff.setGender(true);
		staff.setBirthday(new Date(birthday));
		staff.setPhoto(photo);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setSalary(salary);
		staff.setNotes(notes);
		staff.setDepart(new Depart(departId));
		actual = staffDAO.insertStaff(staff);
		long idThread = Thread.currentThread().getId();
		System.out.println(idThread);
		assertEquals(actual, expected);
	}

	// bảng quyết định 24 trở đi
	@Parameters({ "id", "name", "birthday", "photo", "email", "phone", "departId", "expected" })
	@Test(description = "Kiem tra luong")
	public void addStaff7(@Optional() String id, @Optional() String name, 
			@Optional() String birthday, @Optional() String photo,
			@Optional() String email, @Optional String phone,
			@Optional String departId, @Optional() boolean expected)
			throws ParseException {
		boolean actual;
		staff.setId(id);
		staff.setName(name);
		staff.setBirthday(ConversionStringtoSqlDate(birthday));
		staff.setPhoto(photo);
		staff.setEmail(email);
		staff.setPhone(phone);
		staff.setDepart(new Depart(departId));
		actual = staffDAO.insertStaff(staff);
		long idThread = Thread.currentThread().getId();
		System.out.println(idThread);
		assertEquals(actual, expected);
	}
}

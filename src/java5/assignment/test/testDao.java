package java5.assignment.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import java5.assignment.dao.StaffDAO;
import java5.assignment.dao.impl.StaffDAOImpl;
import java5.assignment.entity.Depart;
import java5.assignment.entity.Staff;

public class testDao {
	public static void main(String[] args) {
		Staff s = new Staff();
		s.setId("NV08");
		s.setName("Trịnh Hoàng Quân");
		s.setBirthday(new Date("01/07/1998"));
		s.setEmail("quanthph08983@fpt.edu.vn");
		s.setPhoto("user.jpg");
		s.setPhone("0976707569");
		s.setDepart(new Depart("NS"));
		StaffDAOImpl staff = new StaffDAOImpl();
		staff.insertStaff(s);
	}
}

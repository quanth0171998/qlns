package java5.assignment.dao;

import java.util.List;

import java5.assignment.entity.Depart;
import java5.assignment.entity.Staff;

public interface StaffDAO {
	public List<Staff> getListStaff();
	public boolean insertStaff(Staff staff);
	public List<Depart> getDeparts();
	public Staff detailStaff(String id);
	public boolean updateStaff(Staff staff);
	public void deleteStaff(String id);
	public boolean checkId(String id);
//	public void sendMail(String from, String to, String subject, String body);
	public List<Staff> search(String name);
}

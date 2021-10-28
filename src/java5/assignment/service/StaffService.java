package java5.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java5.assignment.dao.StaffDAO;
import java5.assignment.entity.Depart;
import java5.assignment.entity.Staff;

@Service
public class StaffService {
	@Autowired
	private StaffDAO staffDAO;
	
	public List<Staff> getListStaff(){
		return staffDAO.getListStaff();
	}
	public boolean insertStaff(Staff staff) {
		return staffDAO.insertStaff(staff);
	}
	public List<Depart> getDeparts(){
		return staffDAO.getDeparts();
	}
	public Staff detailStaff(String id) {
		return staffDAO.detailStaff(id);
	}
	public boolean updateStaff(Staff staff) {
		return staffDAO.updateStaff(staff);
	}
	public void deleteStaff(String id) {
		staffDAO.deleteStaff(id);
	}
	public boolean checkId(String id) {
		return staffDAO.checkId(id);
	}
	public List<Staff> search(String name){
		return staffDAO.search(name);
	}
}

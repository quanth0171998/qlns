package java5.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java5.assignment.dao.DepartDAO;
import java5.assignment.entity.Depart;

@Service
public class DepartService {
	@Autowired
	private DepartDAO departDAO;
	
	
	public List<Depart> getListDepart(){
		List<Depart> list = departDAO.getListDepart();
		return list;
	}
	public Depart detailDepart(String id) {
		Depart depart = departDAO.detailDepart(id);
		return depart;
	}
	public boolean insertDepart(Depart depart) {
		return departDAO.insertDepart(depart);
	}
	public boolean updateDepart(Depart depart) {
		return departDAO.updateDepart(depart);
	}
	public void deleteDepart(String id) {
		departDAO.deleteDepart(id);
	}
	public boolean checkId(String id) {
		return departDAO.checkId(id);
	}
	public List<Depart> search(String name){
		List<Depart> list = departDAO.search(name);
		return list;
	}
	public boolean checkStaffDepart(String id) {
		return departDAO.checkStaffDepart(id);
	}
}

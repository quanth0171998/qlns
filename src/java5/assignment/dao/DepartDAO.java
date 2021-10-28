package java5.assignment.dao;

import java.util.List;

import java5.assignment.entity.Depart;
import java5.assignment.entity.Staff;

public interface DepartDAO {
	public List<Depart> getListDepart();
	public Depart detailDepart(String id);
	public boolean insertDepart(Depart depart);
	public boolean updateDepart(Depart depart);
	public void deleteDepart(String id);
	public boolean checkId(String id);
	public List<Depart> search(String name);
	public boolean checkStaffDepart(String id);
}

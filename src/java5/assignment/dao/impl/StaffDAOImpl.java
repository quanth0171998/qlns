package java5.assignment.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java5.assignment.dao.StaffDAO;
import java5.assignment.entity.Depart;
import java5.assignment.entity.Staff;
import java5.assignment.model.XMailler;


@Transactional
@Repository
public class StaffDAOImpl implements StaffDAO{
	@Autowired
	SessionFactory factory;
//	@Autowired
//	XMailler mailer;
//	
	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> getListStaff() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Depart> getDeparts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		return list;
	}
	@Override
	public boolean insertStaff(Staff staff) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(staff);
			t.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			t.rollback();
			return false;
		}
		finally {
			session.close();
		}
	}
	@Override
	public Staff detailStaff(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Staff staff = (Staff)session.get(Staff.class, id);
		return staff;
	}
	@Override
	public boolean updateStaff(Staff staff) {
		Session session =factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(staff);
			t.commit();
			return true;
		} catch (Exception e) {
			t.rollback();
			return false;
		}
		finally {
			session.close();
		}
	}
	@Override
	public void deleteStaff(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Staff staff = (Staff) session.get(Staff.class, id);
		session.delete(staff);
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkId(String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff where id = '"+id+"'";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		if(list.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
//	@Override
//	public void sendMail(String from, String to, String subject, String body) {
//		// TODO Auto-generated method stub
//		try {
//			mailer.send(from, to, subject, body);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	//search
	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> search(String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff where name like '"+name+"%'";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}
}

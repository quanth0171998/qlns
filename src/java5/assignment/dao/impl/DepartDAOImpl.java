package java5.assignment.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java5.assignment.dao.DepartDAO;
import java5.assignment.entity.Depart;
import java5.assignment.entity.Staff;

@Transactional
@Repository
public class DepartDAOImpl implements DepartDAO{
	@Autowired
	SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Depart> getListDepart() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart";
		Query query= session.createQuery(hql);
		List<Depart> list = query.list();
		return list;
	}
	@Override
	public boolean insertDepart(Depart depart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(depart);
			t.commit();
			return true;
		} catch (Exception e) {
			t.rollback();
			return false;
		}finally {
			session.close();
		}
	}
	@Override
	public Depart detailDepart(String id) {
		Session session = factory.getCurrentSession();
		Depart depart = (Depart) session.get(Depart.class, id);
		return depart;
	}
	@Override
	public boolean updateDepart(Depart depart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(depart);
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
	public void deleteDepart(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Depart depart = (Depart) session.get(Depart.class, id);
		session.delete(depart);
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkId(String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart where id='"+id+"'";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		if(list.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Depart> search(String name) {
		Session session = factory.getCurrentSession();
		String hql="FROM Depart where name like '"+name+"%'";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		return list;
	}
	@Override
	public boolean checkStaffDepart(String id) {
		Session session = factory.getCurrentSession();
//		String hql="FROM Staff where depart.id in (SELECT id from Depart where id='"+id+"')";
		String hql= "SELECT staffs FROM Depart d where d.id='"+id+"'";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		if(list.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
}

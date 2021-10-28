package java5.assignment.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java5.assignment.dao.UserDAO;
import java5.assignment.entity.Depart;
import java5.assignment.entity.User;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;
	}
	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		User user = (User)session.get(User.class, id);
		session.delete(user);
		
	}@Override
	public boolean saveUser(User user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(user);
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
	public User detailUser(String id) {
		Session session = factory.getCurrentSession();
		User user = (User)session.get(User.class, id);
		return user;
	}
	@Override
	public boolean updateUser(User user) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(user);
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
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkId(String id) {
		Session session = factory.getCurrentSession();
		String hql = "FROM User where id='"+id+"'";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		if(list.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
}

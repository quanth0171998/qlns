package java5.assignment.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java5.assignment.dao.RecordDAO;
import java5.assignment.entity.Record;
import java5.assignment.model.XMailler;

@Transactional
@Repository
public class RecordDAOImpl implements RecordDAO{
	@Autowired
	SessionFactory factory;
	XMailler mailer;
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListReportStaff() {
		Session session = factory.getCurrentSession();
		String hql = "SELECT r.staff.id, SUM(case when r.type=1 then 1 else 0 end),"
				+ " SUM(case when r.type=0 then 1 else 0 end) FROM Record r"
				+ " GROUP BY r.staff.id";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getListReportDepart() {
		Session session = factory.getCurrentSession();
		String hql = "SELECT s.depart.name, SUM(case when r.type=1 then 1 else 0 end),"
				+ " SUM(case when r.type=0 then 1 else 0 end) FROM Record r inner join r.staff s"
				+ " GROUP BY s.depart.name";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		return list;
	}
	@Override
	public boolean insertRecord(Record record) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			record.setDate(new Date());
			session.save(record);
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
	public List<Object[]> getTopTen() {
		Session session = factory.openSession();
		String hql = "SELECT r.staff.name, r.staff.photo, s.depart.name, SUM(case when r.type=1 then 1 else 0 end),"
				+ " SUM(case when r.type=0 then 1 else 0 end) FROM Record r inner join r.staff s"
				+ " GROUP BY r.staff.name, r.staff.photo, s.depart.name"
				+ " ORDER BY (SUM(case when r.type=1 then 1 else 0 end)-SUM(case when r.type=0 then 1 else 0 end)) DESC";
		Query query = session.createQuery(hql).setMaxResults(10);
		List<Object[]> list = query.list();
		return list;
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
}

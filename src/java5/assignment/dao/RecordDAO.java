package java5.assignment.dao;

import java.util.List;

import java5.assignment.entity.Record;

public interface RecordDAO {
	public List<Object[]> getListReportStaff();
	public List<Object[]> getListReportDepart();
	public boolean insertRecord(Record record);
	public List<Object[]> getTopTen();
//	public void sendMail(String from, String to, String subject, String body);
}

package java5.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java5.assignment.dao.RecordDAO;
import java5.assignment.entity.Record;

@Service
public class RecordService {
	@Autowired
	private RecordDAO recordDAO;
	public List<Object[]> getListReportStaff(){
		return recordDAO.getListReportStaff();
	}
	public List<Object[]> getListReportDepart(){
		return recordDAO.getListReportDepart();
	}
	public boolean insertRecord(Record record) {
		return recordDAO.insertRecord(record);
	}
	public List<Object[]> getTopTen(){
		return recordDAO.getTopTen();
	}
}

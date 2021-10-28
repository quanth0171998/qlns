package java5.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java5.assignment.dao.RecordDAO;
import java5.assignment.dao.StaffDAO;
import java5.assignment.entity.Record;
import java5.assignment.entity.Staff;
import java5.assignment.service.RecordService;
import java5.assignment.service.StaffService;

@Controller
@RequestMapping("/record/")
public class RecordController {
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping("reportStaff")
	public String reportStaff(ModelMap model) {
		List<Object[]> list = recordService.getListReportStaff();
		model.addAttribute("arrays", list);
		return "admin/record/recordStaff";
	}
	
	
	@RequestMapping("reportDepart")
	public String reportDepart(ModelMap model) {
		List<Object[]> list = recordService.getListReportDepart();
		model.addAttribute("arrays1", list);
		return "admin/record/recordDepart";
	}
	
	
	@RequestMapping(value = "insertRecord", method = RequestMethod.GET)
	public String insertRecord(ModelMap model) {
		model.addAttribute("record", new Record());
		return "admin/record/insertRecord";
	}
	
	
	@RequestMapping(value = "insertRecord", method = RequestMethod.POST)
	public String insertRecord(ModelMap model, @Validated @ModelAttribute("record") Record record, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("message", "Hoàn thành những thông tin dưới đây!");
			return "admin/record/insertRecord";
		}
		else {
			boolean insert = recordService.insertRecord(record);
			System.out.println(result);
			if(insert) {
				model.addAttribute("message", "Thêm ghi nhận thành công !");
			}
			else {
				model.addAttribute("message", "Thêm ghi nhận thất bại !");
			}
			return "redirect:/record/reportStaff.htm";
		}
	}
	
	
	@ModelAttribute("staffs")
	public List<Staff> getListStaff(){
		List<Staff> list = staffService.getListStaff();
		return list;
	}
	
	
	@RequestMapping(value = "index")
	public String index(ModelMap model) {
		List<Object[]> list = recordService.getTopTen();
		model.addAttribute("arrays", list);
		return "admin/index";
	}
}

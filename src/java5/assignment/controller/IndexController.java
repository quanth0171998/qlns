package java5.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java5.assignment.dao.RecordDAO;
import java5.assignment.service.RecordService;

@Controller
public class IndexController {
	@Autowired
	private RecordService recordService;
	@RequestMapping(value = "index")
	public String index(ModelMap model) {
		List<Object[]> list = recordService.getTopTen();
		model.addAttribute("arrays", list);
		return "admin/index";
	}
}

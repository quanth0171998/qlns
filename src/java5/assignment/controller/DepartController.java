package java5.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java5.assignment.dao.DepartDAO;
import java5.assignment.entity.Depart;
import java5.assignment.service.DepartService;

@Controller
@RequestMapping("/depart/")
public class DepartController {
	@Autowired
	private DepartService departService;
	
	@RequestMapping("listDepart")
	public String list(ModelMap model) {
		List<Depart> list = departService.getListDepart();
		model.addAttribute("departs", list);
		return "admin/depart/listDepart";
	}
	
	
	@RequestMapping(value = "insertDepart", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("depart", new Depart());
		return "admin/depart/insertDepart";
	}
	
	
	@RequestMapping(value = "insertDepart", method = RequestMethod.POST)
	public String insert(ModelMap model, @Validated @ModelAttribute("depart") Depart depart, BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("message", "Sửa những lỗi sau đây");
			return "admin/depart/insertDepart";
		}
		else {
			if(departService.checkId(depart.getId())) {
				boolean insert = departService.insertDepart(depart);
				if(insert) {
					model.addAttribute("message", "Thêm phòng ban thành công !");
				}
				else {
					model.addAttribute("message", "Thêm phòng ban thất bại!");
				}
				return "redirect:/depart/listDepart.htm";
			}
			else {
				model.addAttribute("message", "Đã tồn tại mã phòng ban, Vui lòng chọn một mã phòng ban khác !");
				return "admin/depart/insertDepart";
			}
		}
	}
	
	
	@RequestMapping(value = "detail/{id}")
	public String detail(ModelMap model, @PathVariable("id") String id) {
		Depart depart=departService.detailDepart(id);
		model.addAttribute("departDT", depart);
		return "admin/depart/updateDepart";
	}
	
	
	@RequestMapping(value = "updateDepart", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("departDT") Depart depart, BindingResult result) {
		boolean update = departService.updateDepart(depart);
		if(update) {
			model.addAttribute("message", "cập nhật thành công! ");
		}
		else {
			model.addAttribute("message", "Cập nhật thất bại! ");
		}
		return "redirect:/depart/listDepart.htm";
	}
	
	
	@RequestMapping(value = "delete/{id}")
	public String delete(ModelMap model, @PathVariable("id") String id) {
		if(departService.checkStaffDepart(id)) {
			departService.deleteDepart(id);
			return "redirect:/depart/listDepart.htm";
		}
		else {
			model.addAttribute("message", "Phòng ban đang tồn tại nhân viên. Xóa thất bại");
		}
		return "admin/depart/listDepart";
	}
	
	@RequestMapping(value = "listDepart", params = "btnSearch")
	public String search(ModelMap model, @RequestParam("search") String search) {
		List<Depart> list = departService.search(search);
		model.addAttribute("depart", list);
		return "admin/depart/listDepart";
	}
}

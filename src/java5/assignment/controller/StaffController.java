package java5.assignment.controller;

import java.io.File;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java5.assignment.dao.StaffDAO;
import java5.assignment.entity.Depart;
import java5.assignment.entity.Staff;
import java5.assignment.model.XMailler;
import java5.assignment.service.StaffService;

@Controller
@RequestMapping("/staff/")
public class StaffController {
	@Autowired
	ServletContext context;
//	@Autowired
//	JavaMailSender mailer;
	@Autowired
	XMailler mailer;
	@Autowired
	private StaffService staffService;

	@RequestMapping("listStaff")
	public String index(ModelMap model) {
		List<Staff> list = staffService.getListStaff();
		model.addAttribute("staffs", list);
		return "admin/staff/listStaff";
	}

	@RequestMapping("insertStaff")
	public String insert(ModelMap model) {
		model.addAttribute("staff", new Staff());
		return "admin/staff/insertStaff";
	}

	@RequestMapping(value = "insertStaff", method = RequestMethod.POST)
	public String insert(ModelMap model,@Validated @ModelAttribute("staff") Staff staff, BindingResult errors,
			@RequestParam("photo1") MultipartFile image) {
		if(image.isEmpty()) {
			model.addAttribute("upimage", "Bạn chưa chọn ảnh");
		}
		if(errors.hasErrors()) {
			model.addAttribute("message", "Hoàn thành đầy đủ những thông tin dưới đây");
			return "admin/staff/insertStaff"; 
		}
		else {
			try {
				if(staffService.checkId(staff.getId())) {
					String path = context.getRealPath("/images/") + image.getOriginalFilename();
					image.transferTo(new File(path));
					boolean insert = staffService.insertStaff(staff);
					if(insert) {
						model.addAttribute("success", "ThÃªm nhÃ¢n viÃªn thÃ nh cÃ´ng!");
					}
					else {
						model.addAttribute("success", "ThÃªm nhÃ¢n viÃªn tháº¥t báº¡i");
					}
				}
				else {
					model.addAttribute("message", "Ä�Ã£ tá»“n táº¡i mÃ£ nhÃ¢n viÃªn, vui lÃ²ng chá»�n má»™t mÃ£ khÃ¡c !");
					return "admin/staff/insertStaff";
				}
			} catch (Exception e) {
				System.out.println("Xáº£y ra lá»—i khi thÃªm nhÃ¢n viÃªn!");
			}
		}
		return "redirect:/staff/listStaff.htm";
	}

	@RequestMapping("detail/{id}")
	public String detail(ModelMap model, @PathVariable("id") String id) {
		Staff staff = staffService.detailStaff(id);
		model.addAttribute("staffDT", staff);
		return "admin/staff/updateStaff";
	}
	
	
	//gá»­i mail
	@RequestMapping("detailsend/{a}")
	public String detailMail(ModelMap model, @PathVariable("a") String id) {
		Staff staff = staffService.detailStaff(id);
		model.addAttribute("staffxx", staff);
		return "admin/record/sendMail";
	}
	
	
	@RequestMapping(value = "send", method = RequestMethod.POST)
	public String send(ModelMap model, @RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("subject") String subject, @RequestParam("body") String body) {
		try {
			mailer.send(from, to, subject, body);
			
			model.addAttribute("message", "Gá»­i mail thÃ nh cÃ´ng!");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Gá»­i mail tháº¥t báº¡i!");
			System.out.println(e);
		}
		return "admin/record/sendMail";
	}

	@RequestMapping(value = "updateStaff", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("staffDT") Staff staff, BindingResult errors,
			@RequestParam("photo1") MultipartFile image) {
		if(image.isEmpty()) {
			model.addAttribute("upimage", "Báº¡n chÆ°a chá»�n áº£nh");
			return "admin/staff/updateStaff";
		}
		if(errors.hasErrors()) {
			model.addAttribute("message", "HoÃ n thÃ nh Ä‘áº§y Ä‘á»§ nhá»¯ng thÃ´ng tin dÆ°á»›i Ä‘Ã¢y!");
			return "admin/staff/updateStaff";
		}
		try {
			String path = context.getRealPath("/images/") + image.getOriginalFilename();
			image.transferTo(new File(path));
			staff.setPhoto(image.getOriginalFilename());
			boolean update = staffService.updateStaff(staff);
			if (update) {
				model.addAttribute("message", "Cáº­p nháº­t nhÃ¢n viÃªn thÃ nh cÃ´ng!");
			} else {
				model.addAttribute("message", "Cáº­p nháº­t nhÃ¢n viÃªn tháº¥t báº¡i!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "CÃ³ lá»—i xáº£y ra khi cáº­p nháº­t nhÃ¢n viÃªn!");
		}
		return "redirect:/staff/listStaff.htm";
	}
	
	
	@RequestMapping(value = "delete/{id}")
	public String delete(ModelMap model, @PathVariable("id") String id) {
		try {
			staffService.deleteStaff(id);
			model.addAttribute("message", "XÃ³a nhÃ¢n viÃªn thÃ nh cÃ´ng");
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "XÃ³a nhÃ¢n viÃªn tháº¥t báº¡i");
		}
		return "redirect:/staff/listStaff.htm";
	}
	
	
	@ModelAttribute("departs")
	public List<Depart> getDeparts() {
		List<Depart> list = staffService.getDeparts();
		return list;
	}
	
//	//Search
//	@RequestMapping(value = "listStaff", params = "btnSearch")
//	public String search(ModelMap model, @RequestParam("search") String search) {
//		List<Staff> list = staffDAO.search(search);
//		model.addAttribute("user", list);
//		return "admin/staff/listStaff";
//	}
}

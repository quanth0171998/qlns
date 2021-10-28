package java5.assignment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import java5.assignment.dao.UserDAO;
import java5.assignment.entity.User;
import java5.assignment.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("listUser")
	public String index(ModelMap model) {
		List<User> list = userService.getListUser();
		model.addAttribute("users", list);
		return "admin/listUser";
	}
	
	
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("user", new User());
		return "admin/insertUser";
	}
	
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @Validated @ModelAttribute("user") User user, BindingResult errors) {
		if(errors.hasErrors()) {
			model.addAttribute("message", "Hoàn thành những thông tin dưới đây để thêm người dùng!");
			return "admin/insertUser";
		}
		if(userService.checkId(user.getUsername())) {
			boolean insert = userService.saveUser(user);
			if(insert) {
				model.addAttribute("message", "Thêm user thành công");
			}
			else {
				model.addAttribute("message", "Thêm user thất bại");
			}
			return "redirect:/user/listUser.htm";
		}
		else {
			model.addAttribute("message", "Đã tồn tại mã người dùng, vui lòng chọn mã khác!");
			return "admin/insertUser";
		}
	}
	
	@RequestMapping(value = "detail/{username}")
	public String update(ModelMap model, @PathVariable("username") String id) {
		User user = userService.detailUser(id);
		model.addAttribute("userDT", user);
		return "admin/update";
	}
	
	
	@RequestMapping(value = "detail1")
	public String detail(ModelMap model, HttpSession session) {
//		System.out.println(id);
		String id = (String) session.getAttribute("id");
		System.out.println(session.getAttribute("id"));
		User user = userService.detailUser(id);
		model.addAttribute("userDT1", user);
		return "admin/detailUser";
	}
	
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("userDT") User user) {
		boolean update = userService.updateUser(user);
		if(update) {
			model.addAttribute("message", "Sửa user thành công!");
		}
		else {
			model.addAttribute("message", "Sửa user thất bại!");
		}
		return "redirect:/user/listUser.htm";
	}
	
	
	@RequestMapping(value = "delete/{username}")
	public String delete(ModelMap model, @PathVariable("username") String id) {
		userService.deleteUser(id);
		model.addAttribute("message", "Xóa nhân viên thành công");
		return "redirect:/user/listUser.htm";
	}
	
	
	@RequestMapping("login")
	public String login(ModelMap model) {
		return "login";
	}
	
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		try {
			
			User user = userService.detailUser(username);
			if(!user.getPassword().equals(password)) {
				model.addAttribute("message", "Sai mật khẩu !");
			}
			else {
				model.addAttribute("userDetail", user);
				session.setAttribute("user", user);
				model.addAttribute("message", "Đăng nhập thành công");
				session.setAttribute("id", user.getUsername());
//				System.out.println(session.getAttribute("user"));
				User user1 = (User) session.getAttribute("user");
//				System.out.println(user1.getFullname());
//				System.out.println(user.getUsername());
				return "redirect:/staff/listStaff.htm";
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("message", "Sai tên đăng nhập !");
		}
		return "login";
	}
	
	
	@RequestMapping(value = "logout")
	public String logout(ModelMap model, HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("id");
		return "login";
	}
	
	
	@RequestMapping(value = "changePassword", method = RequestMethod.GET)
	public String changePassword(ModelMap model) {
		return "admin/changePassword";
	}
	
	
	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public String changePassword(ModelMap model, 
			@RequestParam("passwordOld") String passwordOld,
			@RequestParam("passwordNew") String passwordNew, 
			@RequestParam("passwordVerify") String passwordVerify,
			@RequestParam("username") String username) {
		if(!passwordNew.equals(passwordVerify)) {
			model.addAttribute("message", "Xác nhận mật khẩu không đúng!");
		}
		else {
			try {
				User user1= userService.detailUser(username);
				if(!user1.getPassword().equals(passwordOld)) {
					model.addAttribute("message", "Mật khẩu cũ không đúng!");
				}
				else {
					model.addAttribute("message", "Đổi mật khẩu thành công!");
					user1.setPassword(passwordVerify);
					userService.updateUser(user1);
				}
			} catch (Exception e) {
				// TODO: handle exception
				model.addAttribute("message", "Đổi mật khẩu không thành công!");
			}
		}
		return "admin/changePassword";
	}
}

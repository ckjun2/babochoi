package global.sesoc.web5.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web5.dao.CustomerMapper;
import global.sesoc.web5.vo.Customer;

//로그인, 로그아웃 처리 (세션 사용)
@Controller
@RequestMapping("customer")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	SqlSession sqlSession;
	
	//로그인 폼으로 이동
	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm() {
		return "customer/loginForm";
	}
	
	//로그인 처리
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(String id, String password, HttpSession session) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = mapper.getCustomer(id);
		if (customer != null && customer.getPassword().equals(password)) {
			session.setAttribute("loginId", customer.getCustid());
			session.setAttribute("loginName", customer.getName());
		}
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		session.removeAttribute("loginName");
		return "redirect:/";
	}
}
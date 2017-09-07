package global.sesoc.web5.controller;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web5.dao.CustomerMapper;
import global.sesoc.web5.vo.Customer;

//회원 가입 콘트롤러
@Controller
@RequestMapping("customer")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static String path = "customer/";
	
	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping(value = "joinForm", method = RequestMethod.GET)
	//회원가입 폼으로 이동
	public String joinForm() {
		return path + "joinForm";
	}
	
	//사용자가 입력한 데이터를 DB에 저장하여 회원가입 처리
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(Customer customer) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		mapper.insertCustomer(customer);

		return "redirect:/";
	}
	
	//ID중복확인 폼으로 이동
	@RequestMapping(value = "idcheck", method = RequestMethod.GET)
	public String idcheck(Model model) {
		model.addAttribute("check", false);	//검색전
		return "customer/idcheck";
	}

	//ID 검색
	@RequestMapping(value = "idcheck", method = RequestMethod.POST)
	public String idcheck(String searchId, Model model) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = mapper.getCustomer(searchId);

		model.addAttribute("check", true);				//검색후인지 여부 
		model.addAttribute("checkResult", customer);	//검색결과
		model.addAttribute("searchId", searchId);		//검색한 ID
		return "customer/idcheck";
	}
}



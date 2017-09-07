package global.sesoc.web5.controller;

import javax.servlet.http.HttpSession;

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

//개인정보 수정 콘트롤러
@Controller
@RequestMapping("customer")
public class UpdateController {
	private static final Logger logger = LoggerFactory.getLogger(UpdateController.class);
	
	@Autowired
	SqlSession sqlSession;
	
	//개인정보 수정폼으로 이동
	@RequestMapping(value = "updateForm", method = RequestMethod.GET)
	public String updateForm(HttpSession session, Model model) {
		//로그인한 사용자의 ID를 세션에서 읽음
		String id = (String) session.getAttribute("loginId");
		//DB에서 그 사용자의 정보를 검색
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = mapper.getCustomer(id);
		//사용자 정보를 모델에 저장
		model.addAttribute("customer", customer);
		return "customer/updateForm";
	}
	
	//사용자가 수정한 데이터를 DB에 반영
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Customer customer, HttpSession session) {
		logger.debug("전달된 값 : {}", customer.toString());
		
		//세션에서 로그인한 아이디를 읽어 Customer 객체에 세팅
		String id = (String) session.getAttribute("loginId");
		customer.setCustid(id);
		//DB로 수정할 데이터 전달
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		int res = mapper.updateCustomer(customer);
		
		return "redirect:/";
	}
}



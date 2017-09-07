package global.sesoc.web5.dao;

import global.sesoc.web5.vo.Customer;

public interface CustomerMapper {
	//회원정보 저장
	public int insertCustomer(Customer customer);
	//ID로 회원정보 검색
	public Customer getCustomer(String id);
	//개인정보 수정
	public int updateCustomer(Customer customer);
}

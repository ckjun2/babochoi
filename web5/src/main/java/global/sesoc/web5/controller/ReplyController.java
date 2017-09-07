package global.sesoc.web5.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web5.dao.BoardMapper;
import global.sesoc.web5.vo.Board;
import global.sesoc.web5.vo.Reply;

@Controller
@RequestMapping("board")
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);	
  @Autowired
  SqlSession sqlsession;	 	
  @RequestMapping(value="replyWrite",method=RequestMethod.POST)
  public String reply(String text,int boardnum,HttpSession session)
  { //DB에 글 전체(날짜의 역순)읽어서 모델에 저장
	
	BoardMapper mapper=sqlsession.getMapper(BoardMapper.class);  
    String id=(String)session.getValue("loginId");
    System.out.println("하하하");
    Reply reply=new Reply(1,boardnum,id,text,"1");
    int i=mapper.input(reply);
    System.out.println(i);
    System.out.println(reply);
    return "redirect:read?boardnum="+reply.getBoardnum();
  }
  
  @RequestMapping(value="delete2",method=RequestMethod.GET)
  public String replyDelete(int replynum,int boardnum,HttpSession session)
  {
	
	BoardMapper mapper=sqlsession.getMapper(BoardMapper.class);  
    String id=(String)session.getValue("loginId");
    
    System.out.println("리플삭제");
    Reply reply=new Reply(replynum,boardnum,id,"1","1");
    int i=mapper.delete2(reply);
    System.out.println(i);
    System.out.println(reply);
    return "redirect:read?boardnum="+reply.getBoardnum();
  }
  
  @RequestMapping(value="update2",method=RequestMethod.GET)
  public String replyUpdate(int replynum,HttpSession session)
  {
	  session.setAttribute("replynum", replynum);
       return "board/update2";
  }
  
  @RequestMapping(value="update2",method=RequestMethod.POST)
  public String replyUpdate(String text,HttpSession session)
  {
	  
	  BoardMapper mapper=sqlsession.getMapper(BoardMapper.class);  
       int replynum=(int)session.getValue("replynum");
	   int boardnum=(int)session.getValue("boardnum"); 
	    System.out.println("리플수정");
	   Reply reply=new Reply(replynum,1,"1",text,"1");
	   int i=mapper.update2(reply);
	   
	   System.out.println(i);
	    //System.out.println(reply);
	    return "redirect:read?boardnum="+boardnum;  
	  
	 
       
  }
  
  
  
  
  
  
	
}

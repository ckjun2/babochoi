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
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);	
  @Autowired
  SqlSession sqlsession;	 
  //게시판 목록으로 이동	
  @RequestMapping(value="list",method=RequestMethod.GET)
  public String list(Model model)
  { //DB에 글 전체(날짜의 역순)읽어서 모델에 저장
	
	BoardMapper mapper=sqlsession.getMapper(BoardMapper.class);  
	ArrayList<Board> board=mapper.select(); 
   System.out.println(board);
   model.addAttribute("board", board);   
   return "board/listForm";   	   
  }
	
  //글 한개 상세보기	
  @RequestMapping(value="read",method=RequestMethod.GET)
  public String read(int boardnum,Model model,HttpSession session)
  { 
	 //전달된 번호의 글을 하나 읽어서 모델에 저장하고
	 //jsp로 이동하여 출력 
	  BoardMapper mapper=sqlsession.getMapper(BoardMapper.class);  
	  Board board=mapper.read(boardnum);
	   if(board.getContent()!=null || board.getContent()!="")
	   {	   
	   mapper.update(boardnum);
	   Board board2=mapper.read(boardnum);
	   session.setAttribute("boardnum", boardnum);
	   
	   model.addAttribute("board", board2);   
	   System.out.println(board.getId());
	   
	   String loginId=(String)session.getValue("loginId");
	   System.out.println(loginId);
	   
	   
	   ArrayList<Reply>list=mapper.choose();
	   session.setAttribute("list", list);
	   
	   
	   return "board/read";
	   
	   //redirect인 경우에는 "redirect:read?boardnum=10";
	   
	   }
	  
	   return "redirect:list";
	  
	  //해당 번호의 글이 없으면 글 목록으로 리다이렉트
	 	   
  }
  
  //게시판 글 지우기	
  @RequestMapping(value="eraser",method=RequestMethod.GET)
  public String eraser(HttpSession session)
  {
	String loginId=(String)session.getValue("loginId");
	int boardnum=(int)session.getValue("boardnum");
	Board board=new Board(boardnum,loginId,"1","1","1",1,"1","1");
	BoardMapper mapper=sqlsession.getMapper(BoardMapper.class);
	System.out.println(board.getId());
	System.out.println(board.getBoardnum());
	int i=mapper.eraser(board);
	System.out.println(i);
    
    
      return "redirect:list";	
    
	
	
      	   
  }
  
 //게시판 글쓰기 
  @RequestMapping(value="write",method=RequestMethod.GET)
  public String write()
  {   
   return "board/write";   	   
  } 
  
  @RequestMapping(value="write",method=RequestMethod.POST)
  public String write(HttpSession session,String title,String content )
  { 
	  String id=(String)session.getAttribute("loginId");  
	  Board board=new Board(1,id,title,content,"11",1,"1","1");
	  BoardMapper mapper=sqlsession.getMapper(BoardMapper.class);  
		int i=mapper.insert(board); 
	    if(i==1)
	    {
	      return "redirect:list";	
	    }     
	  
   return "board/write";   	   
  } 
  
//게시판 글수정 
  @RequestMapping(value="rewrite",method=RequestMethod.GET)
  public String rewrite()
  {   
   return "board/rewrite";   	   
  } 
  
  @RequestMapping(value="rewrite",method=RequestMethod.POST)
  public String rewrite(HttpSession session,String title,String content )
  { 
	  String id=(String)session.getAttribute("loginId");
	  int boardnum=(int)session.getValue("boardnum");
	  Board board=new Board(boardnum,id,title,content,"11",1,"1","1");
	  BoardMapper mapper=sqlsession.getMapper(BoardMapper.class);
	 
		int i=mapper.rewrite(board); 
	   
	      return "redirect:read?boardnum="+boardnum;	
	         
	     	   
  } 
  
  
 //게시판 검색 
  @RequestMapping(value="search",method=RequestMethod.GET)
  public String rewrite(HttpSession session,String title,Model model)
  { 
	  
	  Board board=new Board(1,"1",title,"1","11",1,"1","1");
	  BoardMapper mapper=sqlsession.getMapper(BoardMapper.class);
	  ArrayList<Board> bord=mapper.search(board);
	  System.out.println("bord");
	 
	  model.addAttribute("board", bord);   
	  return "board/listForm";   	   
	  	
	  
	  
	     	   
  }  
  
	
	
}

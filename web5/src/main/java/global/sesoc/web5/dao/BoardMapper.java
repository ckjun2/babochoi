package global.sesoc.web5.dao;

import java.util.ArrayList;

import global.sesoc.web5.vo.Board;
import global.sesoc.web5.vo.Reply;

public interface BoardMapper {

 public ArrayList<Board> select();
 	
 public Board read(int boardnum);
 
 public int update(int boardnum);

 public int eraser(Board board);
 
 public int insert(Board board);
 
 public int input(Reply reply);
 
 public ArrayList<Reply> choose();

 public int delete2(Reply reply);
 
 public int update2(Reply reply);
 
 public int rewrite(Board board);
 
 public ArrayList<Board> search(Board board);
 
}

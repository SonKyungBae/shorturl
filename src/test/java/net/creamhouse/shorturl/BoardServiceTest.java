package net.creamhouse.shorturl;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.creamhouse.shorturl.domain.BoardVO;
import net.creamhouse.shorturl.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardServiceTest {
	
	@Inject
	BoardService service;
	BoardVO board = new BoardVO();
	
	//@Test
	public void regist() throws Exception {
		System.out.println("regist start");
		
		board.setTitle("title");
		board.setContent("content");
		board.setWriter("test");
		
		service.regist(board);
	}
	
	//@Test
	public void read() throws Exception {
		board = service.read(2);
		
		System.out.println(board.toString());
		
	}
	
	//@Test
	public void modify() throws Exception {
		board.setBno(1);
		board.setTitle("first");
		board.setContent("first content");
		
		service.modify(board);
	}
	
	//@Test
	public void remove() throws Exception {
		service.remove(4);
	}
	
	@Test
	public void listAll() throws Exception {
		List<BoardVO> list = service.listAll();		
 		System.out.println("start");
 		
		for (BoardVO obj : list) {			
			System.out.println(obj);
		}
		
		System.out.println();
	}
	
}

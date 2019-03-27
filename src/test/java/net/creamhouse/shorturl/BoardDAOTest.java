package net.creamhouse.shorturl;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.creamhouse.shorturl.controller.BoardController;
import net.creamhouse.shorturl.domain.BoardVO;
import net.creamhouse.shorturl.domain.Criteria;
import net.creamhouse.shorturl.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardDAO dao;
	
	//@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글을 넣습니다.");
		board.setContent("새로운 글을 넣습니다");
		board.setWriter("user00");
		
		dao.create(board);		
	}
	
	//@Test
	public void testListPage() throws Exception {
		int page = 3;
		
		List<BoardVO> list = dao.listPage(page);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
		
		
	}
	
	@Test
	public void testCriteria() throws Exception {
		Criteria cri = new Criteria();
		
		cri.setPage(1);
		cri.setPerPageNum(10);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		logger.info("testCriteria start......");
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
		
	}

}

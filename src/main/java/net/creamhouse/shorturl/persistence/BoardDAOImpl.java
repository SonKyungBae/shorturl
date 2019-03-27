package net.creamhouse.shorturl.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import net.creamhouse.shorturl.controller.BoardController;
import net.creamhouse.shorturl.domain.BoardVO;
import net.creamhouse.shorturl.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private SqlSession session;
	
	private static String namespcae = "net.creamhouse.mapper.BoardMapper";

	@Override
	public void create(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespcae + ".create", vo);

	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespcae + ".read", bno );
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		logger.info(vo.toString());
		session.update(namespcae + ".update", vo);

	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespcae + ".delete",bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespcae + ".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		if (page <= 0) {
			page = 1;
		}
		
		page = (page-1) * 10;
		
		return session.selectList(namespcae + ".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespcae + ".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespcae + ".countPaging", cri);
	}

}

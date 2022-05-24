package com.playground.pg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.FaqDto;
import com.playground.pg.domain.SearchCondition;

@Repository
public class FaqDaoImpl implements FaqDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.FaqMapper.";
	
	@Override
	public int selectTotalCnt() throws Exception {
		return session.selectOne(namespace+"selectTotalCnt");
	}
	
	
	@Override
	public String adminChk(String id) throws Exception {
		return session.selectOne(namespace+"adminChk", id);
	}


	@Override
	public List<FaqDto> selectFaqListCategory(String category, SearchCondition sc) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("category", category);
		map.put("SearchCondition", sc);
		return session.selectList(namespace+"selectListCategory", map);
	}
	
	@Override
	public List<FaqDto> selectFaqList(SearchCondition sc) throws Exception {
		return session.selectList(namespace+"selectList", sc);
	}

	@Override
	public FaqDto selectFaq(int no) throws Exception {
		return session.selectOne(namespace+"selectFaq", no);
	}

	@Override
	public int insertFaq(FaqDto faqDto) throws Exception {
		return session.insert(namespace+"insertFaq", faqDto);
	}

	@Override
	public int findFaqNo(FaqDto faqDto) throws Exception {
		return session.selectOne(namespace+"selectFaqNo", faqDto);
	}

	@Override
	public int deleteFaq(int no) throws Exception {
		return session.delete(namespace+"deleteFaq", no);
	}

}

package com.playground.pg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.playground.pg.domain.InquiryDto;

@Repository
public class InquiryDaoImpl implements InquiryDao {
	@Autowired
	private SqlSession session;
	private static String namespace = "com.playground.pg.dao.InquiryMapper.";
	
	@Override
	public int insertInq(InquiryDto inquiryDto) throws Exception {
		return session.insert(namespace + "insertInq", inquiryDto);
	}

	@Override
	public List<InquiryDto> getInqList(String writer) throws Exception {
		return session.selectList(namespace + "getInqList" ,writer);
	}

	@Override
	public InquiryDto getInq(int no) throws Exception {
		return session.selectOne(namespace + "getInq", no);
	}
	
	@Override
	public int getInqCnt() throws Exception {
		return session.selectOne(namespace + "selectInqCnt");
	}

	@Override
	public int deleteInq(int no) throws Exception {
		return session.delete(namespace + "deleteInq", no);
	}

	@Override
	public List<InquiryDto> getAdminInqList() throws Exception {
		return session.selectList(namespace + "getAdminInqList");
	}
	
	@Override
	public List<InquiryDto> getAdminInqListN() throws Exception {
		return session.selectList(namespace + "getAdminInqListN");
	}
	
	@Override
	public List<InquiryDto> getAdminInqListF() throws Exception {
		return session.selectList(namespace + "getAdminInqListF");
	}

	@Override
	public int updateReply(int no, String reply) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("no", no);
		map.put("reply", reply);
		return session.update(namespace + "updateReply", map);
	}

}

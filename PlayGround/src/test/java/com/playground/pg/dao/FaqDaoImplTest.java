package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.pg.domain.FaqDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FaqDaoImplTest {
	@Autowired
	FaqDao faqDao;
	
	@Test
	public void totalCntCheck() throws Exception {
		int rows = faqDao.selectTotalCnt();
		System.out.println("rows : "+rows);
//		assertTrue(rows==0);
	}
	
	@Test
	public void insertFaq() throws Exception {
		FaqDto faqDto = new FaqDto();
		faqDto.setCategory("A");
		faqDto.setTitle("title title");
		faqDto.setContent("contentcontet");
		faqDto.setWriter("writer");
		int res = faqDao.insertFaq(faqDto);
		assertTrue(res==1);
	}
	
	@Test
	public void findFaqNo() throws Exception {
		FaqDto faqDto = new FaqDto();
		faqDto.setCategory("A");
		faqDto.setTitle("title title");
		faqDto.setContent("contentcontet");
		faqDto.setWriter("writer");
		int no = faqDao.findFaqNo(faqDto);
		System.out.println("no : " + no);
	}
	
	@Test
	public void selectFaq() throws Exception {
		FaqDto faqDto = new FaqDto();
		faqDto.setCategory("A");
		faqDto.setTitle("title title");
		faqDto.setContent("contentcontet");
		faqDto.setWriter("writer");
		int no = faqDao.findFaqNo(faqDto);
		
		faqDto = faqDao.selectFaq(no);
		if(faqDto == null) {
			System.out.println("db is empty");
		} else {
			System.out.println(faqDto.toString());
		}
		
	}
	
	@Test
	public void deleteFaq() throws Exception {
		int res = faqDao.deleteFaq(1);
		assertTrue(res==1);
	}
}

package com.playground.pg.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FaqDaoImplTest {
	@Autowired
	FaqDao faqDao;
	
	@Test
	public void totalCntCheck() throws Exception {
		int rows = faqDao.selectTotalCnt();
		System.out.println("rows : "+rows);
		assertTrue(rows==0);
	}
}

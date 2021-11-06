package org.kpu.myweb.test;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.domain.SubjectVO;
import org.kpu.myweb.persistence.MemberDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {

	
	@Autowired
	private MemberDAO dao;
	private static Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	//1. 전체 수강과목 목록 출력 단위 테스트
	//@Test
	public void testSubjectReadList() throws Exception {
		List<SubjectVO> voList;
		voList = dao.subjectReadList();

		for(SubjectVO svo : voList) {
			logger.info(svo.toString());
		}
		
	}
	//2. 학과 번호 11번(컴퓨터공학과)의 수강 가능 과목 리스트 출력
	@Test
	public void testMatchSubject() throws Exception {
		List<SubjectVO> voList;
		voList = dao.matchSubject(11);

		for(SubjectVO svo : voList) {
			logger.info(svo.toString());
		}
	}
}

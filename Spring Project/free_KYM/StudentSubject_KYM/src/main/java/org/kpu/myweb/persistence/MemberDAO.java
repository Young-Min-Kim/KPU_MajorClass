package org.kpu.myweb.persistence;

import java.util.List;
import java.util.Map;

import org.kpu.myweb.domain.PreferVO;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.domain.SubjectVO;

public interface MemberDAO {

	public void add(StudentVO student) throws Exception;
	public void subjectAdd(SubjectVO subject) throws Exception;
	
	public List<StudentVO> readList() throws Exception;
	public List<SubjectVO> subjectReadList() throws Exception;
	
	public StudentVO read(String id) throws Exception;
	public SubjectVO subjectRead(String subjectNum) throws Exception;
	
	public void delete(String id) throws Exception;
	public void subjectDelete(String subjectNum) throws Exception;
	
	public void update(StudentVO student) throws Exception;
	public void txUpdate(StudentVO student) throws Exception;
	public void subjectUpdate(SubjectVO subject) throws Exception;

	
	public List<SubjectVO> matchSubject(int departNum) throws Exception;
	
	
	public int preferAddSubject(Map<String , Object> map) throws Exception;
	public int preferDeleteSubject(Map<String , Object> map) throws Exception;
	
	public List<PreferVO> preferListSubject(String studentNum) throws Exception;
	public int preferCreditCount(String studentNum) throws Exception;
}

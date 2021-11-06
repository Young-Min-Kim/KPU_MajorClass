package org.kpu.myweb.service;

import java.util.List;
import java.util.Map;

import org.kpu.myweb.domain.PreferVO;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.domain.SubjectVO;

public interface MemberService {
	
	public StudentVO readMember(String id) throws Exception;
	public SubjectVO subjectReadMember(String subjectNum) throws Exception;
	
	public List<StudentVO> readMemberList() throws Exception;
	public List<SubjectVO> subjectReadMemberList() throws Exception;

	public void addMember(StudentVO student) throws Exception;
	public void subjectAddMember(SubjectVO subject) throws Exception;
	
	public void deleteMember(String id) throws Exception; 
	public void subjectDeleteMember(String subjectNum) throws Exception; 
	
	public void updateMember(StudentVO student) throws Exception;
	public void subjectUpdateMember(SubjectVO subject) throws Exception;
	
	public void txUpdateMember(StudentVO student1, StudentVO student2) throws Exception;
	
	public List<SubjectVO> matchSubjectReadMemberList(int departNum) throws Exception;
	
	
	public int preferSubjectAddMember(Map<String , Object> map) throws Exception;
	public int preferSubjectDeleteMember(Map<String , Object> map) throws Exception;
	
	
	
	public List<PreferVO> preferSubjectReadMemberList(String  studentNum) throws Exception;
	public int preferCreditCountMember(String  studentNum) throws Exception;
	
	
}

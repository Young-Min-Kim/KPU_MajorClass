package org.kpu.myweb.service;

import java.util.List;
import java.util.Map;

import org.kpu.myweb.domain.PreferVO;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.domain.SubjectVO;
import org.kpu.myweb.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public StudentVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}
	public SubjectVO subjectReadMember(String subjectNum) throws Exception {
		return memberDAO.subjectRead(subjectNum);
	}
	
	
	public List<StudentVO> readMemberList() throws Exception{
		return memberDAO.readList();
	}
	public List<SubjectVO> subjectReadMemberList() throws Exception{
		return memberDAO.subjectReadList();
	}
	
	
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}
	public void subjectAddMember(SubjectVO subject) throws Exception {
		memberDAO.subjectAdd(subject);
	}
	
	
	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}
	public void subjectDeleteMember(String subjectNum) throws Exception {
		memberDAO.subjectDelete(subjectNum);
	}
	
	
	public void updateMember(StudentVO student) throws Exception {
		memberDAO.update(student);
	}
	public void subjectUpdateMember(SubjectVO subject) throws Exception {
		memberDAO.subjectUpdate(subject);
	}
	
	@Transactional ( propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10 )
	public void txUpdateMember(StudentVO student1, StudentVO student2) throws Exception {
		memberDAO.txUpdate(student1);
		memberDAO.txUpdate(student2);
	}
	
	public List<SubjectVO> matchSubjectReadMemberList(int departNum) throws Exception{
		return memberDAO.matchSubject(departNum);
	}
	
	public int preferSubjectAddMember(Map<String , Object> map) throws Exception{
		return memberDAO.preferAddSubject(map);
	}
	public int preferSubjectDeleteMember(Map<String , Object> map) throws Exception{
		return memberDAO.preferDeleteSubject(map);
	}
	
	public List<PreferVO> preferSubjectReadMemberList(String studentNum) throws Exception{
		return memberDAO.preferListSubject(studentNum);
	}
	public int preferCreditCountMember(String studentNum) throws Exception{
		return memberDAO.preferCreditCount(studentNum);
	}

}

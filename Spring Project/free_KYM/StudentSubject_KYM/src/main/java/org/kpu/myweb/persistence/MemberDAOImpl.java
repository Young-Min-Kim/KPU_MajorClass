package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.PreferVO;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.domain.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.myweb.mapper.StudentMapper";
	private static final String subjectNamespace = "org.kpu.myweb.mapper.SubjectMapper";
	private static final String preferNamespace = "org.kpu.myweb.mapper.PreferMapper";

	public StudentVO read(String id) throws Exception {
	
		StudentVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		return vo;   
	}
	public SubjectVO subjectRead(String subjectNum) throws Exception {
		
		SubjectVO svo = sqlSession.selectOne(subjectNamespace+".subjectSelectByid", subjectNum);
		return svo;   
	}
 
	
	public List<StudentVO> readList() throws Exception {
		List<StudentVO> studentlist = new ArrayList<StudentVO>();
		studentlist = sqlSession.selectList(namespace + ".selectAll");
		return studentlist;
	}
	public List<SubjectVO> subjectReadList() throws Exception {
		List<SubjectVO> subjectlist = new ArrayList<SubjectVO>();
		subjectlist = sqlSession.selectList(subjectNamespace + ".subjectSelectAll");
		return subjectlist;
	}
	

	public void add(StudentVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
	}
	public void subjectAdd(SubjectVO svo) throws Exception {
		sqlSession.insert(subjectNamespace + ".subjectInsert", svo);
	}
	

	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", id);
	}
	public void subjectDelete(String subjectNum) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(subjectNamespace + ".subjectDelete", subjectNum);
	}
	

	public void update(StudentVO student) throws Exception {
		// TODO Auto-generated method stub
	    sqlSession.update(namespace + ".update", student);
	}
	public void txUpdate(StudentVO student) throws Exception {
		// TODO Auto-generated method stub
	    sqlSession.update(namespace + ".txupdate", student);
	}
	public void subjectUpdate(SubjectVO subject) throws Exception {
		// TODO Auto-generated method stub
	    sqlSession.update(subjectNamespace + ".subjectUpdate", subject);
	}

	
	public List<SubjectVO> matchSubject(int departNum) throws Exception{
		List<SubjectVO> matchSubjectlist = new ArrayList<SubjectVO>();
		matchSubjectlist = sqlSession.selectList(subjectNamespace + ".matchSubjectlist", departNum);
		return matchSubjectlist;
	}
	
	public int preferAddSubject(Map<String , Object> map) throws Exception{
		
		return sqlSession.insert(preferNamespace + ".preferAdd", map);
	}
	public int preferDeleteSubject(Map<String , Object> map) throws Exception{
		
		return sqlSession.insert(preferNamespace + ".preferDelete", map);
	}
	
	
	public List<PreferVO> preferListSubject(String studentNum) throws Exception{
		List<PreferVO> preferSubjectlist = new ArrayList<PreferVO>();
		preferSubjectlist = sqlSession.selectList(preferNamespace + ".preferSelectList", studentNum);
		return preferSubjectlist;
	}
	public int preferCreditCount(String studentNum) throws Exception{
		int creditCnt;
		creditCnt = sqlSession.selectOne(preferNamespace + ".prefercreditCount", studentNum);
		return creditCnt;
	}

}

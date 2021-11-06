package org.kpu.myweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kpu.myweb.domain.PreferVO;
import org.kpu.myweb.domain.StudentVO;
import org.kpu.myweb.domain.SubjectVO;
import org.kpu.myweb.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping(value="/member") // /member를 받으면 아래를 실행하겠다.
public class MemberController {
	

	@Autowired
    private MemberService memberService;  // 멤버 서비스 호출


	private static final Logger logger = LoggerFactory.getLogger(MemberController.class); // 실행하면서 과정 정보 표시위함
	
	// student list 읽기
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET) // /member/list 를 받으면 아래 클래스가 실행
    public String listMember(Model model) throws Exception { // 리스트 출력하는 메서드
    	List<StudentVO> students = memberService.readMemberList(); // 멤버서비스에서 readMemberList 메서드 사용해서 결과값 students에 저장
    	
		//logger.info(" /member/list URL called. then listMemebr method executed.");
        model.addAttribute("students", students);
        return "member/KYM_student_list";
    }    
	// subject list 읽기
	@RequestMapping(value = {"/subjectList"}, method = RequestMethod.GET) // /member/list 를 받으면 아래 클래스가 실행
    public String subjectListMember(Model model) throws Exception { // 리스트 출력하는 메서드
    	List<SubjectVO> subjects = memberService.subjectReadMemberList(); 
		//logger.info(" /member/subjectList URL called. then subjectListMember method executed.");
        model.addAttribute("subjects", subjects);
        return "member/KYM_subject_list";
    }
	
    //수강 가능 과목 리스트 출력
	@RequestMapping(value = {"/matchSubject"}, method = RequestMethod.GET)
    public String matchSubjectListMember(@RequestParam("departNum") int departNum, @RequestParam("studentNum") String studentNum, Model model) throws Exception {
    	List<SubjectVO> match = memberService.matchSubjectReadMemberList(departNum);
    	
		//logger.info(" /member/matchSubject?departNum=11 URL called. then matchSubjectListMember method executed.");
        model.addAttribute("match", match);
        model.addAttribute("studentNum", studentNum);
        model.addAttribute("departNum", departNum);
        return "member/KYM_subject_sugang_list";
    }
	
	@RequestMapping(value = {"/preferAdd"}, method = RequestMethod.GET)
    public String preferSubjectAddMember(@RequestParam("departNum") int departNum, @RequestParam("studentNum") String studentNum, @RequestParam("subjectNum") String subjectNum, @RequestParam("memberDepartNum") String memberDepartNum, Model model) throws Exception {
	
		Map<String , Object> map = new HashMap<String , Object>();
		map.put("studentNum", studentNum);
		map.put("subjectNum", subjectNum);
		
		
		int resultNum = memberService.preferSubjectAddMember(map);
    	
		if(resultNum<=0) {
			return "redirect:/member/error";
		}
			
		//logger.info(" /member/preferAdd?departNum=11&studentNum=2016156007&subjectNum=1101 URL called. then preferSubjectAddMember method executed.");
        return "redirect:/member/matchSubject?departNum="+ memberDepartNum + "&studentNum=" + studentNum;
    }
	
	
	@RequestMapping(value = {"/preferDelete"}, method = RequestMethod.GET)
    public String preferSubjectDeleteMember(@RequestParam("studentNum") String studentNum, @RequestParam("subjectNum") String subjectNum,Model model) throws Exception {
	
		Map<String , Object> map = new HashMap<String , Object>();
		map.put("studentNum", studentNum);
		map.put("subjectNum", subjectNum);
		
		model.addAttribute("studentNum", studentNum);
		int resultNum = memberService.preferSubjectDeleteMember(map);
    	
		//logger.info(" /member/preferList?studentNum=2016156007&subjectNum=1101 URL called. then preferSubjectAddMember method executed.");
        return "redirect:/member/preferList";
    }

	
	
	
	
	
	
	@RequestMapping(value = {"/preferList"}, method = RequestMethod.GET)
    public String preferSubjectListMember(@RequestParam("studentNum") String studentNum, Model model) throws Exception {
    	
		
		List<PreferVO> prefer = memberService.preferSubjectReadMemberList(studentNum);
    	
    	// 트랜잭션 자리??
    	int creditCnt = memberService.preferCreditCountMember(studentNum);
    	
		//logger.info(" /member/preferList?studentNum=2016156007 URL called. then preferSubjectListMember method executed.");
        model.addAttribute("prefer", prefer);
        model.addAttribute("creditCnt", creditCnt);
        model.addAttribute("studentNum", studentNum);
        
        return "member/KYM_prefer_list"; //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    }


	
	
	
	
	
	// student 하나 선택 읽기 
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String readMember(@RequestParam("id") String id, Model model) throws Exception {
    	StudentVO student = memberService.readMember(id);
    	
		//logger.info(" /read?id=kang URL called. then readMemebr method executed.");
        model.addAttribute("student", student);
        return "member/KYM_student_read";
    }
	// student 하나 선택 읽기 
    @RequestMapping(value = "/subjectRead", method = RequestMethod.GET)
    public String subjectReadMember(@RequestParam("subjectNum") String subjectNum, Model model) throws Exception {
    	SubjectVO subject = memberService.subjectReadMember(subjectNum); 
    	
		//logger.info(" /read?subjectNum=1101 URL called. then subjectReadMember method executed.");
        model.addAttribute("subject", subject);
        return "member/KYM_subject_read";
    }
    
    
    
    //student 하나 추가 
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String createMemberGet() throws Exception {
		//logger.info(" /register URL GET method called. then forward KYM_student_register.");
		return "member/KYM_student_register";
	}	
    //subject 하나 추가 
	@RequestMapping(value = {"/subjectRegister"}, method = RequestMethod.GET)
	public String subjectcreateMemberGet() throws Exception {
		//logger.info(" /subjectRegister URL GET method called. then forward KYM_subject_register.jsp.");
		return "member/KYM_subject_register";
	}
	
	
	
	
    //student
    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String createMemberPost( @ModelAttribute("student") StudentVO vo) throws Exception {
		memberService.addMember(vo);
		logger.info(vo.toString());
		//logger.info(" /register URL POST method called. then createMember method executed.");
		return "redirect:/member/list";
	}
    //subject
    @RequestMapping(value = {"/subjectRegister"}, method = RequestMethod.POST)
	public String subjectCreateMemberPost( @ModelAttribute("subject") SubjectVO svo) throws Exception {
		memberService.subjectAddMember(svo);
		logger.info(svo.toString());
		//logger.info(" /subjectRegister URL POST method called. then createMember method executed.");
		return "redirect:/member/subjectList";
	}
    
	
    //student GET 수정  
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyMemberGet(@RequestParam("id") String id, Model model) throws Exception {
    	StudentVO student = memberService.readMember(id);
    	
		//logger.info(" /modify?id=id01 URL GET method called. then forward KYM_student_modify.jsp");
        model.addAttribute("student", student);
        return "member/KYM_student_modify";
    }
    //subject GET 수정 
    @RequestMapping(value = "/subjectModify", method = RequestMethod.GET)
    public String subjectModifyMemberGet(@RequestParam("subjectNum") String subjectNum, Model model) throws Exception {
    	SubjectVO subject = memberService.subjectReadMember(subjectNum);
    	
		//logger.info(" /subjectModify?id=kang URL GET method called. then forward KYM_subject_modify.jsp.");
        model.addAttribute("subject", subject);
        return "member/KYM_subject_modify";
    }
    
    
    //student POST 수정
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyMemberPost(@ModelAttribute("student") StudentVO vo) throws Exception {
    	memberService.updateMember(vo);
		logger.info(vo.toString());
		//logger.info(" /Modify?id=1101 URL POST method called. then modifyMemberPost method executed.");
        return "redirect:/member/list";
    }
    //subject POST 수정
    @RequestMapping(value = "/subjectModify", method = RequestMethod.POST)
    public String subjectModifyMemberPost(@ModelAttribute("subject") SubjectVO svo) throws Exception {
    	memberService.subjectUpdateMember(svo);
		logger.info(svo.toString());
		//logger.info(" /subjectModify?subjectNum=1101 URL POST method called. then subjectModifyMemberPost method executed.");
        return "redirect:/member/subjectList";
    }
    
    
    
    
    //student 트랜잭션 수정 - 2명 이름 변경
    @RequestMapping(value = "/txModify", method = RequestMethod.GET)
    public String txModifyMember(@RequestParam("id1") String id1, @RequestParam("id2") String id2, StudentVO vo1, StudentVO vo2) throws Exception {
    	
    	
		vo1 = new StudentVO();
    	vo1.setId(id1);
		vo1.setName("바꾼이름이이름은안들어갈예정가나다라마바사자차카타파하가나다라마바사자차카타파하일이삼사오율칠팔구십십일십이십삼십사십오십육십칠십팔십구이십");
		//
		
		
		vo2 = new StudentVO();
    	vo2.setId(id2);
		vo2.setName("바꾼이름2");
    	
    	
    	try {
    		memberService.txUpdateMember(vo1, vo2);
			System.out.println("TRANSACTION 처리 완료");
			logger.info(vo1.toString());
			logger.info(vo2.toString());
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("TRANSACTION 처리 완료");
			System.out.println("---------롤백----------");
		}
		//logger.info(" /txModify?id1=id02&id2=id03 URL POST method called. then modifyMemberPost method executed.");
        return "redirect:/member/list"; // redirect: 고민해보기
    }
    
    
    
    
    
    //student 삭제
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteMemberGet(@RequestParam("id") String id, Model model) throws Exception {
    	memberService.deleteMember(id);

		//logger.info(" /delete?id=hansol URL POST method called. then deleteMemberPost method executed.");
        return "redirect:/member/list";
    }
    
    //subject 삭제
    @RequestMapping(value = "/subjectDelete", method = RequestMethod.GET)
    public String subjectDeleteMemberGet(@RequestParam("subjectNum") String subjectNum, Model model) throws Exception {
    	memberService.subjectDeleteMember(subjectNum);

		//logger.info(" /delete?subjectNum=1101 URL POST method called. then deleteMemberPost method executed.");
        return "redirect:/member/subjectList";
    }
    
	/*
	 * @ExceptionHandler(Exception.class)
	 * 
	 * @RequestMapping(path = "/error500") public String error() throws Exception {
	 * 
	 * return "member/error"; }
	 */
    
    
    

    


   
}
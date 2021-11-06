package org.kpu.myweb.domain;

public class StudentVO {

	private String id;
	private String name;
	private String studentNum;
	private String depart;
	private int departNum;
	private String phoneNum;
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getStudentNum() {
		return studentNum;
	}





	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}





	public String getDepart() {
		return depart;
	}





	public void setDepart(String depart) {
		this.depart = depart;
	}





	public int getDepartNum() {
		return departNum;
	}





	public void setDepartNum(int departNum) {
		this.departNum = departNum;
	}





	public String getPhoneNum() {
		return phoneNum;
	}





	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}





	@Override
	public String toString() {
		return "StudentVO [id=" + id + ", name=" + name + ", studnetNum=" + studentNum + ", depart=" + depart + ", departNum="
				+ departNum + ", phoneNum=" + phoneNum + "]";
	}

	
}

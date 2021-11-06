package org.kpu.myweb.domain;

public class SubjectVO {
	private String subjectNum;
	private String subjectName;
	private int departNum;
	private String subjectDiv;
	private int subjectCredit;
	private int presentNum;
	private int maxNum;
	private String preference;

	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public int getPresentNum() {
		return presentNum;
	}
	public void setPresentNum(int presentNum) {
		this.presentNum = presentNum;
	}

	public String getSubjectNum() {
		return subjectNum;
	}
	public void setSubjectNum(String subjectNum) {
		this.subjectNum = subjectNum;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getDepartNum() {
		return departNum;
	}
	public void setDepartNum(int departNum) {
		this.departNum = departNum;
	}
	public String getSubjectDiv() {
		return subjectDiv;
	}
	public void setSubjectDiv(String subjectDiv) {
		this.subjectDiv = subjectDiv;
	}
	public int getSubjectCredit() {
		return subjectCredit;
	}
	public void setSubjectCredit(int subjectCredit) {
		this.subjectCredit = subjectCredit;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	
	@Override
	public String toString() {
		return "StudentVO [subjectNum=" + subjectNum + ", subjectName=" + subjectName + ", departNum=" + departNum + ", subjectDiv=" + subjectDiv + ", subjectCredit="
				+ subjectCredit + ", presentNum=" + presentNum + ", maxNum=" + maxNum + "]";
	}

}

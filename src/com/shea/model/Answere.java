package com.shea.model;

public class Answere {
private String answereid;
private String facultyid;
private String date;
private String answere;
private String questionid;
private String status;
private String studentid;
public String getAnswereid() {
	return answereid;
}
public String getQuestionid() {
	return questionid;
}
public void setQuestionid(String questionid) {
	this.questionid = questionid;
}
public void setAnswereid(String answereid) {
	this.answereid = answereid;
}
public String getFacultyid() {
	return facultyid;
}
public void setFacultyid(String facultyid) {
	this.facultyid = facultyid;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getAnswere() {
	return answere;
}
public void setAnswere(String answere) {
	this.answere = answere;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getStudentid() {
	return studentid;
}
public void setStudentid(String studentid) {
	this.studentid = studentid;
}
}
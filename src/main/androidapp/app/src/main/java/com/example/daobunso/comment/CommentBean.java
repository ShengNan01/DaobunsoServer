package com.example.daobunso.comment;

import java.sql.Timestamp;


public class CommentBean {

	Integer Grading_Id;
	String Account;
	Integer Stars;
	Timestamp Comment_Date;
	String Comment;
	
	
	public CommentBean() {
		super();
	}


	public CommentBean(Integer grading_Id, String account, Integer stars, Timestamp comment_Date, String comment) {
		super();
		Grading_Id = grading_Id;
		Account = account;
		Stars = stars;
		Comment_Date = comment_Date;
		Comment = comment;
	}


	public Integer getGrading_Id() {
		return Grading_Id;
	}


	public void setGrading_Id(Integer grading_Id) {
		Grading_Id = grading_Id;
	}


	public String getAccount() {
		return Account;
	}


	public void setAccount(String account) {
		Account = account;
	}


	public Integer getStars() {
		return Stars;
	}


	public void setStars(Integer stars) {
		Stars = stars;
	}


	public Timestamp getComment_Date() {
		return Comment_Date;
	}


	public void setComment_Date(Timestamp comment_Date) {
		Comment_Date = comment_Date;
	}


	public String getComment() {
		return Comment;
	}


	public void setComment(String comment) {
		Comment = comment;
	}
	
	
	
	
}

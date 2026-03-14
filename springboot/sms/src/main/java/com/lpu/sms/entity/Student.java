package com.lpu.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String email;
	private String course;
	private int marks;
	private String role;   // ADMIN or USER
	
	@Lob
	private byte[] profileImage;
	@Lob
	private byte[] assignmentFile;
	private String imageType;
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	
	
	
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public byte[] getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	public byte[] getAssignmentFile() {
		return assignmentFile;
	}
	public void setAssignmentFile(byte[] assignmentFile) {
		this.assignmentFile = assignmentFile;
	}
	
	
}

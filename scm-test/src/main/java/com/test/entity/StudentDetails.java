package com.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="full_name")
	private String FullName;
	@Column(name="university_id")
	private String universityId;
	@Column(name="student_address")
	private String address;
	@Column(name="admission_date")
	private Date admissionDate;
	@Column(name="max_book_limit")
	private int maxBookAllowed;
	@Column(name="accademic_year")
	private String academicYear;
	@Column(name="no_books_issued")
	private int booksIssued;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getUniversityId() {
		return universityId;
	}
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public int getMaxBookAllowed() {
		return maxBookAllowed;
	}
	public void setMaxBookAllowed(int maxBookAllowed) {
		this.maxBookAllowed = maxBookAllowed;
	}
	public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}
	public int getBooksIssued() {
		return booksIssued;
	}
	public void setBooksIssued(int booksIssued) {
		this.booksIssued = booksIssued;
	}
	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", FullName=" + FullName + ", universityId=" + universityId + ", address="
				+ address + ", admissionDate=" + admissionDate + ", maxBookAllowed=" + maxBookAllowed
				+ ", academicYear=" + academicYear + ", booksIssued=" + booksIssued + "]";
	}
	

}

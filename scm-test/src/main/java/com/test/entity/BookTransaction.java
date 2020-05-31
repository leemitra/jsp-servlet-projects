package com.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction_history")
public class BookTransaction {
	@Id
	@Column(name="transaction_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private StudentDetails memberId;
	
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private BookDetails bookId;

	@Column(name="date_issue",length=50)
	private Date issuedDate;
	@Column(name="returned_date",length=50)
	private Date returnedDate;
	@Column(name="due_date",length=50)
	private Date dueDate;
	@Column(name="fine_collected")
	private int fineAmount;
	@Column(name="transaction_status", length=50)
	private String transactionStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	 
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public int getFineAmount() {
		return fineAmount;
	}
	public void setFineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	
	public StudentDetails getMemberId() {
		return memberId;
	}
	public void setMemberId(StudentDetails memberId) {
		this.memberId = memberId;
	}
	public BookDetails getBookId() {
		return bookId;
	}
	public void setBookId(BookDetails bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "BookTransaction [id=" + id + ", memberId=" + memberId + ", bookId=" + bookId + ", issuedDate="
				+ issuedDate + ", returnedDate=" + returnedDate + ", dueDate=" + dueDate + ", fineAmount=" + fineAmount
				+ ", transactionStatus=" + transactionStatus + "]";
	}
	 
	
}

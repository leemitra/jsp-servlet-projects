package com.test.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="book_details")
public class BookDetails {

	@Id
	@Column(name="book_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookId;
	@Column(name="book_author", length =100)
	private String bookAuthor;
	@Column(name="book_name", length =100)
	private String bookName;
	@Column(name="book_price", length =10)
	private Double bookPrice;
	@Column(name="book_isbn_number", length =40)
	private String bookNumber;
	@Column(name="status", length =20)
	private String status;
	@Column(name="edition", length =20)
	private String edition;
	@Column(name="date_purchage", length =40)
	@Temporal(TemporalType.DATE)
	private Calendar purchageDate;
	@Column(name="number_copies", length =10)
	private int numberOfCopies;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	 
	public Calendar getPurchageDate() {
		return purchageDate;
	}
	public void setPurchageDate(Calendar purchageDate) {
		this.purchageDate = purchageDate;
	}
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookAuthor=" + bookAuthor + ", bookName=" + bookName
				+ ", bookPrice=" + bookPrice + ", bookNumber=" + bookNumber + ", status=" + status + ", edition="
				+ edition + ", purchageDate=" + purchageDate + ", numberOfCopies=" + numberOfCopies + "]";
	}
	
	
}

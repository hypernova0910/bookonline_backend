package com.hieu.backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.hieu.backend.dto.FeedbackStatistic;

@Entity
@Table (name = "feedback")
@SqlResultSetMapping(
    name = "FeedbackStatisticMapping",
    classes = @ConstructorResult(
        targetClass = FeedbackStatistic.class,
        columns = {
            @ColumnResult(name = "book_id", type=Long.class),
            @ColumnResult(name = "star1", type=Double.class),
            @ColumnResult(name = "star2", type=Double.class),
            @ColumnResult(name = "star3", type=Double.class),
            @ColumnResult(name = "star4", type=Double.class),
            @ColumnResult(name = "star5", type=Double.class),
            @ColumnResult(name = "total"),
            @ColumnResult(name = "average", type=Double.class),
        }
    )
)
public class Feedback {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "content", length = 4000)
	private String content;
	
	@Column (name = "stars")
	private Integer stars;
	
	@Column (name = "date_created")
	private Date date_created;
	
	@Column (name = "writer_name")
	private String writer_name;
	
	@ManyToOne
	@JoinColumn (name = "customer_id")
	@JsonIncludeProperties({"id", "first_name", "last_name"})
	private Customer customer;
	
	@ManyToOne
	@JoinColumn (name = "book_id")
	@JsonIncludeProperties({"id", "name"})
	private Book book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public String getWriter_name() {
		return writer_name;
	}

	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}

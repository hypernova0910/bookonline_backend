package com.hieu.backend.dto;

public class FeedbackStatistic {
	private Long book_id;
	private Double star1;
	private Double star2;
	private Double star3;
	private Double star4;
	private Double star5;
	private Integer total;
	private Double average;
	
	public FeedbackStatistic() {
		super();
		this.book_id = 0L;
		this.star1 = 0D;
		this.star2 = 0D;
		this.star3 = 0D;
		this.star4 = 0D;
		this.star5 = 0D;
		this.total = 0;
		this.average = 0D;
	}

	public FeedbackStatistic(Long book_id, Double star1, Double star2, Double star3, Double star4, Double star5,
			Integer total, Double average) {
		super();
		this.book_id = book_id;
		this.star1 = star1;
		this.star2 = star2;
		this.star3 = star3;
		this.star4 = star4;
		this.star5 = star5;
		this.total = total;
		this.average = average;
	}

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public Double getStar1() {
		return star1;
	}

	public void setStar1(Double star1) {
		this.star1 = star1;
	}

	public Double getStar2() {
		return star2;
	}

	public void setStar2(Double star2) {
		this.star2 = star2;
	}

	public Double getStar3() {
		return star3;
	}

	public void setStar3(Double star3) {
		this.star3 = star3;
	}

	public Double getStar4() {
		return star4;
	}

	public void setStar4(Double star4) {
		this.star4 = star4;
	}

	public Double getStar5() {
		return star5;
	}

	public void setStar5(Double star5) {
		this.star5 = star5;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}
}

package com.hieu.backend.dto;

import javax.persistence.ColumnResult;
import javax.persistence.EntityResult;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;
import javax.persistence.SqlResultSetMapping;

import com.hieu.backend.entity.Book;

public class BookDTO {
	private Long id;
	private String name;
	private String thumb_nail;
	private String translator;
	private Integer publish_year;
	private Integer cover_form;
	private String cover_formST;
	private Float weight;
	private Float length;
	private Float width;
	private Integer page_count;
	private String description;
	private Integer count;
	private Integer buy_price;
	private Integer sell_price;
	private Float discount_percent;
	private Integer class_id;
	private String class_idST;
	private Integer class_level_id;
	private String class_level_idST;
	private Integer language_id;
	private String language_idST;
	private Long provider_id;
	private String provider_idST;
	private Long publisher_id;
	private String publisher_idST;
	private Integer episode;
	private Long book_set_id;
	private String book_set_idST;
	private String author_idST;

	public BookDTO(Long id, String name, String thumb_nail, String translator, Integer publish_year, Integer cover_form,
			String cover_formST, Float weight, Float length, Float width, Integer page_count, String description,
			Integer count, Integer buy_price, Integer sell_price, Float discount_percent, Integer class_id,
			String class_idST, Integer class_level_id, String class_level_idST, Integer language_id,
			String language_idST, Long provider_id, String provider_idST, Long publisher_id, String publisher_idST,
			Integer episode, Long book_set_id, String book_set_idST, String author_idST) {
		this.id = id;
		this.name = name;
		this.thumb_nail = thumb_nail;
		this.translator = translator;
		this.publish_year = publish_year;
		this.cover_form = cover_form;
		this.cover_formST = cover_formST;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.page_count = page_count;
		this.description = description;
		this.count = count;
		this.buy_price = buy_price;
		this.sell_price = sell_price;
		this.discount_percent = discount_percent;
		this.class_id = class_id;
		this.class_idST = class_idST;
		this.class_level_id = class_level_id;
		this.class_level_idST = class_level_idST;
		this.language_id = language_id;
		this.language_idST = language_idST;
		this.provider_id = provider_id;
		this.provider_idST = provider_idST;
		this.publisher_id = publisher_id;
		this.publisher_idST = publisher_idST;
		this.episode = episode;
		this.book_set_id = book_set_id;
		this.book_set_idST = book_set_idST;
		this.author_idST = author_idST;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPublish_year() {
		return publish_year;
	}

	public void setPublish_year(Integer publish_year) {
		this.publish_year = publish_year;
	}

	public Integer getCover_form() {
		return cover_form;
	}

	public void setCover_form(Integer cover_form) {
		this.cover_form = cover_form;
	}

	public Integer getBuy_price() {
		return buy_price;
	}

	public void setBuy_price(Integer buy_price) {
		this.buy_price = buy_price;
	}

	public Integer getSell_price() {
		return sell_price;
	}

	public void setSell_price(Integer sell_price) {
		this.sell_price = sell_price;
	}

	public Float getDiscount_percent() {
		return discount_percent;
	}

	public void setDiscount_percent(Float discount_percent) {
		this.discount_percent = discount_percent;
	}

	public String getThumb_nail() {
		return thumb_nail;
	}

	public void setThumb_nail(String thumb_nail) {
		this.thumb_nail = thumb_nail;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Integer getPage_count() {
		return page_count;
	}

	public void setPage_count(Integer page_count) {
		this.page_count = page_count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}

	public Integer getClass_level_id() {
		return class_level_id;
	}

	public void setClass_level_id(Integer class_level_id) {
		this.class_level_id = class_level_id;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public Integer getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}

	public String getClass_idST() {
		return class_idST;
	}

	public void setClass_idST(String class_idST) {
		this.class_idST = class_idST;
	}

	public String getClass_level_idST() {
		return class_level_idST;
	}

	public void setClass_level_idST(String class_level_idST) {
		this.class_level_idST = class_level_idST;
	}

	public String getLanguage_idST() {
		return language_idST;
	}

	public void setLanguage_idST(String language_idST) {
		this.language_idST = language_idST;
	}

	public Long getProvider_id() {
		return provider_id;
	}

	public void setProvider_id(Long provider_id) {
		this.provider_id = provider_id;
	}

	public String getProvider_idST() {
		return provider_idST;
	}

	public void setProvider_idST(String provider_idST) {
		this.provider_idST = provider_idST;
	}

	public Long getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(Long publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getPublisher_idST() {
		return publisher_idST;
	}

	public void setPublisher_idST(String publisher_idST) {
		this.publisher_idST = publisher_idST;
	}

	public String getCover_formST() {
		return cover_formST;
	}

	public void setCover_formST(String cover_formST) {
		this.cover_formST = cover_formST;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public Long getBook_set_id() {
		return book_set_id;
	}

	public void setBook_set_id(Long book_set_id) {
		this.book_set_id = book_set_id;
	}

	public String getBook_set_idST() {
		return book_set_idST;
	}

	public void setBook_set_idST(String book_set_idST) {
		this.book_set_idST = book_set_idST;
	}

	public String getAuthor_idST() {
		return author_idST;
	}

	public void setAuthor_idST(String author_idST) {
		this.author_idST = author_idST;
	}
}

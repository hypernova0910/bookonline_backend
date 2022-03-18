package com.hieu.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "devvn_tinhthanhpho")
public class Province {
	@Id
	@Column(name = "matp")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "slug")
	private String slug;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
}

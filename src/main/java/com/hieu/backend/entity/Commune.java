package com.hieu.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "devvn_xaphuongthitran")
public class Commune {
	@Id
	@Column(name = "xaid")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@ManyToOne
	@JoinColumn (name = "maqh")
	private District district;

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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}

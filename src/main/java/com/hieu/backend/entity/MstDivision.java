package com.hieu.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "mst_division")
public class MstDivision {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "dvs_group_cd")
	private String dvs_group_cd;
	
	@Column (name = "dvs_group_name")
	private String dvs_group_name;
	
	@Column (name = "dvs_name")
	private String dvs_name;
	
	@Column (name = "dvs_value")
	private Integer dvs_value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDvs_group_cd() {
		return dvs_group_cd;
	}

	public void setDvs_group_cd(String dvs_group_cd) {
		this.dvs_group_cd = dvs_group_cd;
	}

	public String getDvs_group_name() {
		return dvs_group_name;
	}

	public void setDvs_group_name(String dvs_group_name) {
		this.dvs_group_name = dvs_group_name;
	}

	public String getDvs_name() {
		return dvs_name;
	}

	public void setDvs_name(String dvs_name) {
		this.dvs_name = dvs_name;
	}

	public Integer getDvs_value() {
		return dvs_value;
	}

	public void setDvs_value(Integer dvs_value) {
		this.dvs_value = dvs_value;
	}
}

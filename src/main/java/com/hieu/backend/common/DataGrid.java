package com.hieu.backend.common;

import java.util.List;

public class DataGrid {
	private Long total;
	private Integer curPage;
	private List data;
	
	public Long getTotal() {
		return total;
	}
	
	public void setTotal(Long total) {
		this.total = total;
	}
	
	public Integer getCurPage() {
		return curPage;
	}
	
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
	public List getData() {
		return data;
	}
	
	public void setData(List data) {
		this.data = data;
	}
	
	
}

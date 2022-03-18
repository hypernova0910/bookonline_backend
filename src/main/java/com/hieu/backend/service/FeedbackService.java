package com.hieu.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hieu.backend.common.DataGrid;
import com.hieu.backend.dao.FeedbackDAO;
import com.hieu.backend.dto.FeedbackStatistic;
import com.hieu.backend.entity.Book;
import com.hieu.backend.entity.Feedback;

@Service
@Transactional
public class FeedbackService {
	@Autowired
	private FeedbackDAO feedbackDAO;
	
//	public List<Feedback> findAll(int offset, int limit){
//		return feedbackDAO.findAll(offset, limit);
//	}
	
	public Long add(final Feedback feedback) {
		return feedbackDAO.persist(feedback);
	}
	
	public DataGrid findAllDataGrid(int curPage, int limit, Long bookId) {
		int offset = (curPage - 1) * limit;
		DataGrid grid = new DataGrid();
		Long count = feedbackDAO.count(bookId);
		grid.setTotal(count);
		grid.setCurPage(curPage);
		grid.setData(new ArrayList<Book>());
		if(count > 0) {
			grid.setData(feedbackDAO.findAll(offset, limit, bookId));
		}
		return grid;
	}
	
	public FeedbackStatistic statistic(Long book_id) {
		if(feedbackDAO.count(book_id) > 0) {
			return feedbackDAO.statistic(book_id);
		}
		else {
			return new FeedbackStatistic();
		}
	}
}

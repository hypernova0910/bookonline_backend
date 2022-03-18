package com.hieu.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hieu.backend.common.Constants;
import com.hieu.backend.common.DataGrid;
import com.hieu.backend.dto.FeedbackStatistic;
import com.hieu.backend.entity.Feedback;
import com.hieu.backend.service.FeedbackService;

@CrossOrigin(origins = Constants.CROSS_ORIGIN)
@RestController
@RequestMapping("feedback")
public class FeedbackController {
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("getAllDataGrid/{curPage}/{limit}")
	public DataGrid getAllDataGrid(@PathVariable int curPage, @PathVariable int limit,
			@RequestParam Long bookId
	){
		return feedbackService.findAllDataGrid(curPage, limit, bookId);
	}
	
	@PostMapping("add")
	public Long add(@RequestBody Feedback feedback) {
		return feedbackService.add(feedback);
	}
	
	@GetMapping("statistic")
	public FeedbackStatistic statistic(@RequestParam Long bookId) {
		return feedbackService.statistic(bookId);
	}
}

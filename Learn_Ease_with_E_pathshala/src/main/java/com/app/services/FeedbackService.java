package com.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Feedback;
import com.app.repository.FeedbackDao;

@Transactional
@Service
public class FeedbackService {
	@Autowired
	private FeedbackDao feedbackdao;
	

	public boolean addFeedback(Feedback feedback) {
		if (feedbackdao.save(feedback)!=null)
			return true;
		return false;
	}
	
	
	
//
	public List<Object> findAllFeedback(){
		List<Object> feedbackList =feedbackdao.findByAllFeedbackk();
		return feedbackList;

	}
	
//	
	public Feedback findByFeedbackId(int feedbackid) {
		Feedback feedback = feedbackdao.findByFeedbackid(feedbackid);
		return feedback;
	}

}

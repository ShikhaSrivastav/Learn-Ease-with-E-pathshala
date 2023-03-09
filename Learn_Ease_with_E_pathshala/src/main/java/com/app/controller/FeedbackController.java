package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Response;
import com.app.entity.Feedback;
import com.app.services.FeedbackService;

@CrossOrigin
@RestController
public class FeedbackController {
	
	
@Autowired
private FeedbackService feedbackservice;


@PostMapping("/addFeedback")
public ResponseEntity<?> addNewFeedback(@RequestBody Feedback newFeedback)
{
	if(feedbackservice.addFeedback(newFeedback))	
		return Response.success("Package added...");
	return Response.error("Package not added");
}



//
//
@GetMapping("/feedbackk/all")
public ResponseEntity<?> findAllFeedback(){
	List<Object> result = new ArrayList<>();
	result = feedbackservice.findAllFeedback();
	return Response.success(result);

	}
//
@GetMapping("/feedback/find/{Feedbackid}")
public ResponseEntity<?> findFeedbackById(@PathVariable("Feedbackid") int id){
	Feedback result = feedbackservice.findByFeedbackId(id);
	return Response.success(result);
}

}

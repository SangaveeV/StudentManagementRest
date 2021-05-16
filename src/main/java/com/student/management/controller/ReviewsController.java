package com.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.management.model.RecordNotFoundException;
import com.student.management.model.Reviews;
import com.student.management.service.ReviewsService;

@Controller
@RequestMapping("/course")
public class ReviewsController {
	
	@Autowired
	ReviewsService reviewsService;

	@GetMapping("/reviews/{id}")
	public ResponseEntity<List<Reviews>> getReviews(@PathVariable int id){
		if(reviewsService.getReviewsByCourseId(id).isEmpty()) {
			throw new RecordNotFoundException("No Reviews found for the course id : " +id );
		}
		List<Reviews> reviews=reviewsService.getReviewsByCourseId(id);
		return new ResponseEntity<List<Reviews>>(reviews,HttpStatus.FOUND);
	}
	
	@PostMapping("/reviews/add")
	public ResponseEntity<Reviews> addReviews(@RequestBody Reviews review){
		Reviews newReview=reviewsService.addReviews(review);
		return new ResponseEntity<Reviews>(newReview,HttpStatus.CREATED);
	}
	
	
}

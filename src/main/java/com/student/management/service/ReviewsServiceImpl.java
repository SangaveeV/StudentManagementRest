package com.student.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.management.model.Reviews;
import com.student.management.repository.ReviewsRepository;

@Service
public class ReviewsServiceImpl implements ReviewsService {
	
	@Autowired
	ReviewsRepository reviewsRepository;

	@Override
	public Reviews addReviews(Reviews review) {
		return reviewsRepository.save(review);
	}

	@Override
	public List<Reviews> getReviewsByCourseId(Integer id) {
		return reviewsRepository.findByCourseId(id);
	}

}

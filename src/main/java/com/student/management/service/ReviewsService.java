package com.student.management.service;

import java.util.List;

import com.student.management.model.Reviews;

public interface ReviewsService {

	Reviews addReviews(Reviews review);
	List<Reviews> getReviewsByCourseId(Integer id);
}

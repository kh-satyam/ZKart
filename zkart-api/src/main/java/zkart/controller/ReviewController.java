package zkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zkart.entity.Review;
import zkart.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("")
	public List<Review> getAllReviews() {
		return reviewService.getAllReviews();
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addReview(Review review) {
		if(reviewService.saveReview(review))
			return new ResponseEntity<>("Success.", HttpStatus.OK);
		return new ResponseEntity<>("Error!", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateReview(@PathVariable("id") Integer id, Review review) {
		review.setId(id);
		if(reviewService.saveReview(review))
			return new ResponseEntity<>("Success.", HttpStatus.OK);
		return new ResponseEntity<>("Error!", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/listing/{id}")
	public List<Review> getReviewByItemId(@PathVariable("id") Integer id) {
		return reviewService.getAllReviewsByItemId(id);
	}
	
	@GetMapping("/listing/avg/{id}")
	public double getAvgReviewByItemId(@PathVariable("id") Integer id) {
		List<Review> reviews = reviewService.getAllReviewsByItemId(id);
		double avgRating = 0.0f;
		for (Review review : reviews) {
			avgRating += review.getStars();
		}
		return avgRating / reviews.size();
	}

	@GetMapping("/seller/{id}")
	public List<Review> getReviewBySellerId(@PathVariable("id") Integer id) {
		return reviewService.getAllReviewsBySellerId(id);
	}

	@GetMapping("/user/{id}")
	public List<Review> getFlopkartReviewByUserId(@PathVariable("id") Integer id) {
		return reviewService.getAllReviewByUserId(id);
	}
}
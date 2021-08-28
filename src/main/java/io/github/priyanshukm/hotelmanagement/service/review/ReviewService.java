package io.github.priyanshukm.hotelmanagement.service.review;

import io.github.priyanshukm.hotelmanagement.model.review.Review;
import io.github.priyanshukm.hotelmanagement.repository.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Review review) {
        reviewRepository.delete(review);
    }

    public Optional<Review> findReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public List<Review> findReviewByUserName(String userName) {
        return reviewRepository.findByUserName(userName);
    }
}

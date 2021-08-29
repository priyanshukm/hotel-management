package io.github.priyanshukm.hotelmanagement.service.review;

import io.github.priyanshukm.hotelmanagement.exception.ReviewNotFoundException;
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

    public Review findReviewById(Long reviewId) throws ReviewNotFoundException {
        Optional<Review> review = reviewRepository.findById(reviewId);

        if (review.isEmpty()) {
            throw new ReviewNotFoundException("No review found for reviewId=" + reviewId);
        }

        return review.get();
    }

    public List<Review> findReviewByUserName(String userName) throws ReviewNotFoundException {
        List<Review> reviews = reviewRepository.findByUserName(userName);

        if (reviews.size() == 0) {
            throw new ReviewNotFoundException("No review found for user=" + userName);
        }

        return reviews;
    }
}

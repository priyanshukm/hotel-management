package io.github.priyanshukm.hotelmanagement.controller.review;

import io.github.priyanshukm.hotelmanagement.model.review.Review;
import io.github.priyanshukm.hotelmanagement.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Optional<Review>> FetchReviewsById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(reviewService.findReviewById(id));
    }

    @GetMapping("/fetch/{name}")
    public ResponseEntity<List<Review>> FetchReviewsByName(@PathVariable("username") String name) {
        return ResponseEntity.ok(reviewService.findReviewByUserName(name));
    }
}

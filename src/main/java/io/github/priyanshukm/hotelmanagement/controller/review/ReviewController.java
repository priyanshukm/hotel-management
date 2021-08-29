package io.github.priyanshukm.hotelmanagement.controller.review;

import io.github.priyanshukm.hotelmanagement.exception.ReviewNotFoundException;
import io.github.priyanshukm.hotelmanagement.model.review.Review;
import io.github.priyanshukm.hotelmanagement.service.review.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@Slf4j
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/fetch")
    public ResponseEntity<List<Review>> fetchReviews(
            @RequestParam("id") Optional<Long> id, @RequestParam("username") Optional<String> name) {

        List<Review> allReviews = new ArrayList<>();
        log.info("Received request to fetch reviews id=" + id.orElse(0L) + " AND name=" + name.orElse("<nil>"));

        try {
            if (id.isPresent()) {
                Review review = reviewService.findReviewById(id.get());
                allReviews.add(review);

                log.info("Fetched reviews " + allReviews);
                return ResponseEntity.ok(allReviews);
            }

            if (name.isPresent()) {
                List<Review> reviews = reviewService.findReviewByUserName(name.get());
                allReviews.addAll(reviews);

                log.info("Fetched reviews " + allReviews);
                return ResponseEntity.ok(allReviews);
            }
        } catch (ReviewNotFoundException e) {
            log.error("Details: {}", e.getMessage());
            return ResponseEntity.notFound().build();
        }

        log.error("Empty reviewId and userName");
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review) throws Exception {

        log.info("Received request to add review " + review);

        Review r = reviewService.addReview(review);

        log.info("Successfully added review" + review);

        return ResponseEntity.ok(r);
    }
}

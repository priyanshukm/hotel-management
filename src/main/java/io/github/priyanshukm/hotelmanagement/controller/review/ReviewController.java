package io.github.priyanshukm.hotelmanagement.controller.review;

import io.github.priyanshukm.hotelmanagement.model.review.Review;
import io.github.priyanshukm.hotelmanagement.service.review.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@Slf4j
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/fetch")
    public ResponseEntity<List<Review>> FetchReviews(
            @RequestParam("id") Optional<Long> id,
            @RequestParam("username") Optional<String> name
    ) throws NoSuchElementException {

        List<Review> allReviews = new ArrayList<>();

        log.info("Fetching Reviews id=" + id.orElse(0L) + " AND name=" + name.orElse("<nil>"));

        id.ifPresent(aLong -> allReviews.add(reviewService.findReviewById(aLong).orElseThrow()));
        name.ifPresent(aString -> allReviews.addAll(reviewService.findReviewByUserName(aString)));

        log.info("Fetched reviews - " + allReviews);

        return ResponseEntity.ok(allReviews);
    }
}

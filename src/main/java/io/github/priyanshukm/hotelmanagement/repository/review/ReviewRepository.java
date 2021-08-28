package io.github.priyanshukm.hotelmanagement.repository.review;

import io.github.priyanshukm.hotelmanagement.model.review.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Interface that implements Review Repository, with JPA CRUD methods
 *
 */
@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    /**
     *
     * @param userName of the user for which reviews are to be fetched
     * @return List<Review>
     */
    List<Review> findByUserName(String userName);
}

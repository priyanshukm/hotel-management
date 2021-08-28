package io.github.priyanshukm.hotelmanagement.model.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    private Long id;

    @Indexed
    private String userName;

    private Long score;

    private List<String> data;
}
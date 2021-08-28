package io.github.priyanshukm.hotelmanagement.model.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    private Long id;

    @Indexed
    @Field("username")
    private String userName;

    @Field("score")
    private Long score;

    @Field("data")
    private List<String> data;
}
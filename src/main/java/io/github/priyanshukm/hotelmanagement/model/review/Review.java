package io.github.priyanshukm.hotelmanagement.model.review;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Indexed(unique=true)
    @Field("id")
    @JsonAlias("id")
    private Long id;

    @Indexed
    @Field("username")
    @JsonAlias("username")
    private String userName;

    @Field("score")
    @JsonAlias("score")
    private Long score;

    @Field("data")
    @JsonAlias("data")
    private List<String> data;
}
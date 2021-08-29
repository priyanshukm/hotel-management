package io.github.priyanshukm.hotelmanagement.model.user;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Indexed
    @Field("id")
    @JsonAlias("id")
    private String id;

    @Indexed
    @Field("name")
    @JsonAlias("name")
    private String name;
}
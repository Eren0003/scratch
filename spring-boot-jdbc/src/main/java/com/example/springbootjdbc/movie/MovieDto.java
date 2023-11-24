package com.example.springbootjdbc.movie;

import com.example.springbootjdbc.actor.Actor;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieDto{
    @Min(1)
    int id;
    @NotBlank(message = "Moviename is blank")
    String moviename;
    List<@Valid Actor>  actors;
    @NotNull(message = "dateOfBirth is required")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    LocalDate releaseDate;
}

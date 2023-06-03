package com.Movie.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Data
public class Movie {
    private String title;
    private String rating;
    private String overview;
    private String releaseYear;
    private String posterUrl;
    private String votes;
    private String genre;
    private String actor;
    private String director;
    private String language;

    public Movie(String title, String overview, String releaseYear, String posterUrl, String rating, String votes, String genre, String director, String actor, String language) {
        this.title = title;
        this.overview = overview;
        this.releaseYear = releaseYear;
        this.posterUrl = posterUrl;
        this.rating = rating;
        this.votes = votes;
        this.genre = genre;
        this.director = director;
        this.actor = actor;
        this.language = language;
    }
}

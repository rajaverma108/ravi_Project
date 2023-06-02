package com.Movie.services;

import com.Movie.entities.Movie;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${API_key}")
    String requesturl;

    public List<Movie> getMovieByName(String title) throws IOException {
        ResponseEntity<String> response = restTemplate.getForEntity(requesturl + title, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.readTree(response.getBody());
        List<Movie> movies = new ArrayList<>();

        try {
            String movietitle = json.get("Title").asText();
            String releseYear = json.get("Released").asText();
            String posterUrl = json.get("Poster").asText();
            String rating = json.get("imdbRating").asText();
            String description = json.get("Plot").asText();
            String votes = json.get("imdbVotes").asText();
            String genre = json.get("Genre").asText();
            String director = json.get("Director").asText();
            String actor = json.get("Actors").asText();
            String language = json.get("Language").asText();
            movies.add(new Movie(movietitle, description, releseYear, posterUrl, rating, votes, genre, director, actor, language));
        } catch (Exception e) {
            movies.add(new Movie("Not Found", "N/A", "N/A", "https://dam.muyinteresante.com.mx/wp-content/uploads/2020/04/error-404.jpg", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"));
        }
        return movies;
    }
}

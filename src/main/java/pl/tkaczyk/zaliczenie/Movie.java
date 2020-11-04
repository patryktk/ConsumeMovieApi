package pl.tkaczyk.zaliczenie;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "movie_id",
        "movie_name",
        "movie_genre"
})
public class Movie {

    @JsonProperty("movie_id")
    private Integer movieId;
    @JsonProperty("movie_name")
    private String movieName;
    @JsonProperty("movie_genre")
    private String movieGenre;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("movie_id")
    public Integer getMovieId() {
        return movieId;
    }

    @JsonProperty("movie_id")
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    @JsonProperty("movie_name")
    public String getMovieName() {
        return movieName;
    }

    @JsonProperty("movie_name")
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @JsonProperty("movie_genre")
    public String getMovieGenre() {
        return movieGenre;
    }

    @JsonProperty("movie_genre")
    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
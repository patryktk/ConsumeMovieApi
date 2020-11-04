package pl.tkaczyk.zaliczenie;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiController {


    RestTemplate restTemplate = new RestTemplate();

    public ApiController() {
    }

    public List<Movie> allMovies() {
        List<Movie> movieList = new ArrayList<>();
        Movie[] movies = restTemplate.getForObject("https://pkowaleckimoviesapi.herokuapp.com/movie/allMovies", Movie[].class);
        return getMovieList(movieList, movies);
    }

    public List<Movie> selectMovie(String title) {
        List<Movie> movieList = new ArrayList<>();
        Movie[] movies = restTemplate.getForObject("https://pkowaleckimoviesapi.herokuapp.com/movie/getMovie/" + title, Movie[].class);
        return getMovieList(movieList, movies);
    }

    public void deleteMovie(String title) {
        restTemplate.getForObject("https://pkowaleckimoviesapi.herokuapp.com/movie/deleteMovie/" + title, Movie.class);
    }

    private List<Movie> getMovieList(List<Movie> movieList, Movie[] movies) {
        for (Movie movie1 : movies) {
            Movie newMovie = new Movie();
            newMovie.setMovieId(movie1.getMovieId());
            newMovie.setMovieName(movie1.getMovieName());
            newMovie.setMovieGenre(movie1.getMovieGenre());
            movieList.add(newMovie);
        }
        return movieList;
    }


    public void addMovie(String title, String genre) {
        String url = "https://pkowaleckimoviesapi.herokuapp.com/movie/addMovie";
        Movie movie1 = new Movie();
        movie1.setMovieName(title);
        movie1.setMovieGenre(genre);
        ResponseEntity<Movie> responseEntity = restTemplate.postForEntity(url, movie1, Movie.class);
    }

//    public void editName(String prevTitle,String genre ,String title) {
//        String url = "localhost:8081/movie/editMovie/" + prevTitle;
//        Movie movie1 = new Movie();
//        movie1.setMovieName(title);
//        ResponseEntity<Movie> responseEntity = restTemplate.postForEntity(url, movie1, Movie.class);
//    }

}

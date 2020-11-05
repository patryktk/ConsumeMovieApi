package pl.tkaczyk.zaliczenie;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Route("Consume")
public class ApiGUI extends VerticalLayout {

    ApiController apiController;
    Grid<Movie> grid = new Grid<>(Movie.class);
    List<Movie> movieList = new ArrayList<>();
    private HorizontalLayout horizontalLayout;
    private VerticalLayout verticalLayout;
    private TextField nameField;
    private TextField secondField;
    private Movie movie;
    private TextField thirdField;


    @Autowired
    public ApiGUI(ApiController apiController) {
        this.apiController = apiController;
        start();

    }

    private void start() {
        verticalLayout = new VerticalLayout();
        horizontalLayout = new HorizontalLayout();
        startButtons();
    }

    private void startButtons() {
        Button showGridButton = new Button("Show me Films");
        showGridButton.addClickListener(buttonClickEvent -> {
            refresh();
            createGrid();
        });
        Button showOneFilm = new Button("Serach for film");
        showOneFilm.addClickListener(buttonClickEvent -> {
            refresh();
            searchMovie();
        });
        Button deleteButton = new Button("Delete");
        deleteButton.addClickListener(buttonClickEvent -> {
            refresh();
            deleteMovie();
            createGrid();
        });
        Button addButton = new Button("Add");
        addButton.addClickListener(buttonClickEvent -> {
            refresh();
            addMovie();
            createGrid();
        });
        Button editNameButton = new Button("Edit Name");
        editNameButton.addClickListener(buttonClickEvent -> {
            refresh();
            editName();
            createGrid();
        });
        Button editGenreButton = new Button("Edit Genre");
        editGenreButton.addClickListener(buttonClickEvent -> {
            refresh();
            editGenre();
            createGrid();
        });

        horizontalLayout.add(showGridButton, showOneFilm, deleteButton, addButton, editNameButton, editGenreButton);
        add(horizontalLayout);
    }

    private void editGenre() {
        nameField = new TextField();
        nameField.setPlaceholder("Movie title");
        secondField = new TextField();
        secondField.setPlaceholder("Genre to change");
        Button editButton = new Button("Submit");
        editButton.addClickListener(buttonClickEvent -> {
            verticalLayout.remove(grid);
            apiController.editGenre(nameField.getValue(), secondField.getValue());
            nameField.setValue("");
            secondField.setValue("");
            createGrid();
        });
        verticalLayout.add(nameField, secondField, editButton);
        add(verticalLayout);
    }

    private void editName() {
        nameField = new TextField();
        nameField.setPlaceholder("Title before change");
        secondField = new TextField();
        secondField.setPlaceholder("Title after change");
        Button editButton = new Button("Submit");
        editButton.addClickListener(buttonClickEvent -> {
            verticalLayout.remove(grid);
            apiController.editName(nameField.getValue(), secondField.getValue());
            nameField.setValue("");
            secondField.setValue("");
            createGrid();
        });
        verticalLayout.add(nameField, secondField, editButton);
        add(verticalLayout);
    }

    private void addMovie() {
        nameField = new TextField();
        nameField.setPlaceholder("Title of movie");
        secondField = new TextField();
        secondField.setPlaceholder("Genre of movie");
        Button addButton = new Button("Submit");
        addButton.addClickListener(buttonClickEvent -> {
            verticalLayout.remove(grid);
            apiController.addMovie(nameField.getValue(), secondField.getValue());
            nameField.setValue("");
            secondField.setValue("");
            createGrid();
        });
        verticalLayout.add(nameField, secondField, addButton);
        add(verticalLayout);
    }

    private void deleteMovie() {
        nameField = new TextField();
        nameField.setPlaceholder("Title of movie to delete");
        Button deleteMovieButton = new Button("Submit");
        deleteMovieButton.addClickListener(buttonClickEvent -> {
            verticalLayout.remove(grid);
            apiController.deleteMovie(nameField.getValue());
            nameField.setValue("");
            createGrid();
        });
        verticalLayout.add(nameField, deleteMovieButton);
        add(verticalLayout);
    }

    private void refresh() {
        verticalLayout.removeAll();
    }

    private void searchMovie() {
        nameField = new TextField();
        nameField.setPlaceholder("Title of movie");
        Button searchMovieButton = new Button("Submit");
        searchMovieButton.addClickListener(buttonClickEvent -> {
            gridForOne(nameField.getValue());
        });
        verticalLayout.add(nameField, searchMovieButton);
        add(verticalLayout);

    }

    private void gridForOne(String tytuł) {
        grid = new Grid<>(Movie.class);
        movieList = apiController.selectMovie(tytuł);
        configureGrid();
        grid.setItems(movieList);
        verticalLayout.add(grid);
        add(verticalLayout);
    }

    private void createGrid() {
        grid = new Grid<>(Movie.class);
        movieList = apiController.allMovies();
        configureGrid();
        grid.setItems(movieList);
        verticalLayout.add(grid);
        add(verticalLayout);
    }

    private void configureGrid() {
        grid.addClassName("movies");
        grid.removeAllColumns();
        Grid.Column<Movie> idColumn = grid.addColumn(Movie::getMovieId).setHeader("ID");
        Grid.Column<Movie> nameColumn = grid.addColumn(Movie::getMovieName).setHeader("Tytuł");
        Grid.Column<Movie> genreColumn = grid.addColumn(Movie::getMovieGenre).setHeader("Gatunek");

    }


}

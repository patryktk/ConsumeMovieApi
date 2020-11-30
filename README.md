# Consume Movie API
Jest to aplikacja która konsumuje API "Movie API" <br>
Front aplikacji został wykonany z pomocą Vaadin<br>
Back aplikacji to spring-boot<br>
Link do API: https://github.com/pkowalecki/MovieApi

## Opis funkcjonalności <Br>
<b>"Show me films"</b><br>
![Show me films](/img/showmefilms.png)<br><br>
Pokazuje nam listę wszystkich filmów w bazie danych
<br>
<b>"Search for films"</b><br>
![Search for films](/img/showmefilms.png)<br><br>
Wyszukuje dany film po nazwie
<br>
<b>"Delete"</b><br>
![Delete](/img/showmefilms.png)<br><br>
Usuwamy film z naszej bazy po podaniu jego nazwy
<br>
<b>"Add"</b><br>
![Add](/img/showmefilms.png)<br><br>
Dodajemy film do naszej bazy
<br>
<b>"Edit Name"</b><br>
![Edit Name](/img/showmefilms.png)<br><br>
Edytujemy nazwę filmu
<br>
<b>"Edit Genre"</b><br>
![Edit Genre](/img/showmefilms.png)<br><br>
Edytujemy gatunek filmu
<br>
## Zawartość aplikacji <Br>
### .../zaliczenie/API/ApiService<br>
**allMovies()**
<br>Metoda która pobiera listę wszystkich filmów z API i zapisuje je do Listy<br>
**selectMovie(String title)**
<br>Metoda która wyciąga pojedynczy film z API, za pomocą tytułu który przekazujemy do metody<br>
**deleteMovie(String title)**
<br>Metoda która usuwa dany film, po tym jak podany tytuł tego filmu<br>
**getMovieList(List<Movie> movieList, Movie[] movies)**
<br>Ta metoda przepisuje nam dane, które wyciągamy za pomocą allMovies(), do listy która jest możliwa do wyświetlania za pomocą Vaadina<br>
**addMovie(String title, String genre)**
<br>Metoda która dodaje film, do bazy. Aby dodać wysyłamy do API ResponseEntity z odwołaniem do naszego modelu, a zwracany element to restTemplate.postForEntity, gdzie parametrami jest url(czyli link do naszego API), obiekt oraz Klasa modelowa.<br>
**editName(String prevTitle, String title)**
<br>Metoda dokonuje edycji nazwy filmu, po podaniu poprzedniego tytułu filmu, do url z edycju nazwy doklejemay tytuł filmu, w ten sposób API go znajduje. Następnie przekazujemy w body zmienioną nazwę filmu.<br>
**editGenre(String title, String genre)**
<br>Metoda doknuje edycji gatunkuj filmu, jak w poprzednim przypadku, podajemy tytuł filmu, a następnie przekazujemy w body nazwę gatnuku.<br>
### .../zaliczenie/model/Movie<br>
Model aplikacji
### .../zaliczenie/API/ApiGUI<br>
<br>@Route("") - ustawia naszą stronę, jako stronę startową<br>
**start()**
<br>Tutaj startuje nasze całe GUI, definiuje layouty, wertykalny i horyzontalny, definiują one rozmieszczenie elemntów na naszej stronie. Następnie wywołuje startowe przyciski<br>
**startButtons()**
<br>Tutaj zdefiniowane są wszystkie przyciski jakie mam na stronie. A także clickevent, czyli co się stanie po ich wciśnięciu. Przy każdym wciśnięciu wykonuje się metoda refresh()<br>
**editGenre()** **addMovie()** **editName()**
<br>Tworzy dwa pola tekstowe oraz button. Po wciśnięciu przycisku potwierdzającego, odświeża nasz grid<br>
**refresh()**
<br>Usuwa wszystkie elementy z werytkalnego układu<br>
**gridForOne()** **createGrdi()**
<br>Tworzy tabele, odwołuje się do metody configureGrid()<br>
**configureGrid()**
<br>Opisuję układ naszej całej tabeli, uwzględniając nazwę tabeli oraz wszystkie nazwy kolumn.<br>

![Diagram](/img/diagramy.png)<br><br>

Screeny z aplikacji <br>
Strona głóna <br>
![Strona Główna](/img/Stronagłówna.png)<br><br>
Show Me Films <br>
![ShowMeFilms](/img/showmefilms_pokaz.png)<br><br>
Search For Film<br>
![SearchForFilm](/img/searchfofilmpokaz.png)<br><br>
Delete<br>
![Delete](/img/Delete_pokaz.png)<br><br>
Add<br>
![Add_1](/img/Add_1.png)<br><br>
![Add_2](/img/Add_2.png)<br><br>
Edit Name<br>
![EditName_1](/img/EditName_1.png)<br><br>
![EditName_2](/img/EditName_2.png)<br><br>
Edit Genre<br>
![Diagram](/img/EditGenre_1.png)<br><br>
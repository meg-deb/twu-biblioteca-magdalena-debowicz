package com.twu.biblioteca;

public class Movie {
    //instance variables/ class fields
    private int id;
    private String title;
    private String director;
    private String year;
    private String rating;

    //constructor declaration
    public Movie( int id, String title, String director, String year, String rating){
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String giveMovieDataAsString() {
        return "Movie id: " + id + " | " + title + " | " + director + " | " + year + " | " + "Rating: " + rating;
    }

}

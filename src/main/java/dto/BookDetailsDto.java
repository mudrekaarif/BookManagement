package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDetailsDto {
    private long id;
    private String title;
    private String author;

    public BookDetailsDto() {
    }

    public BookDetailsDto(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public BookDetailsDto(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getAuthor() {
        return author;
    }
}
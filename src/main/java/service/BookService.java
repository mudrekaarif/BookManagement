package service;

import dto.BookDetailsDto;
import exceptions.BookNotFoundException;

public interface BookService {

    public BookDetailsDto getBookById(long id);

    public long getBooksByAuthor(String author);

    public BookDetailsDto createNewBook(String title, String author);

    public BookDetailsDto updateBook(long id, String updatedTitle, String updatedAuthor);

    public void deleteBook(long id);
}

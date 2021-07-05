package service;

import dao.BookDetailsDAO;
import dto.BookDetailsDto;
import entity.BookDetails;
import exceptions.BookNotFoundException;
import mapper.BookDetailEntityToDto;

public class BookServiceImpl implements BookService{
    private BookDetailsDAO bookDetailsDAO;

    public BookServiceImpl(BookDetailsDAO bookDetailsDAO) {
        this.bookDetailsDAO = bookDetailsDAO;
    }

    @Override
    public BookDetailsDto getBookById(long id) {
        BookDetails bookDetailsEntity = bookDetailsDAO.findById(id);
        if(bookDetailsEntity == null) throw new BookNotFoundException("Book id is invalid");
        return BookDetailEntityToDto.convert(bookDetailsEntity);
    }

    @Override
    public long getBooksByAuthor(String author) {
        return bookDetailsDAO.countBooksByAuthor(author);
    }

    @Override
    public BookDetailsDto createNewBook(String title, String author) {
        BookDetails bookDetailsEntity = bookDetailsDAO.create(new BookDetails(title, author));
        return BookDetailEntityToDto.convert(bookDetailsEntity);
    }

    @Override
    public BookDetailsDto updateBook(long id, String updatedTitle, String updatedAuthor) {
        bookDetailsDAO.update(new BookDetails(id,updatedTitle, updatedAuthor));
        return getBookById(id);
    }

    @Override
    public void deleteBook(long id) {
        getBookById(id);
        bookDetailsDAO.delete(id);
    }
}

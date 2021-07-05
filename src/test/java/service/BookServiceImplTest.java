package service;

import dao.BookDetailsDAO;
import dto.BookDetailsDto;
import entity.BookDetails;
import exceptions.BookNotFoundException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceImplTest {

    private static final BookDetailsDAO dao = mock(BookDetailsDAO.class);
    private BookDetails bookDetails;

    @Before
    void setup() {
        bookDetails = new BookDetails(1L,"title","author");
    }

    @Test
    void getBookById() {
        when(dao.findById(1L)).thenReturn(bookDetails);
        when(dao.findById(2L)).thenReturn(null);

        BookService bookService = new BookServiceImpl(dao);
        BookDetailsDto expectedOutput = new BookDetailsDto(1L, "title", "author");

        assertTrue(EqualsBuilder.reflectionEquals(expectedOutput,bookService.getBookById(1L)));
        assertThrows(BookNotFoundException.class,()-> bookService.getBookById(2L));
    }

}
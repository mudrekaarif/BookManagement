package resources;

import dto.BookDetailsDto;
import dto.MessageDto;
import exceptions.BookNotFoundException;
import io.dropwizard.hibernate.UnitOfWork;
import service.BookService;
import service.BookServiceImpl;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookDetailsResource {
    private BookService bookService;

    public BookDetailsResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    @UnitOfWork
    public BookDetailsDto getBookInfoById(@QueryParam("id") long id) {
        return bookService.getBookById(id);
    }

    @GET
    @UnitOfWork
    @Path("/author")
    public MessageDto getNumberOfBooksByAuthor(@QueryParam("name") String author) {
        return new MessageDto("Number of books by author " + author + " are "
                + bookService.getBooksByAuthor(author));
    }

    @POST
    @UnitOfWork
    public BookDetailsDto saveBookInfo(BookDetailsDto bookDetailsDto) {
        return bookService.createNewBook(bookDetailsDto.getTitle(), bookDetailsDto.getAuthor());
    }

    @PUT
    @UnitOfWork
    public BookDetailsDto updateBookInfo(BookDetailsDto bookDetailsDto,@QueryParam("id") long id) {
        return bookService.updateBook(id,bookDetailsDto.getTitle(), bookDetailsDto.getAuthor());
    }

    @DELETE
    @UnitOfWork
    public MessageDto deleteBookById(@QueryParam("id") long id) {
        bookService.deleteBook(id);
        return new MessageDto("Successfully deleted");
    }
}

package mapper;

import dto.BookDetailsDto;
import entity.BookDetails;

public class BookDetailEntityToDto {
    public static BookDetailsDto convert(BookDetails bookDetails) {
        if(bookDetails == null) return null;
        return new BookDetailsDto(bookDetails.getId(), bookDetails.getTitle(), bookDetails.getAuthor());
    }
}

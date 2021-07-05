package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InventoryDetailsDto {
    private long id;
    private long bookId;
    private String title;
    private long quantity;

    public InventoryDetailsDto() {
    }

    public InventoryDetailsDto(long id, long bookId, String title, long quantity) {
        this.id = id;
        this.bookId = bookId;
        this.title = title;
        this.quantity = quantity;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public long getBookId() {
        return bookId;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public long getQuantity() {
        return quantity;
    }
}

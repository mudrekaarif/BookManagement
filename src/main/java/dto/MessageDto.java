package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {
    String message;

    public MessageDto(String message) {
        this.message = message;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }
}

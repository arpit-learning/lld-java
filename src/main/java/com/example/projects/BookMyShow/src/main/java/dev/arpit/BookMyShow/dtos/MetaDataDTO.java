package dev.arpit.BookMyShow.dtos;

public class MetaDataDTO {
    private String message;
    private ResponseCode code;
    private String displayMessage;

    public MetaDataDTO() {}

    public MetaDataDTO(String message, ResponseCode code, String displayMessage) {
        this.message = message;
        this.code = code;
        this.displayMessage = displayMessage;
    }

    public String getMessage() {
        return message;
    }

    public MetaDataDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseCode getCode() {
        return code;
    }

    public MetaDataDTO setCode(ResponseCode code) {
        this.code = code;
        return this;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public MetaDataDTO setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
        return this;
    }
}

package dev.arpit.BookMyShow.dtos;

public class MetaDataDTO {
    private String message;
    private String code;

    public MetaDataDTO() {}

    public MetaDataDTO(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public MetaDataDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public MetaDataDTO setCode(String code) {
        this.code = code;
        return this;
    }
}

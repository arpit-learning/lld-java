package dev.arpit.BookMyShow.dtos;

public class ResponseDTO<T> {
    private T data;
    private MetaDataDTO meta;

    public ResponseDTO() {}

    public ResponseDTO(T data, MetaDataDTO meta) {
        this.data = data;
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public ResponseDTO<T> setData(T data) {
        this.data = data;
        return this;
    }

    public MetaDataDTO getMeta() {
        return meta;
    }

    public ResponseDTO<T> setMeta(MetaDataDTO meta) {
        this.meta = meta;
        return this;
    }
}

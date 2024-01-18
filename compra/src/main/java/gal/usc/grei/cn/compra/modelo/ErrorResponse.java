package gal.usc.grei.cn.compra.modelo;

import java.time.LocalDateTime;
import java.util.Objects;

public class ErrorResponse {
    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorResponse that)) return false;
        return getStatus() == that.getStatus() && Objects.equals(getTimestamp(), that.getTimestamp()) && Objects.equals(getError(), that.getError()) && Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getPath(), that.getPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimestamp(), getStatus(), getError(), getMessage(), getPath());
    }
}

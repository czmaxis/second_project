package org.second.project;

import java.time.LocalDateTime;

public class ErrorResponse {
    public String message;
    public LocalDateTime timestamp;

    public ErrorResponse(String message, LocalDateTime now) {
        this.message = message;
        this.timestamp = now;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

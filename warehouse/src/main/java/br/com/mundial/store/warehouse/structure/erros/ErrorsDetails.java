package br.com.mundial.store.warehouse.structure.erros;

import java.time.LocalDateTime;

public class ErrorsDetails {

    private String title;
    private int status;
    private String detail;
    private LocalDateTime timestamp;
    private String developerMessage;


    private ErrorsDetails() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }


    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private LocalDateTime timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withStatus(int status) {
            this.status = status;
            return this;
        }

        public Builder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder withDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ErrorsDetails build() {
            ErrorsDetails errorsDetails = new ErrorsDetails();
            errorsDetails.setTitle(title);
            errorsDetails.setStatus(status);
            errorsDetails.setDetail(detail);
            errorsDetails.setTimestamp(timestamp);
            errorsDetails.setDeveloperMessage(developerMessage);
            return errorsDetails;
        }
    }
}

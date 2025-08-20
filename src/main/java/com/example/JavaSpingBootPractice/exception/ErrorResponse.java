package com.example.JavaSpingBootPractice.exception;

import java.util.Map;


public class ErrorResponse {
    private int status;
    private String error;
    private Map<String, String> message;
    private String path;

    public ErrorResponse(int status, String error, Map<String, String> message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }

    public void setPath(String path) {
        this.path = path;
    }

}

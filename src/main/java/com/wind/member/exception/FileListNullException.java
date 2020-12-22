package com.wind.member.exception;

public class FileListNullException extends RuntimeException{

    @Override
    public String getMessage() {
        return "File list is null so .....";
    }
}

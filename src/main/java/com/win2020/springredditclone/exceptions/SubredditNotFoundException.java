package com.win2020.springredditclone.exceptions;

public class SubredditNotFoundException extends RuntimeException {
    public SubredditNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }
}

package com.yuan.practice.exception;

/**
 * @author Yuan
 */
public class AuthException extends RuntimeException{
    private String msgDes;

    public AuthException() {
        super();
    }

    public AuthException(String message) {
        super(message);
        msgDes = message;
    }

    public String getMsgDes() {
        return msgDes;
    }
}

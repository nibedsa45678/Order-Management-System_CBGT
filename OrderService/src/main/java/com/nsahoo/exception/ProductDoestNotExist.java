package com.nsahoo.exception;

public class ProductDoestNotExist extends Exception {
    String message;



    public ProductDoestNotExist(String msg) {
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

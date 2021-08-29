package io.github.priyanshukm.hotelmanagement.exception;

/**
 * Class that implements ReviewNotFoundException for the API
 */
public class ReviewNotFoundException extends Exception {

    public ReviewNotFoundException(){
        super();
    }

    public ReviewNotFoundException(String msg){
        super(msg);
    }

    public ReviewNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}

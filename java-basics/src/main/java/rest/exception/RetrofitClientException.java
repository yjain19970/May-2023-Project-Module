package rest.exception;

public class RetrofitClientException extends Exception {
    public RetrofitClientException(String errorMessage) {
        super(errorMessage);
    }
}

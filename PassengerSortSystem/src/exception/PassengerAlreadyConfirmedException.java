package exception;

public class PassengerAlreadyConfirmedException extends Exception {
    public PassengerAlreadyConfirmedException(String message) {
        super(message);
    }
}
import java.util.Random;

public class OurException extends Exception {
    public OurException(String message) {
        super(message + " " + new Random().nextInt(100));
    }
}

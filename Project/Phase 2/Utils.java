package Phase2;

public class Utils {
    private static Utils instance = null;
    private int nextAccountNumber = 1000; // Initial account number

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public int getNextAccountNumber() {
        return nextAccountNumber++; // Ensure this is incrementing properly
    }
}
public class Utils {
    private int nextAccountNumber = 1000;

    /**
     * Gets the next account number.
     * 
     * @return The next account number.
     */
    public int getNextAccountNumber() {
        int returnValue = nextAccountNumber;
        nextAccountNumber++;
        return returnValue;
    }
}
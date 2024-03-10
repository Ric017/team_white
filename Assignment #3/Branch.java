public class Branch {
    private String name;

    /*
     * Constructor for Branch
     */
    public Branch(String name) {
        this.name = name;
    }

    /*
     * Gets the name of the branch
     */
    public String getName() {
        return this.name;
    }

    /*
     * Sets the name of the branch
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Branch: " + this.name;
    }
}

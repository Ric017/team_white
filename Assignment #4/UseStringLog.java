public class UseStringLog
{
    public static void main(String[] args) {
        StringLogInterface sample;
        sample = new ArrayStringLog("Example Use");
        sample.insert("Elvis");
        sample.insert("King Louis XII");
        sample.insert("Captain Kirk");
        System.out.println(sample);
        System.out.println("The size of the log is " + sample.size());
        System.out.println("Elvis is in the log: " + sample.contains("Elvis"));
        System.out.println("Santa is in the log: " + sample.contains("Santa"));

        if(sample.isEmpty())
            System.out.println("The log is empty");
        else
            System.out.println("The log is not empty");

        sample.insert("Elvis");

        System.out.println("Elvis is in the log " + sample.howMany("Elvis") + " times");

        if(sample.uniqueInsert("Elvis"))
            System.out.println("Elvis was inserted");
        else
            System.out.println("Elvis was not inserted");

        if(sample.uniqueInsert("Isaac Newton"))
            System.out.println("Isaac Newton was inserted");
        else
            System.out.println("Isaac Newton was not inserted");

        // Delete Santa from the log
        if(sample.delete("Santa"))
            System.out.println("Santa was deleted");
        else
            System.out.println("Santa was not deleted");
        
        // Delete All Elvis from the log
        System.out.println(sample.deleteAll("Elvis") + " instances of Elvis were deleted");
    }
}
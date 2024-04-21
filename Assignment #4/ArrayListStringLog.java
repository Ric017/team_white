import java.util.ArrayList;

public class ArrayListStringLog implements StringLog {
    private String name;
    private ArrayList<String> log;

    public ArrayListStringLog(String name) {
        this.name = name;
        log = new ArrayList<>();
    }

    @Override
    public void insert(String element) {
        log.add(element);
    }

    @Override
    public boolean isEmpty() {
        return log.isEmpty();
    }

    @Override
    public int howMany(String element) {
        int count = 0;
        for (String str : log) {
            if (str.equals(element)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean uniqueInsert(String element) {
        if (contains(element)) {
            return false;
        } else {
            insert(element);
            return true;
        }
    }

    @Override
    public boolean delete(String element) {
        return log.remove(element);
    }

    @Override
    public int deleteAll(String element) {
        int count = 0;
        while (log.remove(element)) {
            count++;
        }
        return count;
    }

    @Override
    public boolean isFull() {
        return false; // ArrayList is never full
    }

    @Override
    public int size() {
        return log.size();
    }

    @Override
    public boolean contains(String element) {
        return log.contains(element);
    }

    @Override
    public void clear() {
        log.clear();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder logString = new StringBuilder("Log: " + name + "\n\n");
        for (int i = 0; i < log.size(); i++) {
            logString.append(i + 1).append(". ").append(log.get(i)).append("\n");
        }
        return logString.toString();
    }
}

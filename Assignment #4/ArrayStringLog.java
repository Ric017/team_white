//----------------------------------------------------------------------
// ArrayStringLog.java        by Dale/Joyce/Weems
//
// Implements StringLogInterface using an array to hold the strings.
//----------------------------------------------------------------------

public class ArrayStringLog implements StringLogInterface {
  protected String name;              // name of this StringLog
  protected String[] log;             // array that holds strings
  protected int lastIndex = -1;       // index of last string in array

  public ArrayStringLog(String name, int maxSize)
  // Precondition:   maxSize > 0
  //
  // Instantiates and returns a reference to an empty ArrayStringLog
  // object with name "name" and room for maxSize strings.
  {
    log = new String[maxSize];
    this.name = name;
  }

  public ArrayStringLog(String name)
  // Instantiates and returns a reference to an empty ArrayStringLog
  // object with name "name" and room for 100 strings.
  {
    log = new String[100];
    this.name = name;
  }

  public void insert(String element)
  // Precondition:   This StringLog is not full.
  //
  // Places element into this StringLog.
  {
    lastIndex++;
    log[lastIndex] = element;
  }

  public boolean isFull()
  // Returns true if this StringLog is full, otherwise returns false.
  {
    if (lastIndex == (log.length - 1))
      return true;
    else
      return false;
  }

  public int size()
  // Returns the number of Strings in this StringLog.
  {
    return (lastIndex + 1);
  }

  public boolean contains(String element)
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case differences when doing string comparison.
  {
    int location = 0;
    while (location <= lastIndex)
    {
      if (element.equalsIgnoreCase(log[location]))  // if they match
        return true;
      else
        location++;
    }
   return false;
  }

  public void clear()
  // Makes this StringLog empty.
  {
    for (int i = 0; i <= lastIndex; i++)
      log[i] = null;
    lastIndex = -1;
  }

  public String getName()
  // Returns the name of this StringLog.
  {
    return name;
  }

  public String toString()
  // Returns a nicely formatted string representing this StringLog.
  {
    String logString = "Log: " + name + "\n\n";

    for (int i = 0; i <= lastIndex; i++)
      logString = logString + (i+1) + ". " + log[i] + "\n";

    return logString;
  }

  /*
   * The method returns true if the log is empty and false otherwise
   */
  public boolean isEmpty() {
    return (lastIndex == -1);
  }

  /*
   * The method returns a integer value indicating how many
   * times element occurs in the log
   * 
   * @param element the element to be counted
   * 
   * @return the number of times element occurs in the log
   */
  public int howMany(String element) {
    int count = 0;
    for (int i = 0; i <= lastIndex; i++) {
      if (element.equalsIgnoreCase(log[i])) {
        count++;
      }
    }
    return count;
  }

  /*
   * The method inserts an element in the log unless an identical string already exists in the log, 
   * in which case it has no effect on the log. If it does insert the string, the method returns true, 
   * otherwise it returns false. Use case-insensitive string comparison.
   */
  public boolean uniqueInsert(String element) {
    if (contains(element)) {
      return false;
    }
    else {
      insert(element);
      return true;
    }
  }

  public boolean delete(String element) {
    boolean moreToSearch;
    int location = 0;
    boolean found = false;
    moreToSearch = (location <= lastIndex);

    while(moreToSearch && !found) {
      if (element.equalsIgnoreCase(log[location])) {
        found = true;
      }
      else {
        location++;
        moreToSearch = (location <= lastIndex);
      }
    }

    if(found) {
      log[location] = log[lastIndex];
      log[lastIndex] = null;
      lastIndex--;
    }
    
    return found;
  }

  /*
   * The method deletes all occurrences of element from the string log and returns a integer 
   * value indicating the number of deletions. Hint: it would be better if you implement a delete 
   * (String element) method. Once this method is created, you can simply implement deleteAll 
   * by having a loop that calls delete (String element) repeatedly and counts the number of 
   * deletions. 
   */
  public int deleteAll(String element) {
    int count = 0;
    while (contains(element)) {
      delete(element);
      count++;
    }
    return count;
  }
}
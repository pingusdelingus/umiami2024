package lab05;

/**
 * Represents a sorted set of doubles backed by a simple array.
 * The set remains sorted at all times and does not allow duplicates.
 */
public class SortedBinarySet {
    /**
     * The array that holds the list of values
     */
    public double[] theData;

    /**
     * The capacity of the storage array
     */
    private int capacity;

    /**
     * The current number of elements in the list
     */
    private int size;

    /**
     * Constant for the initial storage array capacity
     */
    private static final int INITIAL_STORAGE_CAPACITY = 11;

    /**
     * A flag to toggle between binary search and sequential search.
     */
    public boolean usesBinarySearch = false; //Keep as false for the Lab. You will need this in the assignment.

    /**
     * Default constructor that initializes the set with the default capacity.
     */
    public SortedBinarySet() {
        // TODO: Lab Part 2.1 - Initialize theData array with INITIAL_STORAGE_CAPACITY and other class variables
        this.capacity = INITIAL_STORAGE_CAPACITY;
        this.size = 0;
        this.theData = new double[this.capacity];
    }


    /**
     * Constructor that initializes the set with an input array.
     * This is for the assignment, not for the lab.
     *
     * @param input The array to initialize the set with.
     */
    public SortedBinarySet(double[] input) {
        this();
        SortedBinarySet newset = new SortedBinarySet();
        // TODO: Assignment Part 1.5 - Hint: think about whether you can reuse any of the methods you have implemented to make your job easier.
        int sizeCount = 0;

        int index;


        for (index = 0; index < input.length; index++) {
            if (newset.insert(input[index])) {
                sizeCount += 1;
            }


        }// end of for loop
        this.theData = newset.theData;

        this.capacity = INITIAL_STORAGE_CAPACITY;
        this.size = sizeCount;

    }// end of constructor METHOD

    /**
     * Checks if the set is empty.
     *
     * @return true if the set is empty, false otherwise.
     */
    public boolean empty() {

        // TODO: Lab Part 2.2 - Check if the SortedBinarySet contains no elements
        if (this.size == 0) {
            return true;
        } else {
            return false; // placeholder
        }

    }

    /**
     * Returns the number of elements in the set.
     *
     * @return The number of elements in the set.
     */
    public int size() {
        // TODO: Lab Part 2.3 - Return the size of the SortedBinarySet


        return this.size; // placeholder
    }

    /**
     * Grows the storage array by doubling its capacity.
     */
    public void grow() {
        // TODO: Lab Part 2.4 - Double the size of theData and update capacity
        this.capacity = this.capacity * 2;
        double[] copy = new double[this.capacity];
        for (int index = 0; index < this.theData.length; index++) {
            copy[index] = this.theData[index];

        }// end of for loop
        this.theData = copy;

    }// end of grow METHOD

    /**
     * Converts the set to a string that includes its elements, capacity, and size.
     * This is primarily used for testing purposes.
     *
     * @return A string representing the set.
     */
    public String toString() {
        // TODO: Lab Part 2.5 - Return the list of elements, current capacity, and size as a string
        String answer = "";
        for (int index = 0; index < this.theData.length; index++) {
            answer += Double.toString(this.theData[index]) + " ";

        }// end of for loop
        answer += "\n";
        answer += "the total capacity is " + Integer.toString(this.capacity);
        answer += "\n";
        answer += "the total size of used space is " + Integer.toString(this.size);

        return answer; // placeholder
    }// end of toString METHOD

    /**
     * Clears all elements from the set.
     * After this method is called, the set should be empty.
     */
    public void clear() {
        // TODO: Lab Part 2.6 - Remove all elements from the SortedBinarySet and update class variables
        for (int index = 0; index < this.theData.length; index++) {
            this.theData[index] = 0;

        }// end of for loop

        this.size = 0;
    }// end of clear

    /**
     * Inserts a new value into the set in the correct position.
     * The value is inserted only if it's not already in the set.
     *
     * @param newVal The value to insert.
     * @return true if the value was successfully inserted, false if it already exists.
     */
    public boolean insert(double newVal) {
        // TODO: Lab Part 2.7 - Insert newVal in sorted order if it does not exist
        int result = findIndex(newVal);
        //System.out.println(result);
        if (result >= 0) {
            return false;
        } else {
            if (this.size == this.capacity || this.size > this.capacity) {
                this.grow();
            }

            result = result * -1;
            result -= 1;


            //now result should be where the newVal should be inserted into,


            for (int index = this.size - 1; index >= result; index--) {
                this.theData[index + 1] = this.theData[index];


            }// end of the for loop
            this.theData[result] = newVal;
            this.size += 1;
        }// end of else;
        return true; // placeholder
    }

    /**
     * Sequentially searches for a target in the set.
     *
     * @param target The target value to search for.
     * @return The index where the target is found, or -index - 1 if not found.
     */
    private int sequentialFind(double target) {
        // TODO: Lab Part 2.8 - Implement sequential search for the target
        for (int index = 0; index < this.theData.length; index++) {
            if (this.theData[index] == target) {
                return index;
            } else if (this.theData[index] < target) {
                continue;
            } else if (this.theData[index] > target) {
                return (-1 * index) - 1;
            }


        }// end of for loop


        return (this.size * -1) - 1;
    }// end of sequentialFind METHOD

    //*********************************************************************
    // * you will implement the rest of the methods for your assignment    *
    // * don't touch them before finishing the lab portion                 *
    // *********************************************************************

    /**
     * Removes a specified element from the set.
     *
     * @param element The element to remove.
     * @return true if the element was removed, false if it did not exist.
     */
    public boolean remove(double element) {
        // TODO: Assginment part 1.1
        int elementIndex = findIndex(element);
        if (elementIndex == -1) {
            return false;
        }
        // at this point we know that the element is in the data and we just need to remove it.

        //remove element at index
        this.theData[elementIndex] = 0;
        for (int index = elementIndex; index < this.theData.length - 1; index++) {
            this.theData[index] = this.theData[index + 1];
        }
        this.theData[this.theData.length - 1] = 0;
        this.size--;

        return true; // placeholder
    }

    /**
     * Uses binary search to find the target in the set (only if enabled).
     *
     * @param target The target value to search for.
     * @return The index where the target is found, or -index - 1 if not found.
     */
    private int binaryFind(double target) {
        // TODO: Assginment Part 1.2
        int left, right, middle;
        left = 0;
        right = this.size - 1;

        middle = (left + right) / 2;
        while (left <= right) {
            middle = (left + right) / 2;
            if (this.theData[middle] == target) {
                return middle;
            } else if (this.theData[middle] < target) {
                left = middle + 1;

            } else {
                right = middle - 1;
            }


        }// end of while


        //target not in theData, try to find where it should go!

        return (-1 * left) - 1;


    }// end of binaryfind

    /**
     * Checks if the set contains a specific element.
     *
     * @param element The element to check.
     * @return true if the element is found, false otherwise.
     */
    public boolean contains(double element) {
        // TODO: Assigment Part 1.3
        int result = binaryFind(element);
        if (result < 0) {
            return false;// this means that it is not in theData and you can insert element at this point -1

        } else {
            return true;
        }


    }

    /**
     * Checks if the set contains all the elements of an input array.
     *
     * @param elements The array of elements to check.
     * @return true if all elements are found in the set, false otherwise.
     */
    public boolean containsAll(double[] elements) {
        // TODO: Assignment Part 1.4
        int index;
        for (index = 0; index < elements.length; index++) {
            int res = binaryFind(elements[index]);
            if (res >= 0) {
                continue;
            } else {
                return false;
            }
        }

        return true; // placeholder
    }


    /**
     * Finds the index of a target value using either sequential or binary search.
     *
     * @param target The target value to search for.
     * @return The index where the target is found, or -index - 1 if not found.
     */
    public int findIndex(double target) {
        if (usesBinarySearch) {
            return binaryFind(target);
        } else {
            return sequentialFind(target);
        }
    }


}

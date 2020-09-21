import java.util.List;
public class SimpleArrayList {
    public String[] base_array; //creates an array of strings called array
    public int array_size; //array size
    public SimpleArrayList() { //initializes array with capacity of 10
        base_array = new String[10];
        array_size = 0;
    }
    public SimpleArrayList(int initialCapacity) {//creates the array with given length
        if(initialCapacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        array_size = 0;
        base_array = new String[initialCapacity];
    }
    public SimpleArrayList(List<String> list) { //converts a list into an array
        if (list == null) throw new NullPointerException();
        base_array = new String[list.size()];
        for (int y = 0; y < list.size(); y++) {
            base_array[y] = list.get(y);
        }
        array_size = base_array.length;
    }
    public void add(int index, String s) { //adds a string at given index
        checkForSpace();
        checkArrayBounds(index, array_size);
        for(int y = base_array.length-2; y > index-1; y--) {
            base_array[y+1] = base_array[y];
        }
        base_array[index] = s;
        array_size +=1;
    }
    public boolean add(String s) { //adds a string to end of array
        checkForSpace();
        base_array[array_size] = s;
        array_size +=1;
        return true;
    }
    public void clear() { //clears entire array
        array_size = 0;
        base_array = new String[0];
    }
    public boolean contains(String s) { //checks if given string is within array
        for(int y = 0; y < array_size; y++) {
            if(base_array[y].equals(s)) return true;
        }
        return false;
    }
    public String get(int index) { //retrieves the element at that index
        checkArrayBounds(index, array_size);
        return base_array[index];
    }
    public int indexOf(String given) { //checks for the index of a certain string
        for(int y = 0; y < array_size; y++) {
            if(base_array[y].equals(given)) return y;
        }
        return -1;
    }
    public boolean isEmpty() { //checks if array is empty
        return (array_size==0);
    }
    public String remove(int index) { //removes the string at a specific index
        checkArrayBounds(index, array_size);
        String element = base_array[index];
        for(int y = index; y < array_size-1; y++) {
            base_array[y] = base_array[y+1];
        }
        base_array[array_size-1] = null;
        array_size -=1;
        return element;
    }
    public boolean remove(String given) { //removes the string given by user
        int index = indexOf(given);
        if(index != -1) {
            remove(index);
            return true;
        }
        return false;
    }
    public String set(int index, String given) { //replaces the current element at an index with a new given string
        checkArrayBounds(index, array_size);
        String value = base_array[index];
        if (given == null) {
            given = "null";
        }
        base_array[index] = given;
        return value;
    }
    public int size() { //returns the size of the array
        return array_size;
    }
    public void trimToSize() { //removes nulls/empty spaces from array
        String[] temp_string = new String[array_size];
        for(int y = 0; y < array_size; y++) {
            temp_string[y] = base_array[y];
        }
        base_array = temp_string;
    }
    public String toString() { //converts the array into a list of strings with commas separating
        if (array_size ==0) return "[]";
        String convert = "[";
        for(int y = 0; y < array_size-1; y++) {
            convert += base_array[y];
            convert += ", ";
        }
        if(array_size != 0) {
            convert += base_array[array_size-1];
        }
        return convert += "]";
    }
    public void checkForSpace() { //checks that there is space an array
        if(array_size+1 > base_array.length) {
            String[] temp_string = new String[base_array.length+10];
            for(int y = 0; y < base_array.length; y++) {
                temp_string[y] = base_array[y];
            }
            base_array = temp_string;
        }
    }
    private void checkArrayBounds(int index, int array_size) { //checks if index is within array bounds
        if(index < 0 || index >= array_size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + array_size);
        }
    }
}
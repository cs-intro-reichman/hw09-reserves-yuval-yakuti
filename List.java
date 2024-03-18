
public class List {

    // Points to the first node in this list
    private Node first;

    // The number of elements in this list
    private int size;

    /** Constructs an empty list. */
    public List() {
        first = null;
        size = 0;
    }

    /** Returns the number of elements in this list. */
    public int getSize() {
        return size;
    }

    /** Returns the first element in the list */
    public CharData getFirst() {
        return first.cp;
    }

    /**
     * GIVE Adds a CharData object with the given character to the beginning of this
     * list.
     */
    public void addFirst(char chr) {
        CharData newData = new CharData(chr);
        Node newNode = new Node(newData, first);
        first = newNode;
        size++;
    }

    /** GIVE Textual representation of this list. */
    public String toString() {
        Node current = first;
        String str = "(";
        while (current != null) {
            str += current.cp.toString();
            str += " ";
            current = current.next;
        }

        return str.substring(0, str.length() - 1) + ")";// Your code goes here
    }

    /**
     * Returns the index of the first CharData object in this list
     * that has the same chr value as the given char,
     * or -1 if there is no such object in this list.
     */
    public int indexOf(char chr) {
        Node current = first;
        for (int i = 0; current != null; i++) {
            if (current.cp.chr == chr) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    /**
     * If the given character exists in one of the CharData objects in this list,
     * increments its counter. Otherwise, adds a new CharData object with the
     * given chr to the beginning of this list.
     */
    public void update(char chr) {
        Node current = first;
        while (current != null) {
            if (current.cp.chr == chr) {
                current.cp.count++;
                return;
            }
            current = current.next;
        }
        addFirst(chr);
    }

    /**
     * GIVE If the given character exists in one of the CharData objects
     * in this list, removes this CharData object from the list and returns
     * true. Otherwise, returns false.
     */
    public boolean remove(char chr) {
        Node current = first;
        Node last = current;
        while (current != null) {
            if (current.cp.chr == chr) {
                last.next = current.next;
                current = null;
                return true;
            }
            last = current;
            current = current.next;
        }
        return false;// Your code goes here
    }

    /**
     * Returns the CharData object at the specified index in this list.
     * If the index is negative or is greater than the size of this list,
     * throws an IndexOutOfBoundsException.
     */
    public CharData get(int index) {
        Node current = first;
        if (index >= 0 && index < size) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.cp;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    /**
     * Returns an array of CharData objects, containing all the CharData objects in
     * this list.
     */
    public CharData[] toArray() {
        CharData[] arr = new CharData[size];
        Node current = first;
        int i = 0;
        while (current != null) {
            arr[i++] = current.cp;
            current = current.next;
        }
        return arr;
    }

    /**
     * Returns an iterator over the elements in this list, starting at the given
     * index.
     */
    public ListIterator listIterator(int index) {
        // If the list is empty, there is nothing to iterate
        if (size == 0)
            return null;
        // Gets the element in position index of this list
        Node current = first;
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        // Returns an iterator that starts in that element
        return new ListIterator(current);
    }
}

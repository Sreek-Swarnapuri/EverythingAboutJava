package collections.lists;

import java.util.LinkedList;
import java.util.List;

public class LinkedListUsage {

    public static void main(String[] args) {

        //Basic usage of Lists using LinkedList
        LinkedList<Integer> linkedListImpl = new LinkedList<>();

        //Adding elements into the linked list using add() - this adds the element to the end of the linked list
        linkedListImpl.add(1);
        linkedListImpl.add(2);
        linkedListImpl.add(4);
        linkedListImpl.add(5);

        System.out.println(linkedListImpl);

        //Adding an element to a specific index using overrided add() method which also accepts index
        linkedListImpl.add(2,3);

        System.out.println(linkedListImpl);

        //Adding an element to the first of the list as it is a deque implementation which in turn is a doubly linked list
        linkedListImpl.addFirst(0);
        System.out.println(linkedListImpl);

        //Adding an element to the last of the list as it is a deque implementation which in turn is a doubly linked list
        linkedListImpl.addLast(6);
        System.out.println(linkedListImpl);

        //We can remove the first element using removeFirst()
        linkedListImpl.removeFirst();
        System.out.println(linkedListImpl);

        //we can remove the last element using removeLast()
        linkedListImpl.removeLast();
        System.out.println(linkedListImpl);

        //If there are multiple occurrences of a similar elements, we can remove its first occurrence from the start or end
        linkedListImpl.add(1,1);
        linkedListImpl.add(4,4);
        System.out.println(linkedListImpl);
        linkedListImpl.removeFirstOccurrence(1);
        System.out.println(linkedListImpl);
        linkedListImpl.removeLastOccurrence(4);
        System.out.println(linkedListImpl);

    }

}

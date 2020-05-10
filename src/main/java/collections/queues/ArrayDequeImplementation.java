package collections.queues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class ArrayDequeImplementation {

    public static void main(String[] args) {

        //Using an ArrayDeque as a simple queue
        Queue queue = new ArrayDeque(4);
        System.out.println(queue + " - queue size: " + queue.size());

        //Adding four elements
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        //if we use add method, it will throw an exception as the queue is full
        // So, it is better to use offer method instead
        //queue.add(5);
        System.out.println(queue.offer(5));
        System.out.println(queue.offer(6));
        System.out.println(queue + " - queue size: " + queue.size());

        // we can remove elements using remove() or poll(). Remove throws an exception if the queue is null and would need a pre condition.
        // poll() is better to use at it return null if the queue is empty.
        // we can peek through the elements one by one using peek() or element()
        // element() thorws an error if there are no elements in the queue. It is better to use peek() as it posts null when the queue is empty
        while(queue.peek() != null) {
            System.out.println("removing element: " + queue.peek());
            queue.poll(); // or queue.remove() as we are using peek to check if there is an element in the queue
            System.out.println(queue + " - queue size: " + queue.size());
        }

    }

}

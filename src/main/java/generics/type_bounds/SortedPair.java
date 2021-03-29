package generics.type_bounds;

import lombok.Getter;

// Class demonstrating typebounds
// This means that anything that use with SortedPair should extend Comparable class
// Comparable also restricts the type to be the one passed to SortedPair
@Getter
public class SortedPair<T extends Comparable<T>> {

    private final T first;
    private final T second;

    public SortedPair(T left, T right) {

        if (left.compareTo(right) < 0) {
            first = left;
            second = right;
        } else {
            first = right;
            second = left;
        }
   }

}

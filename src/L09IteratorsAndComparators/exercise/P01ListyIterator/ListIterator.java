package L09IteratorsAndComparators.exercise.P01ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListIterator {
    private List<String> elements;
    private int currentIndex;

    public ListIterator(String... elements) {
        this.elements = Arrays.asList(elements);
        currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < elements.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation");
        }
        System.out.println(this.elements.get(currentIndex));
    }
}

public class Bubble_Numbers_Comparable implements Comparable<Bubble_Numbers_Comparable> {

    private int value;

    public Bubble_Numbers_Comparable(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Bubble_Numbers_Comparable other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return  this.value + " ";
    }
}

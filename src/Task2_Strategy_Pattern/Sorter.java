package Task2_Strategy_Pattern;

public class Sorter {
    Comparable CompareType;

    public Sorter(Comparable a) {
        this.CompareType = a;
    }

    public void setComparable(Comparable a) {
        CompareType = a;
    }

    public void bubbleSort(Object[] ob) {


        for (int i = 0; i < ob.length - 1; i++) {
            for (int j = 0; j < ob.length - i - 1; j++) {

                if (CompareType.compareTo(ob[j], ob[j + 1]) > 0) { // swap
                    Object temp = ob[j];
                    ob[j] = ob[j + 1];
                    ob[j + 1] = temp;
                }
            }
        }

    }
}


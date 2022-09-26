package Task2_Strategy_Pattern;

public class CompareFileType implements Comparable {
    @Override
    public int compareTo(Object o1, Object o2) {
        FileInfo a1 = (FileInfo) o1;
        FileInfo a2 = (FileInfo) o2;

        if (a1.getType().compareTo(a2.getType()) > 0) {
            return 1;
        } else
            return -1;
    }
}

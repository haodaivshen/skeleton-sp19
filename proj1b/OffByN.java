public class OffByN implements CharacterComparator {
    private int off;

    public OffByN(int n) {
        off = n;
    }

    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == off;
    }
}

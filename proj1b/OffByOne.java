import org.junit.Test;
import static org.junit.Assert.*;


public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }


    @Test
    public void TestOffByOne () {
        OffByOne obo = new OffByOne();
        assertTrue(obo.equalChars('a', 'b'));
        assertTrue(obo.equalChars('r', 'q'));

        assertFalse(obo.equalChars('a', 'e'));  // false
        assertFalse(obo.equalChars('z', 'a'));  // false
        assertFalse(obo.equalChars('a', 'a'));  // false
    }
}

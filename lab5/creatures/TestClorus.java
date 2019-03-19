package creatures;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Color;



public class TestClorus {
    @Test
    public void testBasics() {
        Clorus p = new Clorus(2);
        assertEquals(2, p.energy(), 0.01);
        assertEquals(new Color(99, 255, 76), p.color());
        p.move();
        assertEquals(1.97, p.energy(), 0.01);
        p.move();
        assertEquals(1.94, p.energy(), 0.01);
        p.stay();
        assertEquals(1.93, p.energy(), 0.01);
        p.stay();
        assertEquals(1.92, p.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus p = new Clorus(1.5);

        Clorus p2 = p.replicate();
        assertEquals(0.75, p.energy(), 0.01);
        assertEquals(0.75, p2.energy(), 0.01);

        Clorus pp = new Clorus(0);
        Clorus p3 = pp.replicate();
        assertEquals(0, pp.energy(), 0.01);
        assertEquals(0, p3.energy(), 0.01);


    }

}

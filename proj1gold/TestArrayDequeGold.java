import static org.junit.Assert.*;
import org.junit.Test;


public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i++) {
            Integer x = StdRandom.uniform(10);

            student.addFirst(x);
            solution.addFirst(x);
        }

        for (int i = 0; i < 10; i++) {

            assertEquals("student's solution removeFirst error", student.removeFirst(), solution.removeFirst());
        }

        for (int i = 0; i < 10; i++) {
            Integer x = StdRandom.uniform(10);

            student.addLast(x);
            solution.addLast(x);
        }

        for (int i = 0; i < 10; i++) {

            assertEquals("student's solution removeLast error",student.removeLast(), solution.removeLast());
        }
    }

    @Test
    public void RandomizedTesting() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        for (int i = 0; i < 10; i++) {
            int item = StdRandom.uniform(10);
            student.addLast(item);
            solution.addLast(item);
        }

        String msg = helper(student);
        for (int i = 0; i < 10; i++) {
            Integer removed = student.removeLast();
            Integer removed1 = solution.removeLast();
            msg = helper1(msg);
            assertEquals(msg, removed1, removed);
        }
    }

    private String helper(StudentArrayDeque <Integer> array) {
        String msg = "";
        for (int i = 0; i < 10; i ++) {
            msg = msg + "addFirst(" + array.get(i).toString() + ")\n";
        }

        return msg;
    }

    private String helper1(String msg) {
        return msg + "removeLast()\n";
    }
}

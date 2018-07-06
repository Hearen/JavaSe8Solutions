package chap8_others;

import static java.lang.System.out;
import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class Sol_6 {

    @Test
    public void testComparator() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(2, 3));
        points.add(new Point(1, 3));
        points.add(new Point(1, 2));

        points.stream()
                .sorted(comparing(Point::getX).thenComparing(Point::getY))
                .forEach(out::println);
        points.stream()
                .sorted(comparing(Point::getX).reversed()
                        .thenComparing(comparing(Point::getY).reversed()))
                .forEach(out::println);
    }

    class Point {
        int x;
        int y;

        public Point(int theX, int theY) {
            x = theX;
            y = theY;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return String.format("[%3d, %3d]", x, y);
        }
    }
}

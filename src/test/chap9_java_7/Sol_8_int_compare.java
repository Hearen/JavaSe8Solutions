package chap9_java_7;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Sol_8_int_compare {
    @Test
    public void testCompare() {

        List<Point> points = new ArrayList<>();
        points.add(new Point(2, 3));
        points.add(new Point(1, 3));
        points.add(new Point(1, 2));

        points.stream()
                .sorted(Point::compareTo)
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

        public int compareTo(Point other) {
            int xRet = compare(this.x, other.getX());
            if (xRet == 0) {
                return compare(this.y, other.getY());
            }
            return xRet;
        }

        private int compare(int x0, int x1) {
            if (x0 == x1) {
                return 0;
            }
            if (x0 < x1) {
                return -1;
            }
            return 1;
        }
    }


}

package chap9_java_7;

import static java.lang.System.out;

import java.lang.reflect.Field;
import java.util.Objects;

import org.junit.Test;

public class Sol_9 {

    @Test
    public void testEqualHash() {
        LabeledPoint labeledPoint0 = new LabeledPoint("Hearen", 0, 1);
        LabeledPoint labeledPoint1 = new LabeledPoint("Katherine", 0, 0);
        LabeledPoint labeledPoint2 = new LabeledPoint("Katherine", 0, 0);
        out.println(labeledPoint0.equals(labeledPoint2));
        out.println(labeledPoint1.equals(labeledPoint2));
        out.println(labeledPoint0.hashCode());
    }

    class LabeledPoint {
        private String label;
        private int x;
        private int y;

        public LabeledPoint(String theLabel, int theX, int theY) {
            this.label = theLabel;
            this.x = theX;
            this.y = theY;
        }


        @Override
        public boolean equals(Object other) {
            if (other instanceof LabeledPoint == false) {
                throw new IllegalArgumentException("Only LableledPoint can be used");
            }
            try {
                Field[] fields = LabeledPoint.class.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (!field.get(this).equals(field.get(other))) {
                        return false;
                    }
                }
            } catch (IllegalAccessException ignored) {
                ignored.printStackTrace();
            }
            return true;
        }

        @Override
        public int hashCode() {
            Object[] values = null;
            try {
                Field[] fields = LabeledPoint.class.getDeclaredFields();
                values = new Object[fields.length];
                for (int i = fields.length - 1; i >= 0; i--) {
                    Field field = fields[i];
                    field.setAccessible(true);
                    values[i] = field.get(this);
                }
            } catch (IllegalAccessException ignored) {
                ignored.printStackTrace();
            }
            return Objects.hashCode(values);

        }
    }
}

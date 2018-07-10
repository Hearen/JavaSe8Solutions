package chap8_others;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Objects;

public class Sol_14_requireNonNull {
    @Test(expected = NullPointerException.class)
    public void testRequireNonNull() {
        Objects.requireNonNull(null, "Object should not be null [" + LocalDateTime.now() + "]");
        Objects.requireNonNull(null, () -> "Object should not be null [" + LocalDateTime.now() + "]");
    }
}

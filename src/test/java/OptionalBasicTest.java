import com.blog.util.ExceptionUtil;
import org.junit.Test;

import java.util.Optional;
import static org.junit.Assert.*;

public class OptionalBasicTest {

    @Test
    public void whenCreateEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();

        assertFalse(empty.isPresent());
    }

    @Test
    public void optional_of_success() {
        String name = "1234";
        Optional<String> optional = Optional.of(name);
        System.out.println(optional);
        assertTrue(optional.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void optional_of_error() {
        String name = null;
        Optional.of(name);
    }

    @Test
    public void optional_ofNullable() {
        String name = "1234";
        Optional<String> opt = Optional.ofNullable(name);

        assertTrue(opt.isPresent());
    }

    @Test
    public void optional_ofNullable_error() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }



}

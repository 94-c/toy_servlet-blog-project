import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;
import static org.junit.Assert.*;

public class OptionalTest {

    private static final Optional<?> EMPTY = Optional.of(new OptionalTest());

    @DisplayName("빈 객체를 생성한다.")
    @Test
    void empty() {
        Optional<Object> test = Optional.empty();

}

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import utils.StringsComparator;
import constants.Action;

public class StringComparatorTest {

    @ParameterizedTest(name = "input is equal apart actions")
    @ValueSource(strings = {"apart", "Apart", "aparT", "APART"})
    void isEqualApart(String value) {
        assertTrue(StringsComparator.isEqual(value, Action.APART));
    }

    @ParameterizedTest(name = "input is equal book actions")
    @ValueSource(strings = {"book", "Book", "booK", "BOOK"})
    void isEqualBook(String value) {
        assertTrue(StringsComparator.isEqual(value, Action.BOOK));
    }

    @ParameterizedTest(name = "input is equal stop actions")
    @ValueSource(strings = {"stop", "Stop", "stoP", "STOP"})
    void isEqualStop(String value) {
        assertTrue(StringsComparator.isEqual(value, Action.STOP));
    }

    @ParameterizedTest(name = "input is not equal to any actions")
    @ValueSource(strings = {"test", "apartment", "some random input", ""})
    void isNotEqual(String value) {
        assertFalse(StringsComparator.isEqual(value, Action.APART));
        assertFalse(StringsComparator.isEqual(value, Action.BOOK));
        assertFalse(StringsComparator.isEqual(value, Action.STOP));
    }
}

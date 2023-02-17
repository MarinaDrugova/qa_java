import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class FelineParametrizedTest{
    private final int kittensCount;
    private final int expected;

    public FelineParametrizedTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getKittens() {
        return new Object[][] {
                { 1, 1},
                { 3, 3},
                { 10, 10},
        };
    }
    @Test
    public void felineCountTest() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(kittensCount));
    }
}
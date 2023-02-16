import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionHasManeParametrizedTest {
    private final String lionGender;
    private final boolean mane;
    public LionHasManeParametrizedTest(String lionGender, boolean mane){
        this.lionGender = lionGender;
        this.mane = mane;
    }
        @Parameterized.Parameters
        public static Object[][] getManeData(){
            return new Object[][]{
                    {"Самец", true},
                    {"Самка", false}
            };
        }
        @Test
    public void LionHasManeTest() throws Exception {
            Feline feline = Mockito.mock(Feline.class);
            Lion lion = new Lion(lionGender, feline);
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals(mane, actual);

        }
    }
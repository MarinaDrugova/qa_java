import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline;
    @Test
    public void getFoodFelineEatMeatTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
    @Test
    public void getFamilyOffFelineTest() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals(expectedFamily, actualFamily);
    }
    @Test
    public void getKittensFelineTest() {
        Feline feline = new Feline();
        int expected = 3;
        Assert.assertEquals("Неверно", expected, feline.getKittens(expected));
    }
    @Test
    public void getKittensFelineCountTest() {

        Feline feline = new Feline();
        int expectedKittensFeline = 1;
        Assert.assertEquals("Неверно", expectedKittensFeline, feline.getKittens());
    }
    @Test
    public void getAnimalFamilyTest() {
        Animal animal = new Animal();
        String expectedAnimalFamily = ("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");
        String actualAnimalFamily = animal.getFamily();
        Assert.assertEquals(expectedAnimalFamily, actualAnimalFamily);
    }

    @Test
    public void getAnimalFamilyExceptionTest() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        Assert.assertEquals(List.of("Трава", "Различные растения"), food);
    }
    @Test
    public void getAnimalFamilyExceptionUnknownTest() throws Exception {
        try {
            Feline feline = new Feline();
            List<String> food = feline.getFood("Вода");
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
        } catch (Exception exception) {
            Assert.assertEquals(exception.getMessage(), "Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }
}
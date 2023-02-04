import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {
    @Test
    public void getFoodFelineTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.getFood("Хищник");
        Assert.assertEquals("Неверный выбор еды животного", expectedFood, actualFood);
    }

    @Test
    public void getFoodFelineEatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void getFamilyOffFelineTest() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensHaveFeline() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(1);
        Assert.assertEquals(1, kittens);
    }

    @Test
    public void getKittensCanFelineTest() {
        Feline feline = new Feline();
        int kittensCount = feline.getKittens(1);
        Assert.assertEquals(1, kittensCount);
    }

    @Test
    public void getAnimalFamilyTest() {
        Animal animal = new Animal();
        String expectedAnimalFamily = ("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи");
        String actualAnimalFamily = animal.getFamily();
        assertEquals(expectedAnimalFamily, actualAnimalFamily);
    }

    @Test
    public void getAnimalFamilyExceptionTest() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
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
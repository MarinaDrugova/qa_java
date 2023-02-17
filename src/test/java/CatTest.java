import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Test
    public void getSound() {
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String voice = cat.getSound();
        Assert.assertEquals("Мяу", voice);
    }
    @Mock
    Feline feline;
    @Test
    public void getFoodPredatorEatMeat() throws Exception{
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные","Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = cat.getFood();
        Assert.assertEquals("Неверный выбор еды животного", expectedFood, actualFood);
    }
}
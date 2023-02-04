import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionTest {

    @Test
    public void hasManeHeTest() throws  Exception{
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertTrue(hasMane);
    }
    @Test
    public void hasManeSheTest() throws  Exception{
        Feline feline = new Feline();
        Lion lion = new Lion("Самка", feline);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertFalse(hasMane);
    }
    @Test
    public void haveNotManeTest(){
        Feline feline = new Feline();
        try {
            Lion lion = new Lion("Новорожденный львенок", feline);
            boolean hasMane = lion.doesHaveMane();
            Assert.assertTrue(hasMane);
        }
        catch (Exception exception) {
            Assert.assertEquals(exception.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
        }
    }
    @Test
    public void getFoodLionEatMeatTest() throws Exception{
        Feline feline = new Feline();
        List<String> food = feline.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }
}
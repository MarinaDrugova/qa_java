
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import org.mockito.Mockito;
@RunWith(MockitoJUnitRunner.class)
public  class LionTest {
    @Test
    public void hasManeHeTest() throws  Exception{
        Lion lion = new Lion("Самец", feline);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertTrue(hasMane);
    }
    @Test
    public void hasManeSheTest() throws  Exception{
        Lion lion = new Lion("Самка", feline);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertFalse(hasMane);
    }
    @Test
    public void haveNotManeTest() {
        Feline feline = new Feline();
        try {
            Lion lion = new Lion("Новорожденный львенок", feline);
            boolean hasMane = lion.doesHaveMane();
            Assert.assertTrue(hasMane);
        } catch (Exception exception) {
            Assert.assertEquals(exception.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
        }
    }
  @Mock
    Feline feline;
    Lion lion;
    @Before
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
    }
    @Test
    public void getFood() throws Exception {
        lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные","Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Неверный выбор еды животного", expected, lion.getFood());
    }
    @Test
    public void getKittens() throws Exception{
        lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        Assert.assertEquals("1 детеныш", expected, lion.getKittens());
    }
}
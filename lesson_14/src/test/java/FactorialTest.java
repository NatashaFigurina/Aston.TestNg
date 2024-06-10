import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {
    Factorial result = new Factorial();

    @Test

    public void testFactorialZero() {
        Assert.assertEquals(result.calculateFactorial(0), 1);
    }

    @Test

    public void testFactorialPositive() {
        Assert.assertEquals(result.calculateFactorial(5), 120);
    }

    @Test

    public void testFactorialNegative() {
        try {
            result.calculateFactorial(-5);
            Assert.fail("Невозможно вычислить факториал отрицательного числа");
        } catch (IllegalArgumentException e) {
        }
    }
}



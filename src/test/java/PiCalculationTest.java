import org.junit.Assert;
import org.junit.Test;

public class PiCalculationTest {


    @Test
    public void piCalculationFunctionTest() {
        PiCalculation.getPiLength(5);
        Assert.assertEquals(PiCalculation.getPiValue().length(), 6);
    }

    @Test
    public void piCalculationFunctionTestThreadCountPi() {
        WorkThread.CountPi countPi = new WorkThread.CountPi();
        countPi.start();
        Assert.assertTrue(countPi.isAlive());
    }

    @Test
    public void piCalculationFunctionTestThreadSearch() {
        WorkThread.Search search = new WorkThread.Search();
        search.start();
        Assert.assertTrue(search.isAlive());
    }
}

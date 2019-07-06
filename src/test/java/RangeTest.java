import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RangeTest {

    @Test
    public void t1() {


        int [] z = {0,1,2,3,4,5,5};

        Range range = new Range();
        int [] y = range.alg(z ,4 );
        Assert.assertEquals(4, y[0]);
        Assert.assertEquals(4, y[1]);

    }

    @Test
    public void t2() {
        int [] z = {0,1,2,3,4,4,5};

        Range range = new Range();
        int [] y = range.alg(z ,4 );
        Assert.assertEquals(4, y[0]);
        Assert.assertEquals(5, y[1]);
    }

    @Test
    public void t3() {
        int [] z = {0,1,2,3,4,4};

        Range range = new Range();
        int [] y = range.alg(z ,4 );
        Assert.assertEquals(4, y[0]);
        Assert.assertEquals(5, y[1]);
    }
}
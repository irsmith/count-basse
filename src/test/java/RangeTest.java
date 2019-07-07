import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RangeTest {


    @Test
    public void t0() {


        int [] z = {0,0,0,1,2,3,4,5,5};

        Range range = new Range();
        int [] y = range.alg(z ,0 );
        Assert.assertEquals(0, y[0]);
        Assert.assertEquals(2, y[1]);

    }

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

    @Test
    public void t4() {
        int [] z = {0};

        Range range = new Range();
        int [] y = range.alg(z ,0 );
        Assert.assertEquals(0, y[0]);
        Assert.assertEquals(0, y[1]);
    }

    @Test
    public void t5() {
        int [] z = {0};

        Range range = new Range();
        int [] y = range.alg(z ,99 );
        Assert.assertEquals(-1, y[0]);
        Assert.assertEquals(-1, y[1]);
    }

    @Test
    public void t6() {
        int [] z = new int[500000000];

        for (int i=0;i<z.length;i++) {
            z[i]=i;
        }

        Range range = new Range();
        int [] y = range.alg(z ,z.length-2 );
        Assert.assertEquals(z.length-2, y[0]);
        Assert.assertEquals(z.length-2, y[1]);
    }
}
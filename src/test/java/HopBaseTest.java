import org.junit.Assert;
import org.junit.Test;

public class HopBaseTest {
    @Test
    public void iter_targetAtFirstHop() {
        Hop hop = new Hop();
        int s[] = {5,1,0,3,2,4} ;
        Assert.assertEquals("nbr hops  ",0,hop.hopEasy(s, 1));
    }

    @Test
    public void iter_targetAt5() {
        Hop hop = new Hop();
        int s[] = {5,1,0,4,2,3} ;
        Assert.assertEquals("nbr hops",4,hop.hopEasy(s, 4));
    }


    @Test
    public void recur_targetAtFirstHop() {
        Hop hop = new Hop();
        int s[] = {5,1,0,3,2,4} ;
        Assert.assertEquals("nbr hops",0,hop.alg(s, 1));
    }

    @Test
    public void recur_targetAt5() {
        Hop hop = new Hop();
        int s[] = {5,1,0,4,2,3} ;
        Assert.assertEquals("nbr hops",4,hop.alg(s, 4));
    }
}
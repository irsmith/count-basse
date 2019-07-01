import org.junit.Assert;
import org.junit.Test;

public class LookAndSayTest {
    LookAndSay app = new LookAndSay();

    // String input
    @Test
    public void given1_expect11() {
        Assert.assertEquals("int input","11", app.lookAndSay("1"));
    }

    @Test
    public void given11_expect21() {
        Assert.assertEquals("int input","21", app.lookAndSay("11"));
    }

    @Test
    public void given21_expect1211() {
        Assert.assertEquals("int input","1211", app.lookAndSay("21"));
    }

    @Test
    public void given9999999999_expect109() {
        Assert.assertEquals("int input","109", app.lookAndSay("9999999999"));
    }

    //  Integer INPUT
    @Test
    public void whenIdx0_then1() {
         Assert.assertEquals("int input","1", app.lookAndSay(0));
    }

    @Test
    public void whenIdx1_then1() {
        Assert.assertEquals("int input","1", app.lookAndSay(1));
    }

    @Test
    public void whenIdx2_then11() {
        Assert.assertEquals("int input","11", app.lookAndSay(2));
    }

    @Test
    public void whenIdx4_thenOK() {
        Assert.assertEquals("int input","1211", app.lookAndSay(4));
    }

    @Test
    public void whenIdx5_then111221() {
        Assert.assertEquals("int input","111221", app.lookAndSay(5));
    }

    @Test
    public void whenIdx31_thenLength5808() {
        Assert.assertEquals("length",5808, app.lookAndSay(31).length());
    }
}
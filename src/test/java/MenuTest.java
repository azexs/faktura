import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    Menu test = new Menu("testmenu");



    @Test
    public void addItem() {
        assertNotNull(test.addItem(new MenuItem("testmenuitem",null,null)));
    }

    @Test
    public void teststringbuilder(){
        assertEquals( "\ntestmenu\n--------\n0) Quit", test.toString());

    }

}
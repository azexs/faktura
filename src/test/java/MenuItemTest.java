import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MenuItemTest {
    private String title;
    private String expectedtitle;
    MenuItem testitem;

    @Before
    public void initialize() {
       testitem = new MenuItem(title, null, null);
    }


    public MenuItemTest(String title,String expectedtitle){
        this.title=title;
        this.expectedtitle=expectedtitle;

    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { "abc", "abc" },
                { "abb", "abb" },
                { "ccc", "ccc" }
        });
    }



    @Test
    public void getTitle() {
        assertEquals(expectedtitle, testitem.getTitle());

    }



}
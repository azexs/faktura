import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementTest {



    @Test
    public void iselementcreated(){
        Element testelement = new Element("test",15,15);
        assertNotNull(testelement);
    }




}
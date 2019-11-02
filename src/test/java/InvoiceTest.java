import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InvoiceTest {


    @Test
    public void isinvoicecreated(){
        Element testelement = new Element("test",15,15);
        ArrayList<Element> elements = new ArrayList<Element>();
        elements.add(testelement);
        Invoice invo = new Invoice("51431","ferf",elements);
        assertNotNull(invo);

    }


}
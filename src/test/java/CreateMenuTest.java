import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CreateMenuTest {
    CreateMenu createMenu = new CreateMenu();
    ArrayList<Element> elements = new ArrayList<Element>();

    @Test
    public void sumofinvoicetest(){



        elements.add(new Element("erferf",15,15));
        elements.add(new Element("erferf",10,1.5));
        Invoice invoice = new Invoice("aaa","crt", elements);
        createMenu.invoices.add(invoice);
        createMenu.totalsumofinvoice("aaa");

        assertEquals(240, createMenu.totalsumofinvoice("aaa"), 0.1);





    }








}
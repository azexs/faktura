import java.util.ArrayList;
import java.util.List;

class Invoice {

    String number;
    String client;
    List<Element> elements;

    Invoice(String number, String client, ArrayList<Element> elements){
        this.number=number;
        this.client=client;
        this.elements=elements;
    }
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateMenu {

    ArrayList <Invoice> invoices = new ArrayList <Invoice>();

     Menu rootMenu;

     ArrayList<Element> enterproducts() {
        ArrayList<Element> elements = new ArrayList<Element>();
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Product name: ");
            String product = input.next();
            System.out.print("Quantity: ");
            int quantity = input.nextInt();
            System.out.print("Price: ");
            double price = input.nextDouble();
            elements.add(new Element(product, quantity, price));
            System.out.print("q for quit: ");
        } while (!input.next().equals("q"));
        return elements;
    }

     Double totalsumofinvoice(String newinvoicenumber){
        double totalsum=0;
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).number.equals(newinvoicenumber)) {

                for (int y = 0; y < invoices.get(i).elements.size(); y++) {
                    totalsum=totalsum+(invoices.get(i).elements.get(y).quantity*invoices.get(i).elements.get(y).price);
                }
                break;
            }
        }
        return totalsum;
    }

     void displayinvoice(String newinvoicenumber) {
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).number.equals(newinvoicenumber)) {
                System.out.println("Invoice number: " + invoices.get(i).number);
                System.out.println("Client name: " + invoices.get(i).client + "\n");
                System.out.println("Product name | Quantity | Price");
                double totalsum=0;
                for (int y = 0; y < invoices.get(i).elements.size(); y++) {
                    totalsum=totalsum+(invoices.get(i).elements.get(y).quantity*invoices.get(i).elements.get(y).price);
                    System.out.println(y+1 +". "+invoices.get(i).elements.get(y).name + " | " + invoices.get(i).elements.get(y).quantity + " | " + invoices.get(i).elements.get(y).price);
                }
                System.out.println("The total is: $" + totalsumofinvoice(newinvoicenumber) );
                break;
            }
        }
    }


     public void addinvoiceforclient(String Newclient){
        System.out.print("Enter invoice name: ");
        Scanner input = new Scanner(System.in);
        final String InvoNumber;
        InvoNumber = input.next();
        System.out.println("Enter products: ");

        invoices.add(new Invoice(InvoNumber,Newclient,enterproducts()));

        for (int k=0; k<rootMenu.items.size(); k++) {
            if(rootMenu.items.get(k).getTitle().equals(Newclient)) {
                rootMenu.items.get(k).getSubMenu().addItem(new MenuItem(InvoNumber, null, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        displayinvoice(InvoNumber);
                    }
                }));
                break;
            }
        }
    }

     String addclientname(){
        System.out.print("Enter new client name: ");
        Scanner in = new Scanner(System.in);
        String Newclient;
        Newclient = in.next();
        return Newclient;
    }

    Menu createmenu(){


        rootMenu = new Menu( "CLIENTS" ) ;
        final MenuItem backmenu;
        backmenu = new MenuItem( "<--back<--", rootMenu , null ) ;



        rootMenu.addItem(new MenuItem("Add clients", null,  new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final String newclient = addclientname();
                rootMenu
                        .addItem(new MenuItem(newclient, new Menu(newclient)
                                .addItem(backmenu)
                                .addItem(new MenuItem("Add invoice",null, new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        addinvoiceforclient(newclient);
                                    }
                                }))
                                , null));
            }
        }));

        return rootMenu;
    }
}

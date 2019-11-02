import java.util.Scanner;

public class Main {
    public static void main( String[] args ) {

        CreateMenu root = new CreateMenu();
        Scanner br = new Scanner(System.in);
        Menu currentMenu = root.createmenu();
        while( currentMenu != null )
        {
            System.out.println( currentMenu ) ;
            System.out.print( "Your Selection : " ) ;

            try {
                int inp = br.nextInt();
                System.out.print("\n");
                currentMenu = currentMenu.doOption(inp);
            } catch (Exception e ) {System.out.println("Wrong option");}

        }


    }
}





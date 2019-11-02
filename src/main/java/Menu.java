import java.util.ArrayList;
import java.util.List;

class Menu
{
    List<MenuItem> items = new ArrayList<MenuItem>() ;
    private String title ;

    Menu(String title)
    {
        this.title = title ;
    }

    Menu doOption(int option)
    {
        if( option == 0 ) return null ;
        option-- ;
        if( option >= items.size() )
        {
            System.out.println( "Unknown option " + option ) ;
            return this ;
        }

        items.get( option ).select() ;
        Menu next = items.get( option ).getSubMenu() ;

        return next == null ? this : next ;
    }

    Menu addItem(MenuItem item)
    {
        items.add( item ) ;
        return this;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder() ;
        sb.append("\n").append( title ).append( "\n" ) ;
        for( int i = 0 ; i < title.length() ; i++ )
        {
            sb.append( "-" ) ;
        }
        sb.append( "\n" ) ;
        for( int i = 0 ; i < items.size() ; i++ )
        {
            sb.append( ( i + 1 ) ).append( ") " ).append( items.get( i ) ).append( "\n" ) ;
        }
        sb.append( "0) Quit" ) ;
        return sb.toString() ;
    }
}
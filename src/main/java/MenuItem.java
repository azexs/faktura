import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MenuItem
{
    private String title ;
    private Menu submenu ;
    private ActionListener onselect ;


    MenuItem(String title, Menu submenu, ActionListener onselect)
    {
        this.title = title ;
        this.submenu = submenu ;
        this.onselect = onselect ;
    }

    String getTitle()
    {
        return title;
    }

    void select()
    {
        if( onselect != null )
            onselect.actionPerformed( new ActionEvent( this, 0, "select" ) ) ;
    }

    Menu getSubMenu()
    {
        return submenu ;
    }

    public String toString()
    {
        return title ;
    }
}
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Madalin.Colezea on 9/16/2015.
 */
public class JavaResourceBundle {

    public static void main(String[] args) {
        Locale locale = new Locale("en", "CA");
        ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);
        System.out.println(rb.getObject("hello"));
        System.out.println(rb.getString("world"));
    }

}

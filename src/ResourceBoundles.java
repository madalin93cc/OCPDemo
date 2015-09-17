import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Madalin.Colezea on 9/16/2015.
 */
public class ResourceBoundles {
    public static void main(String[] args) {
        Locale locale = new Locale("en");
        Locale locale1 = new Locale("fr");
        ResourceBundle rb = ResourceBundle.getBundle("Labels", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("hello2"));
        System.out.println(rb.getString("hello3"));
        rb = ResourceBundle.getBundle("Labels", locale1);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("hello2"));
        System.out.println(rb.getString("hello3"));
    }
}

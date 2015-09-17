import java.util.Locale;

/**
 * Created by Madalin.Colezea on 9/16/2015.
 */
public class DefaultLocale {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        Locale.setDefault(Locale.GERMANY);
        System.out.println(Locale.getDefault());
        Locale.setDefault(locale);
        System.out.println(Locale.getDefault());
    }
}

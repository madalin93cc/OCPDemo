import java.util.ListResourceBundle;

/**
 * Created by Madalin.Colezea on 9/16/2015.
 */
public class Labels_en_CA extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"hello", new StringBuilder("From java")},
                {"world", new String("World java")}
        };
    }

}

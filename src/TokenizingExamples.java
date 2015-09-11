import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Madalin.Colezea on 9/11/2015.
 */
public class TokenizingExamples {
    public static void main(String[] args) {
        testUsingString("Som1e 2 lo3ng str56ing to split", "\\d");
        testUsingString(("ab.def.aset"), ""); // all characters
        testUsingString(("ab.def.aset"), "."); // no character
        testUsingString(("ab.def.aset"), "\\."); // . separator
        testUsingScanner("1 true 34 hi");
        testUsingStringTokenizer();
    }

    private static void testUsingStringTokenizer(){
        StringTokenizer stringTokenizer1 = new StringTokenizer("a bc d e");
        System.out.println("Count: " + stringTokenizer1.countTokens());
        while (stringTokenizer1.hasMoreTokens()){
            System.out.println(">" + stringTokenizer1.nextToken() + "<");
        }
        System.out.println("Count: " + stringTokenizer1.countTokens());
        StringTokenizer  stringTokenizer2 = new StringTokenizer("a b cab a ba d", "a");
        System.out.println("Count: " + stringTokenizer2.countTokens());
        while (stringTokenizer2.hasMoreTokens()){
            System.out.println(">" + stringTokenizer2.nextToken() + "<");
        }
        System.out.println("Count: " + stringTokenizer2.countTokens());
    }

    private static void testUsingString(String s, String del){
        System.out.println("String: " + s);
        String[] tokens = s.split(del);
        for (String str: tokens){
            System.out.println("Token: >" + str + "<");
        }
    }

    private static void testUsingScanner(String s){
        int i;
        boolean b;
        String str, hits = "";
        Scanner s1 = new Scanner(s), s2 = new Scanner(s);

        while (s1.hasNext()){
            str = s1.next();
            hits += "s";
        }

        while (s2.hasNext()){
            if (s2.hasNextDouble()){
                i = s2.nextInt();
                hits += "i";
            } else if (s2.hasNextBoolean()){
                b = s2.nextBoolean();
                hits += "b";
            } else {
                s2.next();
                hits += "s2";
            }
        }
        System.out.println(hits);
    }
}

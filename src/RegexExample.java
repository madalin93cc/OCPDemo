import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Madalin.Colezea on 9/11/2015.
 */
public class RegexExample {
    public static void main(String[] args) {
        testRegex();
        testScanner();
    }

    private static void testRegex(){
        execRegex("ab", "abaaaba");
        execRegex("aba", "abababa");
        execRegex("\\d", "a12dd678a"); // digits
        execRegex("\\D", "a12dd678a"); // but digits
        execRegex("\\s", " a \tsda \rf\n\f"); // whitespaces
        execRegex("\\S", " a \tsda \rf\n\f"); // but whitespaces
        execRegex("\\w", "1a Z _ "); // word character
        execRegex("\\W", "1a Z _ "); // but word character
        execRegex("\\b", "w2w w$ &#w2");
        execRegex("\\B", "w2w w$ &#w2");
        execRegex("[abc]", "ansbdewcaf");
        execRegex("[a-f]", "ansbdewcaf");
        execRegex("[a-fA-F]","ansbDewcafDAacE");
        execRegex("[^abc]", "ansbdewcaf");
        execRegex("[a-z&&[abc]]", "ansbdewcaf");
        execRegex("0[xX][0-9a-fA-f]", "12 0x 0x12 0Xf 0xg"); // hexadecimal with one digit
        execRegex("\\d+", "1 a12 234b");
        execRegex("0[xX]([0-9a-fA-F])+", "12 0x 0x1234 0Xf 0xg");
        execRegex("proj1([^,])*", "proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java");
        execRegex("\\d\\d\\d([ -])?\\d\\d\\d\\d", "0123456a012 3456b012-3456");
        execRegex("a.c", "ac abc a c");
        execRegex(".*xx", "yyxxxyxx"); // greedy
        execRegex(".*?xx", "yyxxxyxx"); // non greedy
        execRegex("a?", "aba"); // zero length
        execRegex("a?", "baba");
    }

    private static void execRegex(String r, String s){
        Pattern pattern = Pattern.compile(r);
        Matcher matcher = pattern.matcher(s);
        System.out.println("Regex: " + r + " Input: " + s);
        while (matcher.find()){
            System.out.print(matcher.start()+ " " + matcher.end() + " " + matcher.group() + "\n");
        }
    }

    private static void testScanner(){
        Scanner s = new Scanner(System.in);
        String token;
        do {
            token = s.findInLine("\\d\\d");
            System.out.println("Found:" + token);
        } while (token != null);
    }
    private static void execScanner(){

    }
}

package assertions;
/**
 * Created by Madalin.Colezea on 9/4/2015.
 */
public class TestAssertions {
    public static void main(String[] args) {
//        testVerySimpleAssertion();
        testSimpleAssertion();
    }

    private static void testVerySimpleAssertion(){
        assert (1 < 2); // True
        System.out.println("pass 1");
        assert (1 > 2); // False
        System.out.println("pass 2");

        assert true;
        assert false;

//        illergal
//        assert (true): noReturn();
//        assert (true): ;
//        assert(x == 1) : ValidAssert va;
    }
    private static void noReturn(){};
    private static void testSimpleAssertion(){
        assert (1 < 2): "1 < 2"; // True
        System.out.println("pass 1");
        assert (1 == 1): 1; // True
        System.out.println("pass 2");
        assert (1 > 2): "1 > 2"; // False
        System.out.println("pass 3");
    }

}

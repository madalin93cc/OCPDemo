/**
 * Created by Madalin.Colezea on 9/17/2015.
 */
public class InnerClasses {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.createInner();

        Outer.Inner inner1 = outer.new Inner();
        inner1.doStuff();
        Outer.Inner inner2 = new Outer().new Inner();
        inner2.doStuff();

        Outer2 outer2 = new Outer2();
        outer2.doStuff();

        new InnerClasses().go();
    }

    void go (){
        new A().m();

        class A{
            void m() {
                System.out.println("Inner");
            }
        }
        new A().m();
    }

    class A{
        void m(){
            System.out.println("Middle");
        }
    }

}

class Outer {

    private int i = 0;

    public void createInner(){
        Inner inner = new Inner();
        inner.doStuff();
    }

    public static void createInnerStatic(){
        Inner inner = new Outer().new Inner();
        inner.doStuff();
    }

    class Inner {
        public void doStuff(){
            System.out.println(i);
            System.out.println("Inner:" + this);
            System.out.println("Outer:" + Outer.this);
        }
    }

}

class Outer2 {

    private String s = "Outer";

    public void doStuff(){
        final String s2 = "Local";
        class Inner2 {
            public void showOuter(){
                System.out.println("Outer: " + s);
                System.out.println("Local: " + s2);
            }
        }

        Inner2 inner2 = new Inner2();
        inner2.showOuter();
    }
}

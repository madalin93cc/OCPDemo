/**
 * Created by Madalin.Colezea on 9/18/2015.
 */
class Popcorn {
    public void pop(){
        System.out.println("Pop");
    }
}

interface Cookable {
    public void cook();
}

public class AnonymousClasses {

    Popcorn p = new Popcorn(){
        private int i = 0;
        @Override
        public void pop(){
            System.out.println("Anonymous pop");
        }
    };

    Cookable c = new Cookable() {
        @Override
        public void cook() {
            System.out.println("Cookable");
        }
    };

    public void doStuff(Cookable c, Popcorn a){
        c.cook();
        a.pop();
    }

    static class Nested {
        public void go(){
            System.out.println("Go");
        }

        public static void go2(){
            System.out.println("Go2");
        }
    }

    public static void main(String[] args) {
        AnonymousClasses ac = new AnonymousClasses();
        ac.p.pop();
        ac.c.cook();

        ac.doStuff(new Cookable() {
            @Override
            public void cook() {
                System.out.println("Cookable argument");
            }
        }, new Popcorn() {
            @Override
            public void pop() {
                System.out.println("Pop argument");
            }
        });

        AnonymousClasses.Nested n = new AnonymousClasses.Nested();
        n.go();
        Nested n2 = new Nested();
        n2.go();
        AnonymousClasses.Nested.go2();
        Nested.go2();
    }

}

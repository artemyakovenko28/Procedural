@SuppressWarnings("Duplicates")
public class OuterClass {

    private int foo;
    private static int bar;

    private void foo() {

    }

    private static void bar() {

    }

    public static class StaticNestedClass {
        public void baz() {
            OuterClass outerClass = new OuterClass();
            System.out.println(outerClass.foo);
            outerClass.foo();

            System.out.println(bar);
            bar();

            StaticNestedClass staticNestedClass = this;
        }

        public static void main(String[] args) {
            OuterClass outerClass = new OuterClass();
            System.out.println(outerClass.foo);
            outerClass.foo();

            System.out.println(bar);
            bar();
        }
    }

    public class InnerClass {
        public void baz() {
            System.out.println(foo);
            foo();

            System.out.println(bar);
            bar();

            OuterClass outerClass = OuterClass.this;
            InnerClass innerClass = this;
        }

        // Inner classes cannot have static declarations
    }
}

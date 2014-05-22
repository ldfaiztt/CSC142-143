public class FooBarBazMumble {
    public static void main(String[] args) {
        foo();
        bar();
        System.out.println("mumble");
    }

    public static void foo() {
        System.out.println("foo");
    }

    public static void bar() {
        baz();
        System.out.println("bar");
    }

    public static void baz() {
        System.out.println("baz");
    }
}

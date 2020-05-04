public class Test1 {
    private Foo testFoo;

    private class Foo {
        private int x;
        private int counter;

        public Foo() {
            x = (++counter);
        }
    }

    public void test() {
        testFoo = new Foo();
    }

}

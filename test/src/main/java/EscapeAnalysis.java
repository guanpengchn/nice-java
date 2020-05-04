
class EscapeAnalysis {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        long start = System.nanoTime();
        for (int i = 0; i < 1000 * 1000 * 10; ++i) {
            test1.test();
        }
        long end = System.nanoTime();
        System.out.println("Time cost is " + (end - start));
    }
}
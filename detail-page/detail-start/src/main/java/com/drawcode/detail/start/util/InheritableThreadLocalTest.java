package com.drawcode.detail.start.util;

public class InheritableThreadLocalTest {
//    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
//
//    public static String get() {
//        return threadLocal.get();
//    }
//
//    public static void set(String value) {
//        threadLocal.set(value);
//    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        System.out.println(Thread.currentThread().getName() +
                " 线程所在的线程组：" + group.getName());
//        InheritableThreadLocalTest.set("ye");
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName() + ":" + InheritableThreadLocalTest.get());
//            }
//        });
//
//        t.start();
    }
}

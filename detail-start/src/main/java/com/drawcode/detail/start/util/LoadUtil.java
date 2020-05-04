package com.drawcode.detail.start.util;

import com.drawcode.detail.service.RootAbility;
import com.drawcode.detail.service.annoation.Have;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadUtil {
    public static List<List<Class>> loadAll() {
        List<List<Class>> resList = new ArrayList<>();
        Class rootClass = RootAbility.class;

        List<Class> rootList = new ArrayList<>();
        rootList.add(rootClass);
        resList.add(rootList);

        Queue<Class> classQueue = new LinkedList<>();
        classQueue.add(rootClass);

        while (!classQueue.isEmpty()) {
            Class clazz = classQueue.poll();
            Field[] fields = clazz.getDeclaredFields();

            List<Class> clazzList = new ArrayList<>();

            for (Field field : fields) {
                Have have = field.getAnnotation(Have.class);
                if (have != null) {
                    Class childClass = field.getType();
                    classQueue.add(childClass);
                    clazzList.add(childClass);
                }
            }

            if (!clazzList.isEmpty()) {
                resList.add(clazzList);
            }
        }

        Collections.reverse(resList);

        createThreadPool(resList);
        return resList;
    }


    public static void createThreadPool(List<List<Class>> abilityList) {
        ThreadFactory threadFactory = new DetailThreadFactory();
        ExecutorService executorService = new ThreadPoolExecutor(
                3, 5, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(), threadFactory);
        Map<String, Object> abilityMap = new HashMap<>();
        for(List<Class> list: abilityList) {
            List<Future> futureList = new ArrayList<>();
            for(Class clazz: list) {
                Future future = executorService.submit(new Runnable() {
                    public void run() {
                        try {
                            Object object = clazz.newInstance();
                            abilityMap.put(clazz.getName(), object);
                            Field[] fields = clazz.getDeclaredFields();
                            for(Field field: fields) {
                                Have have = field.getAnnotation(Have.class);
                                if (have != null) {
                                    Class childClass = field.getType();
                                    field.setAccessible(true);
                                    field.set(object,abilityMap.get(childClass.getName()));
                                }
                            }
                            clazz.getDeclaredMethod("init").invoke(object);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                futureList.add(future);
            }
            for(Future future: futureList) {
                try {
                    future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }



    }

    static class DetailThreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }
}

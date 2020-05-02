package com.drawcode.detail.start.util;

import com.drawcode.detail.service.RootAbility;
import com.drawcode.detail.service.annoation.Have;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadUtil {
    public static List<Map<String, Class>> loadAll() {
        List<Map<String, Class>> resList = new ArrayList<>();
        Class rootClass = RootAbility.class;

        Map<String, Class> rootMap = new HashMap<>();
        rootMap.put(rootClass.getName(), rootClass);
        resList.add(rootMap);

        Queue<Class> classQueue = new LinkedList<>();
        classQueue.add(rootClass);

        while (!classQueue.isEmpty()) {
            Class clazz = classQueue.poll();
            Field[] fields = clazz.getDeclaredFields();

            Map<String, Class> clazzMap = new HashMap<>();

            for (Field field : fields) {
                Have have = field.getAnnotation(Have.class);
                if (have != null) {
                    Class childClass = field.getType();
                    classQueue.add(childClass);
                    clazzMap.put(childClass.getName(), childClass);
                }
            }

            if (!clazzMap.isEmpty()) {
                resList.add(clazzMap);
            }
        }

        Collections.reverse(resList);

        return resList;
    }

    public static void createThreadPool() {
        ThreadFactory threadFactory = new DetailThreadFactory();
        ExecutorService executorService = new ThreadPoolExecutor(
                3, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory);
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

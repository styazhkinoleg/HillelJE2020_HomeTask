package lesson_19;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        long stop = System.currentTimeMillis() + 5_000;
        Thread generator = new Thread(new ThreadGenerator());
        Thread consumer = new Thread(new ThreadConsumer());
        generator.start();
        consumer.start();
        do {
            Thread.sleep(1000);
        }while (System.currentTimeMillis() < stop);
        generator.interrupt();
        while(!consumer.isInterrupted()){
            if(Data.queue.isEmpty()){
                consumer.interrupt();
            }
        }

    }

    static class ThreadGenerator implements Runnable {
        @Override
        public void run() {
            Boolean isFull;
            while (!Thread.interrupted()) {
                isFull = Data.queue.size() == Data.queueLength;
                if (isFull) {
                    Thread.yield();
                } else {
                    Data.queue.add("#");
                    System.out.print(new Date().toString() + " >> ");
                    Data.showQueue();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    static class ThreadConsumer implements Runnable {
        @Override
        public void run() {
            Boolean isEmpty;
            while (!Thread.interrupted()) {
                isEmpty = Data.queue.isEmpty();
                if (isEmpty) {
                    Thread.yield();
                } else {
                    Data.queue.remove(0);
                    System.out.print(new Date().toString() + " << ");
                    Data.showQueue();
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    static class Data {
        final static int queueLength = 10;
        static volatile List<String> queue = new ArrayList();
        static void showQueue() {
            queue.stream().forEach((x) -> System.out.print(x));
            System.out.println();
        }
    }

}

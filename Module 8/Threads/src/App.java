//test code

public class App {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new NoahThreeThreads("Thread 1"));
        Thread thread2 = new Thread(new NoahThreeThreads("Thread 2"));
        Thread thread3 = new Thread(new NoahThreeThreads("Thread 3"));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

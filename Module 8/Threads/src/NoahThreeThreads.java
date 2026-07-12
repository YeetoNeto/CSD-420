/*
 Module 8.2 Assignment by Noah McCarthy
 Practice Running of multiple threads
*/


import java.util.concurrent.ThreadLocalRandom; //

public class NoahThreeThreads implements Runnable {
    private String threadType;

    public NoahThreeThreads(String threadType) {
        this.threadType = threadType;
    }

    @Override
    public void run() {
        char threadChar;
        int threadValue;
        for (int i = 0; i < 10000; i++) {
            switch (threadType) {
                case "Thread 1": //Char
                if (ThreadLocalRandom.current().nextBoolean()) {
                    threadChar = (char) (ThreadLocalRandom.current().nextInt('a', 'z'+1)); //65-122 a-z and A-Z                   
                }
                else{
                    threadChar = (char) (ThreadLocalRandom.current().nextInt('A', 'Z'+1)); //65-122 a-z and A-Z
                }
                System.out.print(threadChar);
                break;
                case "Thread 2": // Numbah
                    threadValue = ((int) (ThreadLocalRandom.current().nextInt(1, 101)));
                    System.out.print(threadValue);
                    break;
                case "Thread 3": // Special Symbol
                    if (ThreadLocalRandom.current().nextBoolean()) { // randomly generate a boolean true or fals for 50/50 odds
                        threadChar = (char) (ThreadLocalRandom.current().nextInt('!', '/'+1)); //33-47
                    } else {
                        threadChar = (char) (ThreadLocalRandom.current().nextInt(':', '@'+1)); //58-64
                    }
                    System.out.print(threadChar);
                    break;
                default:
                    System.out.print("This is an unknown thread");
            }
            try {
                Thread.sleep(1); // Sleep for 1 millisecond, to prevent hogging of print
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}

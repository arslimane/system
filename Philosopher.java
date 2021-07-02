package system;

import java.util.concurrent.ThreadLocalRandom;

public class Philosopher extends Thread{
    public int number;
    public fork leftfork;
    public fork rightfork;

    Philosopher(int num, fork left, fork right) {
        number = num;
        leftfork = left;
        rightfork = right;
    }

    public void run(){

        while (true) {
            think();
            leftfork.grab();
            System.out.println("philosopher " + (number+1) + " grabs left fork.");
            rightfork.grab();
            System.out.println("philosopher " + (number+1) + " grabs right fork.");
            eat();
            leftfork.release();
            System.out.println("philosopher " + (number+1) + " releases left fork.");
            rightfork.release();
            System.out.println("philosopher " + (number+1) + " releases right fork.");
        }
    }

    void eat() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
            System.out.println("philosopher " + (number+1) + " eats for " + sleepTime);
            Thread.sleep(sleepTime);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    void think() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
            System.out.println("philosopher " + (number+1) + " think for " + sleepTime);
            Thread.sleep(sleepTime);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }


}


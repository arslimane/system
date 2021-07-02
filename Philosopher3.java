package system;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Philosopher3 extends Thread{
    public int number;
    public static String[] etat_philo= {"PENSE","PENSE","PENSE","PENSE","PENSE"};
    public static Semaphore mutex=new Semaphore(1);
    public static   Semaphore[] philo;

    public static void init(){
        philo=new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            philo[i]=new Semaphore(0);
        }
    }

  public Philosopher3(int n){
      this.number=n;
  }

    @Override
    public void run() {
        while (true) {
            think();
            prendre_fourchette(this.number);
            poser_fourchette(this.number);

        }

    }

    public void  prendre_fourchette (int i){
        try {
            mutex.acquire();
            etat_philo[i]="A_FAIM";
            System.out.println(" philo" +(i+1)+"A_FAIM");
            test_mange(i);
            eat();
            mutex.release();
            philo[ this.number ].acquire();

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void  test_mange(int i){
        if (etat_philo[ i ] == "A_FAIM"
                && etat_philo[ (i+1)%5 ] != "MANGE"
                && etat_philo[ (i-1+5)%5 ] != "MANGE" ) {
            etat_philo[i ] = "MANGE";
            philo[ i ].release();
        }
    }
    public void poser_fourchette (int i){
        try {
            mutex.acquire();
            etat_philo[i] = "PENSE";
            System.out.println("philo "+(i+1)+" pose f");
            test_mange((i + 1) % 5);
            test_mange((i - 1 + 5) % 5);
            mutex.release();
        }catch (Exception e){
            System.out.println(e);
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
}

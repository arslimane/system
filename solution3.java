package system;

public class solution3 {
    public static fork[] forks;
    public static Philosopher2[] philosopher;
    public static void main(String[] args) {
        forks=new fork[5];
        philosopher=new Philosopher2[5];

        for(int i=0;i<5;i++){
            forks[i]=new fork();
        }

        for(int i=0;i<5;i++){
            philosopher[i]=new Philosopher2(i,forks[i],forks[(i+1)%5]);
            philosopher[i].start();
        }



    }
}

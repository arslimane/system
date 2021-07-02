package system;

public class solution2 {
    public static fork[] forks;
    public static Philosopher[] philosopher;
    public static void main(String[] args) {
        forks=new fork[5];
        philosopher=new Philosopher[5];

        for(int i=0;i<5;i++){
            forks[i]=new fork();
        }

        for(int i=0;i<5;i++){
            if(i==4){
                philosopher[i]=new Philosopher(i, forks[(i+1)%5], forks[i]);
                philosopher[i].start();

            }else {
                philosopher[i] = new Philosopher(i, forks[i], forks[(i + 1) % 5]);
                philosopher[i].start();
            }
        }



    }
}

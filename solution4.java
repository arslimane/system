package system;

public class solution4 {
    public static Philosopher3[] philosopher;
    public static void main(String[] args) {
        Philosopher3.init();
        philosopher=new Philosopher3[5];
        for(int i=0;i<5;i++){
            philosopher[i]=new Philosopher3(i);
            philosopher[i].start();
        }

    }
}

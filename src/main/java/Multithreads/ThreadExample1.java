package Multithreads;

public class ThreadExample1 extends Thread{

    public void start(){
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }


}

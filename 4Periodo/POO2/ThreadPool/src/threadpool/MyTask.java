package threadpool;

import java.awt.BorderLayout;

public class MyTask implements Runnable {
    private static int id = 0;
    private String name;

    public MyTask() {
        this.name = "MyTask_" + id++;
    }
    
    @Override 
    public void run() {
        System.out.printf("%s is running %s \n", Thread.currentThread().getName(), name);
        this.process();
        System.out.printf("%s End.\n", name);
    }
    
    private void process(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    } 
    
}

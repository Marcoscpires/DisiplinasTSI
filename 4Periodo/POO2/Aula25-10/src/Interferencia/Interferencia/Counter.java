package Interferencia;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private AtomicInteger c = new AtomicInteger();
    public void increment(){
        c.getAndIncrement();
    }
    public void decrement(){
        c.getAndDecrement();
    }
    public int value(){
        return c.get();
    }
}

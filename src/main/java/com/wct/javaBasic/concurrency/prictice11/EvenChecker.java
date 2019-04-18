package com.wct.javaBasic.concurrency.prictice11;

public class EvenChecker implements Runnable{
    EvenGenerator evenGenerator;

    public EvenChecker(EvenGenerator evenGenerator) {
        this.evenGenerator = evenGenerator;
    }

    @Override
    public void run() {
        while (!evenGenerator.isCancel()){
            int value = evenGenerator.next();
            if (value % 2 != 0){
                evenGenerator.cancel();
                System.out.println(Thread.currentThread().getName()+"发生异常，异常数据："+value);
            }
            else{
                System.out.println(Thread.currentThread().getName()+"产生的偶数："+value);
            }
            Thread.yield();
        }
    }
}

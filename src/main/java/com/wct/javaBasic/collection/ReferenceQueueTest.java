package com.wct.javaBasic.collection;

import java.lang.ref.*;
import java.util.LinkedList;

public class ReferenceQueueTest {

    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<>();

    private static void checkQueue(){
        Reference<? extends VeryBig> inq = rq.poll();
        if (inq != null){
            System.out.println("in queue"+inq.get());
        }
    }

    public static void main(String[] args) {
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
        for (int i=0;i<10;i++){
            sa.add(new SoftReference<VeryBig>(new VeryBig("Soft"+i),rq));
            System.out.println("just created"+sa.getLast());
            checkQueue();
        }
        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
        for (int i=0;i<10;i++){
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak"+i),rq));
            System.out.println("just created"+wa.getLast());
            checkQueue();
        }
        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
        for (int i=0;i<10;i++){
            pa.add(new PhantomReference<VeryBig>(new VeryBig("Phantom"+i),rq));
            System.out.println("just created"+pa.getLast());
            checkQueue();
        }

        System.gc();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Reference<? extends VeryBig> inq = null;
        try {
            inq = rq.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (inq != null){
            System.out.println("in queue"+inq.get());
        }
    }
}

class VeryBig{
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;

    public VeryBig(String ident) {
        this.ident = ident;
    }

    @Override
    public String toString() {
        return "VeryBig{" +
                "ident='" + ident + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " + ident);
    }
}


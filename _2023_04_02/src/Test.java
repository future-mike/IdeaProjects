class BlockThread extends Thread {
    private String name;    //当前线程名称
    private Object lock;    //锁
    public BlockThread(Object lock,String name){
        this.lock = lock;
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println("Thread "+name+" State is "+Thread.currentThread().getState());
        synchronized (lock) {
            System.out.println("Thread "+name+" hold the lock");
            try {
                System.out.println("Thread "+name+" State is "+Thread.currentThread().getState());
                Thread.sleep(1000 * 10);    //抢到锁的线程执行逻辑，这里用睡眠模拟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + name + " release the lock");
        }
    }
}
public class Test{
    public static void main(String[] args) throws Exception{
        Object lock = new Object();//锁
        BlockThread t1 = new BlockThread(lock,"T1");
        BlockThread t2 = new BlockThread(lock,"T2");
        t1.start(); //线程 T1开始运行
        t2.start(); //线程 T2开始运行
        Thread.sleep(100);  //阻塞主线程，等待T1，T2抢锁
        System.out.println("Thread T1 State is " + t1.getState());  //获取T1线程状态
        System.out.println("Thread T2 State is " + t2.getState());  //获取T2线程状态
    }
}

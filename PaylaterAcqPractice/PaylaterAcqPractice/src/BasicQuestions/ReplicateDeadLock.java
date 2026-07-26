package BasicQuestions;

public class ReplicateDeadLock {
	
	   static final Object LOCK_A = new Object();
	    static final Object LOCK_B = new Object();

	public static void main(String[] args) {
		
		// Thread 1: acquires Lock A, then tries to acquire Lock B
        Thread thread1 = new Thread(() -> {
            synchronized (LOCK_A) {
                System.out.println("Thread 1: Holding Lock A...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for Lock B...");
                synchronized (LOCK_B) {
                    System.out.println("Thread 1: Acquired both locks!");
                }
            }
        });

        // Thread 2: acquires Lock B, then tries to acquire Lock A
        Thread thread2 = new Thread(() -> {
            synchronized (LOCK_B) {
                System.out.println("Thread 2: Holding Lock B...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for Lock A...");
                synchronized (LOCK_A) {
                    System.out.println("Thread 2: Acquired both locks!");
                }
            }
        });

        thread1.start();
        thread2.start();
        
//        In the Deadlock code ❌
//        Thread 1Thread 2Lock A → then Lock BLock B → then Lock A ← opposite!
//        Thread 2 acquires them in reverse order — that's what causes the deadlock.
//        In the Fix ✅
//        Thread 1Thread 2Lock A → then Lock BLock A → then Lock B ← same order!
//        Both threads follow the same order, so one will always finish and release before the other needs it.

	}

}

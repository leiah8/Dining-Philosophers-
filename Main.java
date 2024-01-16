public class Main {
    private static final int K = 3;
    
    public static void main(String[] args) {
        CookieDispenser cookieDispenser = new CookieDispenser();
        ColaDispenser colaDispenser = new ColaDispenser();
        Servant servant = new Servant(cookieDispenser, colaDispenser);
        Thread [] philosophers = new Thread[K];
        
        
        // create and start philosopher threads
        for (int i = 0; i < K; i++) {
            philosophers[i] = new Thread(new Philosopher(i + 1, cookieDispenser, colaDispenser));
            philosophers[i].start();
        
        }
        
    }
}
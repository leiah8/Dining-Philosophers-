public class CookieDispenser {
    private static final int M = 3;
    private int cookies = M;

    public synchronized boolean hasCookie() {
        return cookies > 0;
    }

    public synchronized void takeCookie() {
        cookies--;
        System.out.println("give cookie");
        notifyAll();
    }

    public synchronized void refillCookies() {
        cookies = M;
        //System.out.println("refill cookie");
        notifyAll();
    }
}
public class Philosopher implements Runnable {
    private final int num;
    private final CookieDispenser cookieDispenser;
    private final ColaDispenser colaDispenser;

    public Philosopher(int num, CookieDispenser cookieDispenser, ColaDispenser colaDispenser) {
        this.num = num;
        this.cookieDispenser = cookieDispenser;
        this.colaDispenser = colaDispenser;
    }

    @Override
    public void run() {
        while (true) {
            think();
            getCookie();
            eatCookie();
            getCola();
            drinkCola();
        }
    }

    private void think() {
        System.out.println("thinking");
    }

    private void getCookie() {
        synchronized (cookieDispenser) {
            while (!cookieDispenser.hasCookie()) {
                try {
                    cookieDispenser.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cookieDispenser.takeCookie();
        }
    }

    private void eatCookie() {
    	System.out.println("eating cookie");
    }

    private void getCola() {
        synchronized (colaDispenser) {
            while (!colaDispenser.hasCola()) {
                try {
                    colaDispenser.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            colaDispenser.takeCola();
        }
    }

    private void drinkCola() {
    	System.out.println("drinking cola");
    }
}
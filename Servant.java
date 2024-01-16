public class Servant implements Runnable {
    private final CookieDispenser cookieDispenser;
    private final ColaDispenser colaDispenser;

    public Servant(CookieDispenser cookieDispenser, ColaDispenser colaDispenser) {
        this.cookieDispenser = cookieDispenser;
        this.colaDispenser = colaDispenser;
    }

    @Override
    public void run() {
        while (true) {
            // wait action
            if (!cookieDispenser.hasCookie()) {
                cookieDispenser.refillCookies();
                System.out.println("refilling cookies");
            }
            if (!colaDispenser.hasCola()) {
                colaDispenser.refillCola();
                System.out.println("refilling colas");
            }
        }
    }
}

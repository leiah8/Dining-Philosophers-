public class ColaDispenser {
    private static final int N = 3;
    private int colas = N;

    public synchronized boolean hasCola() {
        return colas > 0;
    }

    public synchronized void takeCola() {
        colas--;
        System.out.println("give cola");
        notifyAll();
    }

    public synchronized void refillCola() {
        colas = N;
        notifyAll();
    }
}

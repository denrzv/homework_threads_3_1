import java.util.concurrent.atomic.AtomicBoolean;

public class Toy implements Runnable {
    private final AtomicBoolean isToyOpen;
    private final long SLEEP_TIMER = 1500;

    public Toy() {
        isToyOpen = new AtomicBoolean(false);
    }

    public void close() {
        isToyOpen.set(false);
        System.out.println("Игрушка закрылась!");
    }

    public boolean isOpen() {
        return isToyOpen.get();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (isOpen()) {
                close();
            }
            try {
                Thread.sleep(SLEEP_TIMER);
            } catch (InterruptedException e) {
                System.out.println("Игрушка останавливается...");
                Thread.currentThread().interrupt();
            }
        }
    }

    public void open() {
        isToyOpen.set(true);
        System.out.println("Игрушка открылась!");
    }
}

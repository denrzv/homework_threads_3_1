public class Player implements Runnable {
    private final long REPEAT_TIMER = 3000;
    private final int REPEAT_COUNT = 3;
    private final Toy toy;

    public Player(Toy toy) {
        this.toy = toy;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < REPEAT_COUNT) {
            System.out.println("Игрок нажимает тумблер...");
            counter++;
            toy.open();
            try {
                Thread.sleep(REPEAT_TIMER);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Игрок закончил играть...");
    }
}

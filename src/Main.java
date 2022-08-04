public class Main {

    public static void main(String[] args) {
        Toy toy = new Toy();
        Player player = new Player(toy);

        Thread toyThread = new Thread(toy, "Игрушка");
        Thread playerThread = new Thread(player, "Игрок");

        toyThread.start();
        playerThread.start();

        try {
            playerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            toyThread.interrupt();
        }
    }
}
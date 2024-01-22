package JAVA2;

import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Thread[] readers = new Thread[7];
        Thread[] writers = new Thread[2];

        for (int i = 0; i < 7; i++) {
            readers[i] = new Thread(new Reader("Czytelnik " + (i + 1), library));
            readers[i].start();
        }

        for (int i = 0; i < 2; i++) {
            writers[i] = new Thread(new Writer("Pisarz " + (i + 1), library));
            writers[i].start();
        }

        Timer timer = new Timer(); // Program symuluje przez 10 sekund
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Koniec symulacji.");
                System.exit(0);
            }
        }, 10000);
    }
}
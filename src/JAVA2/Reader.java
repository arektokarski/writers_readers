package JAVA2;

import java.util.Random;

class Reader implements Runnable {
    private String name;
    private Library library;
    private Random random;

    public Reader(String name, Library library) {
        this.name = name;
        this.library = library;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(501) + 500);  // Czas oczekiwania przed wejściem do biblioteki
                library.enterLibrary(name);
                Thread.sleep(random.nextInt(401) + 100);  // Czas spędzony w bibliotece
                library.exitLibrary(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
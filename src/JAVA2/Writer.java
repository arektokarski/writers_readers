package JAVA2;

import java.util.Random;

class Writer implements Runnable {
    private String name;
    private Library library;
    private Random random;

    public Writer(String name, Library library) {
        this.name = name;
        this.library = library;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(501) + 500);  // Time waiting before entering the Library

                synchronized (library) {
                    while (!library.isLibraryEmpty()) {
                        library.wait();
                    }

                    library.enterLibrary(name);
                    Thread.sleep(random.nextInt(401) + 100);  // Time spent in the Library
                    library.exitLibrary(name);
                }

                Thread.sleep(random.nextInt(501) + 500);  // Time waiting after leaving the Library
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
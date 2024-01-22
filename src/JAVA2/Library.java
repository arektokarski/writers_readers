package JAVA2;

import java.util.LinkedList;
import java.util.Queue;

class Library {
    private Queue<String> queue;

    public Library() {
        queue = new LinkedList<>();
    }

    public synchronized void enterLibrary(String name) {
        queue.add(name);
        System.out.println(name + " wszedł do biblioteki.");
    }

    public synchronized void exitLibrary(String name) {
        queue.remove(name);
        System.out.println(name + " wyszedł z biblioteki.");
        notifyAll();
    }

    public synchronized boolean isLibraryEmpty() {
        return queue.isEmpty();
    }
}
package colas;

import listas.TLLNode;

import java.util.List;

public class Main {
    public static void main (String[] args) {
        TQueue <Integer> queue = new TQueue <> ();

        System.out.println (queue.isEmpty () ? "Vacia" : "No vacia");
        queue.offer (-1);
        queue.offer (0);
        queue.offer (1);
        queue.offer (5);
        System.out.println (queue.isEmpty () ? "Vacia" : "No vacia");
        System.out.println (queue.poll ());
        System.out.println (queue.peek ());

        for (Integer i : queue) {
            System.out.println (i);
        }
    }
}

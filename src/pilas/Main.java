package pilas;

public class Main {
    public static void main (String[] args) {
        TStack <Integer> stack = new TStack <> ();
        Integer elPopi;

        stack.push (5);
        stack.push (4);
        elPopi = stack.pop ();
        stack.push (3);
        stack.push (2);
        stack.push (1);

        System.out.println (stack.pop () );
        System.out.println (stack.peek () );
        System.out.println (stack.pop () );
        System.out.println (elPopi);
        System.out.println (stack.search (5) );
        System.out.println (stack.isEmpty ()? "Esta vacio" : "No esta vacio");
    }
}

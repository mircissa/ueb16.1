import java.util.Iterator;
import java.util.Scanner;
/**
 * Test-Klasse um den lexikalisch kleinsten Vornamen zurueckzugeben
 * Author: Abbas, Maass
 */
public class Main {
    public static void main(String[] args){
        PersonQueue queue = new PersonQueue();
        queue.addLast(new Person("Jonathan", "Joestar"));
        queue.addLast(new Person("Joseph", "Joestar"));
        queue.addLast(new Person("Jotaro", "Kujo"));
        queue.addLast(new Person("Josuke", "Higashikata"));
        queue.addLast(new Person("Giorno", "Giovanna"));
        //queue.print();
        System.out.println(queue.smallest());
    }

}


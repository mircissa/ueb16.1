import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Die Klasse "PersonQueue" zum Implementieren mittels der Klasse "ObjectQueue"
 * 
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */

public class PersonQueue
        extends ObjectQueue {
    private static final String KEIN_PERSON_OBJEKT = "Das angegebene Objet ist kein Person-Objekt.";

    /**
     * Methode um ein Person-Element an Queue anfuegen
     * 
     * @param Object (Person)
     * @return fügt Person in das array ein
     */

    public void addLast(Object o) {
        if (o instanceof Person) {
            super.addLast(o);
        } else {
            throw new RuntimeException(KEIN_PERSON_OBJEKT);
        }
    }


    /**
     * Methode um die erste Person aus der Queue entfernen
     * 
     * @return entfernt erste Person
     */

    public Person removeFirst() {
        return (Person) super.removeFirst();
    }


    /**
     * Methode um die i-te Person der Queue zurueckgeben
     * 
     * @param array stelle als int wert
     * @return Person an dieser Stelle
     */
    public Person get(int i) {
        return (Person) super.get(i);
    }

    /**
     * Methode um die Gesamte Queue mithilfe des Iterators auszugegeben
     * 
     * @return Queue Ausgabe
     */
    
    public void print() {
        Iterator iterator = new PersonQeueIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    /**
     * Methode um die Person mit dem lexikalisch kleinsten Vornamen
     * zu finden (durch internen Iterator)
     * 
     * @return lexikalisch kleinste Person
     */
    public String smallest() {

        PersonQeueIterator iterator = new PersonQeueIterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException();
        }
        Person smallest = iterator.next();
        while(iterator.hasNext()){
            Person p = iterator.next();
            if(NameIsSmaller(p, smallest)){
                smallest = p;
            }
        }
        return smallest.toString();
    }
    
    /**
     * Methode um zwei lexikanische werte zu vergleichen
     * 
     * @param zwei Personen/namen
     * @return true or false
     */
    private boolean NameIsSmaller(Person newPerson, Person smallest){
        int count = 0;
        String newVorname = newPerson.vorname;
        String smallestVorname = smallest.vorname;
        while(count < newVorname.length() && count < smallestVorname.length()){
            if(newVorname.charAt(count) < smallestVorname.charAt(count)){
                return true;
            }
            count++;
        }
        return newVorname.length() < smallestVorname.length();
    }


    interface PersonIterator extends java.util.Iterator<Person> {
    }

    /**
     * Iterator
     */
    private class PersonQeueIterator implements PersonIterator {
        int counter = 1;


        @Override
        public boolean hasNext() {
            return this.counter <= PersonQueue.super.size();
        }

        @Override
        public Person next() {
            if (this.hasNext()) {
                return PersonQueue.this.get(counter++);
            }
            throw new NoSuchElementException();
        }
    }

}

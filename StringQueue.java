/**
 * Die Klasse "StringQueue" zum Implementieren mittels der Klasse "ObjectQueue"
 * 
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */

public class StringQueue 
       extends ObjectQueue

{
   private static final String  KEIN_STRING_OBJEKT = "Das angegebene Objekt ist kein String-Objekt.";


   /** 
    * * Methode um ein String-Element an Queue anfuegen
     * 
     * @param Object (Person)
     * @return fügt Person in das array ein
    */
   public void addLast (Object o) 
   {
     if ( o instanceof String )
       {
        super.addLast( o );
       }
     else
       {
         throw new RuntimeException(KEIN_STRING_OBJEKT);
       }
   }


   /**
    * Methode um den ersten String aus der Queue zu entfernen
    * 
    * @return entfernt ersten String
    */
   public String removeFirst () 
   {
     return (String)super.removeFirst();
   }


   /** 
    *Methode um den i-ten String der Queue zurueckgeben
    * 
    * @param array stelle als int wert
    * @return Person an dieser Stelle
    */
   public String get ( int i ) 
   {
     return (String)super.get(i);
   }

}

/**
 * Die Klasse "ObjectQueue" zum Implmenetieren mittels Object-Array
 * 
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */

public class ObjectQueue 
       implements Queue
{


   public static final int QUEUE_STANDARD_LAENGE = 10;
   
   private static final String  QUEUE_IST_VOLL = "Die Queue ist vollstaendig belegt.";
   private static final String  QUEUE_IST_LEER = "Die Queue ist vollstaendig leer.";
   private static final String  INDEX_OUT_OFF_RANGE = "Der angegebene Index ist groesser als die Laenge der Queue!";

   /**
    * Queue-Array
    */
   private Object[] queue;
   private int size;

   /**
    * Konstruktor
    * erstellt ein Object: array nḿit standart länge von 10
    * 
    * @return Array Object
    */

   public ObjectQueue() {
       queue = new Object[QUEUE_STANDARD_LAENGE];
       size = 0;
   }

   /** 
    * Methode um ein Element an Queue anfuegen 
    * 
    * @param object
    * @return fügt object ubs array ein
    */
   
   public void addLast (Object o) 
   {
     if ( full() )
       {
         throw new RuntimeException(QUEUE_IST_VOLL);
       }
    
     queue[size] = o;
     size++;
   }

   /** 
    * Methode um erstes Element aus der Queue zu entfernen
    * 
    * @return entfernt erstes object
    */
   
   public Object removeFirst () 
   {
     if ( empty() )
       {
         throw new RuntimeException(QUEUE_IST_LEER);
       }
    
     int i;
     Object helfer = queue[0];
     size--;
     for ( i = 0; i < size; i++ )
       {
        queue[i] = queue[i+1];
       }
     queue[i+1] = null;  
     return helfer;
   }

   /** 
    * Methode um das i-te Element der Queue zurueckgeben
    * 
    * @param array stelle als int wert
    * @return object an dieser Stelle
    */
   public Object get ( int i ) 
   {
     if ( empty() )
       {
         throw new RuntimeException(QUEUE_IST_LEER);
       }
    
     if ( i > size )
       {
         throw new RuntimeException(INDEX_OUT_OFF_RANGE);
       }
    
     return queue[i-1];
   }

   /** 
    * Methode um zu checken ob die Queue voll ist
    * 
    * @return true or false
    */
   public boolean full  () 
   {
     return ( size == 10 );
   }

   /** 
    * Methode um zu checken ob die Queue leer ist
    * 
    * @return true or false
    */
   public boolean empty  () 
   {
     return ( size == 0 );
   }

   /** 
    * Methode um zu checken wie viele Elemente die Queue enthaelt
    * 
    * @return anzahl der objekte
    */
   public int size  () 
   {
     return size;
   }

   /** 
    * toString-Methode
    */
   public String toString() 
   {
     StringBuffer sb = new StringBuffer();

     for ( int index = 0; index < size; index++)
        {
           sb.append(queue[index] + " - ");
        }
     return sb.toString();
   }
}

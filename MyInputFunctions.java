/**
 * Die Klasse "MyInputFunctions", welches Eingabe-Methoden
 * realisisert (auf Basis der Scanner-Klasse)
 */

import java.util.Scanner;

public class MyInputFunctions
{
                         
    /**
     * Konstruktor, der die Erzeugung eines Objektes dieser Klasse verhindert
     */
    private MyInputFunctions()
    {
    }

   /**
    * Eingabeaufforderungs-Text wird ausgegeben
    * und liest aus int die erste int-Zahl
    * (danach ueberliest es bis zum Zeilenende alle weiteren Zeichen)
    * 
    * @param eingabe & eingabeaufforderung
    * @return int zahl
    */ 
   public static int readlnInt(Scanner in, String eingabeAufforderung)
   {
    System.out.print( eingabeAufforderung );
    int zahl = in.nextInt();
    in.nextLine();
    return zahl;
   }

   /**
    * Eingabeaufforderungs-Text wird ausgegeben
    * und liest aus Long die erste Long-Zahl
    * (danach ueberliest es bis zum Zeilenende alle weiteren Zeichen)
    * 
    * @param eingabe & eingabeaufforderung
    * @return Long zahl
    */ 
   public static long readlnLong(Scanner in, String eingabeAufforderung)
   {
    
    System.out.print( eingabeAufforderung );
    long zahl = in.nextLong();
    in.nextLine();
    return zahl;
   }

   /**
    * Eingabeaufforderungs-Text wird ausgegeben
    * und liest aus float die erste float-Zahl
    * (danach ueberliest es bis zum Zeilenende alle weiteren Zeichen)
    * 
    * @param eingabe & eingabeaufforderung
    * @return float zahl
    */ 
   public static float readlnFloat(Scanner in, String eingabeAufforderung)
   {
    System.out.print( eingabeAufforderung );
    float zahl = in.nextFloat();
    in.nextLine();
    return zahl;
   }

   
   /**
    * Eingabeaufforderungs-Text wird ausgegeben
    * und liest aus double die erste double-Zahl
    * (danach ueberliest es bis zum Zeilenende alle weiteren Zeichen)
    * 
    * @param eingabe & eingabeaufforderung
    * @return double zahl
    */ 
   public static double readlnDouble(Scanner in, String eingabeAufforderung)
   {
    System.out.print( eingabeAufforderung );
    double zahl = in.nextDouble();
    in.nextLine();
    return zahl;
   }

   /**
    * Eingabeaufforderungs-Text wird ausgegeben
    * und liest aus String den erste String
    * (danach ueberliest es bis zum Zeilenende alle weiteren Zeichen)
    * 
    * @param eingabe & eingabeaufforderung
    * @return String
    */ 
   public static String readlnString(Scanner in, String eingabeAufforderung)
   {
    System.out.print( eingabeAufforderung );
    String zeile = in.nextLine();
    return zeile;
   }


   /**
    * Eingabeaufforderungs-Text wird ausgegeben
    * 
    * @param eingabe
    * @return String
    */ 
   public static String readlnString(Scanner in)
   {
    String zeile = null;

    if ( in.hasNextLine() )
      {
        zeile = in.nextLine();
      }
    return zeile;
   }
   
   /**
    * Eingabeaufforderungs-Text wird ausgegeben
    * und liest aus Char der erste Char
    * (danach ueberliest es bis zum Zeilenende alle weiteren Zeichen)
    * 
    * @param eingabe & eingabeaufforderung
    * @return Char
    */    
   public static char readlnChar(Scanner in, String eingabeAufforderung)
   {
    System.out.print( eingabeAufforderung );
    String zeile = in.nextLine();
    char zeichen = zeile.toCharArray()[0];
    return zeichen;
   }

}

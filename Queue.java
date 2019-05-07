/**
 * Eine einfache Queue-Klasse zum Beschreiben von Schnittstellen
 * 
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */

public interface Queue
{

  /**
   * Objekt hinten anfuegen
   */
  public void addLast ( Object o );

  /**
   * Entferne das erste Element und gebe eine Referenz darauf zurueck
   */
  public Object removeFirst();

  /**
   * Das i-te Element zurueckgeben
   */
  public Object get(int i);

  /**
   * Testen, ob schon Element eingefuegt wurden
   */
  public boolean empty();

  /**
   * Testen, ob noch Element einfuegbar sind, d.h. ob das letzte
   * Element schon einen Wert ungleich null hat
   */
  public boolean full();

  /**
   * Anzahl eingefuegter Elemente
   */
  public int size();
}

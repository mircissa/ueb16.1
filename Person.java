/**
 * Klasse Person zum erstellen eines Person Objekts
 * 
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */

public class Person implements java.io.Serializable {
  protected String name;
  protected String vorname;
    
  /**
   * Konstruktor um ein Personen-Object zu erstellen
   * 
   * @param nachname & vorname
   * @return person object
   */  
  public Person( String name, String vorname) {
      this.name = name;
      this.vorname = vorname;
  }

  /**
   * Methode um das Personen Object in der Standardausgabe auszugeben
   * 
   * @return Ausgabe
   */
  public void ausgeben() {
      System.out.print(name + ", " + vorname);
  }
  
  /**
   * Set-Methode für nachname
   * 
   * @param name
   * @return setted nachname
   */
  public void setName(String n) {
      name = n;
  }
  
  /**
   * Set-Methode für vorname
   * 
   * @param name
   * @return setted vorname
   */
  public void setVorname(String vn) {
      vorname = vn;
  }
  
  /**
   * Get-Methode für nachname
   * 
   * @return nachname
   */
  public String getName() {
      return name;
  }
  
  /**
   * Get-Methode für vorname
   * 
   * @return vorname
   */
  public String getVorname() {
      return vorname;
  }
  
  /**
   * toString
   */
  public String toString() {
      return name + ", " + vorname;
  }
}


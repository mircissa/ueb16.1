import java.util.Scanner;

/**
 * Eine Test-Klasse "QueueTest" welches ein Dialogprogramm
 * zum Testen von Klasse "StringQueue" und "PersonQueue" sein soll
 * 
 * @author Hussein Abbas & Samantha Maaß
 * @version 04.05.2019
 */

public class QueueTest {
    //Klassenkonstanten
    private boolean isPersonQueue = false;
    private static final int QUEUE_INHALT_ANZEIGEN = 3;
    private static final int QUEUE_ELEMENT_ANHAENGEN = 4;
    private static final int QUEUE_ELEMENT_ENTFERNEN = 5;
    private static final int QUEUE_INDEX_ELEMENT_ANZEIGEN = 6;
    private static final int QUEUE_PRINT = 7;
    private static final int QUEUE_SMALLEST = 8;

    private static final int STRING = 0;
    private static final int PERSON = 2;

    private static final int QUEUE_LEER = 9;
    private static final int QUEUE_VOLL = 10;

    private static final int ZEIGE_MOMENTANE_ANZAHL = 11;

    private static final int ENDE = 99;


    private static final char STRING_QUEUE = 's';
    private static final char PERSON_QUEUE = 'p';

    public static final int KEIN_OBJEKT_VORHANDEN = -1;


    private Scanner in;
    private Queue eineQueue;

    /**
     * Methode um eine Queue zu erstellen (entweder typ String oder Typ Person)
     * 
     * @param char (S = String, P = Person)
     * @return erstellt queue
     */
    public QueueTest(char wahl)
            throws Exception {
        if (wahl == STRING_QUEUE) {
            eineQueue = new StringQueue();
            System.out.println("\n\tEin StringQueue-Objekt wurde konstruiert.\n\n");
        } else {
            if (wahl == PERSON_QUEUE) {
                eineQueue = new PersonQueue();
                isPersonQueue = true;
                System.out.println("\n\tEin PersonQueue-Objekt wurde konstruiert.\n\n");
            } else {
                throw new Exception("\n\nMan kann nur Objekt-(" + STRING_QUEUE +
                        ") oder Objektbestandteil-(" + PERSON_QUEUE +
                        ") -Arrays erzeugen."
                );
            }
        }

        in = new Scanner(System.in);
    }

    /**
     * Start-Methode
     */
    public void start() {
        int wastun;
        int index;
        Object helfer;


        while ((wastun = wasTun()) != ENDE) {
            try {
                switch (wastun) {
                    case QUEUE_INHALT_ANZEIGEN:
                        System.out.println("Die Queue: ");
                        System.out.println("-------------------------------------------------");
                        System.out.println(eineQueue);
                        System.out.println("-------------------------------------------------");
                        break;
                    case QUEUE_ELEMENT_ANHAENGEN:
                        eineQueue.addLast(leseElement());
                        break;
                    case QUEUE_ELEMENT_ENTFERNEN:
                        helfer = eineQueue.removeFirst();
                        System.out.println("\t---> Das entfernte Queue-Element: " +
                                helfer
                        );
                        break;
                    case QUEUE_INDEX_ELEMENT_ANZEIGEN:
                        index = MyInputFunctions.readlnInt(in, "Gebe ein Index ein, zu dem " +
                                "das Queue-Element angezeigt werden soll: "
                        );
                        System.out.println("\t---> Das " + index + "'te Queue-Element : " +
                                eineQueue.get(index)
                        );
                        break;
                    case QUEUE_LEER:
                        System.out.println("\n\t\tDie aktuelle Queue ist leer." +
                                "\t-->\tDiese Aussage ist: " +
                                eineQueue.empty()
                        );
                        break;
                    case QUEUE_VOLL:
                        System.out.println("\n\t\tDie aktuelle Queue ist voll." +
                                "\t-->\tDiese Aussage ist: " +
                                eineQueue.full()
                        );
                        break;
                    case ZEIGE_MOMENTANE_ANZAHL:
                        System.out.println("\n\t Die aktuelle Queue-Element-Anzahl: " +
                                eineQueue.size()
                        );
                        break;
                    case QUEUE_PRINT:
                        if (isPersonQueue) {
                            PersonQueue queue = (PersonQueue) eineQueue;
                            queue.print();
                        } else {
                            System.out.println("Print wird nur fuer PersonQueue unterstuetzt");
                        }
                        break;
                    case QUEUE_SMALLEST:
                        if (isPersonQueue) {
                            PersonQueue queue = (PersonQueue) eineQueue;
                            System.out.println(queue.smallest());
                        } else {
                            System.out.println("Smallest wird nur fuer PersonQueue unterstuetzt");
                        }
                        break;
                    default:
                        System.out.println("\n Fehler");
                        break;
                }
            } catch (RuntimeException re) {
                System.out.println("\n\nRuntimeException :" +
                        "\n\nFehlermeldung: " + re +
                        "\n\nFehlerort: "
                );
                re.printStackTrace();
            } catch (Exception e) {
                System.out.println("\n\nFehler:" +
                        "\n\nFehlermeldung: " + e +
                        "\n\nFehlerort: "
                );
                e.printStackTrace();
            }
        }

    }


    /**
     * Interaktives Menue welches Benutzer auffordert
     * als Element STRING oder PERSON zu waehlen
     */
    private int leseElementArt() {
        int was = -1;

        while ((was < STRING) | (was > PERSON)) {
            was = MyInputFunctions.readlnInt(in, "Welche Art von Element wird aufgenommen?\n" +
                    "\tein  String  (" + STRING + ")\n" +
                    "\teine Person  (" + PERSON + ")\n" +
                    "Waehle: "
            );
        }

        return was;
    }


    /**
     * Laesst Benutzer entscheiden ob String oder Objekt-Element
     * gelesen werden sollen
     */
    private Object leseElement() {
        int was;

        Object neuesObjekt = null;

        String name, vorname;

        was = leseElementArt();

        if (was == STRING) {
            neuesObjekt = new String(MyInputFunctions.readlnString(in, "\n\tGeben Sie " +
                    "einen String " +
                    " ein: "
            )
            );
        } else {
            name = MyInputFunctions.readlnString(in, "\n\tGeben Sie den Personen-Nachnamen ein: ");
            vorname = MyInputFunctions.readlnString(in, "\n\tGeben Sie den Personen-Vornamen ein: ");

            neuesObjekt = new Person(name, vorname);
        }
        return neuesObjekt;
    }

    /**
     * Dialog um dem Benutzer verschiedene Funktionen anzubieten
     */
    private int wasTun() {
        return (MyInputFunctions.readlnInt(in, "\n\tWas wollen Sie tun?\n\n" +
                "\n\tAnzeigen des aktuellen Queue-Inhalts   -> " +
                QUEUE_INHALT_ANZEIGEN +
                "\n\tElement an Queue anhaengen             -> " +
                QUEUE_ELEMENT_ANHAENGEN +
                "\n\tElement von der Queue entfernen        -> " +
                QUEUE_ELEMENT_ENTFERNEN +
                "\n\tDas i'te Element der Queue anzeigen    -> " +
                QUEUE_INDEX_ELEMENT_ANZEIGEN +
                "\n\tIst die Queue leer?                    -> " +
                QUEUE_LEER +
                "\n\tIst die Queue voll?                    -> " +
                QUEUE_VOLL +
                "\n\tAnzeigen der aktuellen Element-Anzahl  -> " +
                ZEIGE_MOMENTANE_ANZAHL +
                "\n\tBearbeitung beenden                    -> " +
                ENDE +
                "\n\tQueue printen                         -> " +
                QUEUE_PRINT +
                "\n\tKleinstes Element der Queue ausgeben  ->" +
                QUEUE_SMALLEST +
                "\n\n\tGib Aktion ein:"
        )
        );
    }


    /**
     * Das Test-Programm erzeugt ein QueueTest-Objekt
     * und ruft dessen Start-Methode auf
     */
    public static void main(String[] args) {
        QueueTest test;


        try {
            test = new QueueTest(MyInputFunctions.readlnChar(new Scanner(System.in),
                    "Waehle eine Array-Art: \n" +
                            "\tStringQueue  == " + STRING_QUEUE +
                            "\n" +
                            "\tPersonQueue == " + PERSON_QUEUE +
                            "\n" +
                            "\t Gib: "
            )
            );
            test.start();
        } catch (Exception e) {
            System.out.println("\n\nFehler:" +
                    "\n\nFehlermeldung: " + e +
                    "\n\nFehlerort: "
            );
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }
}

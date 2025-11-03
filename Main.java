import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int scelta = 0;
        int numeroDownload;                       // MODIFICA: usare int per numero di download (conteggi interi)
        Scanner s = new Scanner(System.in);

        System.out.print("Scrivi: Nome: ");
        String nome = s.nextLine();

        System.out.print("Scrivi: Sistema Operativo: ");
        String sistemaOperativo = s.nextLine();

        System.out.print("Scrivi: Prezzo: ");
        // MODIFICA: gestire possibile NumberFormatException con parse sicuro
        float prezzo = 0f;
        while (true) {
            String line = s.nextLine();
            try {
                prezzo = Float.parseFloat(line);
                break;
            } catch (NumberFormatException ex) {
                System.out.print("Prezzo non valido. Inserisci un numero (es. 1.99): ");
            }
        }

        mobileApp a1 = new mobileApp(nome, sistemaOperativo, prezzo);

        do {
         
            System.out.println("\nBenvenuto nel Play Store!");
            System.out.println(a1.getSistemaOperativo() + " (" + a1.getNome() + ")");
            System.out.println();
            System.out.println("1) Download singolo");
            System.out.println("2) Download multiplo");
            System.out.println("3) Ricevi valutazione");
            System.out.println("4) Esci");
            System.out.print("Scegli un'opzione: ");

            // leggere scelta in modo robusto
            String sceltaLine = s.nextLine();
            try {
                scelta = Integer.parseInt(sceltaLine);
            } catch (NumberFormatException ex) {
                scelta = -1; // scelta non valida
            }

            switch (scelta) {
                case 1:
                    a1.download();
                    break;
                case 2:
                    System.out.print("Inserisci il numero di Download: ");
                    // leggere come int e con controllo
                    while (true) {
                        String nd = s.nextLine();
                        try {
                            numeroDownload = Integer.parseInt(nd);
                            if (numeroDownload < 0) {
                                System.out.print("Numero non valido. Inserisci un intero positivo: ");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.print("Numero non valido. Inserisci un intero: ");
                        }
                    }
                    a1.download(numeroDownload);
                    break;
                case 3:
                    System.out.print("Inserisci il numero di stelle da assegnare da 1 a 5: ");
                    int numeroStelle;
                    while (true) {
                        String ns = s.nextLine();
                        try {
                            numeroStelle = Integer.parseInt(ns);
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.print("Valore non valido. Inserisci un intero tra 1 e 5: ");
                        }
                    }
                    a1.numeroValutazioni(numeroStelle);
                    break;
                case 4:
                    System.out.println("Arrivederci!!");
                    break;
                default:
                    System.out.println("Scelta non valida!!");
            }

            // Mostro i dati solo se non è stata scelta l'uscita
            if (scelta != 4) {
                a1.visualizzaDati();
                System.out.print("Premi Enter per continuare....");
                s.nextLine();
            }
        } while (scelta != 4);

        s.close();
    }
}
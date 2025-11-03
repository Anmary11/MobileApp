public class mobileApp {
    private String nome;
    private String sistemaOperativo;
    private float prezzo;
    private int totaleValutazioni;
    private int numeroValutazioni;
    private float ricavoTotale;

    public mobileApp(String nome, String sistemaOperativo, float prezzo) {
        super();
        this.nome = nome;                              // variabili inizializzate con this
        this.sistemaOperativo = sistemaOperativo;
        this.prezzo = prezzo;
        totaleValutazioni = 0;                 // settaggio iniziale
        numeroValutazioni = 0;
        ricavoTotale = 0;
    }

    public void download() {
        ricavoTotale += prezzo; // incremento ricavo per download singolo
    }

    //  numeroDownload è int (conteggio), non float
    public void download(int numeroDownload) {
        if (numeroDownload < 0) {
            System.out.println("Numero download non valido!");
            return;
        }
        ricavoTotale += prezzo * numeroDownload;
    }

    public void numeroValutazioni(int numeroStelle) {
        if (numeroStelle >= 1 && numeroStelle <= 5) {
            totaleValutazioni += numeroStelle;
            numeroValutazioni++;
        } else {
            System.out.println("Numero non valido!! (inserire 1-5)");
        }
    }

    //  nome metodo corretto e gestione divisione per zero
    public float valutazioneMedia() {
        if (numeroValutazioni == 0) {
            return 0f; // nessuna valutazione ancora
        }
        return (float) totaleValutazioni / (float) numeroValutazioni;
    }

    void visualizzaDati() {
        System.out.println("Il prezzo è: " + prezzo);
        System.out.println("Il ricavo totale è: " + ricavoTotale);
        // mostrare messaggio se non ci sono valutazioni
        if (numeroValutazioni == 0) {
            System.out.println("La valutazione media è: N/A (nessuna valutazione)");
        } else {
            System.out.println("La valutazione media è di: " + valutazioneMedia());
        }
    }

    public String getNome() {
        return nome;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
}
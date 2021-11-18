
enum Farbe{
        KREUZ,
        PICK,
        HERZ,
        KARO
    }
enum Wert {
        SIEBEN,
        ACHT,
        NEUN,
        ZEHN,
        BUBE,
        DAME,
        KOENIG,
        ASS
    }
record Karte(Farbe farbe, Wert wert) {
        public String toString(){
            return farbe.toString()+wert.toString();
        }
        static Karte neueKarte(Farbe f, Wert w) {
            Karte k = new Karte(f, w);
            return k;
        }
        static Karte neueKarte(String f, String w){
            Karte k = new Karte(Farbe.valueOf(f), Wert.valueOf(w));
            return k;
        }
        static int Kombinationen(){
            return Farbe.values().length * Wert.values().length;
        }
        static Karte[] skatblatt(){
            Karte[] k = new Karte[Kombinationen()];
            int i = 0;
            for( Farbe f : Farbe.values()){
                for( Wert w : Wert.values()){
                    k[i] = new Karte(f,w);
                    i++;
                }
            }
            return k;
        }
        boolean bedient(Karte other){
            if((this.wert == other.wert ^ this.farbe == other.farbe) || this.wert == Wert.BUBE) {
                return true;
            }
            else{
                return false;
            }
        }
        boolean bedienbar(Karte[] kn){
            for( Karte k : kn){
                if(k.bedient(this)){
                    return true;
                }
            }
            return false;
        }

        void druckeDoppelBedienungen(){
            for(Karte k : skatblatt()){
                for(Karte l : skatblatt()){
                    if(k.bedient(l) && l.bedient(k)){
                        System.out.println(k.toString() + " bedient " + l.toString() + " und " + l.toString() + " bedient " + k.toString());
                    }
                }
            }
        }

      }

class Spieler{
    Karte[] kartenhand;
    public String name;
    Karte gespielteKarte;

    public static void main(String[] args){
            Spieler Klaus = new Spieler();
            Spieler Elisabeth = new Spieler();
            Klaus.name = "Klaus";
            Elisabeth.name = "Elisabeth";

            Elisabeth.kartenhand = new Karte[]{new Karte(Farbe.HERZ,Wert.NEUN), new Karte(Farbe.HERZ,Wert.ZEHN), new Karte(Farbe.PICK,Wert.BUBE)};
            Klaus.kartenhand = new Karte[]{new Karte(Farbe.HERZ,Wert.ZEHN), new Karte(Farbe.PICK,Wert.BUBE), new Karte(Farbe.HERZ,Wert.NEUN)};

            Karte anfangsKarte = new Karte(Farbe.KARO, Wert.ZEHN);
            Elisabeth.spiele(anfangsKarte);
            Klaus.spiele(anfangsKarte);

        }

    void spiele(Karte k){
        spieleKarte(k);
        while(gespielteKarte != null){

            spieleKarte(gespielteKarte);
        }
        if(kartenhand.length == 0){
            System.out.println(this.name + " hat gewonnen!");
        }
        else{
            System.out.println(this.name + " hat verloren!");
        }
    }

    public String toString(){
            return name;
        }
    void spieleKarte(Karte k){
            if(k.bedienbar(kartenhand)){
                int index = 0;
                forLoop:
                for(Karte l : kartenhand){

                    if(l.bedient(k)){
                        gespielteKarte = l;

                        Karte[] copy = new Karte[kartenhand.length - 1];

                        for (int i = 0, j = 0; i < kartenhand.length; i++) {
                            if (i != index) {
                                copy[j++] = kartenhand[i];
                            }
                        }
                        kartenhand = copy;
                        System.out.println(this.toString() + " bedient " + k.toString() + " mit " + l.toString());
                        break forLoop;

                    }
                index++;
                }

            }
            else{
                gespielteKarte = null;
            }


        }
      }



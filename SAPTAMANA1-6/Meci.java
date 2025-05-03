class Jucator{
    private String nume;
    private int numar;
    public Jucator(String nume,int numar){
        this.nume=nume;
        this.numar=numar;
    }
    public int getNumar(){
        return this.numar;
    }
    public String getNume(){
        return this.nume;
    }
    public String toString(){
        String rezultat="<"+this.nume+","+this.numar+"> ";
        return rezultat;
    }
}
class Echipa{
    private Jucator[] titulari;
    private Jucator[] rezerve;
    private int numarTitulari;
    private int numarRezerve;
    public Echipa(Jucator[] titulari1,Jucator[] rezerve1){
        this.numarTitulari=titulari1.length;
        this.numarRezerve=rezerve1.length;
        this.titulari=new Jucator[this.numarTitulari];
        this.rezerve=new Jucator[this.numarRezerve];
        int i=0;
        for(i=0;i<this.numarTitulari;i++){
            this.titulari[i]=titulari1[i];
        }
        for(i=0;i<this.numarRezerve;i++){
            this.rezerve[i]=rezerve1[i];
        }
    }
    public boolean efectueazaSchimbare(Jucator titular1,Jucator rezerva1){
        int i=0;
        Jucator aux=null;
        int ok1=0;
        int ok2=0;
        int poz1=-1;
        int poz2=-1;
        for(i=0;i<this.numarTitulari;i++){
            if(titular1.equals(this.titulari[i])){
                ok1=1;
                poz1=i;
            }
        }
        for(i=0;i<this.numarRezerve;i++){
            if(rezerva1.equals(this.rezerve[i])){
                ok2=1;
                poz2=i;
            }
        }
        if(ok1==1&&ok2==1){
            aux=this.titulari[poz1];
            this.titulari[poz1]=this.rezerve[poz2];
            this.rezerve[poz2]=aux;
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat="Titulari: ";
        int i=0;
        for(i=0;i<this.numarTitulari;i++){
            rezultat=rezultat+this.titulari[i].toString();
        }
        rezultat=rezultat+"Rezerve: ";
        for(i=0;i<this.numarRezerve;i++){
            rezultat=rezultat+this.rezerve[i].toString();
        }
        return rezultat;
    }
}
class Ex{
    public static void main(String[] args) {
        Jucator jucator1=new Jucator("Artur",7);
        Jucator jucator2=new Jucator("Alex",10);
        Jucator jucator3=new Jucator("Cos",6);
        Jucator jucator4=new Jucator("Tobi",1);
        Jucator[] titulari={jucator1,jucator2,jucator3};
        Jucator[] rezerve={jucator4};
        Echipa echipa1=new Echipa(titulari,rezerve);
        System.out.println(echipa1.toString());
        echipa1.efectueazaSchimbare(jucator1, jucator4);
        System.out.println(echipa1.toString());
    }
}
class Jucator{
    private String nume;
    private int numar;
    public Jucator(String nume,int numar){
        this.nume=nume;
        this.numar=numar;
    }
    public String getNume(){
        return this.nume;
    }
    public int getNumar(){
        return this.numar;
    }
    public String toString(){
        String rezultat="< "+this.nume+","+this.numar+" > ";
        return rezultat;
    }
}
class Echipa{
    private Jucator[] titulari;
    private Jucator[] rezerve;
    private int numarTitulari;
    private int numarRezerve;
    public Echipa(int numarTitulari,int numarRezerve,Jucator[] titulari1,Jucator[] rezerve1){
        this.numarTitulari=numarTitulari;
        this.numarRezerve=numarRezerve;
        this.titulari=new Jucator[numarTitulari];
        this.rezerve=new Jucator[numarRezerve];
        int i=0;
        for(i=0;i<this.numarTitulari;i++){
            this.titulari[i]=titulari1[i];
        }
        for(i=0;i<this.numarRezerve;i++){
            this.rezerve[i]=rezerve1[i];
        }
    }
    public boolean efectueazaSchimbare(Jucator titular1,Jucator rezerva1){
        int ok1=0;
        int ok2=0;
        int poz1=-1;
        int poz2=-1;
        int i=0;
        Jucator aux=null;
        for(i=0;i<this.numarTitulari;i++){
            if(titular1.equals(titulari[i])){
                ok1=1;
                poz1=i;
            }
        }
        for(i=0;i<this.numarRezerve;i++){
            if(rezerva1.equals(rezerve[i])){
                ok2=1;
                poz2=i;
            }
        }
        if(ok1==1&&ok2==1){
            aux=titulari[poz1];
            titulari[poz1]=rezerve[poz2];
            rezerve[poz2]=aux;
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat="Echipa: "+"Titulari: ";
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
    public static void main(String[] args){
        Jucator j1=new Jucator("Artur",10);
        Jucator j2=new Jucator("Alex",7);
        Jucator j3=new Jucator("Mirela",1);
        Jucator j4=new Jucator("Tobi",5);
        Jucator[] titulari={j1,j2,j3};
        Jucator[] rezerve={j4};
        Echipa echipa1=new Echipa(3,1,titulari,rezerve);
        echipa1.efectueazaSchimbare(j3, j4);
        System.out.println(echipa1.toString());
    }
}
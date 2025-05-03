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
}
class Echipa{
    private Jucator[] titulari;
    private Jucator[] rezerve;
    private int numarTitulari;
    private int numarRezerve;
    public Echipa(){
        this.numarRezerve=0;
        this.numarTitulari=0;
        titulari=new Jucator[11];
        rezerve=new Jucator[5];
    }
    public boolean adaugaTitular(Jucator j1){
        this.titulari[numarTitulari]=j1;    
        this.numarTitulari++;
        return true;
    }
    public boolean adaugaRezerva(Jucator j1){
        this.rezerve[numarRezerve]=j1;    
        this.numarRezerve++;
        return true;
    }
    public boolean efectueazaSchimbare(Jucator titular1,Jucator rezerva1){
        int ok1=0;
        int ok2=0;
        int poz1=0;
        int poz2=0;
        Jucator aux1=null;
        Jucator aux2=null;
        int i=0;
        for(i=0;i<numarTitulari;i++)
        {   
            String numeAux=this.titulari[i].getNume();
            int numarAux=this.titulari[i].getNumar();
            if(titular1.getNumar()==numarAux&&titular1.getNume().equals(numeAux)){
                ok1=1;
                poz1=i;
                aux1=this.titulari[i];
            }
        }
        for(i=0;i<numarRezerve;i++)
        {   
            String numeAux=this.rezerve[i].getNume();
            int numarAux=this.rezerve[i].getNumar();
            if(rezerva1.getNumar()==numarAux&&rezerva1.getNume().equals(numeAux)){
                ok2=1;
                poz2=i;
                aux2=this.rezerve[i];
            }
        }
        if(ok1==1&&ok2==1){
            this.titulari[poz1]=rezerva1;
            this.rezerve[poz2]=titular1;
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat="Ti"+": ";
        int i=0;
        for(i=0;i<numarTitulari;i++){
            rezultat=rezultat+"<"+this.titulari[i].getNume()+" "+this.titulari[i].getNumar()+"> ";
        }
        rezultat=rezultat+"Rz"+": ";
        for(i=0;i<numarRezerve;i++){
            rezultat=rezultat+"<"+this.rezerve[i].getNume()+" "+this.rezerve[i].getNumar()+"> ";
        }
        return rezultat;
    }
}
class Ex{
    public static void main(String[] args) {
        Jucator j1=new Jucator("Artur",7);
        Jucator j2=new Jucator("Tobi",9);
        Jucator j3=new Jucator("Alex",10);
        Jucator j4=new Jucator("Mirela",1);
        Echipa e1=new Echipa();
        e1.adaugaTitular(j1);
        e1.adaugaTitular(j2);
        e1.adaugaTitular(j3);
        e1.adaugaRezerva(j4);
        System.out.println(e1.toString());
        e1.efectueazaSchimbare(j1, j4);
        System.out.println(e1.toString());
    }
}
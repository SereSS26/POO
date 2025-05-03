class Angajat{
    private String nume;
    private int salariu;
    public Angajat(String nume,int salariu){
        this.nume=nume;
        this.salariu=salariu;
    }
    public String getNume(){
        return this.nume;
    }
    public int getSalariu(){
        return this.salariu;
    }
    public String toString(){
        String rezultat="Angajat "+"<"+this.nume+">-<"+this.salariu+"> ";
        return rezultat;
    }
}
class Firma{
    private String nume;
    private int buget;
    private int contor;
    private Angajat[] angajati;
    public Firma(String nume,int buget){
        this.nume=nume;
        this.buget=buget;
        this.contor=0;
        this.angajati=new Angajat[30];
    }
    public boolean adaugaAngajat(Angajat angajat1){
        int ok=0;
        int i=0;
        if(this.contor>=30){
            ok=1;
            return false;
        }
        for(i=0;i<this.contor;i++){
            if(angajat1.equals(this.angajati[i])){
                ok=1;
            }
        }
        if(ok==0){
            this.angajati[this.contor]=angajat1;
            this.contor++;
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat=this.nume+": ";
        int i=0;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+this.angajati[i].toString();
        }
        return rezultat;
    }
    public int platesteSalarii(){
        int bugetRamas=this.buget;
        int i=0;
        for(i=0;i<this.contor;i++){
            bugetRamas=bugetRamas-this.angajati[i].getSalariu();
        }
        return bugetRamas;
    }
}
class Ex{
    public static void main(String[] args){
        Angajat angajat1=new Angajat("Artur",1000);
        Angajat angajat2=new Angajat("Alex",2000);
        Angajat angajat3=new Angajat("Cosmin",3000);
        Firma firma1=new Firma("La babanu",5000);
        firma1.adaugaAngajat(angajat1);
        firma1.adaugaAngajat(angajat2);
        firma1.adaugaAngajat(angajat3);
        firma1.adaugaAngajat(angajat1);
        System.out.println(firma1.toString());
        System.out.println(firma1.platesteSalarii());
    }
}
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
}
class Firma{
    private String nume;
    private int buget;
    private Angajat[] angajati;
    private int numarAngajati;
    public Firma(String nume,int buget){
        this.nume=nume;
        this.buget=buget;
        this.angajati=new Angajat[30];
        this.numarAngajati=0;
    }
    public boolean adaugaAngajat(Angajat angajat1){
        int i=0;
        int ok=0;
        for(i=0;i<this.numarAngajati;i++){
            if(this.angajati[i].equals(angajat1))
                ok=1;
        }
        if(ok==0&&numarAngajati<30){
            this.angajati[numarAngajati]=angajat1;
            this.numarAngajati++;
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat="Firma:"+this.nume+" "+this.buget+" ";
        int i=0;
        for(i=0;i<this.numarAngajati;i++){
            rezultat=rezultat+"Angajat"+(i+1)+" <"+this.angajati[i].getNume()+" "+this.angajati[i].getSalariu()+"> ";
        }
        return rezultat;
    }
    public int platesteSalarii(){
        int rezultat=this.buget;
        int i=0;
        for(i=0;i<this.numarAngajati;i++){
            rezultat=rezultat-this.angajati[i].getSalariu();
        }
        return rezultat;
    }
}
class Ex{
    public static void main(String[] args){
        Angajat angajat1=new Angajat("Artur", 0);
        Angajat angajat2=new Angajat("Mirela", 8000);
        Angajat angajat3=new Angajat("Alex",10);
        Angajat angajat4=new Angajat("Tobi", 20);
        Firma firma1=new Firma("La babanu",3000);
        firma1.adaugaAngajat(angajat1);
        firma1.adaugaAngajat(angajat2);
        firma1.adaugaAngajat(angajat3);
        firma1.adaugaAngajat(angajat4);
        firma1.adaugaAngajat(angajat1);
        System.out.println(firma1.toString());
        System.out.println(firma1.platesteSalarii());
    }
}
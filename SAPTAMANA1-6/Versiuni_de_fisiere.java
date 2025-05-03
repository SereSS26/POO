class Fisier{
    private String nume;
    private int id;
    private static int contor=0;
    private String continut;
    private Fisier anterior;
    private int numarConcatenari;

    public Fisier(String nume,String continut){ 
        this.nume=nume;
        this.continut=continut;
        contor++;
        this.id=contor;
    }
    public Fisier salveazaVerisune(Fisier fisier1){
        String nume2;
        String continut2;
        nume2=fisier1.nume+".bak";
        continut2=fisier1.continut;
        fisier1.anterior=this;
        return new Fisier(nume2,continut2);
    }
    public void concateneaza(Fisier fisier1){
        this.anterior=this.salveazaVerisune(this);
        this.continut=this.continut+fisier1.continut;
        this.numarConcatenari++;
    }
    public int getNumarConcatenari(){
        return this.numarConcatenari;
    }
    public String getNume(){
        return this.nume;
    }
    public String getContinut(){
        return this.continut;
    }
    public String toString(){
        String rezultat=id+" "+this.getNume()+" ["+this.getContinut()+"] ";
        if(this.anterior!=null){
            rezultat=rezultat+"<"+this.anterior.toString()+">";
        }
        return rezultat;
    }
}
class Ex{
    public static void main(String[] args) {
        Fisier fisier1=new Fisier("fisier1","Ana are mere");
        Fisier fisier2=new Fisier("fisier2"," si pere");
        fisier1.salveazaVerisune(fisier1);
        fisier1.concateneaza(fisier2);
        int concatenari=fisier1.getNumarConcatenari();
        System.out.println(concatenari);
        System.out.println(fisier1.toString());
        System.out.println(fisier2.toString());
    }
}
abstract class Greutate{
    public Greutate(){

    }
    abstract public double capacitate();
}
class GreutateSimpla extends Greutate{
    private double greutate;
    public GreutateSimpla(double greutate){
        this.greutate=greutate;
    }
    public double capacitate(){
        return this.greutate;
    }
}
class GreutateDubla extends Greutate{
    private double greutateDreapta;
    private double greutateStanga;
    public GreutateDubla(double greuateDreapta,double greutateStanga){
        this.greutateDreapta=greuateDreapta;
        this.greutateStanga=greutateStanga;
    }
    public void greutateDreaptaModifica(double greuateDreapta){
        this.greutateDreapta=greuateDreapta;
    }
    public void greutateStangaModifica(double greutateStanga){
        this.greutateStanga=greutateStanga;
    }
    public double capacitate(){
        return this.greutateDreapta+this.greutateStanga;
    }
}
class GreutateMultipla extends Greutate{
    private Greutate[] greutati;
    private int numarGreutati;
    public GreutateMultipla(Greutate[] greutati1){
        this.greutati=greutati1;
        this.numarGreutati=greutati1.length;
    }
    public void adaugaGreutate(Greutate greutate1){
        this.greutati[this.numarGreutati]=greutate1;
        this.numarGreutati++;
    }
    public double capacitate(){
        int i=0;
        double total=0;
        for(i=0;i<this.numarGreutati;i++){
            total=total+this.greutati[i].capacitate();
        }
        return total;
    }
}
class ColectieGreutati{
    private Greutate[] greutati;
    private int numarGreutati;
    private int maximGreutati;
    public ColectieGreutati(int maximGreutati){
        this.maximGreutati=maximGreutati;
        this.greutati=new Greutate[maximGreutati];
        this.numarGreutati=0;
    }
    public void adauga(Greutate g){
        if(this.numarGreutati<this.maximGreutati){
            this.greutati[this.numarGreutati]=g;
            this.numarGreutati++;
        }
    }
    public double medie(){
        double media=0;
        double numarElemente=this.numarGreutati;
        int i=0;
        for(i=0;i<this.numarGreutati;i++){
            media=media+this.greutati[i].capacitate();
        }
        return media/numarElemente;
    }
}
class Ex5{
    public static void main(String[] args){
        ColectieGreutati greutati1=new ColectieGreutati(3);
        Greutate greutate1=new GreutateSimpla(9.5);
        Greutate greutate2=new GreutateDubla(10, 10);
        Greutate[] greutati3={greutate1,greutate2};
        Greutate greutate3=new GreutateMultipla(greutati3);
        greutati1.adauga(greutate1);
        greutati1.adauga(greutate2);
        greutati1.adauga(greutate3);
        System.out.println(greutati1.medie());
    } 
}
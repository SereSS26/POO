class Remorca{
    private int cutii=0;
    private String numarInmatriculare;
    private static int antterior=9;
    public Remorca(int cutii,String numarInmatriculare){
        this.cutii=cutii;
        this.numarInmatriculare=numarInmatriculare;
        antterior=cutii;
    }
    public Remorca(String numarInmatriculare){
        this.numarInmatriculare=numarInmatriculare;
        this.cutii=antterior+1;
        antterior=this.cutii;
    }
    public int getCutii(){
        return this.cutii;
    }
    public String getNumar(){
        return this.numarInmatriculare;
    }
    public String toString(){
        String rezultat="R("+this.numarInmatriculare+" "+this.cutii+") ";
        return rezultat;
    }
}
class Tir{
    private Remorca[] remorci;
    private int index=0;
    private int cutii=0;
    public Tir(){
        this.remorci=new Remorca[5];
        this.index=0;
        this.cutii=0;
    }
    public boolean adaugaRemorca(int cutii,String numarInmatriculare){
        if(index==5){
            return false;
        }
        else{
            Remorca remorca1=new Remorca(cutii,numarInmatriculare);
            this.remorci[index]=remorca1;
            this.index++;
            this.cutii=cutii+this.cutii;
            return true;
        }
    }
    public boolean adaugaRemorca(Remorca remorca1){
        if(index==5){
            return false;
        }
        else{   
            this.remorci[index]=remorca1;
            this.index++;
            this.cutii=cutii+this.cutii;
            return true;
        }
    }
    public Remorca stergeRemorca(String numarInmatriculare){
        int i=0;
        int j=0;
        Remorca aux;
        for(i=0;i<this.index;i++){
            if(numarInmatriculare.equals(this.remorci[i].getNumar())){
                aux=this.remorci[i];
                for(j=i;j<this.index-1;j++){
                    this.remorci[j]=this.remorci[j+1];
                }
                this.index--;
                this.cutii=this.cutii-aux.getCutii();
                return aux;
            }
        }
        return null;
    }
    public String toString(){
        String rezultat="T->";
        int i=0;
        for(i=0;i<this.index-1;i++){
            rezultat=rezultat+remorci[i].toString()+"->";
        }
        rezultat=rezultat+remorci[this.index-1].toString();
        return rezultat;
    }
}
class Ex{
    public static void main(String[] args) {
        Tir tir1=new Tir();
        Tir tir2=new Tir();
        Remorca remorca1=new Remorca("AR02HFD");
        tir1.adaugaRemorca(3,"CS03ABC");
        tir1.adaugaRemorca(4,"TM04GGG");
        tir1.adaugaRemorca(remorca1);
        tir2.adaugaRemorca(remorca1);
        tir2.adaugaRemorca(9,"CS23TRE");
        System.out.println(tir1);
        System.out.println(tir2);
        tir1.stergeRemorca("TM04GGG");
        System.out.println(tir1);
        tir1.stergeRemorca("AR04GGG");
        System.out.println(tir1);
    }
}
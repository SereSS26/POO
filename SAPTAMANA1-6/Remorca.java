class Remorca{
    private String numar;
    private int cantitateCutii;
    private int anterior=9;
    public Remorca(String numar,int cantitateCutii){
        this.numar=numar;
        this.cantitateCutii=cantitateCutii;
        this.anterior=this.cantitateCutii;
    }
    public Remorca(String numar){
        this.numar=numar;
        this.cantitateCutii=this.anterior+1;
        this.anterior=this.cantitateCutii;
    }
    public String getNumar(){
        return this.numar;
    }
    public int getCutii(){
        return this.cantitateCutii;
    }
    public String toString(){
        String rezultat;
        rezultat="<"+this.numar+","+this.cantitateCutii+"> ";
        return rezultat;
    }
}
class Tir{
    private Remorca[] remorci;
    private int contor;
    public Tir(){
        this.remorci=new Remorca[5];
        this.contor=0;
    }
    public boolean adaugaRemorca(String numar1,int cantiateCutii1){
        int i=0;
        int ok=0;
        if(this.contor>=5){
            return false;
        }
        else{
            this.remorci[this.contor]=new Remorca(numar1,cantiateCutii1);
            this.contor++;
            return true;
        }
    }
    public boolean adaugaRemorca(Remorca remorca1){
        int i=0;
        int ok=0;
        if(this.contor>=5){
            return false;
        }
        else{
            this.remorci[this.contor]=remorca1;
            this.contor++;
            return true;
        }
    }
    public Remorca stergeRemorca(String numar1){
        int i=0;
        int ok=0;
        int poz=-1;
        Remorca aux=null;
        for(i=0;i<this.contor;i++){
            if(numar1.equals(this.remorci[i].getNumar())){
                ok=1;
                poz=i;
            }
        }
        if(ok==1){
            aux=this.remorci[poz];
            for(i=poz;i<this.contor-1;i++){
                this.remorci[i]=this.remorci[i+1];
            }
            this.contor--;
            return aux;
        }
        else{
            return aux;
        }
    }
    public int getCantitate(){
        int cantiate=0;
        int i=0;
        for(i=0;i<this.contor;i++){
            cantiate=cantiate+this.remorci[i].getCutii();
        }
        return cantiate;
    }
    public boolean compara(Tir tir1){
        if(this.getCantitate()==(tir1.getCantitate())){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat="Tir:";
        int i=0;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+this.remorci[i].toString();
        }
        return rezultat;
    }
}
class Ex{
    public static void main(String[] args) {
        Remorca remorca1=new Remorca("1",1);
        Remorca remorca2=new Remorca("2",2);
        Remorca remorca3=new Remorca("3",3);
        Remorca remorca4=new Remorca("4");
        Tir tir1=new Tir();
        Tir tir2=new Tir();
        tir1.adaugaRemorca(remorca1);
        tir1.adaugaRemorca(remorca2);
        tir1.adaugaRemorca(remorca3);
        tir2.adaugaRemorca(remorca2);
        tir2.adaugaRemorca(remorca3);
        System.out.println(tir1.toString());
        tir1.stergeRemorca("1");
        System.out.println(tir1.toString());
        System.out.println(tir1.compara(tir2));
    }
}
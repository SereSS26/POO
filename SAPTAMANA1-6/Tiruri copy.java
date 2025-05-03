class Remorca{
    private String numar;
    private int numarCutii;
    private int anteriorNumarCutii=9;
    public Remorca(String numar,int numarCutii){
        this.numar=numar;
        this.numarCutii=numarCutii;
        this.anteriorNumarCutii=numarCutii;
    }
    public Remorca(String numar){
        this.numar=numar;
        this.numarCutii=this.anteriorNumarCutii+1;
        this.anteriorNumarCutii=this.numarCutii;
    }
    public String getNumar(){
        return this.numar;
    }
    public int getNumarCutii(){
        return this.numarCutii;
    }
}
class Tir{
    private Remorca[] remorci;
    private int contor;
    public Tir(){
        this.remorci=new Remorca[5];
        this.contor=0;
    }
    public boolean adaugaRemorca(String numar,int numarCutii){
        int ok=0;
        int i=0;
        if(this.contor>=5){
            ok=1;
        }
        if(ok==0){
            this.remorci[this.contor]=new Remorca(numar,numarCutii);
            this.contor++;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean adaugaRemorca(Remorca remorca1){
        int ok=0;
        int i=0;
        if(this.contor>=5){
            ok=1;
        }
        if(ok==0){
            this.remorci[this.contor]=remorca1;
            this.contor++;
            return true;
        }
        else{
            return false;
        }
    }
    public Remorca stergRemorca(String numar1){
        int i=0;
        int j=0;
        Remorca aux=null;
        for(i=0;i<this.contor;i++){
            if(numar1.equals(this.remorci[i].getNumar())){
                aux=this.remorci[i];
                for(j=i;j<this.contor-1;j++){
                    this.remorci[j]=this.remorci[j+1];
                }
                this.contor--;
            }
        }
        return aux;
    }
    public int getCantitate(){
        int i=0;
        int cantitate=0;
        for(i=0;i<this.contor;i++){
            cantitate=cantitate+this.remorci[i].getNumarCutii();
        }
        return cantitate;
    }
    public boolean egalTir(Tir tir1){
        if(this.getCantitate()==tir1.getCantitate()){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        String rezultat="Tir: ";
        int i=0;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+"R("+this.remorci[i].getNumar()+","+this.remorci[i].getNumarCutii()+") ";
        }
        return rezultat;
    }
}

class Ex{
    public static void main(String[] args) {
        Tir tir1=new Tir();
        Tir tir2=new Tir();
        tir1.adaugaRemorca("1",1);
        tir1.adaugaRemorca("2",2);
        tir1.adaugaRemorca("3",3);
        tir2.adaugaRemorca("1",1);
        tir2.adaugaRemorca("2",2);
        tir2.adaugaRemorca("3",3);
        System.out.println(tir1.toString());
        System.out.println(tir1.egalTir(tir2));
        tir1.stergRemorca("1");
        System.out.println(tir1.toString());
    }
}
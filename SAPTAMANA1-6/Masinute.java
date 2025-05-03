class Masina{
    private String numar;
    private int capacitate;
    public Masina(String numar,int capacitate){
        this.numar=numar;
        this.capacitate=capacitate;
    }
    public String getNumar(){
        return this.numar;
    }
    public int getCapacitate(){
        return this.capacitate;
    }
}
class Benzinarie{
    private int capacitate;
    private Masina[] masini;
    private int contor;
    public Benzinarie(int capcitate){
        this.capacitate=capacitate;
        this.masini=new Masina[10];
        this.contor=0;
    }
    public boolean alimenteazaMasina(Masina masina1){
        if(this.capacitate>=masina1.getCapacitate()){
            this.capacitate=this.capacitate-masina1.getCapacitate();
            return true;
        }
        else{
            if(this.contor<10){
                this.masini[this.contor]=masina1;
                this.contor++;
                return true;
            }
            else{
                return false;
            }
        }
    }
    public String toString(){
        String rezultat="Benzinarie:"+this.capacitate+": ";
        int i=0;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+"Masina"+(i+1)+" <"+this.masini[i].getNumar()+" "+this.masini[i].getCapacitate()+" > ";
        }
        return rezultat;
    }
    public void alimenteazaBenzinarie(int cantitate){
        this.capacitate=this.capacitate+cantitate;
        int i=0;
        int ok=0;
        do { 
            ok=0;
            if(this.capacitate>=this.masini[0].getCapacitate()&&this.contor>0){
                ok=1;
                this.capacitate=this.capacitate-this.masini[0].getCapacitate();
                for(i=0;i<this.contor-1;i++){
                    this.masini[i]=this.masini[i+1];
                }
                this.contor--;
            }
        } while(ok==1);
    }
    public int getCapacitate(){
        return this.capacitate;
    }
}
class Ex{
    public static void main(String[] args) {
        Benzinarie benzinarie1=new Benzinarie(0);
        Masina masina1=new Masina("CS06RVM",5);
        Masina masina2=new Masina("CS30AXA",10);
        Masina masina3=new Masina("CS22HWV",15);
        int combustibil=10;
        benzinarie1.alimenteazaMasina(masina1);
        benzinarie1.alimenteazaMasina(masina2);
        benzinarie1.alimenteazaMasina(masina3);
        System.out.println(benzinarie1.toString());
        benzinarie1.alimenteazaBenzinarie(combustibil);
        System.out.println(benzinarie1.getCapacitate());
        System.out.println(benzinarie1.toString());
    }
}
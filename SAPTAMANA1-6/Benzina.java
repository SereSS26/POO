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
    public String toString(){
        String rezultat="<"+this.numar+"-"+this.capacitate+"> ";
        return rezultat;
    }
}
class Benzinarie{
    private int capacitate;
    private Masina[] masini;
    private int contor;
    public Benzinarie(int capacitate){
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
        String rezultat="Coada benzinarie: ";
        int i=0;
        for(i=0;i<this.contor;i++){
            rezultat=rezultat+this.masini[i].toString()+(i+1)+" ";
        }
        return rezultat;
    }
    public void alimenteazaBenzinarie(int cantitate){
        this.capacitate=this.capacitate+cantitate;
        int i=0;
        while(this.capacitate>=this.masini[0].getCapacitate()&&this.contor!=0){
            this.capacitate=this.capacitate-masini[0].getCapacitate();
            for(i=0;i<this.contor-1;i++){
                this.masini[i]=this.masini[i+1];
            }
            this.contor--;
        }
    }
}
class Ex{
    public static void main(String[] args) {
        Benzinarie benzinarie1=new Benzinarie(0);
        Masina masina1=new Masina("1",5);
        Masina masina2=new Masina("2",10);
        Masina masina3=new Masina("3",15);
        benzinarie1.alimenteazaMasina(masina1);
        benzinarie1.alimenteazaMasina(masina2);
        benzinarie1.alimenteazaMasina(masina3);
        System.out.println(benzinarie1.toString());
        benzinarie1.alimenteazaBenzinarie(10);
        System.out.println(benzinarie1.toString());
    }
}
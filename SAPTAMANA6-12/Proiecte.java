class Membru{
    private String nume;
    private int varsta;
    public Membru(String nume,int varsta){
        this.nume=nume;
        this.varsta=varsta;
    }
    public String getNume(){
        return this.nume;
    }
    public int getVarsta(){
        return this.varsta;
    }
    public String toString(){
        String rezultat="<"+this.nume+","+this.varsta+"> ";
        return rezultat;
    }
}
interface Risky{
    public double getRisk();
}
abstract class Project implements Risky{
    private String titlu;
    private String obiectiv;
    private long fonduri;
    private Membru manager;
    private Membru[] programatori;
    public Project(String titlu,String obiectiv,long fonduri,Membru manager,int numarMaximMembrii){
        this.titlu=titlu;
        this.obiectiv=obiectiv;
        this.fonduri=fonduri;
        this.manager=manager;
        this.programatori=new Membru[numarMaximMembrii];
    }
    public abstract void addMember(Membru m);
    public long getFonduri(){
        return this.fonduri;
    }
    public String getTitlu(){
        return this.titlu;
    }
    public Membru[] getProgramatori(){
        return this.programatori;
    }
}
class Comercial extends Project{
    private String deadline;
    private long fonduriMarketing;
    private int numarEchipe;
    private int numarMembri;
    public Comercial(String titlu,String obiectiv,long fonduri,Membru manager,String deadline,int numarEchipe){
        super(titlu,obiectiv,fonduri,manager,15);
        this.deadline=deadline;
        this.fonduriMarketing=fonduri/2;
        this.numarEchipe=numarEchipe;
        this.numarMembri=0;
    }
    public void addMember(Membru m){
        if(this.numarMembri<15){
            this.getProgramatori()[this.numarMembri]=m;
            this.numarMembri++;
        }
    }
    public double getRisk(){
        return this.numarEchipe*3/this.numarMembri/(this.getFonduri()-this.fonduriMarketing);
    }
}
class Militar extends Project{
    private String deadline;
    private String parola;
    private int numarMembri;
    public Militar(String titlu,String obiectiv,long fonduri,Membru manager,String deadline,String parola){
        super(titlu, obiectiv, fonduri, manager, 15);
        this.deadline=deadline;
        this.parola=parola;
        this.numarMembri=0;
    }
    public void addMember(Membru m){
        if(this.numarMembri<15){
            this.getProgramatori()[this.numarMembri]=m;
            this.numarMembri++;
        }
    }
    public double getRisk(){
        return this.numarMembri/this.parola.length()/this.getFonduri();
    }
}
class OpenSource extends Project{
    private String mailingList;
    private int numarMembri;
    public OpenSource(String titlu,String obiectiv,long fonduri,Membru manager,String maillingList){
        super(titlu, obiectiv, fonduri, manager, 100000);
        this.mailingList=maillingList;
        this.numarMembri=0;
    }
    public void addMember(Membru m){
        this.getProgramatori()[this.numarMembri]=m;
        this.numarMembri++;
    }
    public double getRisk(){
        return this.numarMembri/this.getFonduri();
    }
}
class InvestmentCompany{
    private Project[] proiecte;
    private int numarProiecte;
    public InvestmentCompany(int numarMaximProiecte){
        this.proiecte=new Project[numarMaximProiecte];
        this.numarProiecte=0;
    }
    public void addProject(Project p){
        if(this.numarProiecte<this.proiecte.length){
            this.proiecte[this.numarProiecte]=p;
            this.numarProiecte++;
        } 
    }
    public Project getBestInvestment(){
        Project proiectJmecher=this.proiecte[0];
        double riskJmecher=this.proiecte[0].getRisk();
        int i=0;
        for(i=0;i<this.numarProiecte;i++){
            if(this.proiecte[i].getRisk()<riskJmecher){
                riskJmecher=this.proiecte[i].getRisk();
                proiectJmecher=this.proiecte[i];
            }
        }
        return proiectJmecher;
    }

    public static void main(String[] args) {
        Membru manager1=new Membru("Manager1",30);
        Membru manager2=new Membru("Manager2",31);
        Membru manager3=new Membru("Manager3",32);

        Membru programator1=new Membru("Programtor1", 18);
        Membru programator2=new Membru("Programtor2", 18);
        Membru programator3=new Membru("Programtor3", 19);
        Membru programator4=new Membru("Programtor4", 20);
        Membru programator5=new Membru("Programtor5", 21);
        Membru programator6=new Membru("Programtor6", 22);

        Comercial proiect1=new Comercial("Proiect1","Obiectiv1",1000000,manager1,"22.11.2024",3);
        proiect1.addMember(programator1);
        proiect1.addMember(programator2);
        proiect1.addMember(programator3);
        proiect1.addMember(programator4);

        Militar proiect2=new Militar("Proiect-Putin2025", "Denazificarea Ucrainei", 999999999, manager3, "01.01.2026", "PutinBossuTataNostru");
        proiect2.addMember(programator1);
        proiect2.addMember(programator2);
        proiect2.addMember(programator3);
        proiect2.addMember(programator4);
        proiect2.addMember(manager1);
        proiect2.addMember(manager2);
        proiect2.addMember(programator5);

        OpenSource proiect3=new OpenSource("Proiect3", "Obiectiv3", 20, manager2, "manager3@student.upt.ro");
        proiect3.addMember(programator1);
        proiect3.addMember(programator2);
        proiect3.addMember(programator3);
        proiect3.addMember(programator4);

        InvestmentCompany companie1=new InvestmentCompany(3);
        companie1.addProject(proiect1);
        companie1.addProject(proiect2);
        companie1.addProject(proiect3);
        Project celMaiJmecherProiect=companie1.getBestInvestment();
        System.out.println(celMaiJmecherProiect.getTitlu());
    }
}
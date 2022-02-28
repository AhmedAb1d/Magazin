class Date
{
    int jour;
    String mois;
    int annee;
}

public class produit
{
    int id;
    String libelle;
    String marque;
    Float prix; 
    Date d= new Date();
    public produit(int id,String libelle,String marque,float prix,int jour,String mois,int annee)
    {
       this.id=id;
       this.marque=marque;
       this.libelle=libelle;
       this.prix=prix;
       this.d.jour=jour;
       this.d.mois=mois;
       this.d.annee=annee;
    } 
    public produit(int id,String libelle,String marque,float prix)
    {
       this.id=id;
       this.marque=marque;
       this.libelle=libelle;
       this.prix=prix;
    } 
    //public produit(){}
    public static void main (String[]args)
    {
        produit p1 = new produit(1021,"Lait","Delice",0.700f,2,"juin",2022);
        
        produit p2 = new produit(2510,"Yaourt","Vitalait",0f);

        produit p3 = new produit(3250,"Tomate","Sicam",1.200f);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
    public String toString()
    {
        String s = "";
        s+="identifiant : "+this.id+"\n";
        s+="libelle : "+this.libelle+"\n";
        s+="marque : "+this.marque+"\n";
        s+="prix : "+this.prix+"\n";
        return s;
    }
    public boolean compare(produit p)
    {
        if (this.id==p.id && this.libelle==p.libelle && this.prix==p.prix)
            return true;
        else
            return false;
    }
}
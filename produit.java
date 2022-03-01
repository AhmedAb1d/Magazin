
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
    Date d=new Date();
    double quantite;
    public produit(int id,String libelle)
    {
        this.id=id;
        this.libelle=libelle;
    }
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
    public produit(){}
    public static void main (String[]args)
    {
        ProduitFruit p1 = new ProduitFruit(1254 ,"Fruit", "Fraise", 12.5, "Mars");
        
        ProduitFruit p2 = new ProduitFruit(1224, "Fruit", "Pasteque", 50 ,"Juin");

        ProduitFruit p3 = new ProduitFruit(7896 ,"Fruit" ,"Mandarine", 25.6, "Décembre");

        ProduitLegume p4 = new ProduitLegume(8521 ,"Légumes" ,"Artichauts", 14 ,"Janvier");

        System.out.println(p4.determinerTypeProduit());
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
    public String determinerTypeProduit()
    {
        if (this instanceof ProduitFruit)
        {
            return "Fruit";
        }
        else if (this instanceof ProduitLegume)
        {
            return "Legume";
        }
        else
        {
            return "Autre";
        }

    }
}

class ProduitFruit extends produit
{
    String type;
    double quantite;
    String saison;
    public ProduitFruit(){}
    public ProduitFruit(int id,String type,String libelle,double quantite, String saison)
    {
        super(id, libelle);
        this.type=type;
        this.quantite=quantite;
        this.saison=saison;
    }
    public boolean estFrais(String saison)
    {
        return this.saison==saison;
    }
}

class ProduitLegume extends produit
{
    String type;
    double quantite;
    String saison;
    public ProduitLegume(){}
    public ProduitLegume(int id,String type,String libelle,double quantite, String saison)
    {
        super(id, libelle);
        this.type=type;
        this.quantite=quantite;
        this.saison=saison;
    }
    public boolean estFrais(String saison)
    {
        return this.saison==saison;
    }
}

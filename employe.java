import static java.lang.System.out;
public class employe
{
    int identifiant;
    String nom;
    String adresse;
    int nbr_heures;
    public employe(int identifiant,String nom,String adresse,int nbr_heures)
    {
        this.identifiant=identifiant;
        this.nom=nom;
        this.adresse=adresse;
        this.nbr_heures=nbr_heures;
    }
    public static void main (String[] args)
    {
        caissier c1=new caissier(1,"ahmed","sfax",13,2);
        vendeur v1=new vendeur(3,"ahmed","sfax",23,2.5f);
        responsable r1=new responsable(6,"gaith","bou3rada",10,1200);
        System.out.println(r1.calcule());
    }
    public String toString()
    {
        String s="";
        s+="ID de l'employe: "+this.identifiant+"\n";
        s+="Nom de l'employe: "+this.nom+"\n";
        s+="Adresse de l'employe: "+this.adresse+"\n";
        s+="Le nombre des heures: "+this.nbr_heures+"\n";
        return s;
    }
    public float calcule()
    {
        return 0f;
    }
}

class vendeur extends employe
{
    float tauxDeVente;
    public vendeur(int identifiant, String nom, String adresse, int nbr_heures,float tauxDeVente) 
    {
        super(identifiant, nom, adresse, nbr_heures);
        this.tauxDeVente=tauxDeVente;
    }
    public String toString()
    {
        String s="";
        s+="ID de l'employe: "+this.identifiant+"\n";
        s+="Nom de l'employe: "+this.nom+"\n";
        s+="Adresse de l'employe: "+this.adresse+"\n";
        s+="Le nombre des heures: "+this.nbr_heures+"\n";
        s+="Taux de vente: "+this.tauxDeVente+"\n";
        return s;
    }
    public float calcule()
    {
        float p=450f*this.tauxDeVente;
        return p;
    }
}

class caissier extends employe
{
    int numeroDeCaisse;
    public caissier(int identifiant,String nom,String adresse,int nbr_heures,int numeroDeCaisse)
    {
        super(identifiant,nom,adresse,nbr_heures);
        this.numeroDeCaisse=numeroDeCaisse;
    }
    public String toString()
    {
        String s="";
        s+="ID de l'employe: "+this.identifiant+"\n";
        s+="Nom de l'employe: "+this.nom+"\n";
        s+="Adresse de l'employe: "+this.adresse+"\n";
        s+="Le nombre des heures: "+this.nbr_heures+"\n";
        s+="Numero de Caisse: "+this.numeroDeCaisse+"\n";
        return s;
    }
    public float calcule()
    {
        if (this.nbr_heures>180)
        {
            float p=this.nbr_heures-180;
            return this.nbr_heures*5+p*1.15f*5;
        }
        else
        {
            return this.nbr_heures*5;
        }
    }
}

class responsable extends employe
{
    int prime;
    public responsable(int identifiant, String nom, String adresse, int nbr_heures,int prime)
    {
        super(identifiant, nom, adresse, nbr_heures);
        this.prime=prime;
    }
    public String toString()
    {
        String s="";
        s+="ID de l'employe: "+this.identifiant+"\n";
        s+="Nom de l'employe: "+this.nom+"\n";
        s+="Adresse de l'employe: "+this.adresse+"\n";
        s+="Le nombre des heures: "+this.nbr_heures+"\n";
        s+="Prime: "+this.prime+"\n";
        return s;
    }
    public float calcule()
    {
        if (this.nbr_heures>160)
        {
            float p=this.nbr_heures-160;
            return this.nbr_heures*10+p*1.2f*5+this.prime;
        }
        else
        {
            return this.nbr_heures*10+this.prime;
        }
    }
}



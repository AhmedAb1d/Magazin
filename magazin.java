public class magazin 
{
    int id;
    String adresse;
    String nom;
    static int capacite=50;
    produit[] ensProd=new produit[capacite];
    employe[] ensEmp=new employe[20];

    public magazin(int id,String nom,String adresse)
    {
        this.id=id;
        this.nom=nom;
        this.adresse=adresse;
    }

    public magazin(int id,String adresse,produit p1)
    {
        this.id=id;
        this.adresse=adresse;
        this.ensProd[0]=p1;
    }
    public magazin(int id,String adresse,produit p1,produit p2)
    {
        this.id=id;
        this.adresse=adresse;
        this.ensProd[0]=p1;
        this.ensProd[1]=p2;
    }
    public magazin(int id,String adresse,produit p1,produit p2,produit p3)
    {
        this.id=id;
        this.adresse=adresse;
        this.ensProd[0]=p1;
        this.ensProd[1]=p2;
        this.ensProd[2]=p3;
    }
    public magazin(int id,String nom,String adresse,employe e1,employe e2,employe e3,employe e4)
    {
        this.id=id;
        this.nom=nom;
        this.adresse=adresse;
        this.ensEmp[0]=e1;
        this.ensEmp[1]=e2;
        this.ensEmp[2]=e3;
        this.ensEmp[3]=e4;
    }
    public static void main(String[] args)
    {
        produit p1 = new produit(1021,"Lait","Delice",0.700f,2,"juin",2022);
        ProduitFruit p2 = new ProduitFruit(1224, "Fruit", "Pastèque", 50 ,"Juin");
        ProduitFruit p3 = new ProduitFruit(7896 ,"Fruit" ,"Mandarine", 25.6, "Décembre");
        caissier c1=new caissier(1,"ahmed","sfax",13,2);
        caissier c2=new caissier(2,"abid","sfax",22,3);
        vendeur v1=new vendeur(3,"ahmed","sfax",23,2.5f);
        vendeur v2=new vendeur(4,"racem","ariana",22,2.4f);
        vendeur v3=new vendeur(5,"lasmar","ibnsina",10,2.2f);
        responsable r1=new responsable(6,"gaith","bou3rada",10,1200);
        magazin m1=new magazin(1, "carrefour","Centre-ville",c1,c2,v2,r1);
        magazin m2=new magazin(2,"Monoprix","Menzah 6",v1,v2,v3,r1);
        magazin m3=new magazin(4,"test",p1,p2,p3);
        
        System.out.println(m3.calculStock());
        
    }
    public String toString()
    {
        String s="";
        s+="ID du Magazin: "+this.id+"\n";
        s+="le nom du magazin "+this.nom+"\n";
        s+="Adresse: "+this.adresse+"\n";
        s+="La Liste des produits:\n\n";
        for (int i=0;this.ensProd[i]!=null;i++)
            s+="*Produit n"+Integer.toString(i+1)+" "+this.ensProd[i]+"\n";
        s+="La Liste des employes:\n\n";
        for (int i=0;this.ensEmp[i]!=null;i++)
            s+="*Employe n"+Integer.toString(i+1)+" "+this.ensEmp[i]+"\n";
        return s;
    }
    public void calcule()
    {
        for (int i=0;this.ensEmp[i]!=null;i++)
        {
            System.out.print("Le salaire de l'employe n'"+Integer.toString(i+1)+" est: "+this.ensEmp[i].calcule()+"\n");
        }
    }


    //methode a implementer dans la class produit
    /*public boolean compare(produit p)
    {
        if (this.id==p.id && this.libelle==p.libelle && this.prix==p.prix)
            return true;
        else
            return false;
    }*/


    public boolean compare(produit p1,produit p2)
    {
        if (p1.id==p2.id && p1.libelle==p2.libelle && p1.prix==p2.prix)
            return true;
        else
            return false;
    }
    public boolean chercher(int a)
    {
        for (int i=0;this.ensProd[i]!=null;i++)
        {
            if (this.ensProd[i].id==a)
                return true;
        }
        return false;
    }
    public void ajouterProduit(produit p)
    {
        if (!this.chercher(p.id))
        {
            int i=0;
            while (this.ensProd[i]!=null)
            {
                i++;
            }
            this.ensProd[i]=p;
        }
    }


    public void supprimerProduit(produit p)
    {
        if (this.chercher(p.id))
        {
            int i=0;
            while (this.ensProd[i].id!=p.id)
            {
                i++;
            }
            this.ensProd[i]=null;
            while (this.ensProd[i+1]!=null)
            {
                this.ensProd[i]=this.ensProd[i+1];
                i++;
            }
            this.ensProd[i]=null;
        }
        else
            System.out.println("Le produit n'existe pas dans le magazin");
    }

    public int length()
    {
        int i=0;
        while (this.ensProd[i]!=null)
            i++;
        return i;
    }

    public void compareMagazin(magazin m)
    {
        if (this.length()>m.length())
            System.out.println("Le magazin d'ID: "+this.id+" a plus de produit.");
        else if (this.length()<m.length())
            System.out.println("Le magazin d'ID: "+m.id+" a plus de produit.");
        else
            System.out.println("Les deux magazins ont la meme quantite des produits.");
    }

    public float calculStock()
    {
        float stock=0f;
        for (int i=0; this.ensProd[i]!=null;i++)
        {
            if (this.ensProd[i].determinerTypeProduit()=="Fruit")
            {
                ProduitFruit p=(ProduitFruit)this.ensProd[i];
                stock+=p.quantite;
            }
            else if (this.ensProd[i].determinerTypeProduit()=="Legume")
            {
                ProduitLegume p=(ProduitLegume)this.ensProd[i];
                stock+=p.quantite;
            }
        }
        return stock;
    }
}

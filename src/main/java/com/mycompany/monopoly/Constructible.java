package com.mycompany.monopoly;

public class Constructible extends Achetable {
    private int nbMaison, nbHotel;
    private static final int LOYER = 100;
    private static final int PRIXMAISON = 100;
    private static final int PRIXHOTEL = 1000;

    protected Constructible(String nom, int prix) {
        super(prix, nom);
    }

    public int loyer() {
        return LOYER + nbMaison * PRIXMAISON + nbHotel * PRIXHOTEL;
    }

    
    /**
     * 
     * @param j joueur
     * @param valeurDe valeur du dé
     * @throws NoMoreMoneyException si le joueur n'a pas assez d'argent
     */
    @Override
    public void utiliser(Joueur j, int valeurDe) throws NoMoreMoneyException {
        if (getProprietaire() == null) {
            if (valeurDe % 2 == 1 && j.getFortune() >= getPrix()) {
                setProprietaire(j);
                j.setFortune(j.getFortune() - getPrix());
                System.out.println(j.getNom() + " achète " + this + " !"); 
            }
        } else if (getProprietaire() != j) {
            int lo = loyer();
            j.payer(getProprietaire(), lo);
            System.out.println(j.getNom() + " paye le loyer de " + this.getNom() + " à " + getProprietaire().getNom() + " !");
        }
    }
    /**
     * gère la faillite du joueur au niveau de ses propriété
     * @param j joueur
     */
    @Override
    public void faillite(Joueur j) {
        if (this.getProprietaire() == j) {
            super.faillite(j);
            this.nbMaison = 0;
            this.nbHotel = 0;
        }
    }

    @Override
    public String toString() {
        String s = super.toString();
        if (nbMaison > 0) {
            s += ", " + nbMaison + " maisons";
        }
        if (nbHotel > 0) {
            s += ", " + nbHotel + " hotels";
        }
        s += ", loyer = " + loyer() + "€";
        return s;
    }

    public int getNbMaison() {
        return nbMaison;
    }

    public int getNbHotel() {
        return nbHotel;
    }

    public double getPrixMaison() {
        return PRIXMAISON;
    }

    public double getPrixHotel() {
        return PRIXHOTEL;
    }

    public void ajoutMaison() {
        nbMaison += 1;
    }

    public void ajoutHotel() {
        nbHotel += 1;
    }
}

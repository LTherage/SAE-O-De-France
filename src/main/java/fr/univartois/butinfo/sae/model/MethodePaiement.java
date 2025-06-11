package fr.univartois.butinfo.sae.model;

public abstract class MethodePaiement {
    abstract void payer(double montant);
    abstract void rembourser(double montant);
}

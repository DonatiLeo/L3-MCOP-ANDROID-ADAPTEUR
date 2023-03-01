package fr.uca.ds4h.miage.donati.adapteur;


/**
 * Interface pour écouter les évènements sur le nom d'une personne
 */
public interface PersonneListener {
    public void onClickNom(Personne item, int position);
}

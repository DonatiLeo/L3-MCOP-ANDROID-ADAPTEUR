package fr.uca.ds4h.miage.donati.adapteur;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rosa Lecat on 03/02/2020.
 */
public class PersonneAdapter extends BaseAdapter {

    //Liste de Personnes
    private ListPers personnes;

    //Le contexte dans lequel est présent notre adapter
    private Context context;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater inflater;

    //Liste des abonnés des événements sur les personnes de la liste
    private ArrayList<PersonneListener> ecouteurs = new ArrayList<>();

    public PersonneAdapter(Context context, ListPers aListP) {
        this.context = context;
        personnes = aListP;
        inflater = LayoutInflater.from(this.context);
    }

    //Ajoute un écouteur à la liste des écouteurs
    public void addListener(PersonneListener aListener) {
        ecouteurs.add(aListener);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) inflater.inflate(R.layout.persone_layout, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView tv_Nom = (TextView)layoutItem.findViewById(R.id.TV_Nom);
        TextView tv_Prenom = (TextView)layoutItem.findViewById(R.id.TV_Prenom);

        //(3) : Renseignement des valeurs
        tv_Nom.setText(personnes.get(position).getNom());
        tv_Prenom.setText(personnes.get(position).getPrenom());

        //(4) Changement de la couleur du fond de notre item
        if (personnes.get(position).getGenre() == 1) {
            layoutItem.setBackgroundColor(Color.BLUE);
        } else {
            layoutItem.setBackgroundColor(Color.MAGENTA);
        }
        tv_Nom.setTag(position);

        //(5) On définit que l'événement click sur le nom lance l'event à tous les abonnées
        tv_Nom.setOnClickListener( v ->
                {
                    Integer pos = (Integer)v.getTag();
                    fireEventClicNom(personnes.get(pos), pos);
                });

        //On retourne l'item créé.
        return layoutItem;
    }

    //On notifie les abonnées de l'événment clic sur le nom
    private void fireEventClicNom(Personne item, int position) {
        for(int i = ecouteurs.size()-1; i >= 0; i--)
            ecouteurs.get(i).onClickNom(item, position);
    }

    @Override
    public int getCount() {
        return personnes.size();
    }

    @Override
    public Object getItem(int position) {
        return personnes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}



package fr.uca.ds4h.miage.donati.adapteur;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements PersonneListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperation de la liste des personnes
        ListPers listP = new ListPers();
        listP.construireListe();

        //Creation et initialisation de l'Adapter pour les personnes
        PersonneAdapter adapter = new PersonneAdapter(this, listP);

        //Recuperation du composant ListView
        ListView lV = (ListView) findViewById(R.id.listView);

        //Initialisation de la liste avec les donnees
        lV.setAdapter(adapter);

        //Ecoute des événements sur la liste
        adapter.addListener(this);
    }

    //Méthode de callback associé à l'écouteur de personnes
    @Override
    public void onClickNom(Personne item, int position) {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Personne");
        dlg.setMessage("Vous avez clique sur : " + item.getNom());
        dlg.setPositiveButton("Oui", null);
        dlg.setNegativeButton("Non", null);
        dlg.show();
    }
}
package dmorenoar.uoc.fragments.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import dmorenoar.uoc.fragments.Fragments.DataFragment;
import dmorenoar.uoc.fragments.Fragments.DetailsFragment;
import dmorenoar.uoc.fragments.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener{ //Cambiamos porque es una actividad que recibe fragments

    private boolean isMultiPanel; //Para controlar si es una aplicación multipanel o no(dispositivo pequeño o grande) podremos mostrar un fragment o dos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Establecemos el tipo de multipanel
        setMultiPanel();

    }

    //Al implementar el sendData lo enviaremos al fragment para que lo recoja
    @Override
    public void sendData(String text) {
        /*Llamamos al método renderizarTexto de el DetailsFragment
        pasandole el texto que recibimos por el parámetros en este mismo método
         */

        if(isMultiPanel){
            //Si es multi panel, pasale al fragment el contenido
            //Creamos instancia del fragmento al que queremos comunicarnos
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        }else{
            //Si no lo es le pasamos al activity el texto
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("text",text);
            startActivity(intent);
        }

    }

    private void setMultiPanel(){
        //Traemos el fragment para ver si esta cargado en pantalla el details y saber que tipo de pantalla tenemos
        //Si devuelve null es que el fragment no se encuetnra en pantalla y se trata de un móvil pequeño
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment) != null);
    }

}

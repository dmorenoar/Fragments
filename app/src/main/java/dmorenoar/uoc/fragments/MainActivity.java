package dmorenoar.uoc.fragments;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener{ //Cambiamos porque es una actividad que recibe fragments

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Al implementar el sendData lo enviaremos al fragment para que lo recoja
    @Override
    public void sendData(String text) {
        /*Llamamos al método renderizarTexto de el DetailsFragment
        pasandole el texto que recibimos por el parámetros en este mismo método
         */

        //Creamos instancia del fragmento al que queremos comunicarnos
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);

        detailsFragment.renderText(text);
    }
}

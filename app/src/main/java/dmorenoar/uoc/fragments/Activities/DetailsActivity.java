package dmorenoar.uoc.fragments.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dmorenoar.uoc.fragments.Fragments.DetailsFragment;
import dmorenoar.uoc.fragments.R;

public class DetailsActivity extends AppCompatActivity {

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getIntent().getExtras() != null){ //Comrpobamos que extras tenga contenido para ver si venimos del MainActivity
            text = getIntent().getStringExtra("text");
            //Traemos la instancia del fragmento y llamado al render text
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        }
    }
}

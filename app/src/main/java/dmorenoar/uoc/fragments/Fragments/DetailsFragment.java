package dmorenoar.uoc.fragments.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import dmorenoar.uoc.fragments.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private TextView details;


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container,false);

        details = (TextView) view.findViewById(R.id.textViewDetails);

        return view;
    }

    /*Creamos un metodo renderizar que captura el textview del layout e inyectamos*/
    public void renderText(String text){
        details.setText(text);
    }
}

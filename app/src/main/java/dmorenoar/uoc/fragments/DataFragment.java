package dmorenoar.uoc.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    private EditText textData;
    private Button btnSend;
    private DataListener callback;




    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            //El activity envia y lo recuperamos con el context
            callback = (DataListener) context; //Del Activity nos traemos lo que ha capturado el Listener
        }catch (Exception e){
            throw new ClassCastException(context.toString() + "should implement DataListener");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        //Lógica para capturar los elementos de la UI

        textData = (EditText) view.findViewById(R.id.editTextData);
        btnSend = (Button) view.findViewById(R.id.buttonSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recogemos lo que se le ha hecho al botón y ponemos el texto que hemos recogido
                sendText(textData.getText().toString());
            }
        });



        return view;
    }

    private void sendText(String text){
        callback.sendData(text);
    }

    public interface DataListener {
        void sendData(String text);
    }


}

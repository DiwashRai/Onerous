package cranfield.ssel.onerous;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;

public class VariablesFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.variables_fragment,
                container, false);

        Button updateVarBtn = (Button) view.findViewById(R.id.updateVariablesButton);
        updateVarBtn.setOnClickListener(new View.OnClickListener(){
            @Override
          public void onClick (View v){
            updateVars(view);
          }
        });
        return view;
    }

    public VariablesFragment(){
    }

    public static VariablesFragment newInstance() {
        VariablesFragment fragment = new VariablesFragment();
        return fragment;
    }

    public void updateVars(View v)
    {
        EditText days = (EditText) v.findViewById(R.id.daysText);
        Variables.RunTime = Integer.parseInt(days.getText().toString());
        EditText warmup = (EditText) v.findViewById(R.id.warmUpText);
        Variables.warmUp = Integer.parseInt(warmup.getText().toString());
        EditText helicopters = (EditText) v.findViewById(R.id.helicoptersText);
        Variables.helicopters = Integer.parseInt(helicopters.getText().toString());
        EditText maxhelicopters = (EditText) v.findViewById(R.id.maxHelicoptersText);
        Variables.maxHelicopters = Integer.parseInt(maxhelicopters.getText().toString());
        EditText spareengines = (EditText) v.findViewById(R.id.spareEnginesText);
        Variables.spareEngines = Integer.parseInt(spareengines.getText().toString());
        EditText msrd = (EditText) v.findViewById(R.id.rememsrdText);
        Variables.MSRD = Integer.parseInt(msrd.getText().toString());
        EditText repairteams = (EditText) v.findViewById(R.id.repairTeamsText);
        Variables.repairTeams = Integer.parseInt(repairteams.getText().toString());
    }
}

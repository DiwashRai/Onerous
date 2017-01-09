package cranfield.ssel.onerous;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        Button restoreDefaultBtn = (Button) view.findViewById(R.id.restoreDefaultBtn);
        restoreDefaultBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                restoreDefaultValues(view);
            }
        });

        refreshCurrentVarValues(view);

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

        refreshCurrentVarValues(v);
    }

    public void refreshCurrentVarValues(View v){
        TextView days2 = (TextView) v.findViewById(R.id.days2);
        TextView warmUpPeriod2 = (TextView) v.findViewById(R.id.warmUpPeriod2);
        TextView helicopters2 = (TextView) v.findViewById(R.id.helicopters2);
        TextView maxHelicopters2 = (TextView) v.findViewById(R.id.maxHelicopters2);
        TextView spareEnginges2 = (TextView) v.findViewById(R.id.spareEngines2);
        TextView remeMSRD2 = (TextView) v.findViewById(R.id.remeMSRD2);
        TextView repairTeams2 = (TextView) v.findViewById(R.id.repairTeams2);

        days2.setText("Days: " + Variables.RunTime);
        warmUpPeriod2.setText("Warm-up period: " + Variables.warmUp);
        helicopters2.setText("Helicopters: " + Variables.helicopters);
        maxHelicopters2.setText("Max Helicopters: " + Variables.maxHelicopters);
        spareEnginges2.setText("Spare Engines: " + Variables.spareEngines);
        remeMSRD2.setText("REME MSRD: " + Variables.MSRD);
        repairTeams2.setText("Repair Teams: " + Variables.repairTeams);
    }

    public void restoreDefaultValues (View v)
    {
        Variables.RunTime = 250;
        Variables.warmUp = 25;
        Variables.helicopters = 10;
        Variables.maxHelicopters = 10;
        Variables.spareEngines = 1;
        Variables.MSRD = 1;
        Variables.repairTeams = 1;

        refreshCurrentVarValues(v);
    }
}

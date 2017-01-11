package cranfield.ssel.onerous;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(), R.array.activityDurationType, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ////////////////////////////////// engine failure Spinner ////////////////////////////////////////////////////////
        Spinner engineFailureSpinner = (Spinner) view.findViewById(R.id.engineFailureDistributionType);
        engineFailureSpinner.setAdapter(adapter);
        engineFailureSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                TextView param1tv = (TextView) view.findViewById(R.id.engineFailureParam1L);
                TextView param2tv = (TextView) view.findViewById(R.id.engineFailureParam2L);
                TextView param3tv = (TextView) view.findViewById(R.id.engineFailureParam3L);
                TextView param4tv = (TextView) view.findViewById(R.id.engineFailureParam4L);
                EditText param1text = (EditText) view.findViewById(R.id.engineFailureParam1Text);
                EditText param2text = (EditText) view.findViewById(R.id.engineFailureParam2Text);
                EditText param3text = (EditText) view.findViewById(R.id.engineFailureParam3Text);
                EditText param4text = (EditText) view.findViewById(R.id.engineFailureParam4Text);

                switch (position) {
                    case 0:
                        param1tv.setText("Mean: ");
                        param2tv.setText("Std Dev: ");
                        param3tv.setText("Minimum: ");
                        param4tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.VISIBLE);
                        param4tv.setVisibility(TextView.VISIBLE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.VISIBLE);
                        param4text.setVisibility(EditText.VISIBLE);

                        param1text.setNextFocusDownId(R.id.engineFailureParam2Text);
                        param2text.setNextFocusDownId(R.id.engineFailureParam3Text);
                        param3text.setNextFocusDownId(R.id.engineFailureParam4Text);
                        param4text.setNextFocusDownId(R.id.engineRemovalParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineFailureParam2Text);
                        param2text.setNextFocusForwardId(R.id.engineFailureParam3Text);
                        param3text.setNextFocusForwardId(R.id.engineFailureParam4Text);
                        param4text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        break;
                    case 1:
                        param1tv.setText("Minimum: ");
                        param2tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineFailureParam2Text);
                        param2text.setNextFocusDownId(R.id.engineRemovalParam1Text);
                        param3text.setNextFocusDownId(R.id.engineRemovalParam1Text);
                        param4text.setNextFocusDownId(R.id.engineRemovalParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineFailureParam2Text);
                        param2text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        param3text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        param4text.setNextFocusForwardId(R.id.engineRemovalParam1Text);

                        break;
                    case 2:
                        param1tv.setText("Value: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.GONE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineRemovalParam1Text);
                        param2text.setNextFocusDownId(R.id.engineRemovalParam1Text);
                        param3text.setNextFocusDownId(R.id.engineRemovalParam1Text);
                        param4text.setNextFocusDownId(R.id.engineRemovalParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        param2text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        param3text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        param4text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        break;
                    case 3:
                        param1tv.setVisibility(EditText.VISIBLE);
                        param2tv.setVisibility(EditText.GONE);
                        param3tv.setVisibility(EditText.GONE);
                        param4tv.setVisibility(EditText.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineRemovalParam1Text);
                        param2text.setNextFocusDownId(R.id.engineRemovalParam1Text);
                        param3text.setNextFocusDownId(R.id.engineRemovalParam1Text);
                        param4text.setNextFocusDownId(R.id.engineRemovalParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        param2text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        param3text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        param4text.setNextFocusForwardId(R.id.engineRemovalParam1Text);
                        break;
                }
                param1text.setText(Double.toString(Variables.operationalTime.getParameter1()));
                param2text.setText(Double.toString(Variables.operationalTime.getParameter2()));
                param3text.setText(Double.toString(Variables.operationalTime.getParameter3()));
                param4text.setText(Double.toString(Variables.operationalTime.getParameter4()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        engineFailureSpinner.setSelection(0);

        ////////////////////////////////// engine Removal Spinner  ////////////////////////////////////////////////////////////
        Spinner engineRemovalSpinner = (Spinner) view.findViewById(R.id.engineRemovalDistributionType);
        engineRemovalSpinner.setAdapter(adapter);
        engineRemovalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                TextView param1tv = (TextView) view.findViewById(R.id.engineRemovalParam1L);
                TextView param2tv = (TextView) view.findViewById(R.id.engineRemovalParam2L);
                TextView param3tv = (TextView) view.findViewById(R.id.engineRemovalParam3L);
                TextView param4tv = (TextView) view.findViewById(R.id.engineRemovalParam4L);
                EditText param1text = (EditText) view.findViewById(R.id.engineRemovalParam1Text);
                EditText param2text = (EditText) view.findViewById(R.id.engineRemovalParam2Text);
                EditText param3text = (EditText) view.findViewById(R.id.engineRemovalParam3Text);
                EditText param4text = (EditText) view.findViewById(R.id.engineRemovalParam4Text);

                switch (position) {
                    case 0:
                        param1tv.setText("Mean: ");
                        param2tv.setText("Std Dev: ");
                        param3tv.setText("Minimum: ");
                        param4tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.VISIBLE);
                        param4tv.setVisibility(TextView.VISIBLE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.VISIBLE);
                        param4text.setVisibility(EditText.VISIBLE);

                        param1text.setNextFocusDownId(R.id.engineRemovalParam2Text);
                        param2text.setNextFocusDownId(R.id.engineRemovalParam3Text);
                        param3text.setNextFocusDownId(R.id.engineRemovalParam4Text);
                        param4text.setNextFocusDownId(R.id.badEngineTransitParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineRemovalParam2Text);
                        param2text.setNextFocusForwardId(R.id.engineRemovalParam3Text);
                        param3text.setNextFocusForwardId(R.id.engineRemovalParam4Text);
                        param4text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        break;
                    case 1:
                        param1tv.setText("Minimum: ");
                        param2tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineRemovalParam2Text);
                        param2text.setNextFocusDownId(R.id.badEngineTransitParam1Text);
                        param3text.setNextFocusDownId(R.id.badEngineTransitParam1Text);
                        param4text.setNextFocusDownId(R.id.badEngineTransitParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineRemovalParam2Text);
                        param2text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        param3text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        param4text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        break;
                    case 2:
                        param1tv.setText("Value: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.GONE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.badEngineTransitParam1Text);
                        param2text.setNextFocusDownId(R.id.badEngineTransitParam1Text);
                        param3text.setNextFocusDownId(R.id.badEngineTransitParam1Text);
                        param4text.setNextFocusDownId(R.id.badEngineTransitParam1Text);

                        param1text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        param2text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        param3text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        param4text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        break;
                    case 3:
                        param1tv.setVisibility(EditText.VISIBLE);
                        param2tv.setVisibility(EditText.GONE);
                        param3tv.setVisibility(EditText.GONE);
                        param4tv.setVisibility(EditText.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.badEngineTransitParam1Text);
                        param2text.setNextFocusDownId(R.id.badEngineTransitParam1Text);
                        param3text.setNextFocusDownId(R.id.badEngineTransitParam1Text);
                        param4text.setNextFocusDownId(R.id.badEngineTransitParam1Text);

                        param1text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        param2text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        param3text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        param4text.setNextFocusForwardId(R.id.badEngineTransitParam1Text);
                        break;
                }
                param1text.setText(Double.toString(Variables.removalTime.getParameter1()));
                param2text.setText(Double.toString(Variables.removalTime.getParameter2()));
                param3text.setText(Double.toString(Variables.removalTime.getParameter3()));
                param4text.setText(Double.toString(Variables.removalTime.getParameter4()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        engineRemovalSpinner.setSelection(2);

        /////////////////////////////////////// bad engine spinner  ///////////////////////////////////////////////////////////////
        Spinner badEngineTransitSpinner = (Spinner) view.findViewById(R.id.badEngineTransitDistributionType);
        badEngineTransitSpinner.setAdapter(adapter);
        badEngineTransitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                TextView param1tv = (TextView) view.findViewById(R.id.badEngineTransitParam1L);
                TextView param2tv = (TextView) view.findViewById(R.id.badEngineTransitParam2L);
                TextView param3tv = (TextView) view.findViewById(R.id.badEngineTransitParam3L);
                TextView param4tv = (TextView) view.findViewById(R.id.badEngineTransitParam4L);
                EditText param1text = (EditText) view.findViewById(R.id.badEngineTransitParam1Text);
                EditText param2text = (EditText) view.findViewById(R.id.badEngineTransitParam2Text);
                EditText param3text = (EditText) view.findViewById(R.id.badEngineTransitParam3Text);
                EditText param4text = (EditText) view.findViewById(R.id.badEngineTransitParam4Text);

                switch (position) {
                    case 0:
                        param1tv.setText("Mean: ");
                        param2tv.setText("Std Dev: ");
                        param3tv.setText("Minimum: ");
                        param4tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.VISIBLE);
                        param4tv.setVisibility(TextView.VISIBLE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.VISIBLE);
                        param4text.setVisibility(EditText.VISIBLE);

                        param1text.setNextFocusDownId(R.id.badEngineTransitParam2Text);
                        param2text.setNextFocusDownId(R.id.badEngineTransitParam3Text);
                        param3text.setNextFocusDownId(R.id.badEngineTransitParam4Text);
                        param4text.setNextFocusDownId(R.id.engineRepairParam1Text);

                        param1text.setNextFocusForwardId(R.id.badEngineTransitParam2Text);
                        param2text.setNextFocusForwardId(R.id.badEngineTransitParam3Text);
                        param3text.setNextFocusForwardId(R.id.badEngineTransitParam4Text);
                        param4text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        break;
                    case 1:
                        param1tv.setText("Minimum: ");
                        param2tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.badEngineTransitParam2Text);
                        param2text.setNextFocusDownId(R.id.engineRepairParam1Text);
                        param3text.setNextFocusDownId(R.id.engineRepairParam1Text);
                        param4text.setNextFocusDownId(R.id.engineRepairParam1Text);

                        param1text.setNextFocusForwardId(R.id.badEngineTransitParam2Text);
                        param2text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        param3text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        param4text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        break;
                    case 2:
                        param1tv.setText("Value: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.GONE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineRepairParam1Text);
                        param2text.setNextFocusDownId(R.id.engineRepairParam1Text);
                        param3text.setNextFocusDownId(R.id.engineRepairParam1Text);
                        param4text.setNextFocusDownId(R.id.engineRepairParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        param2text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        param3text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        param4text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        break;
                    case 3:
                        param1tv.setVisibility(EditText.VISIBLE);
                        param2tv.setVisibility(EditText.GONE);
                        param3tv.setVisibility(EditText.GONE);
                        param4tv.setVisibility(EditText.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineRepairParam1Text);
                        param2text.setNextFocusDownId(R.id.engineRepairParam1Text);
                        param3text.setNextFocusDownId(R.id.engineRepairParam1Text);
                        param4text.setNextFocusDownId(R.id.engineRepairParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        param2text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        param3text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        param4text.setNextFocusForwardId(R.id.engineRepairParam1Text);
                        break;
                }
                param1text.setText(Double.toString(Variables.toWorkshopTime.getParameter1()));
                param2text.setText(Double.toString(Variables.toWorkshopTime.getParameter2()));
                param3text.setText(Double.toString(Variables.toWorkshopTime.getParameter3()));
                param4text.setText(Double.toString(Variables.toWorkshopTime.getParameter4()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        badEngineTransitSpinner.setSelection(2);

        ////////////////////////////////////////// Engine Repair Spinner  /////////////////////////////////////////////////////////////////
        Spinner engineRepairSpinner = (Spinner) view.findViewById(R.id.engineRepairDistritbutionType);
        engineRepairSpinner.setAdapter(adapter);
        engineRepairSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                TextView param1tv = (TextView) view.findViewById(R.id.engineRepairParam1L);
                TextView param2tv = (TextView) view.findViewById(R.id.engineRepairParam2L);
                TextView param3tv = (TextView) view.findViewById(R.id.engineRepairParam3L);
                TextView param4tv = (TextView) view.findViewById(R.id.engineRepairParam4L);
                EditText param1text = (EditText) view.findViewById(R.id.engineRepairParam1Text);
                EditText param2text = (EditText) view.findViewById(R.id.engineRepairParam2Text);
                EditText param3text = (EditText) view.findViewById(R.id.engineRepairParam3Text);
                EditText param4text = (EditText) view.findViewById(R.id.engineRepairParam4Text);

                switch (position) {
                    case 0:
                        param1tv.setText("Mean: ");
                        param2tv.setText("Std Dev: ");
                        param3tv.setText("Minimum: ");
                        param4tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.VISIBLE);
                        param4tv.setVisibility(TextView.VISIBLE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.VISIBLE);
                        param4text.setVisibility(EditText.VISIBLE);

                        param1text.setNextFocusDownId(R.id.engineRepairParam2Text);
                        param2text.setNextFocusDownId(R.id.engineRepairParam3Text);
                        param3text.setNextFocusDownId(R.id.engineRepairParam4Text);
                        param4text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineRepairParam2Text);
                        param2text.setNextFocusForwardId(R.id.engineRepairParam3Text);
                        param3text.setNextFocusForwardId(R.id.engineRepairParam4Text);
                        param4text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        break;
                    case 1:
                        param1tv.setText("Minimum: ");
                        param2tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineRepairParam2Text);
                        param2text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);
                        param3text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);
                        param4text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineRepairParam2Text);
                        param2text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        param3text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        param4text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        break;
                    case 2:
                        param1tv.setText("Value: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.GONE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);
                        param2text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);
                        param3text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);
                        param4text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);

                        param1text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        param2text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        param3text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        param4text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        break;
                    case 3:
                        param1tv.setVisibility(EditText.VISIBLE);
                        param2tv.setVisibility(EditText.GONE);
                        param3tv.setVisibility(EditText.GONE);
                        param4tv.setVisibility(EditText.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);
                        param2text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);
                        param3text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);
                        param4text.setNextFocusDownId(R.id.goodEngineTransitParam1Text);

                        param1text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        param2text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        param3text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        param4text.setNextFocusForwardId(R.id.goodEngineTransitParam1Text);
                        break;
                }
                param1text.setText(Double.toString(Variables.repairTime.getParameter1()));
                param2text.setText(Double.toString(Variables.repairTime.getParameter2()));
                param3text.setText(Double.toString(Variables.repairTime.getParameter3()));
                param4text.setText(Double.toString(Variables.repairTime.getParameter4()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        engineRepairSpinner.setSelection(1);

        ////////////////////////////////////// Good engine Transit Spinner  /////////////////////////////////////////////////////////////////
        Spinner goodEngineTransitSpinner = (Spinner) view.findViewById(R.id.goodEngineTransitDistributionType);
        goodEngineTransitSpinner.setAdapter(adapter);
        goodEngineTransitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                TextView param1tv = (TextView) view.findViewById(R.id.goodEngineTransitParam1L);
                TextView param2tv = (TextView) view.findViewById(R.id.goodEngineTransitParam2L);
                TextView param3tv = (TextView) view.findViewById(R.id.goodEngineTransitParam3L);
                TextView param4tv = (TextView) view.findViewById(R.id.goodEngineTransitParam4L);
                EditText param1text = (EditText) view.findViewById(R.id.goodEngineTransitParam1Text);
                EditText param2text = (EditText) view.findViewById(R.id.goodEngineTransitParam2Text);
                EditText param3text = (EditText) view.findViewById(R.id.goodEngineTransitParam3Text);
                EditText param4text = (EditText) view.findViewById(R.id.goodEngineTransitParam4Text);

                switch (position) {
                    case 0:
                        param1tv.setText("Mean: ");
                        param2tv.setText("Std Dev: ");
                        param3tv.setText("Minimum: ");
                        param4tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.VISIBLE);
                        param4tv.setVisibility(TextView.VISIBLE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.VISIBLE);
                        param4text.setVisibility(EditText.VISIBLE);

                        param1text.setNextFocusDownId(R.id.goodEngineTransitParam2Text);
                        param2text.setNextFocusDownId(R.id.goodEngineTransitParam3Text);
                        param3text.setNextFocusDownId(R.id.goodEngineTransitParam4Text);
                        param4text.setNextFocusDownId(R.id.engineInstallParam1Text);

                        param1text.setNextFocusForwardId(R.id.goodEngineTransitParam2Text);
                        param2text.setNextFocusForwardId(R.id.goodEngineTransitParam3Text);
                        param3text.setNextFocusForwardId(R.id.goodEngineTransitParam4Text);
                        param4text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        break;
                    case 1:
                        param1tv.setText("Minimum: ");
                        param2tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.goodEngineTransitParam2Text);
                        param2text.setNextFocusDownId(R.id.engineInstallParam1Text);
                        param3text.setNextFocusDownId(R.id.engineInstallParam1Text);
                        param4text.setNextFocusDownId(R.id.engineInstallParam1Text);

                        param1text.setNextFocusForwardId(R.id.goodEngineTransitParam2Text);
                        param2text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        param3text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        param4text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        break;
                    case 2:
                        param1tv.setText("Value: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.GONE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineInstallParam1Text);
                        param2text.setNextFocusDownId(R.id.engineInstallParam1Text);
                        param3text.setNextFocusDownId(R.id.engineInstallParam1Text);
                        param4text.setNextFocusDownId(R.id.engineInstallParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        param2text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        param3text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        param4text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        break;
                    case 3:
                        param1tv.setVisibility(EditText.VISIBLE);
                        param2tv.setVisibility(EditText.GONE);
                        param3tv.setVisibility(EditText.GONE);
                        param4tv.setVisibility(EditText.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineInstallParam1Text);
                        param2text.setNextFocusDownId(R.id.engineInstallParam1Text);
                        param3text.setNextFocusDownId(R.id.engineInstallParam1Text);
                        param4text.setNextFocusDownId(R.id.engineInstallParam1Text);

                        param1text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        param2text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        param3text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        param4text.setNextFocusForwardId(R.id.engineInstallParam1Text);
                        break;
                }
                param1text.setText(Double.toString(Variables.toOperationTime.getParameter1()));
                param2text.setText(Double.toString(Variables.toOperationTime.getParameter2()));
                param3text.setText(Double.toString(Variables.toOperationTime.getParameter3()));
                param4text.setText(Double.toString(Variables.toOperationTime.getParameter4()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        goodEngineTransitSpinner.setSelection(2);

        ////////////////////////////////////////Engine Install Spinner  ///////////////////////////////////////////////////////////////////////
        Spinner engineInstallSpinner = (Spinner) view.findViewById(R.id.engineInstallDistributionType);
        engineInstallSpinner.setAdapter(adapter);
        engineInstallSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                TextView param1tv = (TextView) view.findViewById(R.id.engineInstallParam1L);
                TextView param2tv = (TextView) view.findViewById(R.id.engineInstallParam2L);
                TextView param3tv = (TextView) view.findViewById(R.id.engineInstallParam3L);
                TextView param4tv = (TextView) view.findViewById(R.id.engineInstallParam4L);
                EditText param1text = (EditText) view.findViewById(R.id.engineInstallParam1Text);
                EditText param2text = (EditText) view.findViewById(R.id.engineInstallParam2Text);
                EditText param3text = (EditText) view.findViewById(R.id.engineInstallParam3Text);
                EditText param4text = (EditText) view.findViewById(R.id.engineInstallParam4Text);

                switch (position) {
                    case 0:
                        param1tv.setText("Mean: ");
                        param2tv.setText("Std Dev: ");
                        param3tv.setText("Minimum: ");
                        param4tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.VISIBLE);
                        param4tv.setVisibility(TextView.VISIBLE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.VISIBLE);
                        param4text.setVisibility(EditText.VISIBLE);

                        param1text.setNextFocusDownId(R.id.engineInstallParam2Text);
                        param2text.setNextFocusDownId(R.id.engineInstallParam3Text);
                        param3text.setNextFocusDownId(R.id.engineInstallParam4Text);
                        param4text.setNextFocusDownId(R.id.updateVariablesButton);

                        param1text.setNextFocusForwardId(R.id.engineInstallParam2Text);
                        param2text.setNextFocusForwardId(R.id.engineInstallParam3Text);
                        param3text.setNextFocusForwardId(R.id.engineInstallParam4Text);
                        param4text.setNextFocusForwardId(R.id.updateVariablesButton);
                        break;
                    case 1:
                        param1tv.setText("Minimum: ");
                        param2tv.setText("Maximum: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.VISIBLE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.VISIBLE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.engineInstallParam2Text);
                        param2text.setNextFocusDownId(R.id.updateVariablesButton);
                        param3text.setNextFocusDownId(R.id.updateVariablesButton);
                        param4text.setNextFocusDownId(R.id.updateVariablesButton);

                        param1text.setNextFocusForwardId(R.id.engineInstallParam2Text);
                        param2text.setNextFocusForwardId(R.id.updateVariablesButton);
                        param3text.setNextFocusForwardId(R.id.updateVariablesButton);
                        param4text.setNextFocusForwardId(R.id.updateVariablesButton);
                        break;
                    case 2:
                        param1tv.setText("Value: ");

                        param1tv.setVisibility(TextView.VISIBLE);
                        param2tv.setVisibility(TextView.GONE);
                        param3tv.setVisibility(TextView.GONE);
                        param4tv.setVisibility(TextView.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.updateVariablesButton);
                        param2text.setNextFocusDownId(R.id.updateVariablesButton);
                        param3text.setNextFocusDownId(R.id.updateVariablesButton);
                        param4text.setNextFocusDownId(R.id.updateVariablesButton);

                        param1text.setNextFocusForwardId(R.id.updateVariablesButton);
                        param2text.setNextFocusForwardId(R.id.updateVariablesButton);
                        param3text.setNextFocusForwardId(R.id.updateVariablesButton);
                        param4text.setNextFocusForwardId(R.id.updateVariablesButton);
                        break;
                    case 3:
                        param1tv.setVisibility(EditText.VISIBLE);
                        param2tv.setVisibility(EditText.GONE);
                        param3tv.setVisibility(EditText.GONE);
                        param4tv.setVisibility(EditText.GONE);

                        param1text.setVisibility(EditText.VISIBLE);
                        param2text.setVisibility(EditText.GONE);
                        param3text.setVisibility(EditText.GONE);
                        param4text.setVisibility(EditText.GONE);

                        param1text.setNextFocusDownId(R.id.updateVariablesButton);
                        param2text.setNextFocusDownId(R.id.updateVariablesButton);
                        param3text.setNextFocusDownId(R.id.updateVariablesButton);
                        param4text.setNextFocusDownId(R.id.updateVariablesButton);

                        param1text.setNextFocusForwardId(R.id.updateVariablesButton);
                        param2text.setNextFocusForwardId(R.id.updateVariablesButton);
                        param3text.setNextFocusForwardId(R.id.updateVariablesButton);
                        param4text.setNextFocusForwardId(R.id.updateVariablesButton);
                        break;
                }
                param1text.setText(Double.toString(Variables.refitTime.getParameter1()));
                param2text.setText(Double.toString(Variables.refitTime.getParameter2()));
                param3text.setText(Double.toString(Variables.refitTime.getParameter3()));
                param4text.setText(Double.toString(Variables.refitTime.getParameter4()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        engineInstallSpinner.setSelection(2);

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
        // entering user entered run param settings and entity  number values
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

        //////////// Entering user entered activity distribution values   ////////////////////////////////////////
        Spinner engineFailureSpinner = (Spinner) v.findViewById(R.id.engineFailureDistributionType);
        EditText engineFailureParam1 = (EditText) v.findViewById(R.id.engineFailureParam1Text);
        EditText engineFailureParam2 = (EditText) v.findViewById(R.id.engineFailureParam2Text);
        EditText engineFailureParam3 = (EditText) v.findViewById(R.id.engineFailureParam3Text);
        EditText engineFailureParam4 = (EditText) v.findViewById(R.id.engineFailureParam4Text);
        Variables.operationalTime.setType(engineFailureSpinner.getSelectedItemPosition()+1);
        Variables.operationalTime.setParameter1(Double.parseDouble(engineFailureParam1.getText().toString()));
        Variables.operationalTime.setParameter2(Double.parseDouble(engineFailureParam2.getText().toString()));
        Variables.operationalTime.setParameter3(Double.parseDouble(engineFailureParam3.getText().toString()));
        Variables.operationalTime.setParameter4(Double.parseDouble(engineFailureParam4.getText().toString()));

        Spinner engineRemovalSpinner = (Spinner) v.findViewById(R.id.engineRemovalDistributionType);
        EditText engineRemovalParam1 = (EditText) v.findViewById(R.id.engineRemovalParam1Text);
        EditText engineRemovalParam2 = (EditText) v.findViewById(R.id.engineRemovalParam2Text);
        EditText engineRemovalParam3 = (EditText) v.findViewById(R.id.engineRemovalParam3Text);
        EditText engineRemovalParam4 = (EditText) v.findViewById(R.id.engineRemovalParam4Text);
        Variables.removalTime.setType(engineRemovalSpinner.getSelectedItemPosition()+1);
        Variables.removalTime.setParameter1(Double.parseDouble(engineRemovalParam1.getText().toString()));
        Variables.removalTime.setParameter2(Double.parseDouble(engineRemovalParam2.getText().toString()));
        Variables.removalTime.setParameter3(Double.parseDouble(engineRemovalParam3.getText().toString()));
        Variables.removalTime.setParameter4(Double.parseDouble(engineRemovalParam4.getText().toString()));

        Spinner badEngineTransitSpinner = (Spinner) v.findViewById(R.id.badEngineTransitDistributionType);
        EditText badEngineTransitParam1 = (EditText) v.findViewById(R.id.badEngineTransitParam1Text);
        EditText badEngineTransitParam2 = (EditText) v.findViewById(R.id.badEngineTransitParam2Text);
        EditText badEngineTransitParam3 = (EditText) v.findViewById(R.id.badEngineTransitParam3Text);
        EditText badEngineTransitParam4 = (EditText) v.findViewById(R.id.badEngineTransitParam4Text);
        Variables.toWorkshopTime.setType(badEngineTransitSpinner.getSelectedItemPosition() + 1);
        Variables.toWorkshopTime.setParameter1(Double.parseDouble(badEngineTransitParam1.getText().toString()));
        Variables.toWorkshopTime.setParameter2(Double.parseDouble(badEngineTransitParam2.getText().toString()));
        Variables.toWorkshopTime.setParameter3(Double.parseDouble(badEngineTransitParam3.getText().toString()));
        Variables.toWorkshopTime.setParameter4(Double.parseDouble(badEngineTransitParam4.getText().toString()));

        Spinner engineRepairSpinner = (Spinner) v.findViewById(R.id.engineRepairDistritbutionType);
        EditText engineRepairParam1 = (EditText) v.findViewById(R.id.engineRepairParam1Text);
        EditText engineRepairParam2 = (EditText) v.findViewById(R.id.engineRepairParam2Text);
        EditText engineRepairParam3 = (EditText) v.findViewById(R.id.engineRepairParam3Text);
        EditText engineRepairParam4 = (EditText) v.findViewById(R.id.engineRepairParam4Text);
        Variables.repairTime.setType(engineRepairSpinner.getSelectedItemPosition() +1);
        Variables.repairTime.setParameter1(Double.parseDouble(engineRepairParam1.getText().toString()));
        Variables.repairTime.setParameter2(Double.parseDouble(engineRepairParam2.getText().toString()));
        Variables.repairTime.setParameter3(Double.parseDouble(engineRepairParam3.getText().toString()));
        Variables.repairTime.setParameter4(Double.parseDouble(engineRepairParam4.getText().toString()));

        Spinner goodEngineTransitSpinner = (Spinner) v.findViewById(R.id.goodEngineTransitDistributionType);
        EditText goodEngineTransitParam1 = (EditText) v.findViewById(R.id.goodEngineTransitParam1Text);
        EditText goodEngineTransitParam2 = (EditText) v.findViewById(R.id.goodEngineTransitParam2Text);
        EditText goodEngineTransitParam3 = (EditText) v.findViewById(R.id.goodEngineTransitParam3Text);
        EditText goodEngineTransitParam4 = (EditText) v.findViewById(R.id.goodEngineTransitParam4Text);
        Variables.toOperationTime.setType(goodEngineTransitSpinner.getSelectedItemPosition() + 1);
        Variables.toOperationTime.setParameter1(Double.parseDouble(goodEngineTransitParam1.getText().toString()));
        Variables.toOperationTime.setParameter2(Double.parseDouble(goodEngineTransitParam2.getText().toString()));
        Variables.toOperationTime.setParameter3(Double.parseDouble(goodEngineTransitParam3.getText().toString()));
        Variables.toOperationTime.setParameter4(Double.parseDouble(goodEngineTransitParam4.getText().toString()));

        Spinner engineInstallSpinner = (Spinner) v.findViewById(R.id.engineInstallDistributionType);
        EditText engineInstallTransitParam1 = (EditText) v.findViewById(R.id.engineInstallParam1Text);
        EditText engineInstallTransitParam2 = (EditText) v.findViewById(R.id.engineInstallParam2Text);
        EditText engineInstallTransitParam3 = (EditText) v.findViewById(R.id.engineInstallParam3Text);
        EditText engineInstallTransitParam4 = (EditText) v.findViewById(R.id.engineInstallParam4Text);
        Variables.refitTime.setType(engineInstallSpinner.getSelectedItemPosition() + 1);
        Variables.refitTime.setParameter1(Double.parseDouble(engineInstallTransitParam1.getText().toString()));
        Variables.refitTime.setParameter2(Double.parseDouble(engineInstallTransitParam2.getText().toString()));
        Variables.refitTime.setParameter3(Double.parseDouble(engineInstallTransitParam3.getText().toString()));
        Variables.refitTime.setParameter4(Double.parseDouble(engineInstallTransitParam4.getText().toString()));

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

        days2.setText(Html.fromHtml("Days: " +"<b>" + Variables.RunTime + "</b>"));
        warmUpPeriod2.setText(Html.fromHtml("Warm-up period: " + "<b>" + Variables.warmUp + "</b>"));
        helicopters2.setText(Html.fromHtml("Helicopters: " + "<b>" + Variables.helicopters + "</b>"));
        maxHelicopters2.setText(Html.fromHtml("Max Helicopters: " + "<b>" + Variables.maxHelicopters + "</b>"));
        spareEnginges2.setText(Html.fromHtml("Spare Engines: " + "<b>" + Variables.spareEngines + "</b>"));
        remeMSRD2.setText(Html.fromHtml("REME MSRD: " + "<b>" + Variables.MSRD + "</b>"));
        repairTeams2.setText(Html.fromHtml("Repair Teams: " + "<b>" + Variables.repairTeams+ "</b>"));

        ////////////// Activity Durations refresh ///////////////////////////////////////////////////////////
        TextView engineFailure2 = (TextView) v.findViewById(R.id.engineFailure2);
        TextView engineRemoval2 = (TextView) v.findViewById(R.id.engineRemoval2);
        TextView badEngineTransit2 = (TextView) v.findViewById(R.id.badEngineTransit2);
        TextView engineRepair2 = (TextView) v.findViewById(R.id.engineRepair2);
        TextView goodEngineTransit2 = (TextView) v.findViewById(R.id.goodEngineTransit2);
        TextView engineInstall2 = (TextView) v.findViewById(R.id.engineInstall2);

        engineFailure2.setText(distributionTypeString(Variables.operationalTime, "Engine Failure: "));
        engineRemoval2.setText(distributionTypeString(Variables.removalTime, "Engine Removal: "));
        badEngineTransit2.setText(distributionTypeString(Variables.toWorkshopTime, "Bad engine Transit: "));
        engineRepair2.setText(distributionTypeString(Variables.repairTime, "Engine repair: "));
        goodEngineTransit2.setText(distributionTypeString(Variables.toOperationTime, "Good Engine Transit: "));
        engineInstall2.setText(distributionTypeString(Variables.refitTime, "Engine Install: "));
    }

    public Spanned distributionTypeString (ActivityDistribution activity, String eventName){
        Spanned details = Html.fromHtml("");
        switch (activity.getType()){
            case 1: details = Html.fromHtml(eventName + "<b> Bounded Normal. </b>Mean: <b> " + activity.getParameter1() + "</b> Std Dev: <b> " + activity.getParameter2() + ". </b> Minimum: <b> " + activity.getParameter3() + ". </b> Maximum: <b>" + activity.getParameter4() + ". <b/>");
                break;
            case 2: details = Html.fromHtml(eventName + "<b> Uniform. </b> Minimum: <b> " + activity.getParameter1() + ". </b> Maximum: <b>" + activity.getParameter2() + ".</b>");
                break;
            case 3: details = Html.fromHtml(eventName + "<b> Constant. </b> Value: <b>" + activity.getParameter1() + ".</b>");
                break;
            case 4: details = Html.fromHtml(eventName + "<b> DISTRIBUITION TYPE NOT IMPLEMENTED </b>");
                break;
            default: details = Html.fromHtml(eventName + "<b> INVALID DISTRIBUTION TYPE VALUE </b>");
                break;
        }
        return details;
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

        ((MainActivity)getActivity()).initDataVariables();

        refreshCurrentVarValues(v);
    }
}

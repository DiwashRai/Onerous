package cranfield.ssel.onerous;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SimulationFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.simulation_fragment,
                container, false);
        final Handler handler = new Handler(Looper.getMainLooper());

        final Button runSimbtn = (Button) view.findViewById(R.id.runSimButton);
        runSimbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runSimbtn.setClickable(false);
                SimGraphics graphics = new SimGraphics(view);
                graphics.resetImage();
                new Thread(new Runnable() {
                    public void run() {
                        SimMethods sim = new SimMethods(view, handler);
                        sim.runSim();
                    }
                }).start();
            }
        });

        Button resetImgBtn = (Button) view.findViewById(R.id.resetImageButton);
        resetImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimGraphics graphics = new SimGraphics(view);
                graphics.resetImage();
            }
        });

        SimGraphics graphics = new SimGraphics(view);
        graphics.resetImage();

        Switch graphicsSwitch = (Switch) view.findViewById(R.id.graphicsSwitch);
        if (Variables.graphicsOn) graphicsSwitch.setChecked(true);
        else graphicsSwitch.setChecked(false);
        graphicsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) Variables.graphicsOn = true;
                else Variables.graphicsOn = false;
            }
        });

        Switch animationSwitch = (Switch) view.findViewById(R.id.animationSwitch);
        if (Variables.animationsOn) animationSwitch.setChecked(true);
        else animationSwitch.setChecked(false);
        animationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) Variables.animationsOn = true;
                else Variables.animationsOn = false;
            }
        });
        return view;
    }

    public SimulationFragment(){
    }

    public static SimulationFragment newInstance() {
        SimulationFragment fragment = new SimulationFragment();
        return fragment;
    }
}

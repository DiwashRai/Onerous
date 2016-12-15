package cranfield.ssel.onerous;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

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

        Button toggleanim = (Button) view.findViewById(R.id.toggleanim);
        toggleanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Variables.animationsOn) Variables.animationsOn = false;
                else Variables.animationsOn = true;

                TextView animstatus = (TextView) view.findViewById(R.id.animstatus);
                if (Variables.animationsOn){
                    animstatus.setText("Animations: ON");
                    animstatus.setTextColor(Color.parseColor("#42B956"));
                }
                else {
                    animstatus.setText("Animations: OFF");
                    animstatus.setTextColor(Color.parseColor("#F73737"));
                }
            }
        });

        Button togglegraphics = (Button) view.findViewById(R.id.togglegraphics);
        togglegraphics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Variables.graphicsOn) Variables.graphicsOn = false;
                else Variables.graphicsOn = true;

                TextView graphicsstatus = (TextView) view.findViewById(R.id.graphicsstatus);
                if (Variables.graphicsOn){
                    graphicsstatus.setText("Graphics: ON");
                    graphicsstatus.setTextColor(Color.parseColor("#42B956"));
                }
                else {
                    graphicsstatus.setText("Graphics: OFF");
                    graphicsstatus.setTextColor(Color.parseColor("#F73737"));
                }
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

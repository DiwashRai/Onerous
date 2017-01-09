package cranfield.ssel.onerous;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ResultsFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.results_fragment,
                container, false);

        Button opHeliStats = (Button) view.findViewById(R.id.ophelistatsbtn);
        opHeliStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showOperationalHelistats(view);
            }
        });

        Button msrdworkingstats = (Button) view.findViewById(R.id.msrdworkingstatsbtn);
        msrdworkingstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showMSRDworkingstats(view);
            }
        });

        Button repairteamworkingstats = (Button) view.findViewById(R.id.repairteamworkingstatsbtn);
        repairteamworkingstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showRepairTeamWorkingstats(view);
            }
        });

        Button failedqstats = (Button) view.findViewById(R.id.failedqstatsbtn);
        failedqstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showFailedQueuestats(view);
            }
        });

        Button removeenginestats = (Button) view.findViewById(R.id.removeenginestatsbtn);
        removeenginestats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showRemoveEnginestats(view);
            }
        });

        Button transittorepairstats = (Button) view.findViewById(R.id.transittorepairstatsbtn);
        transittorepairstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showTransitToRepairstats(view);
            }
        });

        Button badengineqstats = (Button) view.findViewById(R.id.badengineqstatsbtn);
        badengineqstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showBadEngineQstats(view);
            }
        });

        Button enginerepairstats = (Button) view.findViewById(R.id.enginerepairstatsbtn);
        enginerepairstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showEngineRepairstats(view);
            }
        });

        Button transitfromrepairstats = (Button) view.findViewById(R.id.transitfromrepairstatsbtn);
        transitfromrepairstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showTransitFromRepairstats(view);
            }
        });

        Button goodengineqstats = (Button) view.findViewById(R.id.goodengineqstatsbtn);
        goodengineqstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showGoodEngineQstats(view);
            }
        });

        Button refitenginestats = (Button) view.findViewById(R.id.refitenginestatsbtn);
        refitenginestats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showRefitEnginestats(view);
            }
        });

        Button qforopstats = (Button) view.findViewById(R.id.qforopstatsbtn);
        qforopstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showQforOPstats(view);
            }
        });

        Button heliwaitstats = (Button) view.findViewById(R.id.heliwaitstatsbtn);
        heliwaitstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showHeliWaitstats(view);
            }
        });

        Button msrdidlesqstats = (Button) view.findViewById(R.id.msrdidlesqstatsbtn);
        msrdidlesqstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showMSRDidlestats(view);
            }
        });

        Button repairteamsidleqstats = (Button) view.findViewById(R.id.repairteamsidleqstatsbtn);
        repairteamsidleqstats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable(view );
                showRepairTeamidlestats(view);
            }
        });
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   NO AVAILABLE DATA   ");
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        LineChart chart = (LineChart) view.findViewById(R.id.graph);
        chart.setBackgroundColor(android.graphics.Color.rgb(229, 231, 233));

        return view;
    }

    public ResultsFragment(){
    }

    public static ResultsFragment newInstance() {
        ResultsFragment fragment = new ResultsFragment();
        return fragment;
    }

    public void clearTable(View view){
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        resultstable1.removeAllViews();
    }
    public void showOperationalHelistats(View view) {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   helicopters (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   available    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   available   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.operationalStats, resultstable1);

        populateGraph(view, Variables.opheliGraphPointNum, Variables.opHeliGraphData, "Operational Helicopters");
    }

    public void showMSRDworkingstats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   MSRD (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   working    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   working   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.MSRDWorkingStats, resultstable1);

        populateGraph(view,Variables.msrdIdleQGraphPointNum,Variables.msrdWorkingGraphData, "MSRD working");
    }

    public void showRepairTeamWorkingstats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   Teams (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   working    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   working   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.repairStats, resultstable1);

        populateGraph(view, Variables.engRepairGraphPointNum, Variables.engRepairGraphData, "Repair teams working");
    }

    public void showFailedQueuestats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   helicopters (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   available    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   available   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.qforRemovalStats, resultstable1);

        populateGraph(view, Variables.failedQGraphPointNum, Variables.failedQGraphData, "Failed engines awaiting removal");
    }

    public void showRemoveEnginestats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   removals (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   taking place   ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   taking place   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.removalStats, resultstable1);

        populateGraph(view, Variables.removeEngGraphPointNum, Variables.removeEngGraphData, "Engine removals taking place ");
    }

    public void showTransitToRepairstats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   engines (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   in transt    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   in transit   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.toWorkshopStats, resultstable1);

        populateGraph(view, Variables.toRepairGraphPointNum, Variables.toRepairGraphData, "Engines being transported for repair");
    }

    public void showBadEngineQstats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   engines (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   in queue    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   in queue   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.qforRepairStats, resultstable1);

        populateGraph(view, Variables.badEngQGraphPointNum, Variables.badEngQGraphData, "Bad engines awaiting repair");
    }

    public void showEngineRepairstats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   engines (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   undergoing repair    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   undergoing repair   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.repairStats, resultstable1);

        populateGraph(view, Variables.engRepairGraphPointNum, Variables.engRepairGraphData, "Engines being repaired");
    }

    public void showTransitFromRepairstats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   engines (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   in transit    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   in transit   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.toOperationStats, resultstable1);

        populateGraph(view, Variables.toOperationGraphPointNum, Variables.toOperationGraphData, "Repaired good engines being transported for refitting");
    }

    public void showGoodEngineQstats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   engines (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   in queue    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   in queue   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.qforRefitStats, resultstable1);

        populateGraph(view, Variables.goodEngQGraphPointNum, Variables.goodEngQGraphData, "Good engines await refit");
    }

    public void showRefitEnginestats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   refits (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   taking place    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   taking place   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.refitStats, resultstable1);

        populateGraph(view, Variables.refitEngGraphPointNum, Variables.refitEngGraphData, "Engine refits");
    }

    public void showQforOPstats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   helicopters (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   in queue    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   in queue   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.qforOperationalStats, resultstable1);

        populateGraph(view, Variables.qForOpGraphPointNum, Variables.qForOpGraphData, "Helicopters in queue ready for operation");
    }

    public void showHeliWaitstats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   helicopters (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   in queue    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   in queue   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.qHelisNoEngineStats, resultstable1);

        populateGraph(view, Variables.heliAwaitEngGraphPointNum, Variables.heliAwaitEngGraphData, "Helicopters waiting to be refitted with engine");
    }

    public void showMSRDidlestats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   MSRD (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   idle    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   idle   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.MSRDIdleStats, resultstable1);

        populateGraph(view,Variables.msrdIdleQGraphPointNum,Variables.msrdIdleQGraphData, "MSRD teams Idle");
    }

    public void showRepairTeamidlestats(View view)
    {
        TableLayout resultstable1 = (TableLayout) view.findViewById(R.id.table_main);
        TableRow toptablerow = new TableRow(this.getActivity());
        TextView tv0 = new TextView(this.getActivity());
        tv0.setText("   Number of   \n   Teams (N)   ");
        tv0.setGravity(Gravity.CENTER);
        tv0.setTextColor(Color.WHITE);
        toptablerow.addView(tv0);
        TextView tv1 = new TextView(this.getActivity());
        tv1.setText("   % time N   \n   idle    ");
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextColor(Color.WHITE);
        toptablerow.addView(tv1);
        TextView tv2 = new TextView(this.getActivity());
        tv2.setText("   % time N or more   \n   idle   ");
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextColor(Color.WHITE);
        toptablerow.addView(tv2);
        toptablerow.setGravity(Gravity.CENTER);
        resultstable1.addView(toptablerow);

        populateResultsTable(Variables.repairTeamsIdleStats, resultstable1);

        populateGraph(view, Variables.repairTeamIdleGraphPointNum, Variables.repairTeamIdleGraphData, "Repair teams idle");
    }

    public void populateResultsTable(ResultsData results, TableLayout table)
    {
        for (int i = 29; i > -1; i--) {

            if (results.getCumulative(i) > 0)
            {
                DecimalFormat df = new DecimalFormat("0.0");
                TableRow tbrow = new TableRow(this.getActivity());
                TextView resultTv1 = new TextView(this.getActivity());
                resultTv1.setText(Integer.toString(i));
                resultTv1.setTextColor(Color.BLACK);
                resultTv1.setGravity(Gravity.CENTER);
                tbrow.addView(resultTv1);
                TextView resultTv2 = new TextView(this.getActivity());
                resultTv2.setText(df.format(results.getNumber(i)));
                resultTv2.setTextColor(Color.BLACK);
                resultTv2.setGravity(Gravity.CENTER);
                tbrow.addView(resultTv2);
                TextView resultTv3 = new TextView(this.getActivity());
                resultTv3.setText(df.format(results.getCumulative(i)));
                resultTv3.setTextColor(Color.BLACK);
                resultTv3.setGravity(Gravity.CENTER);
                tbrow.addView(resultTv3);
                tbrow.setBackgroundColor(Color.parseColor("#E5E7E9"));
                tbrow.setGravity(Gravity.CENTER);
                table.addView(tbrow);
            }
        }
        DecimalFormat df = new DecimalFormat("0.000");
        TableRow tbrow = new TableRow(this.getActivity());
        TextView resultTv1 = new TextView((this.getActivity()));
        resultTv1.setText("   Mean:   " + df.format(results.getMean()));
        resultTv1.setTextColor(Color.WHITE);
        tbrow.addView(resultTv1);
        table.addView(tbrow);
    }

    public void populateGraph (View view, int graphPointNum, double [][] graphData, String dataSetlabel){
        LineChart chart = (LineChart) view.findViewById(R.id.graph);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);

        chart.getAxisRight().setEnabled(false);
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setDrawZeroLine(true);
        leftAxis.setDrawGridLines(false);
        leftAxis.setDrawAxisLine(true);

        if (graphPointNum ==0){
            chart.setBackgroundColor(android.graphics.Color.rgb(229,231,233));
            chart.invalidate();
        }
        else {
            List<Entry> entries = new ArrayList<Entry>();
            for (int i = 0; i < 4000; ++i) {
                if ((graphData[i][0] != 0) || (graphData[i][1] != 0)) {
                    entries.add(new Entry((float) graphData[i][0], (float) graphData[i][1]));
                }
            }

            LineDataSet dataSet = new LineDataSet(entries, dataSetlabel);
            dataSet.setDrawCircles(false);
            dataSet.setLineWidth(3);
            dataSet.setColor(android.graphics.Color.rgb(70, 130, 180));

            LineData lineData = new LineData(dataSet);
            chart.setBackgroundColor(android.graphics.Color.rgb(229, 231, 233));
            chart.setData(lineData);
            chart.invalidate();
        }
    }
}


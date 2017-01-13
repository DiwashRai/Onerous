package cranfield.ssel.onerous;

import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

/**
 * Created by diwash on 04/11/2016.
 */

public class SimGraphics{
    View view;

    ImageView[] opheliarray = new ImageView[20];
    ImageView[] failedarray = new ImageView[20];
    ImageView[] removeengarray = new ImageView[10];
    ImageView[] removemsrdarray = new ImageView[10];
    ImageView[] msrdidlearray = new ImageView[10];
    ImageView[] dummyQ1array = new ImageView[20];
    ImageView[] toworkshoparray = new ImageView[30];
    ImageView[] badenginearray = new ImageView[30];
    ImageView[] repairenginearray = new ImageView[10];
    ImageView[] repairteamarray = new ImageView[10];
    ImageView[] repairteamidlearray = new ImageView[10];
    ImageView[] heliwaitarray = new ImageView[20];
    ImageView[] dummyQ2array = new ImageView[20];
    ImageView[] tooperationarray = new ImageView[30];
    ImageView[] goodenginearray =  new ImageView[30];
    ImageView[] refitheliarray = new ImageView[10];
    ImageView[] refitengarray = new ImageView[10];
    ImageView[] refitmsrdarray = new ImageView[10];
    ImageView[] operationQarray = new ImageView[20];

    SimGraphics(View v){view = v;}

    public void setView (View v) {view = v;}

    public void switchImage (String node, int N, boolean state)
    {
        switch (node){
            case "Operational":
                if ((N-1)<0) return;
                opheliarray[0] = (ImageView) view.findViewById(R.id.opheli1);
                opheliarray[1] = (ImageView) view.findViewById(R.id.opheli2);
                opheliarray[2] = (ImageView) view.findViewById(R.id.opheli3);
                opheliarray[3] = (ImageView) view.findViewById(R.id.opheli4);
                opheliarray[4] = (ImageView) view.findViewById(R.id.opheli5);
                opheliarray[5] = (ImageView) view.findViewById(R.id.opheli6);
                opheliarray[6] = (ImageView) view.findViewById(R.id.opheli7);
                opheliarray[7] = (ImageView) view.findViewById(R.id.opheli8);
                opheliarray[8] = (ImageView) view.findViewById(R.id.opheli9);
                opheliarray[9] = (ImageView) view.findViewById(R.id.opheli10);
                opheliarray[10] = (ImageView) view.findViewById(R.id.opheli11);
                opheliarray[11] = (ImageView) view.findViewById(R.id.opheli12);
                opheliarray[12] = (ImageView) view.findViewById(R.id.opheli13);
                opheliarray[13] = (ImageView) view.findViewById(R.id.opheli14);
                opheliarray[14] = (ImageView) view.findViewById(R.id.opheli15);
                opheliarray[15] = (ImageView) view.findViewById(R.id.opheli16);
                opheliarray[16] = (ImageView) view.findViewById(R.id.opheli17);
                opheliarray[17] = (ImageView) view.findViewById(R.id.opheli18);
                opheliarray[18] = (ImageView) view.findViewById(R.id.opheli19);
                opheliarray[19] = (ImageView) view.findViewById(R.id.opheli20);
                if (state)opheliarray[N-1].setVisibility(View.VISIBLE);
                else opheliarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "Failed":
                if ((N-1)<0) return;
                failedarray[0] = (ImageView) view.findViewById(R.id.failedheli1);
                failedarray[1] = (ImageView) view.findViewById(R.id.failedheli2);
                failedarray[2] = (ImageView) view.findViewById(R.id.failedheli3);
                failedarray[3] = (ImageView) view.findViewById(R.id.failedheli4);
                failedarray[4] = (ImageView) view.findViewById(R.id.failedheli5);
                failedarray[5] = (ImageView) view.findViewById(R.id.failedheli6);
                failedarray[6] = (ImageView) view.findViewById(R.id.failedheli7);
                failedarray[7] = (ImageView) view.findViewById(R.id.failedheli8);
                failedarray[8] = (ImageView) view.findViewById(R.id.failedheli9);
                failedarray[9] = (ImageView) view.findViewById(R.id.failedheli10);
                failedarray[10] = (ImageView) view.findViewById(R.id.failedheli11);
                failedarray[11] = (ImageView) view.findViewById(R.id.failedheli12);
                failedarray[12] = (ImageView) view.findViewById(R.id.failedheli13);
                failedarray[13] = (ImageView) view.findViewById(R.id.failedheli14);
                failedarray[14] = (ImageView) view.findViewById(R.id.failedheli15);
                failedarray[15] = (ImageView) view.findViewById(R.id.failedheli16);
                failedarray[16] = (ImageView) view.findViewById(R.id.failedheli17);
                failedarray[17] = (ImageView) view.findViewById(R.id.failedheli18);
                failedarray[18] = (ImageView) view.findViewById(R.id.failedheli19);
                failedarray[19] = (ImageView) view.findViewById(R.id.failedheli20);
                if (state) failedarray[N-1].setVisibility(View.VISIBLE);
                else failedarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "RemoveEng":
                if ((N-1)<0) return;
                removeengarray[0] = (ImageView) view.findViewById(R.id.removeheli1);
                removeengarray[1] = (ImageView) view.findViewById(R.id.removeheli2);
                removeengarray[2] = (ImageView) view.findViewById(R.id.removeheli3);
                removeengarray[3] = (ImageView) view.findViewById(R.id.removeheli4);
                removeengarray[4] = (ImageView) view.findViewById(R.id.removeheli5);
                removeengarray[5] = (ImageView) view.findViewById(R.id.removeheli6);
                removeengarray[6] = (ImageView) view.findViewById(R.id.removeheli7);
                removeengarray[7] = (ImageView) view.findViewById(R.id.removeheli8);
                removeengarray[8] = (ImageView) view.findViewById(R.id.removeheli9);
                removeengarray[9] = (ImageView) view.findViewById(R.id.removeheli10);
                if(state) removeengarray[N-1].setVisibility(View.VISIBLE);
                else removeengarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "RemoveMSRD":
                if ((N-1)<0) return;
                removemsrdarray[0] = (ImageView) view.findViewById(R.id.removemsrd1);
                removemsrdarray[1] = (ImageView) view.findViewById(R.id.removemsrd2);
                removemsrdarray[2] = (ImageView) view.findViewById(R.id.removemsrd3);
                removemsrdarray[3] = (ImageView) view.findViewById(R.id.removemsrd4);
                removemsrdarray[4] = (ImageView) view.findViewById(R.id.removemsrd5);
                removemsrdarray[5] = (ImageView) view.findViewById(R.id.removemsrd6);
                removemsrdarray[6] = (ImageView) view.findViewById(R.id.removemsrd7);
                removemsrdarray[7] = (ImageView) view.findViewById(R.id.removemsrd8);
                removemsrdarray[8] = (ImageView) view.findViewById(R.id.removemsrd9);
                removemsrdarray[9] = (ImageView) view.findViewById(R.id.removemsrd10);
                if (state) removemsrdarray[N-1].setVisibility(View.VISIBLE);
                else removemsrdarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "MSRDidle":
                if ((N-1)<0) return;
                msrdidlearray[0] = (ImageView) view.findViewById(R.id.msrdidle1);
                msrdidlearray[1] = (ImageView) view.findViewById(R.id.msrdidle2);
                msrdidlearray[2] = (ImageView) view.findViewById(R.id.msrdidle3);
                msrdidlearray[3] = (ImageView) view.findViewById(R.id.msrdidle4);
                msrdidlearray[4] = (ImageView) view.findViewById(R.id.msrdidle5);
                msrdidlearray[5] = (ImageView) view.findViewById(R.id.msrdidle6);
                msrdidlearray[6] = (ImageView) view.findViewById(R.id.msrdidle7);
                msrdidlearray[7] = (ImageView) view.findViewById(R.id.msrdidle8);
                msrdidlearray[8] = (ImageView) view.findViewById(R.id.msrdidle9);
                msrdidlearray[9] = (ImageView) view.findViewById(R.id.msrdidle10);
                if (state) msrdidlearray[N-1].setVisibility(View.VISIBLE);
                else msrdidlearray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "DummyQ1":
                // Redundant case????///////////////////////////
                break;
            case "ToWorkshop":
                if ((N-1)<0) return;
                toworkshoparray[0] = (ImageView) view.findViewById(R.id.toworkshopengine1);
                toworkshoparray[1] = (ImageView) view.findViewById(R.id.toworkshopengine2);
                toworkshoparray[2] = (ImageView) view.findViewById(R.id.toworkshopengine3);
                toworkshoparray[3] = (ImageView) view.findViewById(R.id.toworkshopengine4);
                toworkshoparray[4] = (ImageView) view.findViewById(R.id.toworkshopengine5);
                toworkshoparray[5] = (ImageView) view.findViewById(R.id.toworkshopengine6);
                toworkshoparray[6] = (ImageView) view.findViewById(R.id.toworkshopengine7);
                toworkshoparray[7] = (ImageView) view.findViewById(R.id.toworkshopengine8);
                toworkshoparray[8] = (ImageView) view.findViewById(R.id.toworkshopengine9);
                toworkshoparray[9] = (ImageView) view.findViewById(R.id.toworkshopengine10);
                toworkshoparray[10] = (ImageView) view.findViewById(R.id.toworkshopengine11);
                toworkshoparray[11] = (ImageView) view.findViewById(R.id.toworkshopengine12);
                toworkshoparray[12] = (ImageView) view.findViewById(R.id.toworkshopengine13);
                toworkshoparray[13] = (ImageView) view.findViewById(R.id.toworkshopengine14);
                toworkshoparray[14] = (ImageView) view.findViewById(R.id.toworkshopengine15);
                toworkshoparray[15] = (ImageView) view.findViewById(R.id.toworkshopengine16);
                toworkshoparray[16] = (ImageView) view.findViewById(R.id.toworkshopengine17);
                toworkshoparray[17] = (ImageView) view.findViewById(R.id.toworkshopengine18);
                toworkshoparray[18] = (ImageView) view.findViewById(R.id.toworkshopengine19);
                toworkshoparray[19] = (ImageView) view.findViewById(R.id.toworkshopengine20);
                toworkshoparray[20] = (ImageView) view.findViewById(R.id.toworkshopengine21);
                toworkshoparray[21] = (ImageView) view.findViewById(R.id.toworkshopengine22);
                toworkshoparray[22] = (ImageView) view.findViewById(R.id.toworkshopengine23);
                toworkshoparray[23] = (ImageView) view.findViewById(R.id.toworkshopengine24);
                toworkshoparray[24] = (ImageView) view.findViewById(R.id.toworkshopengine25);
                toworkshoparray[25] = (ImageView) view.findViewById(R.id.toworkshopengine26);
                toworkshoparray[26] = (ImageView) view.findViewById(R.id.toworkshopengine27);
                toworkshoparray[27] = (ImageView) view.findViewById(R.id.toworkshopengine28);
                toworkshoparray[28] = (ImageView) view.findViewById(R.id.toworkshopengine29);
                toworkshoparray[29] = (ImageView) view.findViewById(R.id.toworkshopengine30);
                if (state)toworkshoparray[N-1].setVisibility(View.VISIBLE);
                else toworkshoparray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "BadEngine":
                if ((N-1)<0) return;
                badenginearray[0] = (ImageView) view.findViewById(R.id.badengine1);
                badenginearray[1] = (ImageView) view.findViewById(R.id.badengine2);
                badenginearray[2] = (ImageView) view.findViewById(R.id.badengine3);
                badenginearray[3] = (ImageView) view.findViewById(R.id.badengine4);
                badenginearray[4] = (ImageView) view.findViewById(R.id.badengine5);
                badenginearray[5] = (ImageView) view.findViewById(R.id.badengine6);
                badenginearray[6] = (ImageView) view.findViewById(R.id.badengine7);
                badenginearray[7] = (ImageView) view.findViewById(R.id.badengine8);
                badenginearray[8] = (ImageView) view.findViewById(R.id.badengine9);
                badenginearray[9] = (ImageView) view.findViewById(R.id.badengine10);
                badenginearray[10] = (ImageView) view.findViewById(R.id.badengine11);
                badenginearray[11] = (ImageView) view.findViewById(R.id.badengine12);
                badenginearray[12] = (ImageView) view.findViewById(R.id.badengine13);
                badenginearray[13] = (ImageView) view.findViewById(R.id.badengine14);
                badenginearray[14] = (ImageView) view.findViewById(R.id.badengine15);
                badenginearray[15] = (ImageView) view.findViewById(R.id.badengine16);
                badenginearray[16] = (ImageView) view.findViewById(R.id.badengine17);
                badenginearray[17] = (ImageView) view.findViewById(R.id.badengine18);
                badenginearray[18] = (ImageView) view.findViewById(R.id.badengine19);
                badenginearray[19] = (ImageView) view.findViewById(R.id.badengine20);
                badenginearray[20] = (ImageView) view.findViewById(R.id.badengine21);
                badenginearray[21] = (ImageView) view.findViewById(R.id.badengine22);
                badenginearray[22] = (ImageView) view.findViewById(R.id.badengine23);
                badenginearray[23] = (ImageView) view.findViewById(R.id.badengine24);
                badenginearray[24] = (ImageView) view.findViewById(R.id.badengine25);
                badenginearray[25] = (ImageView) view.findViewById(R.id.badengine26);
                badenginearray[26] = (ImageView) view.findViewById(R.id.badengine27);
                badenginearray[27] = (ImageView) view.findViewById(R.id.badengine28);
                badenginearray[28] = (ImageView) view.findViewById(R.id.badengine29);
                badenginearray[29] = (ImageView) view.findViewById(R.id.badengine30);
                if (state) badenginearray[N-1].setVisibility(View.VISIBLE);
                else badenginearray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "RepairEngine":
                if ((N-1)<0) return;
                repairenginearray[0] = (ImageView) view.findViewById(R.id.repairengine1);
                repairenginearray[1] = (ImageView) view.findViewById(R.id.repairengine2);
                repairenginearray[2] = (ImageView) view.findViewById(R.id.repairengine3);
                repairenginearray[3] = (ImageView) view.findViewById(R.id.repairengine4);
                repairenginearray[4] = (ImageView) view.findViewById(R.id.repairengine5);
                repairenginearray[5] = (ImageView) view.findViewById(R.id.repairengine6);
                repairenginearray[6] = (ImageView) view.findViewById(R.id.repairengine7);
                repairenginearray[7] = (ImageView) view.findViewById(R.id.repairengine8);
                repairenginearray[8] = (ImageView) view.findViewById(R.id.repairengine9);
                repairenginearray[9] = (ImageView) view.findViewById(R.id.repairengine10);
                if (state) repairenginearray[N-1].setVisibility(View.VISIBLE);
                else repairenginearray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "RepairTeam":
                if ((N-1)<0) return;
                repairteamarray[0] = (ImageView) view.findViewById(R.id.repairteam1);
                repairteamarray[1] = (ImageView) view.findViewById(R.id.repairteam2);
                repairteamarray[2] = (ImageView) view.findViewById(R.id.repairteam3);
                repairteamarray[3] = (ImageView) view.findViewById(R.id.repairteam4);
                repairteamarray[4] = (ImageView) view.findViewById(R.id.repairteam5);
                repairteamarray[5] = (ImageView) view.findViewById(R.id.repairteam6);
                repairteamarray[6] = (ImageView) view.findViewById(R.id.repairteam7);
                repairteamarray[7] = (ImageView) view.findViewById(R.id.repairteam8);
                repairteamarray[8] = (ImageView) view.findViewById(R.id.repairteam9);
                repairteamarray[9] = (ImageView) view.findViewById(R.id.repairteam10);
                if (state) repairteamarray[N-1].setVisibility(View.VISIBLE);
                else repairteamarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "RepairTeamIdle":
                if ((N-1)<0) return;
                repairteamidlearray[0] = (ImageView) view.findViewById(R.id.idlerepair1);
                repairteamidlearray[1] = (ImageView) view.findViewById(R.id.idlerepair2);
                repairteamidlearray[2] = (ImageView) view.findViewById(R.id.idlerepair3);
                repairteamidlearray[3] = (ImageView) view.findViewById(R.id.idlerepair4);
                repairteamidlearray[4] = (ImageView) view.findViewById(R.id.idlerepair5);
                repairteamidlearray[5] = (ImageView) view.findViewById(R.id.idlerepair6);
                repairteamidlearray[6] = (ImageView) view.findViewById(R.id.idlerepair7);
                repairteamidlearray[7] = (ImageView) view.findViewById(R.id.idlerepair8);
                repairteamidlearray[8] = (ImageView) view.findViewById(R.id.idlerepair9);
                repairteamidlearray[9] = (ImageView) view.findViewById(R.id.idlerepair10);
                if (state) repairteamidlearray[N-1].setVisibility(View.VISIBLE);
                else repairteamidlearray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "HeliWait":
                if ((N-1)<0) return;
                heliwaitarray[0] = (ImageView) view.findViewById(R.id.awaitengineheli1);
                heliwaitarray[1] = (ImageView) view.findViewById(R.id.awaitengineheli2);
                heliwaitarray[2] = (ImageView) view.findViewById(R.id.awaitengineheli3);
                heliwaitarray[3] = (ImageView) view.findViewById(R.id.awaitengineheli4);
                heliwaitarray[4] = (ImageView) view.findViewById(R.id.awaitengineheli5);
                heliwaitarray[5] = (ImageView) view.findViewById(R.id.awaitengineheli6);
                heliwaitarray[6] = (ImageView) view.findViewById(R.id.awaitengineheli7);
                heliwaitarray[7] = (ImageView) view.findViewById(R.id.awaitengineheli8);
                heliwaitarray[8] = (ImageView) view.findViewById(R.id.awaitengineheli9);
                heliwaitarray[9] = (ImageView) view.findViewById(R.id.awaitengineheli10);
                heliwaitarray[10] = (ImageView) view.findViewById(R.id.awaitengineheli11);
                heliwaitarray[11] = (ImageView) view.findViewById(R.id.awaitengineheli12);
                heliwaitarray[12] = (ImageView) view.findViewById(R.id.awaitengineheli13);
                heliwaitarray[13] = (ImageView) view.findViewById(R.id.awaitengineheli14);
                heliwaitarray[14] = (ImageView) view.findViewById(R.id.awaitengineheli15);
                heliwaitarray[15] = (ImageView) view.findViewById(R.id.awaitengineheli16);
                heliwaitarray[16] = (ImageView) view.findViewById(R.id.awaitengineheli17);
                heliwaitarray[17] = (ImageView) view.findViewById(R.id.awaitengineheli18);
                heliwaitarray[18] = (ImageView) view.findViewById(R.id.awaitengineheli19);
                heliwaitarray[19] = (ImageView) view.findViewById(R.id.awaitengineheli20);
                if (state) heliwaitarray[N-1].setVisibility(View.VISIBLE);
                else heliwaitarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "DummyQ2" :
                /// Redundant case currently
                break;
            case "ToOperation":
                if ((N-1)<0) return;
                tooperationarray[0] = (ImageView) view.findViewById(R.id.tooperationengine1);
                tooperationarray[1] = (ImageView) view.findViewById(R.id.tooperationengine2);
                tooperationarray[2] = (ImageView) view.findViewById(R.id.tooperationengine3);
                tooperationarray[3] = (ImageView) view.findViewById(R.id.tooperationengine4);
                tooperationarray[4] = (ImageView) view.findViewById(R.id.tooperationengine5);
                tooperationarray[5] = (ImageView) view.findViewById(R.id.tooperationengine6);
                tooperationarray[6] = (ImageView) view.findViewById(R.id.tooperationengine7);
                tooperationarray[7] = (ImageView) view.findViewById(R.id.tooperationengine8);
                tooperationarray[8] = (ImageView) view.findViewById(R.id.tooperationengine9);
                tooperationarray[9] = (ImageView) view.findViewById(R.id.tooperationengine10);
                tooperationarray[10] = (ImageView) view.findViewById(R.id.tooperationengine11);
                tooperationarray[11] = (ImageView) view.findViewById(R.id.tooperationengine12);
                tooperationarray[12] = (ImageView) view.findViewById(R.id.tooperationengine13);
                tooperationarray[13] = (ImageView) view.findViewById(R.id.tooperationengine14);
                tooperationarray[14] = (ImageView) view.findViewById(R.id.tooperationengine15);
                tooperationarray[15] = (ImageView) view.findViewById(R.id.tooperationengine16);
                tooperationarray[16] = (ImageView) view.findViewById(R.id.tooperationengine17);
                tooperationarray[17] = (ImageView) view.findViewById(R.id.tooperationengine18);
                tooperationarray[18] = (ImageView) view.findViewById(R.id.tooperationengine19);
                tooperationarray[19] = (ImageView) view.findViewById(R.id.tooperationengine20);
                tooperationarray[20] = (ImageView) view.findViewById(R.id.tooperationengine21);
                tooperationarray[21] = (ImageView) view.findViewById(R.id.tooperationengine22);
                tooperationarray[22] = (ImageView) view.findViewById(R.id.tooperationengine23);
                tooperationarray[23] = (ImageView) view.findViewById(R.id.tooperationengine24);
                tooperationarray[24] = (ImageView) view.findViewById(R.id.tooperationengine25);
                tooperationarray[25] = (ImageView) view.findViewById(R.id.tooperationengine26);
                tooperationarray[26] = (ImageView) view.findViewById(R.id.tooperationengine27);
                tooperationarray[27] = (ImageView) view.findViewById(R.id.tooperationengine28);
                tooperationarray[28] = (ImageView) view.findViewById(R.id.tooperationengine29);
                tooperationarray[29] = (ImageView) view.findViewById(R.id.tooperationengine30);
                if (state) tooperationarray[N-1].setVisibility(View.VISIBLE);
                else tooperationarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "GoodEngine":
                if ((N-1)<0) return;
                goodenginearray[0] = (ImageView) view.findViewById(R.id.goodengine1);
                goodenginearray[1] = (ImageView) view.findViewById(R.id.goodengine2);
                goodenginearray[2] = (ImageView) view.findViewById(R.id.goodengine3);
                goodenginearray[3] = (ImageView) view.findViewById(R.id.goodengine4);
                goodenginearray[4] = (ImageView) view.findViewById(R.id.goodengine5);
                goodenginearray[5] = (ImageView) view.findViewById(R.id.goodengine6);
                goodenginearray[6] = (ImageView) view.findViewById(R.id.goodengine7);
                goodenginearray[7] = (ImageView) view.findViewById(R.id.goodengine8);
                goodenginearray[8] = (ImageView) view.findViewById(R.id.goodengine9);
                goodenginearray[9] = (ImageView) view.findViewById(R.id.goodengine10);
                goodenginearray[10] = (ImageView) view.findViewById(R.id.goodengine11);
                goodenginearray[11] = (ImageView) view.findViewById(R.id.goodengine12);
                goodenginearray[12] = (ImageView) view.findViewById(R.id.goodengine13);
                goodenginearray[13] = (ImageView) view.findViewById(R.id.goodengine14);
                goodenginearray[14] = (ImageView) view.findViewById(R.id.goodengine15);
                goodenginearray[15] = (ImageView) view.findViewById(R.id.goodengine16);
                goodenginearray[16] = (ImageView) view.findViewById(R.id.goodengine17);
                goodenginearray[17] = (ImageView) view.findViewById(R.id.goodengine18);
                goodenginearray[18] = (ImageView) view.findViewById(R.id.goodengine19);
                goodenginearray[19] = (ImageView) view.findViewById(R.id.goodengine20);
                goodenginearray[20] = (ImageView) view.findViewById(R.id.goodengine21);
                goodenginearray[21] = (ImageView) view.findViewById(R.id.goodengine22);
                goodenginearray[22] = (ImageView) view.findViewById(R.id.goodengine23);
                goodenginearray[23] = (ImageView) view.findViewById(R.id.goodengine24);
                goodenginearray[24] = (ImageView) view.findViewById(R.id.goodengine25);
                goodenginearray[25] = (ImageView) view.findViewById(R.id.goodengine26);
                goodenginearray[26] = (ImageView) view.findViewById(R.id.goodengine27);
                goodenginearray[27] = (ImageView) view.findViewById(R.id.goodengine28);
                goodenginearray[28] = (ImageView) view.findViewById(R.id.goodengine29);
                goodenginearray[29] = (ImageView) view.findViewById(R.id.goodengine30);
                if (state) goodenginearray[N-1].setVisibility(View.VISIBLE);
                else goodenginearray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "RefitHeli":
                if ((N-1)<0) return;
                refitheliarray[0] = (ImageView) view.findViewById(R.id.refitheli1);
                refitheliarray[1] = (ImageView) view.findViewById(R.id.refitheli2);
                refitheliarray[2] = (ImageView) view.findViewById(R.id.refitheli3);
                refitheliarray[3] = (ImageView) view.findViewById(R.id.refitheli4);
                refitheliarray[4] = (ImageView) view.findViewById(R.id.refitheli5);
                refitheliarray[5] = (ImageView) view.findViewById(R.id.refitheli6);
                refitheliarray[6] = (ImageView) view.findViewById(R.id.refitheli7);
                refitheliarray[7] = (ImageView) view.findViewById(R.id.refitheli8);
                refitheliarray[8] = (ImageView) view.findViewById(R.id.refitheli9);
                refitheliarray[9] = (ImageView) view.findViewById(R.id.refitheli10);
                if (state) refitheliarray[N-1].setVisibility(View.VISIBLE);
                else refitheliarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "RefitEng":
                if ((N-1)<0) return;
                refitengarray[0] = (ImageView) view.findViewById(R.id.refitengine1);
                refitengarray[1] = (ImageView) view.findViewById(R.id.refitengine2);
                refitengarray[2] = (ImageView) view.findViewById(R.id.refitengine3);
                refitengarray[3] = (ImageView) view.findViewById(R.id.refitengine4);
                refitengarray[4] = (ImageView) view.findViewById(R.id.refitengine5);
                refitengarray[5] = (ImageView) view.findViewById(R.id.refitengine6);
                refitengarray[6] = (ImageView) view.findViewById(R.id.refitengine7);
                refitengarray[7] = (ImageView) view.findViewById(R.id.refitengine8);
                refitengarray[8] = (ImageView) view.findViewById(R.id.refitengine9);
                refitengarray[9] = (ImageView) view.findViewById(R.id.refitengine10);
                if (state) refitengarray[N-1].setVisibility(View.VISIBLE);
                else refitengarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "RefitMSRD":
                if ((N-1)<0) return;
                refitmsrdarray[0] = (ImageView) view.findViewById(R.id.refitmsrd1);
                refitmsrdarray[1] = (ImageView) view.findViewById(R.id.refitmsrd2);
                refitmsrdarray[2] = (ImageView) view.findViewById(R.id.refitmsrd3);
                refitmsrdarray[3] = (ImageView) view.findViewById(R.id.refitmsrd4);
                refitmsrdarray[4] = (ImageView) view.findViewById(R.id.refitmsrd5);
                refitmsrdarray[5] = (ImageView) view.findViewById(R.id.refitmsrd6);
                refitmsrdarray[6] = (ImageView) view.findViewById(R.id.refitmsrd7);
                refitmsrdarray[7] = (ImageView) view.findViewById(R.id.refitmsrd8);
                refitmsrdarray[8] = (ImageView) view.findViewById(R.id.refitmsrd9);
                refitmsrdarray[9] = (ImageView) view.findViewById(R.id.refitmsrd10);
                if (state) refitmsrdarray[N-1].setVisibility(View.VISIBLE);
                else refitmsrdarray[N-1].setVisibility(View.INVISIBLE);
                break;
            case "OperationalQ":
                if ((N-1)<0) return;
                operationQarray[0] = (ImageView) view.findViewById(R.id.qforopheli1);
                operationQarray[1] = (ImageView) view.findViewById(R.id.qforopheli2);
                operationQarray[2] = (ImageView) view.findViewById(R.id.qforopheli3);
                operationQarray[3] = (ImageView) view.findViewById(R.id.qforopheli4);
                operationQarray[4] = (ImageView) view.findViewById(R.id.qforopheli5);
                operationQarray[5] = (ImageView) view.findViewById(R.id.qforopheli6);
                operationQarray[6] = (ImageView) view.findViewById(R.id.qforopheli7);
                operationQarray[7] = (ImageView) view.findViewById(R.id.qforopheli8);
                operationQarray[8] = (ImageView) view.findViewById(R.id.qforopheli9);
                operationQarray[9] = (ImageView) view.findViewById(R.id.qforopheli10);
                operationQarray[10] = (ImageView) view.findViewById(R.id.qforopheli11);
                operationQarray[11] = (ImageView) view.findViewById(R.id.qforopheli12);
                operationQarray[12] = (ImageView) view.findViewById(R.id.qforopheli13);
                operationQarray[13] = (ImageView) view.findViewById(R.id.qforopheli14);
                operationQarray[14] = (ImageView) view.findViewById(R.id.qforopheli15);
                operationQarray[15] = (ImageView) view.findViewById(R.id.qforopheli16);
                operationQarray[16] = (ImageView) view.findViewById(R.id.qforopheli17);
                operationQarray[17] = (ImageView) view.findViewById(R.id.qforopheli18);
                operationQarray[18] = (ImageView) view.findViewById(R.id.qforopheli19);
                operationQarray[19] = (ImageView) view.findViewById(R.id.qforopheli20);
                if (state) operationQarray[N-1].setVisibility(View.VISIBLE);
                else operationQarray[N-1].setVisibility(View.INVISIBLE);
                break;
            default:
            {
                System.out.println("Invalid switchImage command");
            }
        }
    }

    public void resetImage ()
    {
        //Operational, Failed, RemoveEng, RemoveMSRD, MSRDidle, DummyQ1, ToWorkshop,
        //BadEngine, RepairEngine, RepairTeam, RepairTeamIdle, HeliWait, DummyQ2,
        //ToOperation, GoodEngine, RefitHeli, RefitEng, RefitMSRD, OperationalQ

        for (int i = 1; i < 21; i++)
        {
            if ((i <= Variables.maxHelicopters) && (i <= Variables.helicopters)) switchImage("Operational", i, true);
            else switchImage("Operational", i, false);
        }

        for (int i = 1; i < 21; i++)
        {
            if (i <= (Variables.helicopters - Variables.maxHelicopters)) switchImage("OperationalQ",i,true);
            else switchImage("OperationalQ",i,false);
        }

        for (int i = 1; i < 21; i++) switchImage("Failed", i, false);

        for (int i = 1; i < 11; i++)
        {
            switchImage("RemoveEng",i,false);
            switchImage("RemoveMSRD",i,false);
        }

        for (int i = 1; i < 11; i++)
        {
            if (i <= Variables.MSRD) switchImage("MSRDidle",i,true);
            else switchImage("MSRDidle",i,false);
        }

        for (int i = 1; i < 21; i++)
        {
            //DQ1
        }

        for (int i = 1; i < 31; i++) switchImage("ToWorkshop",i,false);

        for (int i = 1; i < 31; i++) switchImage("BadEngine",i,false);

        for (int i = 1; i < 11; i++)
        {
            switchImage("RepairEngine",i,false);
            switchImage("RepairTeam",i,false);
        }

        for (int i = 1; i < 11; i++)
        {
            if (i <= Variables.repairTeams) switchImage("RepairTeamIdle",i,true);
            else switchImage("RepairTeamIdle",i,false);
        }

        for (int i = 1; i < 21; i++) switchImage("HeliWait",i,false);

        for (int i = 1; i < 21; i++)
        {
            //DQ2
        }

        for (int i = 1; i < 31; i++) switchImage("ToOperation",i,false);

        for (int i = 1; i < 31; i++)
        {
            if (i <= Variables.spareEngines) switchImage("GoodEngine",i,true);
            else switchImage("GoodEngine",i,false);
        }

        for (int i = 1; i < 11; i++)
        {
            switchImage("RefitHeli",i,false);
            switchImage("RefitEng",i,false);
            switchImage("RefitMSRD",i,false);
        }

        Switch graphicsSwitch = (Switch) view.findViewById(R.id.graphicsSwitch);
        Switch animationSwitch = (Switch) view.findViewById(R.id.animationSwitch);

        if (Variables.graphicsOn) graphicsSwitch.setChecked(true);
        else graphicsSwitch.setChecked(false);

        if (Variables.animationsOn) animationSwitch.setChecked(true);
        else animationSwitch.setChecked(false);
    }
}

package cranfield.ssel.onerous;


import android.os.Handler;
import android.view.View;

/**
 * Created by diwash on 20/10/2016.
 */
public class Events {
    Stats stats = new Stats();

    View view;
    Handler handler;
    SimMethods sim = new SimMethods(view, handler);

    SimGraphics graphics = new SimGraphics(view);
    SimAnimations anims = new SimAnimations(view);

    public Events (View v, Handler h) {view = v; handler = h; graphics.setView(view); anims.setView(view);}

    public void engineFails ()   //numOperational -1. numQforRemoval +1
    {
        stats.updateStats(Variables.operationalStats, Variables.numOperational );
        doGraphic("Operational",Variables.numOperational,false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveOpToFailed();
                }
            });
            try {Thread.sleep(1000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        if ((Variables.opheliGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("opHeli");
        }
        Variables.numOperational = Variables.numOperational - 1;
        if ((Variables.opheliGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("opHeli");
        }

        stats.updateStats(Variables.qforRemovalStats, Variables.numQforRemoval);

        if ((Variables.failedQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("failedQ");
        }
        Variables.numQforRemoval = Variables.numQforRemoval + 1;
        if ((Variables.failedQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("failedQ");
        }
        doGraphic("Failed",Variables.numQforRemoval,true);

        startOperational();
        startRemoval();
    }

    public void startRemoval () //numQforRemoval -1. numRemoval +1. numMSRDIdle -1.
    {
        double t;
        EventData N = new EventData();
        if ((Variables.numQforRemoval > 0) && (Variables.numMSRDIdle > 0))
        {
            stats.updateStats(Variables.qforRemovalStats, Variables.numQforRemoval);
            doGraphic("Failed",Variables.numQforRemoval,false);

            if ((Variables.failedQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("failedQ");
            }
            Variables.numQforRemoval = Variables.numQforRemoval - 1;
            if ((Variables.failedQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("failedQ");
            }
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveFailedToRemove();
                    }
                });
                try {Thread.sleep(2000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }

            stats.updateStats(Variables.removalStats, Variables.numRemoval);

            if ((Variables.removeEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("removeEng");
            }
            Variables.numRemoval = Variables.numRemoval + 1;
            if ((Variables.removeEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("removeEng");
            }

            doGraphic("RemoveEng", Variables.numRemoval, true);

            stats.updateStats(Variables.MSRDIdleStats, Variables.numMSRDIdle);
            doGraphic("MSRDidle", Variables.numMSRDIdle,false);

            if ((Variables.msrdIdleQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("msrdIdleQ");
            }
            Variables.numMSRDIdle = Variables.numMSRDIdle - 1;
            if ((Variables.msrdIdleQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("msrdIdleQ");
            }

            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveMSRDtoRemove();
                    }
                });
                try {Thread.sleep(2500);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            doGraphic("RemoveMSRD", Variables.numRemoval, true);

            t = stats.getDuration(Variables.removalTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(2);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endRemoval () // numQHelisNoEngine +1.  numMSRDIdle +1. numQforToWorkshop +1. numRemoval -1.
    {
        stats.updateStats(Variables.qHelisNoEngineStats, Variables.numQHelisNoEngine);

        if ((Variables.heliAwaitEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("heliAwaitEng");
        }
        Variables.numQHelisNoEngine = Variables.numQHelisNoEngine + 1;
        if ((Variables.heliAwaitEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("heliAwaitEng");
        }

        doGraphic("RemoveEng", Variables.numRemoval, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveRemoveToHeliWait();
                }
            });
            try {Thread.sleep(3000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        doGraphic("HeliWait",Variables.numQHelisNoEngine, true);

        stats.updateStats(Variables.MSRDIdleStats, Variables.numMSRDIdle);

        if ((Variables.msrdIdleQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("msrdIdleQ");
        }
        Variables.numMSRDIdle = Variables.numMSRDIdle + 1;
        if ((Variables.msrdIdleQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("msrdIdleQ");
        }

        doGraphic("RemoveMSRD",Variables.numRemoval, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveRemovetoMSRDidle();
                }
            });
            try {Thread.sleep(2500);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        doGraphic("MSRDidle",Variables.numMSRDIdle, true);

        stats.updateStats(Variables.qforToWorkshopStats, Variables.numQforToWorkshop);

        //DummyQ1 node.
        Variables.numQforToWorkshop = Variables.numQforToWorkshop + 1;

        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveRemovetoDQ1();
                }
            });
            try {Thread.sleep(2400);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        doGraphic("DummyQ1", Variables.numQforToWorkshop, true);

        stats.updateStats(Variables.removalStats, Variables.numRemoval);

        if ((Variables.removeEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("removeEng");
        }
        Variables.numRemoval = Variables.numRemoval - 1;
        if ((Variables.removeEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("removeEng");
        }

        startToWorkshop();
        startRefit();
        startRemoval();
    }

    public void startToWorkshop () // numQforToWorkshop -1. numToWorkshop +1.
    {
        double t;
        EventData N = new EventData();

        if (Variables.numQforToWorkshop > 0)
        {
            stats.updateStats(Variables.qforToWorkshopStats, Variables.numQforToWorkshop);
            doGraphic("DummyQ1", Variables.numQforToWorkshop, false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveDQ1toTransport();
                    }
                });
                try {Thread.sleep(2400);}
                catch (InterruptedException e) {e.printStackTrace();}
            }

            //DummyQ1 node.
            Variables.numQforToWorkshop = Variables.numQforToWorkshop - 1;

            stats.updateStats(Variables.toWorkshopStats, Variables.numToWorkshop);

            if ((Variables.toRepairGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("toRepair");
            }
            Variables.numToWorkshop = Variables.numToWorkshop + 1;
            if ((Variables.toRepairGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("toRepair");
            }
            doGraphic("ToWorkshop",Variables.numToWorkshop, true);

            t = stats.getDuration(Variables.toWorkshopTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(3);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endToWorkshop () // numToWorkshop -1. numQforRepair +1.
    {
        stats.updateStats(Variables.toWorkshopStats, Variables.numToWorkshop);
        doGraphic("ToWorkshop",Variables.numToWorkshop, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveTransportToBadEng();
                }
            });
            try {Thread.sleep(3000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }

        if ((Variables.toRepairGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("toRepair");
        }
        Variables.numToWorkshop = Variables.numToWorkshop - 1;
        if ((Variables.toRepairGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("toRepair");
        }

        stats.updateStats(Variables.qforRepairStats, Variables.numQforRepair);

        if ((Variables.badEngQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("badEngQ");
        }
        Variables.numQforRepair = Variables.numQforRepair + 1;
        if ((Variables.badEngQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("badEngQ");
        }

        doGraphic("BadEngine",Variables.numQforRepair, true);

        startRepair();
    }

    public void startRefit () // numRefit +1. numQHelisNoEngine -1. numQforRefit -1. numMSRDIdle -1.
    {
        double t;
        EventData N = new EventData();

        if ((Variables.numQHelisNoEngine > 0) && (Variables.numMSRDIdle > 0) && (Variables.numQforRefit > 0))
        {
            stats.updateStats(Variables.refitStats, Variables.numRefit);

            if ((Variables.refitEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("refitEng");
            }
            Variables.numRefit = Variables.numRefit + 1;
            if ((Variables.refitEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("refitEng");
            }

            stats.updateStats(Variables.qHelisNoEngineStats, Variables.numQHelisNoEngine);
            doGraphic("HeliWait", Variables.numQHelisNoEngine, false);

            if ((Variables.heliAwaitEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("heliAwaitEng");
            }
            Variables.numQHelisNoEngine = Variables.numQHelisNoEngine - 1;
            if ((Variables.heliAwaitEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("heliAwaitEng");
            }

            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveHeliToRefit();
                    }
                });
                try {Thread.sleep(3000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            doGraphic("RefitHeli",Variables.numRefit, true);

            stats.updateStats(Variables.qforRefitStats, Variables.numQforRefit);
            doGraphic("GoodEngine",Variables.numQforRefit, false);

            if ((Variables.goodEngQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("goodEngQ");
            }
            Variables.numQforRefit = Variables.numQforRefit - 1;
            if ((Variables.goodEngQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("goodEngQ");
            }

            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveEngToRefit();
                    }
                });
                try {Thread.sleep(2300);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            doGraphic("RefitEng", Variables.numRefit, true);

            stats.updateStats(Variables.MSRDIdleStats, Variables.numMSRDIdle);
            doGraphic("MSRDidle", Variables.numMSRDIdle, false);

            if ((Variables.msrdIdleQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("msrdIdleQ");
            }
            Variables.numMSRDIdle = Variables.numMSRDIdle - 1;
            if ((Variables.msrdIdleQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("msrdIdleQ");
            }

            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveMSRDToRefit();
                    }
                });
                try {Thread.sleep(2500);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            doGraphic("RefitMSRD", Variables.numRefit, true);

            t = stats.getDuration(Variables.refitTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(4);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endRefit ()  // numMSRDIdle +1. numQforOperational +1. numRefit -1.
    {
        doGraphic("RefitEng", Variables.numRefit, false);
        doGraphic("RefitMSRD", Variables.numRefit,false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveMSRDRefitToIdle();
                }
            });
            try {Thread.sleep(2500);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        stats.updateStats(Variables.MSRDIdleStats, Variables.numMSRDIdle);

        if ((Variables.msrdIdleQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime <= Variables.RunTime)){
            saveGraphStats("msrdIdleQ");
        }
        Variables.numMSRDIdle = Variables.numMSRDIdle + 1;
        if ((Variables.msrdIdleQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("msrdIdleQ");
        }

        doGraphic("MSRDidle",Variables.numMSRDIdle, true);

        doGraphic("RefitHeli", Variables.numRefit, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveHeliToQforOp();
                }
            });
            try {Thread.sleep(2000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        stats.updateStats(Variables.qforOperationalStats, Variables.numQforOperational);

        if ((Variables.qForOpGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("qForOp");
        }
        Variables.numQforOperational = Variables.numQforOperational + 1;
        if ((Variables.qForOpGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("qForOp");
        }

        doGraphic("OperationalQ",Variables.numQforOperational, true);

        stats.updateStats(Variables.refitStats, Variables.numRefit);

        if ((Variables.refitEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("refitEng");
        }
        Variables.numRefit = Variables.numRefit -1;
        if ((Variables.refitEngGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("refitEng");
        }

        startOperational();
        startRefit();
        startRemoval();
    }

    public void startRepair ()  // numQforRepair -1. numRepair +1. numRepairTeamsIdle -1.
    {
        double t;
        EventData N = new EventData();
        if ((Variables.numQforRepair > 0) && (Variables.numRepairTeamsIdle > 0))
        {
            stats.updateStats(Variables.qforRepairStats, Variables.numQforRepair);
            doGraphic("BadEngine", Variables.numQforRepair,false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveBadEngToRepair();
                    }
                });
                try {Thread.sleep(1000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }

            if ((Variables.badEngQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("badEngQ");
            }
            Variables.numQforRepair = Variables.numQforRepair - 1;
            if ((Variables.badEngQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("badEngQ");
            }

            stats.updateStats(Variables.repairStats, Variables.numRepair);

            if ((Variables.engRepairGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("engRepair");
            }
            Variables.numRepair = Variables.numRepair +1;
            if ((Variables.engRepairGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("engRepair");
            }

            doGraphic("RepairEngine", Variables.numRepair, true);
            stats.updateStats(Variables.repairTeamsIdleStats, Variables.numRepairTeamsIdle);
            doGraphic("RepairTeamIdle", Variables.numRepairTeamsIdle, false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveTeamToRepair();
                    }
                });
                try {Thread.sleep(3000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }

            if ((Variables.repairTeamIdleGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("repairTeamIdle");
            }
            Variables.numRepairTeamsIdle = Variables.numRepairTeamsIdle - 1;
            if ((Variables.repairTeamIdleGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("repairTeamIdle");
            }

            doGraphic("RepairTeam", Variables.numRepair, true);

            t = stats.getDuration(Variables.repairTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(5);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endRepair ()  // numRepairTeamsIdle +1. numRepair -1. numQforToOperation +1.
    {
        doGraphic("RepairTeam",Variables.numRepair, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveTeamFromRepair();
                }
            });
            try {Thread.sleep(3000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        stats.updateStats(Variables.repairTeamsIdleStats, Variables.numRepairTeamsIdle);

        if ((Variables.repairTeamIdleGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("repairTeamIdle");
        }
        Variables.numRepairTeamsIdle = Variables.numRepairTeamsIdle + 1;
        if ((Variables.repairTeamIdleGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("repairTeamIdle");
        }

        doGraphic("RepairTeamIdle", Variables.numRepairTeamsIdle, true);

        doGraphic("RepairEngine", Variables.numRepair, false);
        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveFromRepairToDQ2();
                }
            });
            try {Thread.sleep(1400);}
            catch (InterruptedException e) {e.printStackTrace();}
        }
        stats.updateStats(Variables.repairStats, Variables.numRepair);

        if ((Variables.engRepairGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("engRepair");
        }
        Variables.numRepair = Variables.numRepair - 1;
        if ((Variables.engRepairGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("engRepair");
        }

        stats.updateStats(Variables.qforToOperationStats, Variables.numQforToOperation);

        //dummy Q2 node. No need for graph
        Variables.numQforToOperation = Variables.numQforToOperation +1;

        doGraphic("DummyQ2", Variables.numQforToOperation, true);

        startToOperation();
        startRepair();
    }

    public void startToOperation () // numQforToOperation -1. numToOperation +1.
    {
        double t;
        EventData N = new EventData();

        if (Variables.numQforToOperation > 0)
        {
            stats.updateStats(Variables.qforToOperationStats, Variables.numQforToOperation);
            doGraphic("DummyQ2", Variables.numQforToOperation, false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveDQ2ToTransport();
                    }
                });
                try {Thread.sleep(3000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }

            //Dummy Q2 node. no need for graph
            Variables.numQforToOperation = Variables.numQforToOperation - 1;

            stats.updateStats(Variables.toOperationStats, Variables.numToOperation);

            if ((Variables.toOperationGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("toOperation");
            }
            Variables.numToOperation = Variables.numToOperation + 1;
            if ((Variables.toOperationGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("toOperation");
            }

            doGraphic("ToOperation", Variables.numToOperation, true);

            t = stats.getDuration(Variables.toOperationTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(6);
            sim.addEvent(Variables.list, N);
        }
    }

    public void endToOperation () // numToOperation -1. numQforRefit +1.
    {
        stats.updateStats(Variables.toOperationStats, Variables.numToOperation);
        doGraphic("ToOperation", Variables.numToOperation, false);

        if ((Variables.toOperationGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("toOperation");
        }
        Variables.numToOperation = Variables.numToOperation -1;
        if ((Variables.toOperationGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("toOperation");
        }

        if ((Variables.animationsOn)&& (Variables.graphicsOn))
        {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    anims.moveTransportToGoodEng();
                }
            });
            try {Thread.sleep(3000);}
            catch (InterruptedException e) {e.printStackTrace();}
        }

        stats.updateStats(Variables.qforRefitStats, Variables.numQforRefit);

        if ((Variables.goodEngQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("goodEngQ");
        }
        Variables.numQforRefit = Variables.numQforRefit +1;
        if ((Variables.goodEngQGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
            saveGraphStats("goodEngQ");
        }

        doGraphic("GoodEngine", Variables.numQforRefit, true);

        startRefit();
    }

    public void startOperational() // numQforOperational -1. numOperational +1.
    {
        double t;
        EventData N = new EventData();

        if ((Variables.numQforOperational > 0) && (Variables.numOperational < Variables.maxHelicopters))
        {
            stats.updateStats(Variables.qforOperationalStats, Variables.numQforOperational);
            doGraphic("OperationalQ",Variables.numQforOperational, false);
            if ((Variables.animationsOn)&& (Variables.graphicsOn))
            {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        anims.moveHeliToOp();
                    }
                });
                try {Thread.sleep(1000);}
                catch (InterruptedException e) {e.printStackTrace();}
            }

            if ((Variables.qForOpGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("qForOp");
            }
            Variables.numQforOperational = Variables.numQforOperational -1;
            if ((Variables.qForOpGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("qForOp");
            }

            stats.updateStats(Variables.operationalStats, Variables.numOperational );
            if ((Variables.opheliGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("opHeli");
            }
            Variables.numOperational = Variables.numOperational + 1;
            if ((Variables.opheliGraphPointNum < Variables.maxGraphPoints) && (Variables.SimTime < Variables.RunTime)){
                saveGraphStats("opHeli");
            }
            doGraphic("Operational", Variables.numOperational, true);

            t = stats.getDuration(Variables.operationalTime);
            N.setTime(Variables.SimTime + t);
            N.setKind(1);
            sim.addEvent(Variables.list, N);
        }
    }

    public void doGraphic(final String whichNode, final int iconValue, final boolean iconBoolean)
    {
        if ((Variables.graphicsOn)&& (!Variables.stopNow)) {
            if (!Variables.animationsOn)
            {
                try {Thread.sleep(500);}
                catch (InterruptedException e) {e.printStackTrace();}
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    graphics.switchImage(whichNode,iconValue,iconBoolean);
                }
            });z`
        }
    }

    public void saveGraphStats (String whichGraph )
    {
        switch(whichGraph){
            case "opHeli":
                if (Variables.opheliGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.opHeliGraphData,Variables.opheliGraphPointNum-1, Variables.opheliGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.opHeliGraphData, Variables.opheliGraphPointNum-2, Variables.opheliGraphPointNum-3))){
                        Variables.opheliGraphPointNum = Variables.opheliGraphPointNum - 4;
                    }
                }
                Variables.opHeliGraphData[Variables.opheliGraphPointNum][0] = (float)Variables.SimTime;
                Variables.opHeliGraphData[Variables.opheliGraphPointNum][1] = Variables.numOperational;

                Variables.opheliGraphPointNum += 1;
                break;

            //repairWorking and msrdWorking cases are irrelevant.
            //msrdWorking graph data will be generated from msrdIdle data. repairWorking graph data is equivalent to engRepair

            case "failedQ":
                if (Variables.failedQGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.failedQGraphData,Variables.failedQGraphPointNum-1, Variables.failedQGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.failedQGraphData, Variables.failedQGraphPointNum-2, Variables.failedQGraphPointNum-3))){
                        Variables.failedQGraphPointNum= Variables.failedQGraphPointNum - 4;
                    }
                }
                Variables.failedQGraphData[Variables.failedQGraphPointNum][0] = (float)Variables.SimTime;
                Variables.failedQGraphData[Variables.failedQGraphPointNum][1] = Variables.numQforRemoval;

                Variables.failedQGraphPointNum += 1;
                break;
            case "removeEng":
                if (Variables.removeEngGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.removeEngGraphData,Variables.removeEngGraphPointNum-1, Variables.removeEngGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.removeEngGraphData, Variables.removeEngGraphPointNum-2, Variables.removeEngGraphPointNum-3))){
                        Variables.removeEngGraphPointNum= Variables.removeEngGraphPointNum - 4;
                    }
                }
                Variables.removeEngGraphData[Variables.removeEngGraphPointNum][0] = (float)Variables.SimTime;
                Variables.removeEngGraphData[Variables.removeEngGraphPointNum][1] = Variables.numRemoval;

                Variables.removeEngGraphPointNum += 1;
                break;
            case "toRepair":
                if (Variables.toRepairGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.toRepairGraphData,Variables.toRepairGraphPointNum-1, Variables.toRepairGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.toRepairGraphData, Variables.toRepairGraphPointNum-2, Variables.toRepairGraphPointNum-3))){
                        Variables.toRepairGraphPointNum= Variables.toRepairGraphPointNum - 4;
                    }
                }
                Variables.toRepairGraphData[Variables.toRepairGraphPointNum][0] = (float)Variables.SimTime;
                Variables.toRepairGraphData[Variables.toRepairGraphPointNum][1] = Variables.numToWorkshop;

                Variables.toRepairGraphPointNum += 1;
                break;
            case "badEngQ":
                if (Variables.badEngQGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.badEngQGraphData,Variables.badEngQGraphPointNum-1, Variables.badEngQGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.badEngQGraphData, Variables.badEngQGraphPointNum-2, Variables.badEngQGraphPointNum-3))){
                        Variables.badEngQGraphPointNum= Variables.badEngQGraphPointNum - 4;
                    }
                }
                Variables.badEngQGraphData[Variables.badEngQGraphPointNum][0] = (float)Variables.SimTime;
                Variables.badEngQGraphData[Variables.badEngQGraphPointNum][1] = Variables.numQforRepair;

                Variables.badEngQGraphPointNum += 1;
                break;
            case "engRepair":
                if (Variables.engRepairGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.engRepairGraphData,Variables.engRepairGraphPointNum-1, Variables.engRepairGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.engRepairGraphData, Variables.engRepairGraphPointNum-2, Variables.engRepairGraphPointNum-3))){
                        Variables.engRepairGraphPointNum = Variables.engRepairGraphPointNum - 4;
                    }
                }
                Variables.engRepairGraphData[Variables.engRepairGraphPointNum][0] = (float)Variables.SimTime;
                Variables.engRepairGraphData[Variables.engRepairGraphPointNum][1] = Variables.numRepair;

                Variables.engRepairGraphPointNum += 1;
                break;
            case "toOperation":
                if (Variables.toOperationGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.toOperationGraphData,Variables.toOperationGraphPointNum-1, Variables.toOperationGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.toOperationGraphData, Variables.toOperationGraphPointNum-2, Variables.toOperationGraphPointNum-3))){
                        Variables.toOperationGraphPointNum = Variables.toOperationGraphPointNum - 4;
                    }
                }
                Variables.toOperationGraphData[Variables.toOperationGraphPointNum][0] = (float)Variables.SimTime;
                Variables.toOperationGraphData[Variables.toOperationGraphPointNum][1] = Variables.numToOperation;

                Variables.toOperationGraphPointNum += 1;
                break;
            case "goodEngQ":
                if (Variables.goodEngQGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.goodEngQGraphData,Variables.goodEngQGraphPointNum-1, Variables.goodEngQGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.goodEngQGraphData, Variables.goodEngQGraphPointNum-2, Variables.goodEngQGraphPointNum-3))){
                        Variables.goodEngQGraphPointNum = Variables.goodEngQGraphPointNum - 4;
                    }
                }
                Variables.goodEngQGraphData[Variables.goodEngQGraphPointNum][0] = (float)Variables.SimTime;
                Variables.goodEngQGraphData[Variables.goodEngQGraphPointNum][1] = Variables.numQforRefit;

                Variables.goodEngQGraphPointNum += 1;
                break;
            case "refitEng":
                Variables.refitEngGraphData[Variables.refitEngGraphPointNum][0] = (float)Variables.SimTime;
                Variables.refitEngGraphData[Variables.refitEngGraphPointNum][1] = Variables.numRefit;

                Variables.refitEngGraphPointNum += 1;
                break;
            case "qForOp":
                if (Variables.qForOpGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.qForOpGraphData,Variables.qForOpGraphPointNum-1, Variables.qForOpGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.qForOpGraphData, Variables.qForOpGraphPointNum-2, Variables.qForOpGraphPointNum-3))){
                        Variables.qForOpGraphPointNum = Variables.qForOpGraphPointNum - 4;
                    }
                }
                Variables.qForOpGraphData[Variables.qForOpGraphPointNum][0] = (float)Variables.SimTime;
                Variables.qForOpGraphData[Variables.qForOpGraphPointNum][1] = Variables.numQforOperational;

                Variables.qForOpGraphPointNum += 1;
                break;
            case "heliAwaitEng":
                if (Variables.heliAwaitEngGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.heliAwaitEngGraphData,Variables.heliAwaitEngGraphPointNum-1, Variables.heliAwaitEngGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.heliAwaitEngGraphData, Variables.heliAwaitEngGraphPointNum-2, Variables.heliAwaitEngGraphPointNum-3))){
                        Variables.heliAwaitEngGraphPointNum = Variables.heliAwaitEngGraphPointNum - 4;
                    }
                }
                Variables.heliAwaitEngGraphData[Variables.heliAwaitEngGraphPointNum][0] = (float)Variables.SimTime;
                Variables.heliAwaitEngGraphData[Variables.heliAwaitEngGraphPointNum][1] = Variables.numQHelisNoEngine;

                Variables.heliAwaitEngGraphPointNum += 1;
                break;
            case "msrdIdleQ":
                if (Variables.msrdIdleQGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.msrdIdleQGraphData,Variables.msrdIdleQGraphPointNum-1, Variables.msrdIdleQGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.msrdIdleQGraphData, Variables.msrdIdleQGraphPointNum-2, Variables.msrdIdleQGraphPointNum-3))){
                        Variables.msrdIdleQGraphPointNum = Variables.msrdIdleQGraphPointNum - 4;
                    }
                }
                Variables.msrdIdleQGraphData[Variables.msrdIdleQGraphPointNum][0] = (float)Variables.SimTime;
                Variables.msrdIdleQGraphData[Variables.msrdIdleQGraphPointNum][1] = Variables.numMSRDIdle;

                Variables.msrdIdleQGraphPointNum += 1;
                break;
            case "repairTeamIdle":
                if (Variables.repairTeamIdleGraphPointNum > 3){
                    if((arrayRowsIsEqual(Variables.repairTeamIdleGraphData,Variables.repairTeamIdleGraphPointNum-1, Variables.repairTeamIdleGraphPointNum-4)) &&
                            (arrayRowsIsEqual(Variables.repairTeamIdleGraphData, Variables.repairTeamIdleGraphPointNum-2, Variables.repairTeamIdleGraphPointNum-3))){
                        Variables.repairTeamIdleGraphPointNum = Variables.repairTeamIdleGraphPointNum- 4;
                    }
                }
                Variables.repairTeamIdleGraphData[Variables.repairTeamIdleGraphPointNum][0] = (float)Variables.SimTime;
                Variables.repairTeamIdleGraphData[Variables.repairTeamIdleGraphPointNum][1] = Variables.numRepairTeamsIdle;

                Variables.repairTeamIdleGraphPointNum += 1;
                break;
            default:
                System.out.println("Invalid String entered into saveGraphStats method.");
                break;
        }
    }

    public boolean arrayRowsIsEqual(float [][] arr, int row1, int row2){
        boolean isEqual = true;
        for (int i=0; i < 2; i++){
            if ((arr[row1][i] != arr[row2][i])){
                return false;
            }
        }
        return isEqual;
    }
}

package cranfield.ssel.onerous;

import android.media.Image;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by diwash on 14/11/2016.
 */

public class SimAnimations {
    View view;
    ImageView optofailedheli;
    ImageView failedtoremoveheli;
    ImageView msrdtoremove;
    ImageView removetoheliwait;
    ImageView removetomsrdidle;
    ImageView removeengine;
    ImageView dq1totransport;
    ImageView transporttobadeng;
    ImageView badengtorepair;
    ImageView teamtorepair;
    ImageView teamfromrepair;
    ImageView fromrepairtodq2;
    ImageView dq2totransport;
    ImageView transporttogoodeng;
    ImageView helitorefit;
    ImageView engtorefit;
    ImageView msrdtorefit;
    ImageView msrdrefittoidle;
    ImageView helitoqforop;
    ImageView helitoop;

    SimAnimations(View v){view = v;}

    public void setView (View v) {view = v;}

    public void moveOpToFailed() {
        optofailedheli = (ImageView) view.findViewById(R.id.optofailedheli);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -85.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(1000);
        optofailedheli.startAnimation(moveleft1);
    }

    public void moveFailedToRemove(){
        failedtoremoveheli = (ImageView) view.findViewById(R.id.failedtoremoveheli);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -185.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(1000);
        aSet.addAnimation(moveleft1);
        TranslateAnimation movedown1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 60.0f);
        movedown1.setDuration(1000);
        movedown1.setStartOffset(1000);
        aSet.addAnimation(movedown1);
        failedtoremoveheli.startAnimation(aSet);
    }

    public void moveMSRDtoRemove(){
        msrdtoremove = (ImageView) view.findViewById(R.id.msrdtoremove);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -340.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(2500);
        msrdtoremove.startAnimation(moveleft1);
    }

    public void moveRemoveToHeliWait(){
        removetoheliwait = (ImageView) view.findViewById(R.id.removetoheliwait);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveright1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 150.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(1000);
        aSet.addAnimation(moveright1);
        TranslateAnimation movedown1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 110.0f);
        movedown1.setDuration(1000);
        movedown1.setStartOffset(1000);
        aSet.addAnimation(movedown1);
        TranslateAnimation moveright2 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 155.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright2.setDuration(1000);
        moveright2.setStartOffset(2000);
        aSet.addAnimation(moveright2);
        removetoheliwait.startAnimation(aSet);
    }

    public void moveRemovetoMSRDidle(){
        removetomsrdidle = (ImageView) view.findViewById(R.id.removetomsrdidle);
        TranslateAnimation moveright1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 320.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(2500);
        removetomsrdidle.startAnimation(moveright1);
    }

    public void moveRemovetoDQ1(){
        removeengine = (ImageView) view.findViewById(R.id.removeengine);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation movedown1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 50.0f);
        movedown1.setDuration(800);
        aSet.addAnimation(movedown1);
        TranslateAnimation moveright1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 55.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(800);
        moveright1.setStartOffset(800);
        aSet.addAnimation(moveright1);
        TranslateAnimation movedown2 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 50.0f);
        movedown2.setDuration(800);
        movedown2.setStartOffset(1600);
        aSet.addAnimation(movedown2);
        removeengine.startAnimation(aSet);
    }

    public void moveDQ1toTransport(){
        dq1totransport = (ImageView) view.findViewById(R.id.dq1totransport);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveleft1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -80.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(800);
        aSet.addAnimation(moveleft1);
        TranslateAnimation movedown1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 105.0f);
        movedown1.setDuration(800);
        movedown1.setStartOffset(800);
        aSet.addAnimation(movedown1);
        TranslateAnimation moveright1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 40.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(800);
        moveright1.setStartOffset(1600);
        aSet.addAnimation(moveright1);
        dq1totransport.startAnimation(aSet);
    }

    public void moveTransportToBadEng(){
        transporttobadeng = (ImageView) view.findViewById(R.id.transporttobadeng);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveleft1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -40.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(800);
        aSet.addAnimation(moveleft1);
        TranslateAnimation movedown1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 100.0f);
        movedown1.setDuration(800);
        movedown1.setStartOffset(800);
        aSet.addAnimation(movedown1);
        TranslateAnimation moveright1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 230.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(1400);
        moveright1.setStartOffset(1600);
        aSet.addAnimation(moveright1);
        transporttobadeng.startAnimation(aSet);
    }

    public void moveBadEngToRepair(){
        badengtorepair = (ImageView) view.findViewById(R.id.badengtorepair);
        TranslateAnimation moveright1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 160.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(1000);
        badengtorepair.startAnimation(moveright1);
    }

    public void moveTeamToRepair(){
        teamtorepair = (ImageView) view.findViewById(R.id.teamtorepair);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveleft1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -120.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(1000);
        aSet.addAnimation(moveleft1);
        TranslateAnimation moveup1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -129.0f);
        moveup1.setDuration(1000);
        moveup1.setStartOffset(1000);
        aSet.addAnimation(moveup1);
        TranslateAnimation moveright1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 95.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(1000);
        moveright1.setStartOffset(2000);
        aSet.addAnimation(moveright1);
        teamtorepair.startAnimation(aSet);
    }

    public void moveTeamFromRepair(){
        teamfromrepair = (ImageView) view.findViewById(R.id.teamfromrepair);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveright1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 100.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(1000);
        aSet.addAnimation(moveright1);
        TranslateAnimation movedown1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 129.0f);
        movedown1.setDuration(1000);
        movedown1.setStartOffset(1000);
        aSet.addAnimation(movedown1);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -100.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(1000);
        moveleft1.setStartOffset(2000);
        aSet.addAnimation(moveleft1);
        teamfromrepair.startAnimation(aSet);
    }

    public void moveFromRepairToDQ2(){
        fromrepairtodq2 = (ImageView) view.findViewById(R.id.fromrepairtodq2);
        TranslateAnimation moveright1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 180.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(1400);
        fromrepairtodq2.startAnimation(moveright1);
    }

    public void moveDQ2ToTransport(){
        dq2totransport = (ImageView) view.findViewById(R.id.dq2totransport);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveright1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 270.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(1000);
        aSet.addAnimation(moveright1);
        TranslateAnimation moveup1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -92.0f);
        moveup1.setDuration(1000);
        moveup1.setStartOffset(1000);
        aSet.addAnimation(moveup1);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -60.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(1000);
        moveleft1.setStartOffset(2000);
        aSet.addAnimation(moveleft1);
        dq2totransport.startAnimation(aSet);
    }

    public void moveTransportToGoodEng(){
        transporttogoodeng = (ImageView) view.findViewById(R.id.transporttogoodeng);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveright1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 95.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(1000);
        aSet.addAnimation(moveright1);
        TranslateAnimation moveup1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -108.0f);
        moveup1.setDuration(1000);
        moveup1.setStartOffset(1000);
        aSet.addAnimation(moveup1);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -95.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(1000);
        moveleft1.setStartOffset(2000);
        aSet.addAnimation(moveleft1);
        transporttogoodeng.startAnimation(aSet);
    }

    public void moveHeliToRefit(){
        helitorefit = (ImageView) view.findViewById(R.id.helitorefit);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveright1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 160.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(1000);
        aSet.addAnimation(moveright1);
        TranslateAnimation moveup1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -115.0f);
        moveup1.setDuration(1000);
        moveup1.setStartOffset(1000);
        aSet.addAnimation(moveup1);
        TranslateAnimation moveright2 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 165.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright2.setDuration(1000);
        moveright2.setStartOffset(2000);
        aSet.addAnimation(moveright2);
        helitorefit.startAnimation(aSet);
    }

    public void moveEngToRefit(){
        engtorefit = (ImageView) view.findViewById(R.id.engtorefit);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveup1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -55.0f);
        moveup1.setDuration(500);
        aSet.addAnimation(moveup1);
        TranslateAnimation moveright1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 60.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(600);
        moveright1.setStartOffset(500);
        aSet.addAnimation(moveright1);
        TranslateAnimation moveup2 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -102.0f);
        moveup2.setDuration(1000);
        moveup2.setStartOffset(1100);
        aSet.addAnimation(moveup2);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -20.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(200);
        moveleft1.setStartOffset(2100);
        aSet.addAnimation(moveleft1);
        engtorefit.startAnimation(aSet);
    }

    public void moveMSRDToRefit(){
        msrdtorefit = (ImageView) view.findViewById(R.id.msrdtorefit);
        TranslateAnimation moveright1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 360.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveright1.setDuration(2500);
        msrdtorefit.startAnimation(moveright1);
    }

    public void moveMSRDRefitToIdle(){
        msrdrefittoidle = (ImageView) view.findViewById(R.id.msrdrefittoidle);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -360.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(2500);
        msrdrefittoidle.startAnimation(moveleft1);
    }

    public void moveHeliToQforOp(){
        helitoqforop = (ImageView) view.findViewById(R.id.helitoqforop);
        AnimationSet aSet = new AnimationSet(true);
        TranslateAnimation moveup1 =  new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -94.0f);
        moveup1.setDuration(1000);
        aSet.addAnimation(moveup1);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -185.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(1000);
        moveleft1.setStartOffset(1000);
        aSet.addAnimation(moveleft1);
        helitoqforop.startAnimation(aSet);
    }

    public void moveHeliToOp(){
        helitoop = (ImageView) view.findViewById(R.id.helitoop);
        TranslateAnimation moveleft1 = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -100.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f);
        moveleft1.setDuration(1000);
        helitoop.startAnimation(moveleft1);
    }
}

package cranfield.ssel.onerous;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initDataVariables();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void initDataVariables()
    {
        Variables.operationalTime.setType(1);
        Variables.operationalTime.setParameter1(15);
        Variables.operationalTime.setParameter2(3.9);
        Variables.operationalTime.setParameter3(0);
        Variables.operationalTime.setParameter4(25);

        Variables.removalTime.setType(3);
        Variables.removalTime.setParameter1(0.5);
        Variables.removalTime.setParameter2(0);
        Variables.removalTime.setParameter3(0);
        Variables.removalTime.setParameter4(0);

        Variables.toWorkshopTime.setType(3);
        Variables.toWorkshopTime.setParameter1(0.5);
        Variables.toWorkshopTime.setParameter2(0);
        Variables.toWorkshopTime.setParameter3(0);
        Variables.toWorkshopTime.setParameter4(0);

        Variables.repairTime.setType(2);
        Variables.repairTime.setParameter1(1);
        Variables.repairTime.setParameter2(8);
        Variables.repairTime.setParameter3(0);
        Variables.repairTime.setParameter4(0);

        Variables.toOperationTime.setType(3);
        Variables.toOperationTime.setParameter1(0.5);
        Variables.toOperationTime.setParameter2(0);
        Variables.toOperationTime.setParameter3(0);
        Variables.toOperationTime.setParameter4(0);

        Variables.refitTime.setType(3);
        Variables.refitTime.setParameter1(0.5);
        Variables.refitTime.setParameter2(0);
        Variables.refitTime.setParameter3(0);
        Variables.refitTime.setParameter4(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position) {
                case 0: return VariablesFragment.newInstance();
                case 1: return SimulationFragment.newInstance();
                case 2: return ResultsFragment.newInstance();
                default: return PlaceholderFragment.newInstance(position);
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //These are what the tabs at the top of each page will be titled
            switch (position) {
                case 0:
                    return "Variables";
                case 1:
                    return "Simulation";
                case 2:
                    return "Results";
            }
            return null;
        }
    }
}

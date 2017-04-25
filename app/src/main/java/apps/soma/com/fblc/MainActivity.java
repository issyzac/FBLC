package apps.soma.com.fblc;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import apps.soma.com.fblc.customviews.NonSwipeableViewPager;
import apps.soma.com.fblc.fragments.AccountFragment;
import apps.soma.com.fblc.fragments.FrontFragment;
import apps.soma.com.fblc.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbarHome;

    private TabLayout tabLayout;

    public static NonSwipeableViewPager viewPager;

    public static Typeface Athletic, Fun_Raiser, Roboto_Condensed, Roboto_Black, Roboto_Light, Roboto_BoldCondensedItalic, Roboto_BoldCondensed, Rosario_Regular, Rosario_Bold, Rosario_Italic, Roboto_Regular, Roboto_Medium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupTypeface(this);
        setContentView(R.layout.activity_main);

        setupviews();
        setupActionBar();

        viewPager = (NonSwipeableViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
                setupTabIcons();
            }
        });

    }


    public void setupTabIcons() {

        View homeView = getLayoutInflater().inflate(R.layout.custom_tabs, null);
        TextView homeTitle = (TextView) homeView.findViewById(R.id.title_text);
        ImageView iv    = (ImageView) homeView.findViewById(R.id.icon);
//        iv.setColorFilter(this.getResources().getColor(R.color.colorPrimary));
        Glide.with(this).load(R.mipmap.ic_action_home).into(iv);
        homeTitle.setTypeface(Roboto_Light);
        homeTitle.setText("MWANZO");
        tabLayout.getTabAt(0).setCustomView(homeView);

        View newsView = getLayoutInflater().inflate(R.layout.custom_tabs, null);
        TextView newsTitle = (TextView) newsView.findViewById(R.id.title_text);
        newsTitle.setTypeface(Roboto_Light);
        newsTitle.setText("Maktaba");
        ImageView iv2    = (ImageView) newsView.findViewById(R.id.icon);
//        iv2.setColorFilter(this.getResources().getColor(R.color.colorPrimary));
        Glide.with(this).load(R.mipmap.ic_action_maktaba).into(iv2);
        tabLayout.getTabAt(1).setCustomView(newsView);

        View ccmView = getLayoutInflater().inflate(R.layout.custom_tabs, null);
        TextView ccmTitle = (TextView) ccmView.findViewById(R.id.title_text);
        ccmTitle.setTypeface(Roboto_Light);
        ccmTitle.setText("Live");
        ImageView iv3    = (ImageView) ccmView.findViewById(R.id.icon);
//        iv3.setColorFilter(this.getResources().getColor(R.color.colorPrimary));
        Glide.with(this).load(R.mipmap.ic_action_live_on).into(iv3);
        tabLayout.getTabAt(2).setCustomView(ccmView);

        View harambeeView = getLayoutInflater().inflate(R.layout.custom_tabs, null);
        TextView harambeeTitle = (TextView) harambeeView.findViewById(R.id.title_text);
        homeTitle.setTypeface(Roboto_Light);
        harambeeTitle.setText("Ratiba");
        ImageView iv4    = (ImageView) harambeeView.findViewById(R.id.icon);
//        iv4.setColorFilter(this.getResources().getColor(R.color.colorPrimary));
        Glide.with(this).load(R.mipmap.ic_action_calendar).into(iv4);
        tabLayout.getTabAt(3).setCustomView(harambeeView);

        View othersView = getLayoutInflater().inflate(R.layout.custom_tabs, null);
        TextView othersTitle = (TextView) othersView.findViewById(R.id.title_text);
        othersTitle.setTypeface(Roboto_Light);
        othersTitle.setText("Account");
        ImageView iv5    = (ImageView) othersView.findViewById(R.id.icon);
//        iv5.setColorFilter(this.getResources().getColor(R.color.colorPrimary));
        Glide.with(this).load(R.mipmap.ic_action_profile).into(iv5);
        tabLayout.getTabAt(4).setCustomView(othersView);

    }

    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FrontFragment(), "Home");
        adapter.addFragment(new HomeFragment(), "Library");
        adapter.addFragment(new HomeFragment(), "Live");
        adapter.addFragment(new HomeFragment(), "Calendar");
        adapter.addFragment(new AccountFragment(), "Profile");
        viewPager.setAdapter(adapter);
    }

    public void setupviews(){

    }

    public void setupActionBar(){

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            return mFragmentTitleList.get(position);
            return null;
        }
    }

    public static void setupTypeface(Context ctx){
        Roboto_Light = Typeface.createFromAsset(ctx.getAssets(), "Roboto-Light.ttf");
        Roboto_Black = Typeface.createFromAsset(ctx.getAssets(), "Roboto-Black.ttf");
        Roboto_Condensed = Typeface.createFromAsset(ctx.getAssets(), "Roboto-Condensed.ttf");
        Roboto_BoldCondensedItalic = Typeface.createFromAsset(ctx.getAssets(), "Roboto-BoldCondensedItalic.ttf");
        Roboto_BoldCondensed = Typeface.createFromAsset(ctx.getAssets(), "Roboto-BoldCondensed.ttf");
        Roboto_Regular = Typeface.createFromAsset(ctx.getAssets(), "Roboto-Regular.ttf");
        Roboto_Medium = Typeface.createFromAsset(ctx.getAssets(), "Roboto-Medium.ttf");
        Rosario_Regular = Typeface.createFromAsset(ctx.getAssets(), "Rosario-Regular.ttf");
        Rosario_Italic = Typeface.createFromAsset(ctx.getAssets(), "Rosario-Italic.ttf");
        Rosario_Bold = Typeface.createFromAsset(ctx.getAssets(), "Rosario-Bold.ttf");
        Fun_Raiser = Typeface.createFromAsset(ctx.getAssets(), "Fun-Raiser.ttf");
        Athletic = Typeface.createFromAsset(ctx.getAssets(), "athletic.ttf");
    }

}

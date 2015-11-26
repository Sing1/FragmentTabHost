package sing.fragmenttabhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sing.fragmenttabhost.fragment.FragmentA;
import sing.fragmenttabhost.fragment.FragmentB;
import sing.fragmenttabhost.fragment.FragmentC;
import sing.fragmenttabhost.fragment.FragmentD;
import sing.fragmenttabhost.fragment.FragmentE;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private List<Tab> mTabs = new ArrayList<>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        Tab num1 = new Tab(R.string.num1, R.drawable.selector_icon_num1, FragmentA.class);
        Tab num2 = new Tab(R.string.num2, R.drawable.selector_icon_num2, FragmentB.class);
        Tab num3 = new Tab(R.string.num3, R.drawable.selector_icon_num3, FragmentC.class);
        Tab num4 = new Tab(R.string.num4, R.drawable.selector_icon_num4, FragmentD.class);
        Tab num5 = new Tab(R.string.num5, R.drawable.selector_icon_num5, FragmentE.class);

        mTabs.add(num1);
        mTabs.add(num2);
        mTabs.add(num3);
        mTabs.add(num4);
        mTabs.add(num5);

        for (Tab tab : mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabHost.addTab(tabSpec, tab.getFragment(), null);
        }

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId == getString(R.string.num1)) {

                }
            }
        });

//      去掉纵向分割线
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabHost.setCurrentTab(0);
    }

    private View buildIndicator(Tab tab) {
        View view = mInflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        return view;
    }
}
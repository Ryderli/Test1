package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost mtabhost;
    private LayoutInflater minflater;
    private List<Tab> mTabs=new ArrayList<>(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }

    private void initTab() {
        Tab tab_home=new Tab(R.string.home,R.drawable.image_home,HomeFragment.class);
        Tab tab_collect=new Tab(R.string.collect,R.drawable.image_collect,CollectFragment.class);
        Tab tab_hot=new Tab(R.string.hot,R.drawable.image_hot,HotFragment.class);
        Tab tab_about=new Tab(R.string.about,R.drawable.image_about,AboutFragment.class);
        Tab tab_mine=new Tab(R.string.mine,R.drawable.image_mine,MineFragment.class);


        mTabs.add(tab_home);
        mTabs.add(tab_collect);
        mTabs.add(tab_hot);
        mTabs.add(tab_about);
        mTabs.add(tab_mine);


        minflater=LayoutInflater.from(this);
        mtabhost=(FragmentTabHost)this.findViewById(R.id.tabhost);
        mtabhost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);

        for(Tab tab:mTabs){
            TabHost.TabSpec tabSpec=mtabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(builtdInditor(tab));
            mtabhost.addTab(tabSpec,tab.getFragment(),null);
        }
    }
    private View builtdInditor(Tab tab){
        View view=minflater.inflate(R.layout.tab_indicator,null);

        ImageView imageView=(ImageView)view. findViewById(R.id.tab_image);
        TextView textView=(TextView)view. findViewById(R.id.tab_text);
        imageView.setBackgroundResource(tab.getIcon());
        textView.setText(getString(tab.getTitle()));
        return view;
    }
}

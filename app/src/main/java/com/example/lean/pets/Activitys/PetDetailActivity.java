package com.example.lean.pets.Activitys;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lean.pets.Adapters.SectionsPageAdapter;
import com.example.lean.pets.Fragments.Tab1DetailFragment;
import com.example.lean.pets.Fragments.Tab2DetailFragment;
import com.example.lean.pets.R;

public class PetDetailActivity extends AppCompatActivity {

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_detail);
        setTitle(getResources().getString(R.string.title_activity_pet_detail));

        viewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        sectionsPageAdapter.addFragment(new Tab1DetailFragment(), "Tab 1");
        sectionsPageAdapter.addFragment(new Tab2DetailFragment(), "Tab 2");
        viewPager.setAdapter(sectionsPageAdapter);
    }
}

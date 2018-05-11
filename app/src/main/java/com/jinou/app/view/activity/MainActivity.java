package com.jinou.app.view.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jinou.app.R;
import com.jinou.app.view.fragment.FragmentCnTech;
import com.jinou.app.view.fragment.FragmentConsult;
import com.jinou.app.view.fragment.FragmentContact;
import com.jinou.app.view.fragment.FragmentMine;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_bottom_bar)
    BottomBar mainBottomBar;
    @BindView(R.id.main_title)
    TextView mainTitle;
    private Unbinder bind;
    private FragmentManager supportFragmentManager;
    private FragmentCnTech fragmentCnTech;
    private FragmentConsult fragmentConsult;
    private FragmentMine fragmentMine;
    private FragmentContact fragmentContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        init();
        defaultShowFragment();
        initBottomMenu();
    }

    private void defaultShowFragment() {
        fragmentConsult = new FragmentConsult();
        supportFragmentManager.beginTransaction().add(R.id.main_frame_group,fragmentConsult).commit();
    }


    private void init() {
        supportFragmentManager = getSupportFragmentManager();
    }

    private void initBottomMenu() {
        mainBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                hideAllFragments();
                FragmentTransaction toggleTransaction = supportFragmentManager.beginTransaction();
                int backgroundColor = Color.parseColor("#00ACA0");
                String titleStr = "咨询信息";
                switch (tabId) {
                    case R.id.tab_consult:
                        toggleTransaction.show(fragmentConsult);
                        break;
                    case R.id.tab_cnTech:
                        if (fragmentCnTech == null) {
                            fragmentCnTech = new FragmentCnTech();
                            toggleTransaction.add(R.id.main_frame_group, fragmentCnTech);
                        } else {
                            toggleTransaction.show(fragmentCnTech);
                        }

                        backgroundColor = Color.parseColor("#7B1FA2");
                        titleStr = "科技圈";
                        break;
                    case R.id.tab_contacts:
                        if (fragmentContact == null) {
                            fragmentContact = new FragmentContact();
                            toggleTransaction.add(R.id.main_frame_group, fragmentContact);
                        } else {
                            toggleTransaction.show(fragmentContact);
                        }

                        backgroundColor = Color.parseColor("#FF5252");
                        titleStr = "通讯录";
                        break;
                    case R.id.tab_mine:
                        if (fragmentMine == null) {
                            fragmentMine = new FragmentMine();
                            toggleTransaction.add(R.id.main_frame_group, fragmentMine);
                        } else {
                            toggleTransaction.show(fragmentMine);
                        }

                        backgroundColor = Color.parseColor("#FF9800");
                        titleStr = "个人页面";
                        break;
                }
                mainTitle.setText(titleStr);
                mainTitle.setBackgroundColor(backgroundColor);
                toggleTransaction.commit();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bind!=null){
            bind.unbind();
            bind = null;
        }

    }

    private void hideAllFragments() {
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        if (fragmentCnTech != null) fragmentTransaction.hide(fragmentCnTech);
        if (fragmentConsult != null) fragmentTransaction.hide(fragmentConsult);
        if (fragmentContact != null) fragmentTransaction.hide(fragmentContact);
        if (fragmentMine != null) fragmentTransaction.hide(fragmentMine);
        fragmentTransaction.commit();
    }

}

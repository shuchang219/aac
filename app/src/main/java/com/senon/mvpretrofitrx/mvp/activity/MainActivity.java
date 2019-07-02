package com.senon.mvpretrofitrx.mvp.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.senon.mvpretrofitrx.R;
import com.senon.mvpretrofitrx.mvp.fragment.FirstFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView bottomNavigationView;
    private String className = "MenuActivity";
    //  private ViewPager viewPager;
    String msg = "Android : ";
    //继承Activity 不会显示APP头上的标题
    private FirstFragment f1, f2, f3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //bottomNavigationView Item 选择监听
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d("123", "onNavigationItemSelected is click: ");
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                hideAllFragment(transaction);
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Log.d(className, "R.id.navigation_home: ");
                        if (f1 == null) {
                            f1 = FirstFragment.newInstance("首頁", R.layout.menu_main);
                            transaction.add(R.id.FramePage, f1);
                        } else {
                            transaction.show(f1);
                        }
                        break;
                    case R.id.navigation_dashboard:
                        Log.d(className, "R.id.navigation_dashboard: ");
                        if (f2 == null) {
                            f2 = FirstFragment.newInstance("發現", R.layout.found_main);//"第二个Fragment"
                            transaction.add(R.id.FramePage, f2);
                        } else {
                            transaction.show(f2);
                        }
                        break;
                    case R.id.navigation_notifications:
                        Log.d(className, "R.string.title_notification: ");
                        if (f3 == null) {
                            f3 = FirstFragment.newInstance("我的", R.layout.user_main);//"第三个Fragment"
                            transaction.add(R.id.FramePage, f3);
                        } else {
                            transaction.show(f3);
                        }
                        break;
                }
                transaction.commit();
                Log.d(msg, "xxxxx ");

                return false;
            }
        });

    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            transaction.hide(f1);
        }
        if (f2 != null) {
            transaction.hide(f2);
        }
        if (f3 != null) {
            transaction.hide(f3);
        }

    }

}

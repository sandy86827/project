package tw.com.lccnet.myproject2;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;

import tw.com.lccnet.myproject2.basepage.BasePage;
import tw.com.lccnet.myproject2.page.HomePage;
import tw.com.lccnet.myproject2.page.News;
import tw.com.lccnet.myproject2.page.Service;
import tw.com.lccnet.myproject2.page.Setting;
import tw.com.lccnet.myproject2.page.Smart;

public class MainActivity extends AppCompatActivity {
    private ArrayList<BasePage> basePages;
    private ViewPager viewPager;
    private RadioGroup rb_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb_main=findViewById(R.id.rb_group);
        viewPager=findViewById(R.id.viewpager);
        basePages=new ArrayList<>();
        basePages.add(new HomePage(this));
        basePages.add(new News(this));
        basePages.add(new Smart(this));
        basePages.add(new Service(this));
        basePages.add(new Setting(this));

        viewPager.setAdapter(new ConfragmentAdapter());
        rb_main.check(R.id.rb_home);//進入首頁
        rb_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());




    }
    class  MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.rb_news:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.rb_service:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.rb_setting:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.rb_smart:
                    viewPager.setCurrentItem(4);
                    break;

            }

        }
    }

    class  ConfragmentAdapter extends PagerAdapter{

        @Override
        public int getCount() {

            return basePages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            //如果相等 是同個頁面
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            BasePage basePage=basePages.get(position);
            View rootView=basePage.rootview;
            basePage.initData();
            container.addView(rootView);
            return rootView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }

}

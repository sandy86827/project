package tw.com.lccnet.myproject2.page;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import tw.com.lccnet.myproject2.basepage.BasePage;

/**
 * Created by asus on 2018/1/8.
 */

public class News extends BasePage {
    public News(Context context) {
        super(context);
    }
    public void initData(){
        //覆蓋
        TextView tv=new TextView(context);
        tv.setText("新聞");
        tv.setGravity(Gravity .CENTER);
        tv.setTextColor(Color.RED);

        fl_content.addView(fl_content);

    }
}

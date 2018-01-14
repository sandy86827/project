package tw.com.lccnet.myproject2.basepage;

import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import tw.com.lccnet.myproject2.R;

/**
 * Created by asus on 2018/1/8.
 */

public class BasePage {
    //父類別
    public Context context;//activity也可以  代表傳進來的內容
    public View rootview;//初始化
    public FrameLayout fl_content;

    public  BasePage(Context context){
        this.context=context;
        rootview=initView();
    }

    private View initView(){
        View view=View.inflate(context, R.layout.base_page,null);
        fl_content=view.findViewById(R.id.fl_content);
        return  view;
    }
    public  void initData(){
        //資料內容的傳輸


    }


}

package com.lirui.hencoderplus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<String, String> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.rl_1);
        //打印出了3
        Log.i("222222222", maxDeep(view) + "");
    }
    private int maxDeep(View view) {
        //当前的view已经是最底层view了，不能往下累加层数了，返回0，代表view下面只有0层了
        if (!(view instanceof ViewGroup)) {
            return 0;
        }
        ViewGroup vp = (ViewGroup) view;
        //虽然是viewgroup，但是如果并没有任何子view，那么也已经是最底层view了，不能往下累加层数了，返回0，代表view下面只有0层了
        if (vp.getChildCount() == 0) {
            return 0;
        }
        //用来记录最大层数
        int max = 0;
        //广度遍历view
        for (int i = 0; i < vp.getChildCount(); i++) {
            //由于vp拥有子view，所以下面还有一层，因为可以+1，来叠加一层，然后再递归几岁算它的子view的层数
            int deep = maxDeep(vp.getChildAt(i)) + 1;
            //比较哪个大就记录哪个
            if (deep > max) {
                max = deep;
            }
        }
        return max;
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            map.put("1", "22");
        }
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            map.put("1", "222221");
        }
        return super.dispatchKeyEvent(event);
    }
}

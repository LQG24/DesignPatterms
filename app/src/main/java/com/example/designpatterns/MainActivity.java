package com.example.designpatterns;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.appcompat.app.AppCompatActivity;
/**
 * 子线程能否更新UI？
 *
 * 子线程能更新UI，但是不推荐这么做。
 * 一般说的子线程不能更新UI，是因为执行更新UI操作的时候会进行checkThread检查，checkThread判断如果当前线程不是UI线程就会抛出异常。
 * 而checkThread跟ViewRootImpl这个类的对象有关，那么只要ViewRootImpl的对象还未创建，就无法执行checkThread，也就是在子线程更新UI也不会报错。
 * ViewRootImpl的对象是在onResume()之后创建的，因此在onCreate()、onStart()、onResume()中可以做子线程更新UI
* */
public class MainActivity extends AppCompatActivity {
    private LinearLayout layout;

    private static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                TextView textView = new TextView(MainActivity.this);
                textView.setText("create text");
                layout.addView(textView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            }
        });
    }


    public void onTestClick(View view) {
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                ((TextView) layout.getChildAt(0)).setText("update text");
            }
        });
    }
}

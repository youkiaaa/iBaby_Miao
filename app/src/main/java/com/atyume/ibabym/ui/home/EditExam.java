package com.atyume.ibabym.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.atyume.ibabym.R;
import com.qmuiteam.qmui.widget.QMUITopBar;

public class EditExam extends AppCompatActivity {

    QMUITopBar exam_topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editexam);
    }
    protected void initTopBar(){
        exam_topbar = (QMUITopBar) findViewById(R.id.exam_topbar);
        exam_topbar.setTitle("新增体检套餐");
    }
}
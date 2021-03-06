package com.atyume.ibabym.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.atyume.greendao.gen.InoculationDao;
import com.atyume.greendao.gen.ParentInfoDao;
import com.atyume.ibabym.Model.InoculationModel;
import com.atyume.ibabym.Model.ParentModel;
import com.atyume.ibabym.R;
import com.atyume.ibabym.basics.Inoculation;
import com.atyume.ibabym.basics.MyApplication;
import com.atyume.ibabym.basics.ParentInfo;

import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.sql.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BabyAllInfo extends AppCompatActivity {

    @BindView(R.id.comeBack)
    TextView mComeBack;
    @BindView(R.id.show_babyName)
    EditText mShowBabyName;
    @BindView(R.id.show_babyBirth)
    EditText mShowBabyBirth;
    @BindView(R.id.update_babySexMale)
    RadioButton mMale;
    @BindView(R.id.update_babySexFemale)
    RadioButton mFemale;
    @BindView(R.id.show_babyHomead)
    EditText mShowBabyHome;
    @BindView(R.id.show_babyNowad)
    EditText mShowBabyNow;
    @BindView(R.id.show_parentName)
    EditText mShowParentName;
    @BindView(R.id.show_parentTell)
    EditText mShowParentTell;
    @BindView(R.id.show_parentWork)
    EditText mShowParentWork;
    @BindView(R.id.button_update_babyAll)
    QMUIRoundButton mbtnUpdateAll;

    String babyName,babyBirth,babySex,babyHomead,babyNowad,parentName,parentTell,parentWork;

    InoculationModel inoculationModel = new InoculationModel();
    ParentModel parentModel = new ParentModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_babyallinfo);
        ButterKnife.bind(this);

        Inoculation inoculation = getBaby();
        ParentInfo parentInfo = parentModel.selectById(inoculation.getParentId());
        initView(inoculation,parentInfo);

        mComeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BabyAllInfo.this.finish();
            }
        });
        mbtnUpdateAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getEditText();

                inoculationModel.updateBaby(inoculation,babyName,babyBirth,babySex,babyHomead,babyNowad);
                parentModel.updateParent(parentInfo,parentName,parentTell,parentWork);

                Intent intent = new Intent(BabyAllInfo.this, BabyViewActivity.class);
                Toast.makeText(BabyAllInfo.this,"修改了"+babyName+"宝宝",Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            }
        });
    }

    private Inoculation getBaby(){
        Intent intentGetId = getIntent();
        Long babyId = intentGetId.getLongExtra("manageBabyId",0L);
        return inoculationModel.selectBabyByBabyId(babyId);
    }


    private void initView(Inoculation inoculation, ParentInfo parentInfo){
        mShowBabyName.setText(inoculation.getInoculBaby());
        mShowBabyBirth.setText(inoculation.getBabyData());
        mShowBabyHome.setText(inoculation.getBabyHome());
        mShowBabyNow.setText(inoculation.getBabyAdress());
        mShowParentName.setText(parentInfo.getParentName());
        mShowParentTell.setText(parentInfo.getParentTell());
        mShowParentWork.setText(parentInfo.getParentWorkAdress());
        if((inoculation.getBabySex()).equals("男")){
            mMale.setChecked(true);
            mFemale.setChecked(false);
        }
        if((inoculation.getBabySex()).equals("女")){
            mMale.setChecked(false);
            mFemale.setChecked(true);
        }
    }

    private void getEditText(){
        babyName = mShowBabyName.getText().toString();
        babyBirth = mShowBabyBirth.getText().toString();
        babyHomead = mShowBabyHome.getText().toString();
        babyNowad = mShowBabyNow.getText().toString();

        parentName = mShowParentName.getText().toString();
        parentTell = mShowParentTell.getText().toString();
        parentWork = mShowParentWork.getText().toString();

        if(mMale.isChecked()){
            babySex = "男";
        }
        else{
            babySex = "女";
        }
    }

}


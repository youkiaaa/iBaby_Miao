package com.atyume.ibabym.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.atyume.ibabym.R;

import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    @BindView(R.id.adm_editMiao)
    Button adm_editMiao;
    @BindView(R.id.adm_editBaby)
    Button adm_editBaby;
    @BindView(R.id.adm_editExam)
    Button adm_editExam;
    @BindView(R.id.adm_editExPr)
    Button adm_editExPr;
    @BindView(R.id.adm_editOrder)
    Button adm_editOrder;
    @BindView(R.id.adm_editHos)
    Button adm_editHos;

    @BindView(R.id.home_topbar)
    QMUITopBar mbtnHomeTorBar;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,root);
        initTopBar();
        adm_editMiao.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),MiaoViewActivity.class);
                    startActivity(intent);
                }
            });

        adm_editBaby.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),BabyViewActivity.class);
                startActivity(intent);
            }
        });

        adm_editExam.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ExamViewActivity.class);
                startActivity(intent);
            }
        });

        adm_editExPr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ProjectViewActivity.class);
                startActivity(intent);
            }
        });

        /*adm_editOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),EditBaby.class);
                startActivity(intent);
            }
        });*/

        adm_editHos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HosViewActivity.class);
                startActivity(intent);
            }
        });
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    private void initTopBar(){
        mbtnHomeTorBar.setTitle("首页");
    }
    /*@Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Button adm_editMiao = (Button)getActivity().findViewById(R.id.adm_editMiao);
        adm_editMiao.setOnClickListener(new View.onClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(),"正在前往",Toast.LENGTH_LONG).show();
            }
        })
    }*/
}
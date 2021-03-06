package com.atyume.ibabym.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.atyume.greendao.gen.AdminUserDao;
import com.atyume.greendao.gen.ExamInfoDao;
import com.atyume.greendao.gen.HosInfoDao;
import com.atyume.greendao.gen.InoculationDao;
import com.atyume.greendao.gen.OrderExamInfoDao;
import com.atyume.greendao.gen.OrderVaccinDao;
import com.atyume.greendao.gen.ParentInfoDao;
import com.atyume.greendao.gen.VaccinDao;
import com.atyume.ibabym.Model.OrderExamModel;
import com.atyume.ibabym.R;
import com.atyume.ibabym.basics.AdminUser;
import com.atyume.ibabym.basics.ExamInfo;
import com.atyume.ibabym.basics.HosInfo;
import com.atyume.ibabym.basics.Inoculation;
import com.atyume.ibabym.basics.MyApplication;
import com.atyume.ibabym.basics.OrderExamInfo;
import com.atyume.ibabym.basics.OrderVaccin;
import com.atyume.ibabym.basics.ParentInfo;
import com.atyume.ibabym.basics.Vaccin;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class testActivity extends AppCompatActivity {
    @BindView(R.id.button_add)
    Button mbtnAdd;
    @BindView(R.id.button_select)
    Button mbtnSelect;
    @BindView(R.id.button_delete)
    Button mbtnDalete;
    @BindView(R.id.text_showAll)
    TextView mtextShow;
    @BindView(R.id.button_update)
    TextView mbtnUpdate;

    String all;

    private AdminUserDao adminUserDao = MyApplication.getInstances().getDaoSession().getAdminUserDao();
    private ParentInfoDao parentDao = MyApplication.getInstances().getDaoSession().getParentInfoDao();
    private InoculationDao babydao = MyApplication.getInstances().getDaoSession().getInoculationDao();
    private VaccinDao vaccinDao = MyApplication.getInstances().getDaoSession().getVaccinDao();
    private HosInfoDao hosInfoDao = MyApplication.getInstances().getDaoSession().getHosInfoDao();
    private ExamInfoDao examInfoDao = MyApplication.getInstances().getDaoSession().getExamInfoDao();
    private OrderExamInfoDao orderExamInfoDao = MyApplication.getInstances().getDaoSession().getOrderExamInfoDao();
    private OrderVaccinDao orderVaccinDao = MyApplication.getInstances().getDaoSession().getOrderVaccinDao();
    OrderExamModel orderExamModel = new OrderExamModel();


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        ButterKnife.bind(this);

    }
    @OnClick({R.id.button_add, R.id.button_select, R.id.button_delete, R.id.button_update})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_add:
                insertData();
                break;
            case R.id.button_select:
                selectData();
                break;
            case R.id.button_delete:
                deleteData();
                break;
            case R.id.button_update:
                updateData();
                break;
        }
    }
    private void selectData() {
        mtextShow.setText("");
        List<AdminUser> adminUserList = adminUserDao.loadAll();
        List<ParentInfo> parentInfos = parentDao.loadAll();
        List<Inoculation> inoculations = babydao.loadAll();
        List<Vaccin> vaccinList = vaccinDao.loadAll();
        List<HosInfo> hosInfoList = hosInfoDao.loadAll();
        List<ExamInfo> examInfoList = examInfoDao.loadAll();
        List<OrderExamInfo> orderExamInfoList = orderExamInfoDao.loadAll();
        List<OrderVaccin> orderVaccinList = orderVaccinDao.loadAll();
        /*for(ParentInfo parentInfo:parentInfos){]
            all=all.concat(parentInfo.toString());
        }*/
        mtextShow.setText(adminUserList.toString());
//        mtextShow.setText(parentInfos.toString()+"baby:"+inoculations.toString());
//        mtextShow.setText(parentInfos.toString()+"vaccin:"+vaccinList.toString()+"hos:"+hosInfoList.toString()+"exam:"+examInfoList.toString());
//        mtextShow.setText(orderExamInfoList.toString()+"----------"+orderVaccinList.toString()+"--------waitting people:"+orderExamModel.getOrderCountByDate("2020-03-31"));
    }

    private void insertData() {
        /*ParentInfo parentInfo = new ParentInfo(1L,"15159045183","福建省厦门市",null,null,"123456");
        long insert1 = parentDao.insert(parentInfo);
        if (insert1 > 0) {
            Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
        }
        Vaccin vaccin = new Vaccin("卡介苗","结核性脑膜炎、粟粒性肺结核","患有结核病、急性传染病、心肾脑等疾病、极度营养不良、湿疹及其它皮肤病，HⅣ感染者不予接种。使用前须先作结核菌素皮试，呈阴性者方可接种。",
                "在接种后3周左右，接种部位会出现红肿，中间逐渐软化，形成白色小脓疱，脓疱破溃后，脓汁排出，经过1-2 周才结痂，愈合后可留有圆形瘢痕。上述过程一般要持续2个月左右。接种卡介苗后还常引起接种部位附近的淋巴结肿大（多为腋下淋巴结肿大），这是正常反应，随着接种部位脓肿的愈合，肿大淋巴结也会自行消退。可以用热敷的方法促其消退，如果有脓疡形成，可以请医生用注射器将脓液抽出，促进愈合，一般不会影响孩子的健康。",
                "出生时","第1剂",0.00,"长春长生生物科技有限责任公司","201905070-1",2000L);
        long insert2 = vaccinDao.insert(vaccin);
        if (insert2 > 0) {
            Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
        }*/

        /*long insert3 = examInfoDao.insert(new ExamInfoActivity(1L,"小儿遗尿检查",98.0,"福建省福州市现代妇产医院"));
        if (insert3 > 0) {
            Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
        }*/
        AdminUser adminUser = new AdminUser("13959013685","123456");
        long insert1 = adminUserDao.insert(adminUser);
        if (insert1 > 0) {
            Toast.makeText(this, "插入成功", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteData(){
        /*parentDao.deleteByKey(2L);*/
        Long id1 = Long.valueOf(1);
        Long id2 = Long.valueOf(2);
        Long id3 = Long.valueOf(3);
//        babydao.deleteByKey(id1);
        //babydao.deleteByKey(id2);
        //hosInfoDao.deleteByKey(id3);
//        orderExamInfoDao.deleteByKey(id1);
//        orderVaccinDao.deleteByKey(id3);
        adminUserDao.deleteByKey(id1);
        adminUserDao.deleteByKey(id2);

    }

    private void updateData(){
//        Inoculation inoculation1 = babydao.queryBuilder().where(InoculationDao.Properties.Id.eq(Long.valueOf(1002))).unique();
//        inoculation1.setParentId(3L);
//        babydao.update(inoculation1);
        mbtnUpdate.setText("已失效");
        mbtnUpdate.setEnabled(false);
    }

}

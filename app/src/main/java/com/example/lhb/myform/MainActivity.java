package com.example.lhb.myform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lhb.mylibrary.DataBean;
import com.example.lhb.mylibrary.FormView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FormView formView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        formView = (FormView) findViewById(R.id.formView);

        List<DataBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new MyData("淘宝", "123", 12));
        }
        formView.setmDataList(list);
    }

    class MyData implements DataBean {

        String Xname, Yname;
        double yData;

        public MyData() {
        }

        public MyData(String xname, String yname, double yData) {
            Xname = xname;
            Yname = yname;
            this.yData = yData;
        }

        public String getXname() {
            return Xname;
        }

        public void setXname(String xname) {
            Xname = xname;
        }

        public String getYname() {
            return Yname;
        }

        public void setYname(String yname) {
            Yname = yname;
        }

        public double getyData() {
            return yData;
        }

        public void setyData(double yData) {
            this.yData = yData;
        }

        @Override
        public String getXName() {
            return Xname;
        }

        @Override
        public String getYName() {
            return Yname;
        }

        @Override
        public double getYData() {
            return yData;
        }
    }
}

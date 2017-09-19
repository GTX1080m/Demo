package com.example.lhb.mylibrary;

/**
 * Created by lhb on 2017/9/19.
 * Used To:
 */

public class DemoData implements DataBean {

    private String XName, YName;
    private double YData;

    public void setXName(String XName) {
        this.XName = XName;
    }

    public void setYName(String YName) {
        this.YName = YName;
    }

    public void setYData(double YData) {
        this.YData = YData;
    }

    public DemoData(String XName, String YName, double YData) {
        this.XName = XName;
        this.YName = YName;
        this.YData = YData;
    }

    public DemoData() {
    }

    @Override
    public String getXName() {
        return XName;
    }

    @Override
    public String getYName() {
        return YName;
    }

    @Override
    public double getYData() {
        return YData;
    }
}

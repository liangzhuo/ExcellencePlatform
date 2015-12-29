package com.liang.framework.bean;

/**
 * 返回数据对象
 * Created by liangz on 2015/12/29.
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}

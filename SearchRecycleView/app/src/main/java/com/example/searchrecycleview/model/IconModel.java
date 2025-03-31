package com.example.searchrecycleview.model;

import java.io.Serializable;

public class IconModel implements Serializable {
    private Integer imgId;

    public IconModel(Integer imgId, String desc) {
        this.desc = desc;
        this.imgId = imgId;
    }

    public IconModel() {}

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }
}

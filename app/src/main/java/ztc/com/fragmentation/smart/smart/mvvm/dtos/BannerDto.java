package ztc.com.fragmentation.smart.smart.mvvm.dtos;

import ztc.com.fragmentation.smart.smart.mvvm.base.BaseModel;

public class BannerDto extends BaseModel {

    private String lotteryCenterCode;
    private int pictureType;

    public String getLotteryCenterCode() {
        return lotteryCenterCode;
    }

    public void setLotteryCenterCode(String lotteryCenterCode) {
        this.lotteryCenterCode = lotteryCenterCode;
    }

    public int getPictureType() {
        return pictureType;
    }

    public void setPictureType(int pictureType) {
        this.pictureType = pictureType;
    }

    @Override
    public String toString() {
        return "BannerDto{" +
                "lotteryCenterCode='" + lotteryCenterCode + '\'' +
                ", pictureType=" + pictureType +
                '}';
    }
}

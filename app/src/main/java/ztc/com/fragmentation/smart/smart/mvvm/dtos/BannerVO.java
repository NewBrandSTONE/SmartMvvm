package ztc.com.fragmentation.smart.smart.mvvm.dtos;

import java.io.Serializable;

public class BannerVO implements Serializable {

    /**
     * bannerId : 20
     * lotteryCenterCode : WL0270003
     * pictureName : banner/wxpub_banner2.jpg
     * status : 10
     * linkUrl : http://ztc-ioms-tx.sit.sf-express.com/lottery-betting/coupon/spike/2
     * description :
     * startTime : 1566181816000
     * endTime : 1577764799000
     * createTime : 1567678328000
     * updateTime : null
     * imgUrl : https://lcop-test-1258277796.cos.ap-chengdu.myqcloud.com/banner/wxpub_banner2.jpg
     */

    private String bannerId;
    private String lotteryCenterCode;
    private String pictureName;
    private int status;
    private String linkUrl;
    private String description;
    private long startTime;
    private long endTime;
    private long createTime;
    private long updateTime;
    private String imgUrl;

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getLotteryCenterCode() {
        return lotteryCenterCode;
    }

    public void setLotteryCenterCode(String lotteryCenterCode) {
        this.lotteryCenterCode = lotteryCenterCode;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

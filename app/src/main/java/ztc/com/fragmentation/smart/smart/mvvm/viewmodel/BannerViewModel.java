package ztc.com.fragmentation.smart.smart.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ztc.com.fragmentation.smart.smart.mvvm.dtos.BannerVO;

public class BannerViewModel extends ViewModel {

    private MutableLiveData<BannerVO> bannerData = new MutableLiveData<>();

    public MutableLiveData<BannerVO> getBannerData() {
        return bannerData;
    }

}

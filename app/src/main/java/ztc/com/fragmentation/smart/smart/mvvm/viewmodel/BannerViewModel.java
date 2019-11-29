package ztc.com.fragmentation.smart.smart.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ztc.com.fragmentation.smart.smart.mvvm.dtos.BannerVO;

public class BannerViewModel extends ViewModel {

    private MutableLiveData<List<BannerVO>> bannerData = new MutableLiveData<>();

    public MutableLiveData<List<BannerVO>> getBannerData() {
        return bannerData;
    }

}

package ztc.com.fragmentation.smart.smart.mvvm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blankj.utilcode.util.ObjectUtils;
import com.orhanobut.logger.Logger;

import java.util.List;

import ztc.com.fragmentation.smart.smart.mvvm.base.BaseRequest;
import ztc.com.fragmentation.smart.smart.mvvm.base.BaseResponse;
import ztc.com.fragmentation.smart.smart.mvvm.databinding.ActivityMainBinding;
import ztc.com.fragmentation.smart.smart.mvvm.dtos.BannerDto;
import ztc.com.fragmentation.smart.smart.mvvm.dtos.BannerVO;
import ztc.com.fragmentation.smart.smart.mvvm.lifecycle.SmartLifeCycleObserver;
import ztc.com.fragmentation.smart.smart.mvvm.net.LcopApi;
import ztc.com.fragmentation.smart.smart.mvvm.net.LcopNetFactory;
import ztc.com.fragmentation.smart.smart.mvvm.viewmodel.BannerViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getLifecycle().addObserver(new SmartLifeCycleObserver());

        BannerViewModel bannerViewModel = ViewModelProviders.of(this).get(BannerViewModel.class);
        MutableLiveData<BannerVO> bannerData = bannerViewModel.getBannerData();
        bannerData.observe(this, bannerResponse -> {
            if (ObjectUtils.isNotEmpty(bannerResponse)) {
                mBinding.tvBannerUrl.setText(bannerResponse.getImgUrl());
            }
        });

        mBinding.btnSubmit.setOnClickListener(view -> {
            BannerVO bannerResponse = new BannerVO();
            bannerResponse.setImgUrl("http://www.baidu.com");
            bannerViewModel.getBannerData().setValue(bannerResponse);
        });


        getBanner();
    }

    private void getBanner() {
        LcopApi api = LcopNetFactory.get();
        BannerDto bannerDto = new BannerDto();
        bannerDto.setLotteryCenterCode("WL0270003");
        bannerDto.setPictureType(2);
        BaseRequest<BannerDto> bannerDtoBaseRequest = new BaseRequest<>();
        bannerDtoBaseRequest.setData(bannerDto);
        LiveData<BaseResponse<List<BannerVO>>> bannerList = api.getBannerList(bannerDtoBaseRequest);
        bannerList.observe(this, Logger::d);
    }
}

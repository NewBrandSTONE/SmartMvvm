package ztc.com.fragmentation.smart.smart.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;

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

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getLifecycle().addObserver(new SmartLifeCycleObserver());

//        BannerViewModel bannerViewModel = ViewModelProviders.of(this).get(BannerViewModel.class);
//        bannerViewModel.getBannerData()
//                .observe(this, bannerResponse -> {
//                    if (ObjectUtils.isNotEmpty(bannerResponse)) {
//                        mBinding.tvBannerUrl.setText(bannerResponse.getImgUrl());
//                    }
//                });
//
//        mBinding.btnSubmit.setOnClickListener(view -> {
//            BannerVO bannerResponse = new BannerVO();
//            bannerResponse.setImgUrl("http://www.baidu.com");
//            bannerViewModel.getBannerData().setValue(bannerResponse);
//        });


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

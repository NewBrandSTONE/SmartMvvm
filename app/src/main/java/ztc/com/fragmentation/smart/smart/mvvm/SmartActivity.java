package ztc.com.fragmentation.smart.smart.mvvm;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import ztc.com.fragmentation.smart.smart.mvvm.databinding.ActivitySmartBinding;
import ztc.com.fragmentation.smart.smart.mvvm.dtos.BannerVO;
import ztc.com.fragmentation.smart.smart.mvvm.viewmodel.BannerViewModel;

/**
 * @author 01380154
 * @version 2019/11/26
 */
public class SmartActivity extends AppCompatActivity implements BGABanner.Adapter<ImageView, String> {

    private ActivitySmartBinding mDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_smart);
        // 初始化Banner
        initBanner();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        requestBanner();
    }

    @Override
    public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
        Glide.with(itemView.getContext())
                .load(model)
                .into(itemView);
    }

    private void initBanner() {
        BGABanner bgaBanner = mDataBinding.bannerContent;
        bgaBanner.setAdapter(this);

        BannerViewModel bannerViewModel = ViewModelProviders.of(this).get(BannerViewModel.class);
        bannerViewModel.getBannerData().observe(this, bannerVOS -> {
            // 添加到BGABanner中
            List<String> imageList = new ArrayList<>();
            List<String> tipList = new ArrayList<>();

            for (BannerVO bannerVO : bannerVOS) {
                imageList.add(bannerVO.getImgUrl());
                tipList.add(bannerVO.getDescription());
            }

            bgaBanner.setData(imageList, tipList);
        });
    }

    private void requestBanner() {

    }
}

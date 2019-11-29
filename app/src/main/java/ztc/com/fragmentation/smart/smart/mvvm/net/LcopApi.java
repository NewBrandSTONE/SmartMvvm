package ztc.com.fragmentation.smart.smart.mvvm.net;

import android.arch.lifecycle.LiveData;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.POST;
import ztc.com.fragmentation.smart.smart.mvvm.base.BaseRequest;
import ztc.com.fragmentation.smart.smart.mvvm.base.BaseResponse;
import ztc.com.fragmentation.smart.smart.mvvm.dtos.BannerDto;
import ztc.com.fragmentation.smart.smart.mvvm.dtos.BannerVO;

public interface LcopApi {

    @POST("banner/listBanner")
    LiveData<BaseResponse<List<BannerVO>>> getBannerList(@Body BaseRequest<BannerDto> bannerDtoBaseRequest);

}

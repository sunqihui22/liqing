package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.PitchDayProductQueryData;
import com.shtoone.liqing.mvp.model.bean.PitchProductQueryData;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/23.
 * Email：hengzwdhengzwd@qq.com
 */

public interface DayProductQueryContract extends BaseContract {

    interface View extends BaseContract.View {
        void showloadingMore();

        void lodingMorecompleted();

        void showLoadMoreError(Throwable throwable);

        void responseLoadMore(PitchDayProductQueryData pitchDayProductQueryData);

        void responseDayProductQueryData(PitchDayProductQueryData pitchDayProductQueryData);
    }

    interface Presenter extends BaseContract.Presenter {
        void requestDayProductQueryData(Map<String, String> map);

        void loadMoreData(Map<String, String> map);
    }


}

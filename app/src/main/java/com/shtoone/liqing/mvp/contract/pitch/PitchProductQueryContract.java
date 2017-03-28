package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.PitchProductQueryData;
import com.shtoone.liqing.mvp.model.bean.WaterstabilityHistoryData;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public interface PitchProductQueryContract extends BaseContract {

    interface View extends BaseContract.View {
        void showloadingMore();

        void lodingMorecompleted();

        void showLoadMoreError(Throwable throwable);

        void responseLoadMore(PitchProductQueryData pitchProductQueryData);

        void responsePitchProductQueryData(PitchProductQueryData pitchProductQueryData);
    }

    interface Presenter extends BaseContract.Presenter {
        void requestPitchProductQueryData(Map<String, String> map);

        void loadMoreData(Map<String, String> map);
    }
}

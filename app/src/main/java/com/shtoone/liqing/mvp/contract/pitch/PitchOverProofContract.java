package com.shtoone.liqing.mvp.contract.pitch;

import com.shtoone.liqing.mvp.contract.base.BaseContract;
import com.shtoone.liqing.mvp.model.bean.PitchOverProofData;
import com.shtoone.liqing.mvp.model.bean.WaterStabilityOverProofBean;

import java.util.Map;

/**
 * Author： hengzwd on 2017/3/16.
 * Email：hengzwdhengzwd@qq.com
 */

public interface PitchOverProofContract extends BaseContract {


    interface View extends BaseContract.View {
        void showloadingMore();

        void lodingMorecompleted();

        void showLoadMoreError(Throwable throwable);

        void responseLoadMore(PitchOverProofData pitchOverProofData);

        void responsePitchOverProofData(PitchOverProofData pitchOverProofData);
    }

    interface Presenter extends BaseContract.Presenter {
        void requestPitchOverProofData(Map<String, String> map);

        void loadMoreData(Map<String, String> map);
    }
}

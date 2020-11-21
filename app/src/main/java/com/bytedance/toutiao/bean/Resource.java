package com.bytedance.toutiao.bean;

import android.util.Log;

import com.bytedance.toutiao.bean.basebean.ResponseModel;

/**
 * Data : 2020/10/28
 * Time : 16:50
 * Author : 刘朝阳
 */
public class Resource<T> {
    //状态  这里有多个状态 0表示加载中；1表示成功；2表示联网失败；3表示接口虽然走通，但走的失败（如：关注失败）
    public static final int LOADING = 0;
    public static final int SUCCESS = 1;
    public static final int ERROR = 2;
    public static final int FAIL = 3;
    public int state;

    public String errorMsg;
    public T data;
    public Throwable error;



    public Resource(int state, T data, String errorMsg) {
        this.state = state;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public Resource(int state, Throwable error) {
        this.state = state;
        this.error = error;
    }

    public static <T> Resource<T> loading(String showMsg) {
        return new Resource<>(LOADING, null, showMsg);
    }

    public static <T> Resource<T> success(T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> response(ResponseModel<T> data) {
        if (data != null) {
            Log.e("data", "no null");
            if (data.isSuccess()) {
                Log.e("success", "success");
                return new Resource<>(SUCCESS, data.getData(), null);
            }
            return new Resource<>(FAIL, null, data.getErrorMsg());
        }else Log.e("data", " null");
        return new Resource<>(ERROR, null, null);
    }


    public static <T> Resource<T> failure(String msg) {
        return new Resource<>(ERROR, null, msg);
    }

    public static <T> Resource<T> error(Throwable t) {
        return new Resource<>(ERROR, t);
    }



    public void handler(OnHandleCallback<T> callback) {
        switch (state) {
            case LOADING:
                callback.onLoading(errorMsg);
                break;
            case SUCCESS:
                callback.onSuccess(data);
                break;
            case FAIL:
                callback.onFailure(errorMsg);
                break;
            case ERROR:
                callback.onError(error);
                break;
        }

        if (state != LOADING) {
            callback.onCompleted();
        }
    }


//    public void handler(OnHandleCallback<T> callback, SmartRefreshLayout smartRefreshLayout) {
//        switch (state) {
//            case LOADING:
//                callback.onLoading(errorMsg);
//                break;
//            case SUCCESS:
//                callback.onSuccess(data);
//                smartRefreshLayout.finishRefresh();
//                smartRefreshLayout.finishLoadMore();
//                break;
//            case FAIL:
//                callback.onFailure(errorMsg);
//                smartRefreshLayout.finishRefresh(false);
//                smartRefreshLayout.finishLoadMore(false);
//                break;
//            case ERROR:
//                callback.onError(error);
//                smartRefreshLayout.finishRefresh(false);
//                smartRefreshLayout.finishLoadMore(false);
//                break;
//            case PROGRESS:
//                callback.onProgress(precent,total);
//                break;
//        }
//
//        if (state != LOADING) {
//            callback.onCompleted();
//        }
//    }



    public interface OnHandleCallback<T> {
        void onLoading(String showMessage);

        void onSuccess(T data);

        void onFailure(String msg);

        void onError(Throwable error);

        void onCompleted();

        void onProgress(int precent,long total);
    }


}

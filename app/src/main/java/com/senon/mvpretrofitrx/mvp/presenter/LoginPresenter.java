package com.senon.mvpretrofitrx.mvp.presenter;

import android.content.Context;
import com.senon.mvpretrofitrx.mvp.base.BaseResponse;
import com.senon.mvpretrofitrx.mvp.contract.LoginContract;
import com.senon.mvpretrofitrx.mvp.entity.Login;
import com.senon.mvpretrofitrx.mvp.model.LoginModel;
import com.senon.mvpretrofitrx.mvp.progress.ObserverResponseListener;
import com.senon.mvpretrofitrx.mvp.utils.ExceptionHandle;
import com.senon.mvpretrofitrx.mvp.utils.ToastUtil;

import java.util.HashMap;
import java.util.List;

import retrofit2.http.GET;

/**
 */
public class LoginPresenter extends LoginContract.Presenter {

    private LoginModel model;
    private Context context;

    public LoginPresenter(Context context) {
        this.model = new LoginModel();
        this.context = context;
    }

    @Override
    public void login(HashMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.login(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if(getView() != null){
                    getView().result((BaseResponse<List<Login>>) o);
                    getView().setMsg("请求成功");
                }
            }
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if(getView() != null){
                //自定义处理异常
                ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

    @Override
    public void logout(HashMap<String, String> map, boolean isDialog, boolean cancelable) {
        model.logout(context, map, isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if(getView() != null){
                    getView().logoutResult((BaseResponse<List<Login>>) o);
                    getView().setMsg("请求成功");
                }
            }
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if(getView() != null){
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

    @Override
    public void getChapters(boolean isDialog, boolean cancelable) {
        model.getChapters(context,isDialog, cancelable, getView().bindLifecycle(),new ObserverResponseListener() {
            @Override
            public void onNext(Object o) {
                //这一步是必须的，判断view是否已经被销毁
                if(getView() != null){
                    BaseResponse<List<Login>> response = (BaseResponse<List<Login>>) o;
                    if(response.getCode() == 0){
                        getView().getChaptersResult(response);
                        getView().setMsg("请求成功");
                    }else {
                        getView().setMsg("请求失败,errorCode: "+response.getCode());
                    }
                }
            }
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if(getView() != null){
                    ToastUtil.showShortToast(ExceptionHandle.handleException(e).message);
                }
            }
        });
    }

}

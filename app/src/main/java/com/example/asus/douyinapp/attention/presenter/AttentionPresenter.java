package com.example.asus.douyinapp.attention.presenter;


import com.example.asus.douyinapp.attention.model.AttentionModel;
import com.example.asus.douyinapp.attention.view.IView;

public class AttentionPresenter extends IPresenter<IView>{
    private AttentionModel model;
    public AttentionPresenter(IView iView) {
        super(iView);
    }

    @Override
    protected void init() {
        model = new AttentionModel();
    }
}

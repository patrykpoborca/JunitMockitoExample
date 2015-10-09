package io.ppoborca.junittutorial.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class PresenterActivity<T extends BasePresenter> extends AppCompatActivity implements IBasePresenterView{

    private T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            presenter = presenterClass().newInstance();
            presenter.setResources(getResources());
            presenter.registerPresenterView(this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public T getPresenter(){
        return presenter;
    }

    public abstract Class<T> presenterClass();
}

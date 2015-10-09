package io.ppoborca.junittutorial.base;

import android.content.res.Resources;

public class BasePresenter<T extends IBasePresenterView> {

    private Resources resources;
    private T presenterView;

    public void onAttach(){

    }

    public void onDettach(){

    }

    public void setResources(Resources resources){
        if(this.resources != null){
            throw new IllegalStateException("Cannot provide resources twice");
        }
        this.resources = resources;
    }

    protected Resources getResources(){
        return resources;
    }

    public T getPresenterView() {
        return presenterView;
    }

    public void registerPresenterView(T presenterView) {
        this.presenterView = presenterView;
    }
}

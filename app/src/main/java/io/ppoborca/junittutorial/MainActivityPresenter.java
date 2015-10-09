package io.ppoborca.junittutorial;

import io.ppoborca.junittutorial.base.BasePresenter;

public class MainActivityPresenter extends BasePresenter<IMainActivity> {


    public void fabClicked() {
        getPresenterView().showToast(getResources().getString(R.string.hello_world));
    }
}

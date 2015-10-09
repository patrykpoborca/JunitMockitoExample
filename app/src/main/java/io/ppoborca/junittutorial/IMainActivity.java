package io.ppoborca.junittutorial;

import io.ppoborca.junittutorial.base.IBasePresenterView;

public interface IMainActivity extends IBasePresenterView {
    void showToast(String message);
}

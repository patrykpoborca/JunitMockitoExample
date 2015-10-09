package io.ppoborca.junittutorial;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import io.ppoborca.junittutorial.mocks.MockedResources;

public class MainActivityPresenterTestOptionTwo implements IMainActivity {

    private static final String SOME_MOCKED_MESSAGE = "Some Mocked Message";
    private MockedResources resources;
    private MainActivityPresenter mainActivityPresenter;

    @Before
    public void setup(){
        resources = new MockedResources();
        mainActivityPresenter = new MainActivityPresenter();
        mainActivityPresenter.registerPresenterView(this);
        mainActivityPresenter.setResources(resources);
    }

    @Test
    public void testToastMessage(){
        resources.addString(R.string.hello_world, SOME_MOCKED_MESSAGE);
        mainActivityPresenter.fabClicked();
    }

    @Override
    public void showToast(String message) {
        Assert.assertTrue(SOME_MOCKED_MESSAGE.equals(message));
    }
}

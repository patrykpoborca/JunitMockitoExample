package io.ppoborca.junittutorial;

import android.content.res.Resources;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MainActivityPresenterTestOptionOne implements IMainActivity {

    private static final String SOME_MOCKED_MESSAGE = "Some Mocked Message";
    private Resources resources;
    private MainActivityPresenter mainActivityPresenter;

    @Before
    public void setup(){
        resources = Mockito.mock(Resources.class);

        Mockito.when(resources.getString(Mockito.any(Integer.class))).then(
                new Answer<String>() {
                    @Override
                    public String answer(InvocationOnMock invocation) throws Throwable {
                        if(((int)invocation.getArguments()[0]) == R.string.hello_world){
                            return SOME_MOCKED_MESSAGE;
                        }
                        else return null;
                    }
                }
        );

        mainActivityPresenter = new MainActivityPresenter();
        mainActivityPresenter.registerPresenterView(this);
        mainActivityPresenter.setResources(resources);
    }

    @Test
    public void testToastMessage(){
        mainActivityPresenter.fabClicked();
    }

    @Override
    public void showToast(String message) {
        Assert.assertTrue(SOME_MOCKED_MESSAGE.equals(message));
    }
}

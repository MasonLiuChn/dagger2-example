package net.grzechocinski.android.dagger2example.home;

import android.content.Context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HomeActivityTest {

//    @InjectMocks
//    private Context mockContext;

    @Test
    public void shouldBeTrue() throws Exception {
        Context context = Mockito.mock(Context.class);
        context.getCacheDir();
        System.out.print("aaaaa" + context.getCacheDir());
    }

}

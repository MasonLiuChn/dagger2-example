package net.grzechocinski.android.dagger2example;

import android.app.Application;
import android.content.Context;

import net.grzechocinski.android.dagger2example.internal.di.D2EComponent;
import net.grzechocinski.android.dagger2example.internal.di.DaggerD2EComponent;
import net.grzechocinski.android.dagger2example.internal.di.SystemServicesModule;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Component 是连接 Provider(提供者) 和 Injector(使用者)，然后由Injector返回Provider提供的实例。
 * dagger2 生成的代码有 Component 、Provider、Injector。
 * module 是 Provider 的集合。
 **/
public abstract class D2EBaseApplication extends Application {

    private D2EComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponentAndInject();
    }

    public void buildComponentAndInject() {
        component = DaggerComponentInitializer.init(this);
    }

    public static D2EComponent component(Context context) {
        return ((D2EBaseApplication) context.getApplicationContext()).component;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public final static class DaggerComponentInitializer {

        public static D2EComponent init(D2EBaseApplication app) {
            return DaggerD2EComponent.builder()
                    .systemServicesModule(new SystemServicesModule(app))
                    .build();
        }

    }
}

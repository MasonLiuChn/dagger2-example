package net.grzechocinski.android.dagger2example.internal.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * This class is in release/ folder. You can use it to define injects or getters for dependencies only in release variant
 */
@Singleton
@Component(modules = {SystemServicesModule.class, D2EUtilsModule.class})//这里是provider
public interface D2EComponent extends D2EGraph {
    //这里是Injector
}

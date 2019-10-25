package com.example.myvoting.di.Components;


import android.content.Context;
import com.example.myvoting.di.modules.ContextModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class})
public interface AppComponent {
    Context getContextModule();
}

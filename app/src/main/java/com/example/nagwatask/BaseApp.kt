package com.example.nagwatask

import androidx.fragment.app.Fragment
import com.example.nagwatask.data.di.DaggerDataComponent
import com.example.nagwatask.data.di.DataComponent
import com.example.nagwatask.domin.di.DaggerDomainComponent
import com.icon.tamapp.presentation.di.DaggerPresentationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class BaseApp : DaggerApplication() {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    private var dataComponent: DataComponent? = null

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        dataComponent = DaggerDataComponent.builder().bindContext(this).build()
        val domainComponent = DaggerDomainComponent.builder().dataComponent(dataComponent).build()
        val presentationComponent = DaggerPresentationComponent.builder()
            .domainComponent(domainComponent).build()
        presentationComponent.inject(this)
        return presentationComponent
    }
}
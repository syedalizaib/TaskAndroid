package com.taskandroid.di.component

import com.taskandroid.di.module.AppModule
import com.taskandroid.di.module.RetrofitModule
import com.taskandroid.ui.BaseFragment
import com.taskandroid.ui.MainActivity
import com.taskandroid.ui.ingredients.IngredientsFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent {
    fun inject(baseFragment: BaseFragment)
    fun inject(quizPlayFragment: IngredientsFragment)
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun appModule(appModule: AppModule): Builder
        fun retrofitModule(retrofitModule: RetrofitModule): Builder
    }
}

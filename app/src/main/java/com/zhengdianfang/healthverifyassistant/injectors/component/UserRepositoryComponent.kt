package com.zhengdianfang.healthverifyassistant.injectors.component

import com.zhengdianfang.healthverifyassistant.injectors.module.UserModule
import com.zhengdianfang.healthverifyassistant.viewmodel.UserViewModel
import dagger.Component

/**
 * Created by dfgzheng on 20/01/2018.
 */
@Component(modules = arrayOf(UserModule::class))
interface UserRepositoryComponent {
    fun inject(viewModel: UserViewModel)
}

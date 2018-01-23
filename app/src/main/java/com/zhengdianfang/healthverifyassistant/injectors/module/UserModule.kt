package com.zhengdianfang.healthverifyassistant.injectors.module

import com.zhengdianfang.healthverifyassistant.repository.UserRepository
import dagger.Module
import dagger.Provides

/**
 * Created by dfgzheng on 20/01/2018.
 */
@Module
class UserModule {
    @Provides
    fun provideUserRepository() : UserRepository {
        return UserRepository()
    }
}
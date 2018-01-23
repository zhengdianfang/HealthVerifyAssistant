package com.zhengdianfang.healthverifyassistant.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.zhengdianfang.healthverifyassistant.entitiy.User
import com.zhengdianfang.healthverifyassistant.injectors.component.DaggerUserRepositoryComponent
import com.zhengdianfang.healthverifyassistant.repository.UserRepository
import javax.inject.Inject

/**
 * Created by dfgzheng on 20/01/2018.
 */
class UserViewModel: ViewModel {

    constructor() {
        DaggerUserRepositoryComponent.create().inject(this)
    }

    private var user: LiveData<User>? = null

    @Inject
    lateinit var userRepo: UserRepository

    fun getUser(userId: String): LiveData<User>? {
        if (user == null) {
            user = userRepo.getUser(userId)
        }
        return user
    }
}
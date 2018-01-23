package com.zhengdianfang.healthverifyassistant.datasource.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Database
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import android.arch.persistence.room.RoomDatabase
import com.zhengdianfang.healthverifyassistant.entitiy.User

/**
 * Created by dfgzheng on 20/01/2018.
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}

interface UserDao {
    @Insert(onConflict = REPLACE)
    fun save(user: User)

    @Query("SELECT * FROM user WHERE id = :id")
    fun load(id: String): LiveData<User>
}
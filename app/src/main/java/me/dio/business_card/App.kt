package me.dio.business_card

import android.app.Application
import me.dio.business_card.data.AppDatabase
import me.dio.business_card.data.BusinessCardRepository


class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}
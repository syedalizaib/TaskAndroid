package com.taskandroid.constant

class Constants {
    companion object {
        const val SHARED_PREF_NAME = "TASK"
        const val BASE_URL = "https://opentdb.com/"

    }

    object ADAPTER_TYPES {
        const val ORDER_ADAPTER = 1
        const val INGREDIENT_ADAPTER = 2
        const val ADDON_ADAPTER = 3
        const val ORDER_ACCEPTED = 4
        const val ORDER_REJECT = 5
        const val PLAY_RINGTONE = 6
        const val PAUSE_RINGTONE = 7
    }
}
package com.mightyhedgehog.doplanner.presentation.screen.daily

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mightyhedgehog.doplanner.presentation.handler.SimpleHandler

class DailyUpdateHandler : SimpleHandler<Unit> {
    override val data: LiveData<Unit> = MutableLiveData()

    override fun update(value: Unit) {
        (data as MutableLiveData).postValue(Unit)
    }
}

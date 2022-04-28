package com.mightyhedgehog.doplanner.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.mightyhedgehog.doplanner.data.local.datastore.ThemeDataStore
import com.mightyhedgehog.doplanner.ui.theme.style.DoPlannerStyle
import com.mightyhedgehog.doplanner.ui.theme.DoPlannerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var dataStore: ThemeDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //val styleFlow = dataStore.getStyle
            val currentStyle = dataStore.getStyle.collectAsState(DoPlannerStyle.GREEN.name)

            Log.i("test", currentStyle.value.toString())

            DoPlannerTheme(
                style = DoPlannerStyle.valueOf(currentStyle.value!!)
            ) {
                MainScreen()
            }
        }
    }
}

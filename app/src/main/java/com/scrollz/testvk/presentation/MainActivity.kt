package com.scrollz.testvk.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.scrollz.testvk.presentation.catalog.CatalogScreen
import com.scrollz.testvk.theme.TestVKTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestVKTheme {
                CatalogScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

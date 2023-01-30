package com.makeevrserg.kmmplayground.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.makeevrserg.kmmplayground.presentation.sample.SampleScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleScreen{

            }
        }
    }
}
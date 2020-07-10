package ru.skillbranch.gameofthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.skillbranch.gameofthrones.repositories.RootRepository
import ru.skillbranch.gameofthrones.utils.RestApiService

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        RootRepository.getAllHouses {

        }
    }
}
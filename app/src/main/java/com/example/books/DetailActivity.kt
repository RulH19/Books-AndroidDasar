package com.example.books

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.books.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var detail = intent.getParcelableExtra<Books>("DETAIL")

        binding.photoReceived.setImageResource(detail?.photo!!)
        binding.judulReceived.text = detail?.name

        val judul = listOf("Fur Immer Dein Ian","Majnun", "I Think I Love You", "Where Stories Begin",
                            "Ramai Yang Dulu Kita Bawa Pergi", "172 Days", "Funiculi Funicula (Before the Coffee Gets Cold)",
                            "Terpikat", "Oh My Savior", "The Chronicles of Narnia #1: The Magician`s Nephew",
                            "Heartbreak Motel", "Sagaragas")

        val appThemeList = resources.getStringArray(R.array.sinopsis_books_detail)
        binding.sinopsisReceived.text = when(detail?.name){
            judul[0] -> appThemeList[0]
            judul[1] -> appThemeList[1]
            judul[2] -> appThemeList[2]
            judul[3] -> appThemeList[3]
            judul[4] -> appThemeList[4]
            judul[5] -> appThemeList[5]
            judul[6] -> appThemeList[6]
            judul[7] -> appThemeList[7]
            judul[8] -> appThemeList[8]
            judul[9] -> appThemeList[9]
            judul[10] -> appThemeList[10]
            judul[11] -> appThemeList[11]
            else -> "gk ada isinya"
        }

        binding.authorReceived.text= when(detail?.name){
            judul[0] -> "Valerie"
            judul[1] -> "Anton Kurnia"
            judul[2] -> "Cha Mirae"
            judul[3] -> "Wacaku"
            judul[4] -> "Suci Berliana"
            judul[5] -> "Nadzira Shafa"
            judul[6] -> "Toshikazu Kawaguchi"
            judul[7] -> "Ghefira Zakhira"
            judul[8] -> "Washashira"
            judul[9] -> "Staples Lewis "
            judul[10] -> "Ika Natassa"
            judul[11] -> "Tere Liye"
            else -> "gk ada isinya"
        }
//        binding.sinopsisReceived.text = detail?.description


    }
}
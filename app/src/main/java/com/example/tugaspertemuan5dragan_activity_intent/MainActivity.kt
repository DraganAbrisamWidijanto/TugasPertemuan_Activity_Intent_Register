package com.example.tugaspertemuan5dragan_activity_intent

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan5dragan_activity_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Mendefinisikan kunci-kunci (keys) yang akan digunakan untuk mengirim data antar aktivitas.
    // Misalnya, "EXTRA_USERNAME" digunakan untuk mengidentifikasi data username.
    companion object {
        const val EXTRA_USERNAME = "username"
        const val EXTRA_EMAIL = "email"
        const val EXTRA_PHONE = "phone"
        const val EXTRA_PASSWORD = "password"
    }

    // Metode ini dipanggil saat aktivitas (halaman) ini pertama kali dibuat.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan tampilan layout dengan aktivitas ini.
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            // Menghubungkan tindakan (aksi) tombol "Register" dengan kode yang akan dijalankan.
            btnRegister.setOnClickListener{
                // Mengambil teks dari kotak isian (EditText) untuk username, email, phone, dan password.
                val intentToHome = Intent(this@MainActivity,HomepageActivity::class.java)
                val username = ETUsername.text.toString()
                val email = ETEMail.text.toString()
                val phone = ETPhone.text.toString()
                val password = ETPassword.text.toString()

                // Menyertakan data-data tersebut dalam "surat" (Intent).
                intentToHome.putExtra(EXTRA_USERNAME, username)
                intentToHome.putExtra(EXTRA_EMAIL, email)
                intentToHome.putExtra(EXTRA_PHONE, phone)
                intentToHome.putExtra(EXTRA_PASSWORD, password)

                // Mengirim "surat" (Intent) untuk memulai halaman "HomepageActivity".
                startActivity(intentToHome)
            }
        }
    }
}
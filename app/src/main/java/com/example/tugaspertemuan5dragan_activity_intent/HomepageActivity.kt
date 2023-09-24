package com.example.tugaspertemuan5dragan_activity_intent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.tugaspertemuan5dragan_activity_intent.MainActivity.Companion.EXTRA_USERNAME
import com.example.tugaspertemuan5dragan_activity_intent.databinding.ActivityHomepageBinding

class HomepageActivity: AppCompatActivity() {

private lateinit var binding: ActivityHomepageBinding

    // Membuat objek 'launcher' untuk mengelola aktivitas dan hasilnya.
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Ini adalah kode yang akan dijalankan ketika aktivitas yang dimulai telah selesai.

        // Di sini kita memeriksa apakah aktivitas selesai dengan sukses (RESULT_OK).
        if (result.resultCode == RESULT_OK) {
            // Mengambil data yang dikirimkan kembali dari aktivitas yang dimulai.
            val data = result.data

            // Mengambil nilai-nilai tertentu dari data, seperti username, email, dan nomor telepon.
            val username = data?.getStringExtra(EXTRA_USERNAME)
            val email = data?.getStringExtra(MainActivity.EXTRA_EMAIL)
            val phone = data?.getStringExtra(MainActivity.EXTRA_PHONE)

            // Memeriksa apakah data-data tersebut tidak kosong.
            if (!username.isNullOrEmpty() && !email.isNullOrEmpty() && !email.isNullOrEmpty()) {
                // Jika data-data valid, kita menampilkannya di layar.
                binding.txtUsername.text = "$username"
                binding.txtEmail.text = "$email"
                binding.txtPhone.text = "$phone"
            }
        }
    }

    /**
     * Metode onCreate dipanggil ketika aktivitas ini pertama kali dibuat.
     * Di dalam metode ini, kita menginisialisasi tampilan dan menangani hasil yang diterima dari aktivitas lain.
     *
     * @param savedInstanceState Objek Bundle yang berisi data sebelumnya jika ada.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data yang dikirimkan dari MainActivity
        var username = intent.getStringExtra(EXTRA_USERNAME)
        var email = intent.getStringExtra(MainActivity.EXTRA_EMAIL)
        var phone = intent.getStringExtra(MainActivity.EXTRA_PHONE)

        // Menampilkan data pada elemen UI
        with(binding){
            binding.txtUsername.text = "$username"
            binding.txtEmail.text = "$email"
            binding.txtPhone.text = "$phone"

            // Mengatur aksi ketika tombol "Logout" ditekan
            val btnLogout = findViewById<Button>(R.id.btn_logout)
            btnLogout.setOnClickListener {
                // Membuat Intent untuk kembali ke halaman register (mainActivity)
                val intentToMainActivity = Intent(this@HomepageActivity, MainActivity::class.java)

                // Menambahkan flag untuk menghapus semua activity sebelumnya (agar tidak dapat kembali)
                intentToMainActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                // Memulai aktivitas (kembali ke halaman login)
                startActivity(intentToMainActivity)
            }
        }
    }
}

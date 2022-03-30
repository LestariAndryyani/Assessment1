package org.d3if2034.healthy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import org.d3if2034.healthy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener { hitungBmr() }
    }

        private fun hitungBmr() {
            val berat = binding.beratEditText.text.toString()
            if (TextUtils.isEmpty(berat)) {
                Toast.makeText(this, R.string.berat_invalid, Toast.LENGTH_LONG).show()
                return
            }
            val tinggi = binding.tinggiEditText.text.toString()
            if (TextUtils.isEmpty(tinggi)) {
                Toast.makeText(this, R.string.tinggi_invalid, Toast.LENGTH_LONG).show()
                return
            }
            val usia = binding.usiaEditText.text.toString()
            if (TextUtils.isEmpty(usia)) {
                Toast.makeText(this, R.string.usia_invalid, Toast.LENGTH_LONG).show()
                return
            }
            val kategoriKegiatan = binding.kategoriKegiatanEditText.text.toString()
            if (TextUtils.isEmpty(kategoriKegiatan)) {
                Toast.makeText(this, R.string.kk_invalid, Toast.LENGTH_LONG).show()
                return
            }


            val selectedId = binding.radioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                Toast.makeText(this, R.string.gender_invalid, Toast.LENGTH_LONG).show()
                return
            }

            val isMale = selectedId == R.id.priaRadioButton
            val bmr = ((66 + (1.37 * berat.toFloat()) + ( 5 * tinggi.toFloat()) - (6.8 * usia.toFloat())) * kategoriKegiatan.toFloat())
            binding.bmrTextView.text = getString(R.string.bmr_x, bmr)


        }
}
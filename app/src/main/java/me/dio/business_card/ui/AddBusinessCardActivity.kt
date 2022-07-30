package me.dio.business_card.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Toast
import androidx.activity.viewModels
import me.dio.business_card.App
import me.dio.business_card.R
import me.dio.business_card.data.BusinessCard


class AddBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy {ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners(){
        binding.ibClose.setOnClickListener{
            finish()
        }

        binding.btnConfirm.setOnClickListener{
            val businessCard = BusinessCard(
                nome = binding.tilName.editText?.text.toString(),
                empresa = binding.tilCompany.editText?.text.toString(),
                telefone = binding.tilTelephone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success,Toast.LENGTH_SHORT). show()
            finish()
        }
    }
}

class ActivityAddBusinessCardBinding {

}

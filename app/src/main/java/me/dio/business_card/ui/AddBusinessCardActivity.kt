package me.dio.business_card.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate


class AddBusinessCardActivity : AppCompatActivity() {
    private val binding by lazy {ActivityAddBusinessCardBinding.inflate(layoutInflater) }

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

        }
    }
}

class ActivityAddBusinessCardBinding {

}

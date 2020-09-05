package nl.omererdem.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import nl.omererdem.madlevel1task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var totalCorrectAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.submitBtn.setOnClickListener {
            onSubmit()
        }
    }

    private fun onSubmit() {
        if (binding.input1.text.toString().toLowerCase() == "t") {
            totalCorrectAnswers++
        }
        if (binding.input2.text.toString().toLowerCase() == "f") {
            totalCorrectAnswers++
        }
        if (binding.input3.text.toString().toLowerCase() == "f") {
            totalCorrectAnswers++
        }
        if (binding.input4.text.toString().toLowerCase() == "f") {
            totalCorrectAnswers++
        }
        showToast()
        resetScore()
    }

    private fun showToast() {
        Toast.makeText(this, getString(R.string.correct_answer, totalCorrectAnswers), Toast.LENGTH_LONG).show()
    }

    private fun resetScore() {
        totalCorrectAnswers = 0
    }
}
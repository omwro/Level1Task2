package nl.omererdem.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import nl.omererdem.madlevel1task2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var totalCorrectAnswers: Int = 0
    private var answersMap = emptyMap<EditText, String>()

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
        answersMap = mapOf(
            binding.input1 to "t",
            binding.input2 to "f",
            binding.input3 to "f",
            binding.input4 to "f"
        )
    }

    private fun onSubmit() {
        for ((input, answer) in answersMap) {
            if (input.text.toString().toLowerCase() == answer) {
                totalCorrectAnswers++
            }
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
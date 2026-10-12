package project.casestudy2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import project.casestudy2.model.LLMRequest
import project.casestudy2.network.ApiClient

class MainActivity : AppCompatActivity() {

    private lateinit var edtPrompt: EditText
    private lateinit var spinnerModel: Spinner
    private lateinit var btnEvaluate: Button
    private lateinit var progressBar: ProgressBar

    private val models = listOf(
        "OpenAI",
        "Gemini",
        "Ollama",
        "HuggingFace"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPrompt = findViewById(R.id.edtPrompt)
        spinnerModel = findViewById(R.id.spinnerModel)
        btnEvaluate = findViewById(R.id.btnEvaluate)
        progressBar = findViewById(R.id.progressBar)

        progressBar.visibility = View.GONE

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            models
        )

        spinnerModel.adapter = adapter

        btnEvaluate.setOnClickListener {

            val prompt = edtPrompt.text.toString().trim()

            if (prompt.isEmpty()) {
                edtPrompt.error = "Enter Prompt"
                return@setOnClickListener
            }

            val request = LLMRequest(
                prompt,
                spinnerModel.selectedItem.toString()
            )

            callEvaluationAPI(request)
        }
    }

    private fun callEvaluationAPI(request: LLMRequest) {

        progressBar.visibility = View.VISIBLE

        lifecycleScope.launch {

            try {

                val response =
                    ApiClient.apiService.evaluate(request)

                progressBar.visibility = View.GONE

                if (response.isSuccessful && response.body() != null) {

                    val result = response.body()!!

                    val intent =
                        Intent(this@MainActivity, ResultActivity::class.java)

                    intent.putExtra("generatedText", result.generatedText)
                    intent.putExtra("accuracy", result.accuracy)
                    intent.putExtra("coherence", result.coherence)
                    intent.putExtra("perplexity", result.perplexity)
                    intent.putExtra("bleu", result.bleu)
                    intent.putExtra("rouge", result.rouge)

                    startActivity(intent)

                } else {

                    Toast.makeText(
                        this@MainActivity,
                        "Evaluation Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } catch (e: Exception) {

                progressBar.visibility = View.GONE

                Toast.makeText(
                    this@MainActivity,
                    e.localizedMessage,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
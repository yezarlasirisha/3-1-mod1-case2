package project.casestudy2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import project.casestudy2.model.Metric

class ResultActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var txtGenerated: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_result)

        recyclerView = findViewById(R.id.recyclerMetrics)
        txtGenerated = findViewById(R.id.txtGeneratedText)

        val generatedText =
            intent.getStringExtra("generatedText") ?: ""

        txtGenerated.text = generatedText

        val metrics = arrayListOf(

            Metric(
                "Accuracy",
                "${intent.getDoubleExtra("accuracy", 0.0)} %"
            ),

            Metric(
                "Coherence",
                "${intent.getDoubleExtra("coherence", 0.0)} %"
            ),

            Metric(
                "Perplexity",
                intent.getDoubleExtra("perplexity", 0.0).toString()
            ),

            Metric(
                "BLEU Score",
                intent.getDoubleExtra("bleu", 0.0).toString()
            ),

            Metric(
                "ROUGE Score",
                intent.getDoubleExtra("rouge", 0.0).toString()
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EvaluationAdapter(metrics)
    }
}
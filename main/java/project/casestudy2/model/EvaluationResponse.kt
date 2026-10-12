package project.casestudy2.model

data class EvaluationResponse(

    val generatedText: String,

    val accuracy: Double,

    val coherence: Double,

    val perplexity: Double,

    val bleu: Double,

    val rouge: Double

)
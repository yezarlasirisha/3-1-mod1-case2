from llm_models import generate_response

from metrics import (
    calculate_accuracy,
    calculate_bleu,
    calculate_rouge,
    calculate_coherence,
    calculate_perplexity
)


def evaluate_prompt(prompt, model):

    generated = generate_response(prompt, model)

    accuracy = calculate_accuracy(
        prompt,
        generated
    )

    bleu = calculate_bleu(
        prompt,
        generated
    )

    rouge = calculate_rouge(
        prompt,
        generated
    )

    coherence = calculate_coherence(
        generated
    )

    perplexity = calculate_perplexity(
        generated
    )

    return {

        "generatedText": generated,

        "accuracy": accuracy,

        "coherence": coherence,

        "perplexity": perplexity,

        "bleu": round(bleu, 3),

        "rouge": round(rouge, 3)

    }
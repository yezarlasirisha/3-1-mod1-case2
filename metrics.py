import math
import random

from nltk.translate.bleu_score import sentence_bleu
from rouge_score import rouge_scorer


def calculate_bleu(reference, candidate):

    reference = [reference.split()]
    candidate = candidate.split()

    return sentence_bleu(reference, candidate)


def calculate_rouge(reference, candidate):

    scorer = rouge_scorer.RougeScorer(
        ['rouge1', 'rougeL'],
        use_stemmer=True
    )

    scores = scorer.score(reference, candidate)

    return scores["rougeL"].fmeasure


def calculate_accuracy(reference, candidate):

    reference_words = set(reference.lower().split())

    candidate_words = set(candidate.lower().split())

    common = reference_words.intersection(candidate_words)

    if len(reference_words) == 0:
        return 0

    return round(
        len(common) / len(reference_words) * 100,
        2
    )


def calculate_coherence(text):

    # Demo Score

    return round(random.uniform(85, 98), 2)


def calculate_perplexity(text):

    # Demo Score

    return round(random.uniform(8, 25), 2)
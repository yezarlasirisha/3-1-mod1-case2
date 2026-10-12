import os

# ----------------------------
# Demo Response Generator
# Replace with OpenAI/Gemini APIs
# ----------------------------

def generate_response(prompt, model):

    if model == "OpenAI":

        return f"OpenAI Response:\n\n{prompt}"

    elif model == "Gemini":

        return f"Gemini Response:\n\n{prompt}"

    elif model == "Ollama":

        return f"Ollama Response:\n\n{prompt}"

    elif model == "HuggingFace":

        return f"HuggingFace Response:\n\n{prompt}"

    return "Unsupported Model"
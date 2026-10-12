from flask import Flask, request, jsonify
from evaluator import evaluate_prompt

app = Flask(__name__)

@app.route("/evaluate", methods=["POST"])
def evaluate():

    data = request.get_json()

    prompt = data.get("prompt", "")
    model = data.get("model", "OpenAI")

    result = evaluate_prompt(prompt, model)

    return jsonify(result)

if __name__ == "__main__":
    app.run(
        host="0.0.0.0",
        port=5000,
        debug=True
    )
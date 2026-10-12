package project.casestudy2.repository

import project.casestudy2.model.EvaluationResponse
import project.casestudy2.model.LLMRequest
import project.casestudy2.network.ApiClient
import retrofit2.Response

class LLMRepository {

    suspend fun evaluatePrompt(
        request: LLMRequest
    ): Response<EvaluationResponse> {

        return ApiClient.apiService.evaluate(request)

    }
}
package project.casestudy2.network

import project.casestudy2.model.EvaluationResponse
import project.casestudy2.model.LLMRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("evaluate")
    suspend fun evaluate(
        @Body request: LLMRequest
    ): Response<EvaluationResponse>

}
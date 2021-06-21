package ba.unsa.pmf.math.myapplication.util

import retrofit2.Response
import java.lang.Exception

abstract class SourceAssert {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Asserts<T> {
        try {
            val response = call()
            if(response.isSuccessful) {
                val body = response.body()
                return if(body != null) Asserts.success(body) else Asserts.error("Null")

            }
            return Asserts.error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Asserts<T> {
        return Asserts.error("$message")
    }

}
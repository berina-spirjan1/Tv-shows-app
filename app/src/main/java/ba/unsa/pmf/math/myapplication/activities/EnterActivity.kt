package ba.unsa.pmf.math.myapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ba.unsa.pmf.math.myapplication.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EnterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)
        supportActionBar?.hide()

        CoroutineScope(Dispatchers.Main).launch {
            delay(3000L)
            startActivity(Intent(this@EnterActivity, MainActivity::class.java))
            finish()
        }
    }
}
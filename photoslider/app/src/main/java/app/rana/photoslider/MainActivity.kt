import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.rana.photoslider.R
import app.rana.photoslider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageList = listOf(
            R.drawable.pic1, R.drawable.pic2, R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10
        )

        var i = 0

        binding.iv.setImageResource(imageList[i])

        binding.btn1.setOnClickListener{

            i = (i + 1) % imageList.size

            binding.iv.setImageResource(imageList[i])
        }

        binding.btn2.setOnClickListener{

            i = if (i > 0) {
                i - 1
            } else {
                imageList.size - 1
            }

            binding.iv.setImageResource(imageList[i])
        }
    }
}
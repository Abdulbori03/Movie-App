package uz.abshom.movieapp


import Adapter.MovieAdapter
import Model.MovieModel
import Utils.MySharedPreference
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieAdapter: MovieAdapter
    private lateinit var list: ArrayList<MovieModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()

        MySharedPreference.init(this)

        list = ArrayList()
        list = MySharedPreference.objectString

        img_add.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        movieAdapter = MovieAdapter(this, list)
        movieAdapter.notifyDataSetChanged()
        recyclerMovies.adapter = movieAdapter
    }
}
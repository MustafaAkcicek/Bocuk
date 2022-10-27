package com.dot.bck

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.dot.bck.databinding.ActivityMainBinding
import kotlinx.coroutines.Runnable
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {


    var score = 0
    var imageArray = ArrayList<ImageView>()


    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)


        //ImageArray

        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        imageArray.add(binding.imageView14)
        imageArray.add(binding.imageView15)
        imageArray.add(binding.imageView16)
        imageArray.add(binding.imageView17)
        imageArray.add(binding.imageView18)
        imageArray.add(binding.imageView19)
        imageArray.add(binding.imageView20)
        imageArray.add(binding.imageView21)
        imageArray.add(binding.imageView22)
        imageArray.add(binding.imageView23)
        imageArray.add(binding.imageView24)
        imageArray.add(binding.imageView25)
        imageArray.add(binding.imageView27)
        imageArray.add(binding.imageView28)

        hideImages()



        //CountDown Timer

        object : CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                binding.timeText.text = "Time : $p0"
                hideImages()
            }

            override fun onFinish() {
                binding.timeText.text = " Time : 0"
                for(image in imageArray){
                    image.isClickable = false
                }

                //Alert

                val alert = AlertDialog.Builder(this@MainActivity)

                alert.setTitle("Game Over")
                alert.setMessage("Retart The Game?")
                alert.setPositiveButton("Yes") {dialog, which ->
                    //Restart
                    val intent = intent
                    finish()
                    startActivity(intent)

                }
                alert.setNegativeButton("No") {dialog, which ->
                    Toast.makeText(this@MainActivity,"Game over",Toast.LENGTH_LONG).show()
                }
                    alert.show()

            }

        }.start()

    }

    fun hideImages (){


        val random = Random()
        val randomIndex = random.nextInt(24)

        for(image in imageArray){
            image.visibility = View.INVISIBLE
        }
        imageArray[randomIndex].visibility = View.VISIBLE

    }


    fun increaseScore(view:View) {
        score = score +1
        binding.scoreText.text = "Score $score"

    }




}
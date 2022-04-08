package com.example.applikacian2

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {




    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var scoreBoxP1:TextView = findViewById(R.id.TW_Scorebox_player1)
        var scoreBoxP2:TextView = findViewById(R.id.TW_Scorebox_player2)

        var player1:TextView = findViewById(R.id.TW_player1)
        var player2:TextView = findViewById(R.id.TW_player2)

        val winmessage:TextView = findViewById(R.id.TW_winner)

        val score:TextView = findViewById(R.id.TW_score)

        val roll1:Button = findViewById(R.id.BTN_rollP1)
        val roll2:Button = findViewById(R.id.BTN_rollP2)


        val turnIndicator:TextView = findViewById(R.id.TW_turn_indicator)

        val dice1:ImageView = findViewById(R.id.IW_first_die)
        val dice2:ImageView = findViewById(R.id.IW_second_die)


        var sumofTwop1:Int
        var cumulativeSump1: Int = 0

        var sumofTwop2:Int
        var cumulativeSump2: Int = 0



        roll1.setOnClickListener {

            roll2.setBackgroundColor(Color.GREEN)
            roll1.setBackgroundColor(Color.RED)
            roll1.isClickable = false
            roll2.isClickable = true

            val randomDice1 = Random.nextInt(1,7)
            val randomDice2 = Random.nextInt(1,7)


            sumofTwop1 = randomDice1 + randomDice2


            if (randomDice1 == randomDice2){
                sumofTwop1 *= 2
            }

            cumulativeSump1 += sumofTwop1


            score.text = "current score of P1 is: $sumofTwop1"
            scoreBoxP1.text = "score: $cumulativeSump1"
            turnIndicator.text = "Player 2 turn"

            if ((randomDice1 == 5 && randomDice2 == 6) || (randomDice1 == 6 && randomDice2 == 5) ){
                winmessage.text = "Congrats Player1, you won!"
            }

            when(randomDice1) {
                1 -> dice1.setImageResource(R.drawable.ic_dice_one)
                2 -> dice1.setImageResource(R.drawable.ic_dice_two)
                3 -> dice1.setImageResource(R.drawable.ic_dice_three)
                4 -> dice1.setImageResource(R.drawable.ic_dice_four)
                5 -> dice1.setImageResource(R.drawable.ic_dice_five)
                6 -> dice1.setImageResource(R.drawable.ic_dice_six)
            }
            when(randomDice2) {
                1 -> dice2.setImageResource(R.drawable.ic_dice_one)
                2 -> dice2.setImageResource(R.drawable.ic_dice_two)
                3 -> dice2.setImageResource(R.drawable.ic_dice_three)
                4 -> dice2.setImageResource(R.drawable.ic_dice_four)
                5 -> dice2.setImageResource(R.drawable.ic_dice_five)
                6 -> dice2.setImageResource(R.drawable.ic_dice_six)
            }

            if (cumulativeSump1 > 111){
                winmessage.text = "Congrats Player1, you won!"
            }
        }

        roll2.setOnClickListener {
            roll1.setBackgroundColor(Color.GREEN)
            roll2.setBackgroundColor(Color.RED)
            roll2.isClickable = false
            roll1.isClickable = true




            val randomDice1 = Random.nextInt(1,7)
            val randomDice2 = Random.nextInt(1,7)


            sumofTwop2 = randomDice1 + randomDice2


            if (randomDice1 == randomDice2){
                sumofTwop2 *= 2
            }
            cumulativeSump2 += sumofTwop2


            if ((randomDice1 == 5 && randomDice2 == 6) || (randomDice1 == 6 && randomDice2 == 5) ){
                winmessage.text = "Congrats Player2, you won pa zanzibarski!"
            }

            score.text = "current score of P2 is: $sumofTwop2"
            scoreBoxP2.text = "score: $cumulativeSump2"
            turnIndicator.text = "Player 1 turn"




            when(randomDice1) {
                1 -> dice1.setImageResource(R.drawable.ic_dice_one)
                2 -> dice1.setImageResource(R.drawable.ic_dice_two)
                3 -> dice1.setImageResource(R.drawable.ic_dice_three)
                4 -> dice1.setImageResource(R.drawable.ic_dice_four)
                5 -> dice1.setImageResource(R.drawable.ic_dice_five)
                6 -> dice1.setImageResource(R.drawable.ic_dice_six)
            }
            when(randomDice2) {
                1 -> dice2.setImageResource(R.drawable.ic_dice_one)
                2 -> dice2.setImageResource(R.drawable.ic_dice_two)
                3 -> dice2.setImageResource(R.drawable.ic_dice_three)
                4 -> dice2.setImageResource(R.drawable.ic_dice_four)
                5 -> dice2.setImageResource(R.drawable.ic_dice_five)
                6 -> dice2.setImageResource(R.drawable.ic_dice_six)
            }

            if (cumulativeSump2 > 111){
                winmessage.text = "Congrats Player2, you won pa zanzibarski!"
            }
        }
    }
}
package com.example.tictactoe

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private val binding by activityViewBinding(ActivityMainBinding::inflate)

    var isP1Turn = true
    var boards = arrayListOf("", "", "", "", "", "", "", "", "")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        handleClicks()
    }

    private fun handleClicks() {
        binding.bt1.setOnClickListener {
            if (it.checkTextNotExist()) {
                val text = if (isP1Turn) "O" else "X"
                (it as MaterialButton).text = text
                boards[0] = text
                toggleTurn()
                checkWinner(text)

                if (checkDraw()) {
                    showGameOverDialog("Draw !!!")
                }
            }
        }
        binding.bt2.setOnClickListener {
            if (it.checkTextNotExist()) {

                val text = if (isP1Turn) "O" else "X"
                (it as MaterialButton).text = text
                boards[1] = text

                toggleTurn()
                checkWinner(text)

                if (checkDraw()) {
                    showGameOverDialog("Draw !!!")
                }
            }
        }
        binding.bt3.setOnClickListener {
            if (it.checkTextNotExist()) {

                val text = if (isP1Turn) "O" else "X"
                (it as MaterialButton).text = text
                boards[2] = text

                toggleTurn()
                checkWinner(text)

                if (checkDraw()) {
                    showGameOverDialog("Draw !!!")
                }
            }
        }
        binding.bt4.setOnClickListener {
            if (it.checkTextNotExist()) {

                val text = if (isP1Turn) "O" else "X"
                (it as MaterialButton).text = text
                boards[3] = text

                toggleTurn()
                checkWinner(text)

                if (checkDraw()) {
                    showGameOverDialog("Draw !!!")
                }
            }
        }
        binding.bt5.setOnClickListener {
            if (it.checkTextNotExist()) {

                val text = if (isP1Turn) "O" else "X"
                (it as MaterialButton).text = text
                boards[4] = text

                toggleTurn()
                checkWinner(text)

                if (checkDraw()) {
                    showGameOverDialog("Draw !!!")
                }
            }
        }
        binding.bt6.setOnClickListener {
            if (it.checkTextNotExist()) {
                val text = if (isP1Turn) "O" else "X"
                (it as MaterialButton).text = text
                boards[5] = text

                toggleTurn()
                checkWinner(text)

                if (checkDraw()) {
                    showGameOverDialog("Draw !!!")
                }
            }
        }
        binding.bt7.setOnClickListener {
            if (it.checkTextNotExist()) {

                val text = if (isP1Turn) "O" else "X"
                (it as MaterialButton).text = text
                boards[6] = text

                toggleTurn()
                checkWinner(text)

                if (checkDraw()) {
                    showGameOverDialog("Draw !!!")
                }

            }
        }
        binding.bt8.setOnClickListener {
            if (it.checkTextNotExist()) {

                val text = if (isP1Turn) "O" else "X"
                (it as MaterialButton).text = text
                boards[7] = text

                toggleTurn()
                checkWinner(text)

                if (checkDraw()) {
                    showGameOverDialog("Draw !!!")
                }
            }
        }
        binding.bt9.setOnClickListener {
            if (it.checkTextNotExist()) {

                val text = if (isP1Turn) "O" else "X"
                (it as MaterialButton).text = text
                boards[8] = text

                toggleTurn()
                checkWinner(text)
                if (checkDraw()) {
                    showGameOverDialog("Draw !!!")
                }
            }
        }

    }

    private fun View.checkTextNotExist() = (this as MaterialButton).text.isEmpty()


    private fun toggleTurn() {
        isP1Turn = !isP1Turn
    }

    private fun checkDraw() = boards.all { it.isNotEmpty() }

    private fun checkWinner(value: String) {
        //8 condition need to check
        //3 horizontal, 3 vertical, 2diagonal
        val playerName = if (value == "O") "Player 1" else "Player 2"
        val text1 = binding.bt1.text.toString()
        val text2 = binding.bt2.text.toString()
        val text3 = binding.bt3.text.toString()
        val text4 = binding.bt4.text.toString()
        val text5 = binding.bt5.text.toString()
        val text6 = binding.bt6.text.toString()
        val text7 = binding.bt7.text.toString()
        val text8 = binding.bt8.text.toString()
        val text9 = binding.bt9.text.toString()

        val winCondition1 = text1 == value && text2 == value && text3 == value
        val winCondition2 = text4 == value && text5 == value && text6 == value
        val winCondition3 = text7 == value && text8 == value && text9 == value
        val winCondition4 = text1 == value && text4 == value && text7 == value
        val winCondition5 = text2 == value && text5 == value && text8 == value
        val winCondition6 = text3 == value && text6 == value && text9 == value
        val winCondition7 = text1 == value && text5 == value && text9 == value
        val winCondition8 = text3 == value && text5 == value && text7 == value


        if (winCondition1 || winCondition2 || winCondition3 || winCondition4 || winCondition5 || winCondition6 || winCondition7 || winCondition8) {
            showGameOverDialog("$playerName win !!!")
        }


    }

    fun Context.showGameOverDialog(text: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(text)
        builder.setMessage("Game Over, Would you like to try again???")
        builder.setCancelable(false)
        builder.setPositiveButton("Try again") { dialog, _ ->
            dialog.dismiss()
            this@MainActivity.recreate()
        }
        builder.setNegativeButton("Quit") { dialog, _ ->
            dialog.dismiss()
            System.exit(0)
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }

}
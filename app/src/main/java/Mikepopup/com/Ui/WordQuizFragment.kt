package Mikepopup.com.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Mikepopup.com.R
import Mikepopup.com.databinding.FragmentWordQuizBinding


class WordQuizFragment : Fragment() {

    private var score = 0
    private var wordCount = 0
    private  var currentEnglishWord = allEnglishWords
    private val wordList = allEnglishWords
    private val currentPlayWord: MutableList<String>  = mutableListOf()


    // Binding object with access to the views layout
    private lateinit var binding: FragmentWordQuizBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for and return binding object
        binding = FragmentWordQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup click listener for submit and skip buttons.
        binding.btnSubmit.setOnClickListener { onSubmitWord() }
        binding.btnSkip.setOnClickListener { onSkipWord() }

        //Update UI
        updateEnglishWord()
        binding.quizScore.text = getString(R.string.quiz_score, 0)
        binding.quizCount.text = getString(R.string.quiz_count, 0, MAX_NO_OF_WORDS)

    }


    // Build onSubmitWord button function
    private fun onSubmitWord() {
        val playerWord = binding.etTextInput.text.toString()
        if (isUserWordCorrect(playerWord)) {
            setErrorTextField(false)
            wordCount++
            score += SCORE_INCREASE
            binding.quizScore.text = getString(R.string.quiz_score, score)
            binding.quizCount.text = getString(R.string.quiz_count, wordCount, MAX_NO_OF_WORDS)
            updateEnglishWord()
        } else {
            setErrorTextField(true)
        }
    }

    private fun isUserWordCorrect(playerWord: String): Boolean {
        if (playerWord.equals(currentEnglishWord.toString(), false)) {
            return true
        }
        return false
    }

    // Build onSkipWord button function
    private fun onSkipWord() {
        wordCount++
        binding.quizScore.text = getString(R.string.quiz_score, score)
        binding.quizCount.text = getString(R.string.quiz_count, wordCount, MAX_NO_OF_WORDS)
        updateEnglishWord()
    }


    // Get a random English word from the listData
    private fun randomEnglishWord(): String {
        val tempWord = allEnglishWords.random().toCharArray()
        tempWord.random()
        return String(tempWord)
    }



    // Display English word on screen
    private fun updateEnglishWord() {
        binding.tvWord.text = randomEnglishWord()
    }

    //Sets error text fields status
    private fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.textInputLayout.isErrorEnabled = true
            binding.textInputLayout.error = getString(R.string.try_again)
        } else {
            binding.textInputLayout.isErrorEnabled = false
            binding.etTextInput.text = null
        }
    }


}
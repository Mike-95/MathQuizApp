package Mikepopup.com.Ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import Mikepopup.com.R
import Mikepopup.com.databinding.FragmentWordQuizBinding


class WordQuizFragment : Fragment() {

    private val score = 0
    private val wordCount = 0
    private val englishWord = "Test"


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
       /* binding.btnSubmit.setOnClickListener { onSubmitWord }
        binding.btnSkip.setOnClickListener { onSkipWord }*/

        //Update UI
        updateEnglishWord()
        randomEnglishWord()
        binding.quizScore.text = getString(R.string.quiz_score, 0)
        binding.quizCount.text = getString(R.string.quiz_count,0, MAX_NO_OF_WORDS)


    }


    // Get a random English word from the listData
    private fun randomEnglishWord(): String{
        val tempWord = allEnglishWords.random().toCharArray()
        tempWord.random()
        return String(tempWord)
    }

    // Display English word on screen
    private fun updateEnglishWord(){
        binding.tvWord.text = randomEnglishWord()
    }


}
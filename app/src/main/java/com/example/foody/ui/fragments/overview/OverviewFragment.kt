package com.example.foody.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import coil.load
import com.example.foody.R
import com.example.foody.models.Result
import kotlinx.android.synthetic.main.fragment_overview.view.*

class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_overview, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable("recipeBundle")

        view.main_imageView.load(myBundle?.image)
        view.title_textView.text = myBundle?.title
        view.likes_textView.text = myBundle?.aggregateLikes.toString()
        view.time_textView.text = myBundle?.readyInMinutes.toString()
        view.summary_textView.text = myBundle?.summary

        if (myBundle?.vegetarian == true) {
            handleColorFilter(view.vegetarian_imageView, view.vegetarian_textView)
        }
        if (myBundle?.vegan == true) {
            handleColorFilter(view.vegan_imageView, view.vegan_textView)
        }
        if (myBundle?.glutenFree == true) {
            handleColorFilter(view.gluten_free_imageView, view.gluten_free_textView)
        }
        if (myBundle?.dairyFree == true) {
            handleColorFilter(view.dairy_free_imageView, view.dairy_free_textView)
        }
        if (myBundle?.veryHealthy == true) {
            handleColorFilter(view.healthy_imageView, view.healthy_textView)
        }
        if (myBundle?.cheap == true) {
            handleColorFilter(view.cheap_imageView, view.cheap_textView)
        }

        return view
    }

    private fun handleColorFilter(imageView: ImageView, textView: TextView) {
        imageView.setColorFilter(ContextCompat.getColor(requireContext(), R.color.green))
        textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.green))
    }

}
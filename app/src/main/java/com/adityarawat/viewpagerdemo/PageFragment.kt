package com.adityarawat.viewpagerdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class PageFragment : Fragment() {

    companion object {
        private const val ARG_PAGE_NUMBER = "page_number"

        fun newInstance(pageNumber: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt(ARG_PAGE_NUMBER, pageNumber)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_page, container, false)
        val pageNumber = requireArguments().getInt(ARG_PAGE_NUMBER)
        val imageView = view.findViewById<ImageView>(R.id.imageView)

        // Set different images for each page
        when (pageNumber) {
            0 -> imageView.setImageResource(R.drawable.abc)
            1 -> imageView.setImageResource(R.drawable.rainbow)
            2 -> imageView.setImageResource(R.drawable.hills)
        }

        return view
    }
}

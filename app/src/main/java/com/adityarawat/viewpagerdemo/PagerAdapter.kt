package com.adityarawat.viewpagerdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val numPages = 3 // Number of pages

    override fun getItemCount(): Int {
        return numPages
    }

    override fun createFragment(position: Int): Fragment {
        // Returning different fragments for each page
        return PageFragment.newInstance(position)
    }
}

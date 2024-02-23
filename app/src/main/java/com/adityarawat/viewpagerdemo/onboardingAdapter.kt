package com.adityarawat.viewpagerdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// class OnboardingAdapter(onboardingItem: ArrayList<OnboardingItem>) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {
//
// inner class OnboardingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
// private val textTitle: TextView = itemView.findViewById(R.id.textTitle)
// private val textDescription: TextView = itemView.findViewById(R.id.textDescription)
// private val imageOnboarding: ImageView = itemView.findViewById(R.id.imageOnboarding)
//
// fun setOnboardingData(onboardingItem: OnboardingItem) {
// textTitle.text = onboardingItem.title
// textDescription.text = onboardingItem.description
// imageOnboarding.setImageResource(onboardingItem.image)
// }
// }
//
// override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
// val view = LayoutInflater.from(parent.context).inflate(R.layout.item_container_onboarding, parent, false)
// return OnboardingViewHolder(view)
// }
//
// override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
// // Assuming you have a list of OnboardingItem objects
// //holder.setOnboardingData(onboardingItem[position])
// }
//
// /*override fun getItemCount(): Int {
// return onboardingItem.size
// }*/
// }
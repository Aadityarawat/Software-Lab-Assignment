package com.adityarawat.viewpagerdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.adityarawat.viewpagerdemo.loginpage.LoginPage
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonColors = listOf(
            ContextCompat.getColor(this, R.color.green),
            ContextCompat.getColor(this, R.color.darkornage),
            ContextCompat.getColor(this, R.color.yellow)
        )

        val textList = listOf("Quality", "Convenient", "Local")

        val textDis = listOf(
            "Sell your form fresh products directly to consumers, cutting out the middleman and reducing emissions of the global supply chain.",
            "Our team of delivery will make sure your order are picked up on time and promptly delivered to your customers.",
            "We love the earth and know you do too! Join us in reducing our ocal carbon footprint one order at a time.")

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val button: Button = findViewById(R.id.swipeButton)
        val textTitle: TextView = findViewById(R.id.descrip)
        val textdes : TextView = findViewById(R.id.descriptionn)

        loginUnderline()

        val adapter = PagerAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                button.setBackgroundColor(buttonColors[position % buttonColors.size])
                textTitle.text = textList[position % textList.size]
                textdes.text = textDis[position % textDis.size]
            }
        })

        button.setBackgroundColor(buttonColors[0])
        button.setOnClickListener {
            viewPager.currentItem = (viewPager.currentItem + 1) % adapter.itemCount
        }

        val logintext : TextView = findViewById(R.id.logintext)

        logintext.setOnClickListener{
            val intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }
    }

    private fun loginUnderline() {
        val textView = findViewById<TextView>(R.id.logintext)

        val text = "Login"
        val spannableString = SpannableString(text)
        spannableString.setSpan(UnderlineSpan(), 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        textView.text = spannableString
    }
}

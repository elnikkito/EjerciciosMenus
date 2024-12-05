package com.example.menuejer3

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class Animacion : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {

        page.translationX = position * -page.width
        page.alpha = 1 - kotlin.math.abs(position)

    }
}

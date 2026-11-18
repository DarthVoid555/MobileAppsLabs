package com.example.myapplication1.data

import com.example.myapplication1.R
import com.example.myapplication1.model.Topic

object DataSource {
    val topics = listOf(
        Topic(nameResId = R.string.architecture, availableCourses = 58, imageResId = R.drawable.image1),
        Topic(nameResId = R.string.crafts, availableCourses = 121, imageResId = R.drawable.image2),
        Topic(nameResId = R.string.business, availableCourses = 78, imageResId = R.drawable.image3),
        Topic(nameResId = R.string.culinary, availableCourses = 118, imageResId = R.drawable.image4),
        Topic(nameResId = R.string.design, availableCourses = 423, imageResId = R.drawable.image5),
        Topic(nameResId = R.string.fashion, availableCourses = 92, imageResId = R.drawable.image6),
        Topic(nameResId = R.string.film, availableCourses = 165, imageResId = R.drawable.image7),
        Topic(nameResId = R.string.gaming, availableCourses = 164, imageResId = R.drawable.image8),
        Topic(nameResId = R.string.drawing, availableCourses = 326, imageResId = R.drawable.image9),
        Topic(nameResId = R.string.lifestyle, availableCourses = 305, imageResId = R.drawable.image10),
        Topic(nameResId = R.string.music, availableCourses = 212, imageResId = R.drawable.image1),
        Topic(nameResId = R.string.painting, availableCourses = 172, imageResId = R.drawable.image2),
        Topic(nameResId = R.string.photography, availableCourses = 321, imageResId = R.drawable.image3),
        Topic(nameResId = R.string.tech, availableCourses = 118, imageResId = R.drawable.image4)
    )
}
package com.example.myapplication1.data

import com.example.myapplication1.R
import com.example.myapplication1.model.Affirmation

class Datasource {
    fun loadAffirmations(): List<Affirmation> {
        return listOf(
            Affirmation(stringResourceId = R.string.affirmation1, imageResourceId = R.drawable.image1),
            Affirmation(stringResourceId = R.string.affirmation2, imageResourceId = R.drawable.image2),
            Affirmation(stringResourceId = R.string.affirmation3, imageResourceId = R.drawable.image3),
            Affirmation(stringResourceId = R.string.affirmation4, imageResourceId = R.drawable.image4),
            Affirmation(stringResourceId = R.string.affirmation5, imageResourceId = R.drawable.image5),
            Affirmation(stringResourceId = R.string.affirmation6, imageResourceId = R.drawable.image6),
            Affirmation(stringResourceId = R.string.affirmation7, imageResourceId = R.drawable.image7),
            Affirmation(stringResourceId = R.string.affirmation8, imageResourceId = R.drawable.image8),
            Affirmation(stringResourceId = R.string.affirmation9, imageResourceId = R.drawable.image9),
            Affirmation(stringResourceId = R.string.affirmation10, imageResourceId = R.drawable.image10)
        )
    }
}
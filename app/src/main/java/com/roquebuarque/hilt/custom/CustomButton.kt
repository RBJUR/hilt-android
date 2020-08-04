package com.roquebuarque.hilt.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.roquebuarque.hilt.R
import com.roquebuarque.hilt.feature.domain.CustomButtonInteractor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.custom_button.view.*
import javax.inject.Inject

@AndroidEntryPoint
class CustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attrs, defStyleAttr) {

    @Inject
    lateinit var interactor : CustomButtonInteractor

    init {
        LayoutInflater.from(context).inflate(R.layout.custom_button, this)

        context.obtainStyledAttributes(attrs, R.styleable.CustomButton, defStyleAttr, 0).apply {

            customButtonText.text = getString(R.styleable.CustomButton_android_text)
            recycle()
        }

        interactor.start()
    }

}
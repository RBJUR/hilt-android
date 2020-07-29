package com.roquebuarque.hilt.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import com.roquebuarque.hilt.R
import com.roquebuarque.hilt.domain.DogEvent
import com.roquebuarque.hilt.domain.DogState
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


@AndroidEntryPoint
class DogActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: DogPresenter

    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRandomDog.setOnClickListener {
            presenter.dispatch(event = DogEvent.Fetch)
        }

        btnShare.setOnClickListener {
            //TODO Make it better
            val imgBitmap = imgDog.drawable.toBitmap()
            val imgBitmapPath =
                MediaStore.Images.Media.insertImage(contentResolver, imgBitmap, "title", null)
            val imgBitmapUri: Uri = Uri.parse(imgBitmapPath)
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "image/*"
            shareIntent.putExtra(Intent.EXTRA_STREAM, imgBitmapUri)
            startActivity(Intent.createChooser(shareIntent, "share image using"))
        }
    }

    override fun onStart() {
        super.onStart()
        disposable = presenter
            .state
            .subscribe(::updateState)

    }

    override fun onStop() {
        super.onStop()
        disposable.dispose()
    }

    private fun updateState(state: DogState) {
        showImage(state.image)

        when {
            state.error.isNotEmpty() -> state.error
            state.isLoading -> getString(R.string.loading)
            else -> getString(R.string.tap_on_random_dog_button)

        }
            .run{ txtMessage.text = this }
    }

    private fun showImage(image: String) {
        image
            .takeIf { it.isNotEmpty() }
            .let {
                //TODO Glide cache
                Glide
                    .with(this)
                    .load(it)
                    .into(imgDog)

            }
    }
}





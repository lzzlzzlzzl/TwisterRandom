package com.elizavetastep.twisterrandom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val LAST_ROLLED_IMAGE = "image"

class TwisterRandomFragment : Fragment() {

    private lateinit var commandImageView: ImageView
    private lateinit var rollButton: Button

    private val commandImageList: List<Int> = listOf(
        R.drawable.leftfootblue,
        R.drawable.leftfootgreen,
        R.drawable.leftfootred,
        R.drawable.leftfootyellow,
        R.drawable.rightfootblue,
        R.drawable.rightfootgreen,
        R.drawable.rightfootred,
        R.drawable.rightfootyellow,
        R.drawable.lefthandblue,
        R.drawable.lefthandgreen,
        R.drawable.lefthandred,
        R.drawable.lefthandyellow,
        R.drawable.righthandblue,
        R.drawable.righthandgreen,
        R.drawable.righthandred,
        R.drawable.righthandyellow,
    )

    var lastRolledCommand = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_twister_random, container, false)

        commandImageView = view.findViewById(R.id.command_image_view)
        rollButton = view.findViewById(R.id.roll_button)

        if (savedInstanceState != null)
            commandImageView.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))

        rollButton.setOnClickListener {
            lastRolledCommand = commandImageList.random()
            commandImageView.setImageResource(lastRolledCommand)
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, lastRolledCommand)
    }

}
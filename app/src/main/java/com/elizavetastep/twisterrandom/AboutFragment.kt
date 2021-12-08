package com.elizavetastep.twisterrandom

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutFragment : Fragment() {

    lateinit var developersRecyclerView: RecyclerView
    lateinit var showWebSiteButton: Button

    private val developersNames: List<String> = listOf(
        "CIO Elizaveta Stepanenkova",
        "Her beloved husband Maxim, who takes care of the children while mom is studying",
        "Impudent ginger cat",
        "The ideological inspirer Maxim Novopashenny")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        showWebSiteButton=view.findViewById(R.id.show_web_site_button)
        developersRecyclerView = view.findViewById(R.id.developers_recycler_view)
        developersRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        developersRecyclerView.adapter = DeveloperAdapter(developersNames)

        showWebSiteButton.setOnClickListener {
            val link = Uri.parse("https://cprmo.ggtu.ru/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }
        return view
    }


}
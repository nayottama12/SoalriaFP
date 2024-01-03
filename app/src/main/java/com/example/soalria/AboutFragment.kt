package com.example.soalria

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.MapFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragmentAbout) as? MapFragment
        mapFragment?.getMapAsync { map ->
            googleMap = map
            // Panggil metode untuk menambahkan marker ke peta
            addMarkerToMap()
        }


        return  inflater.inflate(R.layout.fragment_about, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val call: ImageView = view.findViewById(R.id.contact)
        val broswer: ImageView = view.findViewById(R.id.browser)
        val location: ImageView = view.findViewById(R.id.location)
        val calltext: TextView = view.findViewById(R.id.textViewContact)
        val broswertext: TextView = view.findViewById(R.id.textViewBrowser)
        val locationtext: TextView = view.findViewById(R.id.textViewAddress)

        // Dial number
        call.setOnClickListener {
            val callIntent: Intent = Uri.parse("tel:085743439096").let {
                    number -> Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(callIntent)
        }
        calltext.setOnClickListener {
            val callIntent: Intent = Uri.parse("tel:085743439096").let {
                    number -> Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(callIntent)
        }

        // Open website
        broswer.setOnClickListener {
            val broswerIntent: Intent = Uri.parse("https://home.amikom.ac.id/").let {
                    broswerpage -> Intent(Intent.ACTION_VIEW, broswerpage)
            }
            startActivity(broswerIntent)
        }
        broswertext.setOnClickListener {
            val broswerIntent: Intent = Uri.parse("https://home.amikom.ac.id/").let {
                    broswerpage -> Intent(Intent.ACTION_VIEW, broswerpage)
            }
            startActivity(broswerIntent)
        }

        // Open location on map
        location.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:47.6,-122,3?z=11")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(mapIntent)
            }
        }
        locationtext.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:47.6,-122,3?z=11")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(mapIntent)
            }
        }
    }

    private fun addMarkerToMap() {
        // Tambahkan marker ke peta
        val latitude = -7.759671019264172
        val longitude = 110.40913192617204
        val location = LatLng(latitude, longitude)
        googleMap.addMarker(MarkerOptions().position(location).title("Lokasi Saya"))

        // Opsi tambahan: Pindahkan kamera ke lokasi tertentu
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AboutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AboutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
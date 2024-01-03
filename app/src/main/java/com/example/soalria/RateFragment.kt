package com.example.soalria

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.Toast
import com.example.soalria.model.RateModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RateFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rate, container, false)

        // Instance
        val spinnerMenu: Spinner = view.findViewById(R.id.spinnerMenu)
        val ratingBar: RatingBar = view.findViewById(R.id.ratingBar)
        val textSaran: EditText = view.findViewById(R.id.textViewRate6)
        val btnSaveMenu: Button = view.findViewById(R.id.buttonRate)

        // Mengambil array nama-nama menu dari array statis
        val menuList = getMenuList()
        val menuNames = getMenuNamesFromMenuList(menuList)

        // Buat adapter untuk Spinner menggunakan array menuNames
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, menuNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMenu.adapter = adapter

        // Event saat button save di klik
        btnSaveMenu.setOnClickListener {
            val selectedMenu = spinnerMenu.selectedItem.toString().trim()
            val rating: Float = ratingBar.rating
            val saran: String = textSaran.text.toString().trim()

            // Object class DatabaseHelper
            val databaseHelper = DatabaseHelper(requireContext())
            val rateModel = RateModel(selectedMenu, rating, saran)

            // Tambahkan rateModel ke database
            databaseHelper.addRate(rateModel)

            // Membersihkan elemen-elemen setelah penyimpanan berhasil
            spinnerMenu.setSelection(0) // Mengatur spinner ke posisi awal atau sesuai kebutuhan
            ratingBar.rating = 0.0f // Mengatur nilai rating ke 0
            textSaran.text.clear() // Mengosongkan EditText

            Toast.makeText(requireContext(), "Rating added successfully", Toast.LENGTH_SHORT).show()
        }


        // ... (kode lainnya)

        return view
    }

    // Fungsi untuk mendapatkan array nama-nama menu dari array MenuModel
    private fun getMenuNamesFromMenuList(menuList: List<MenuModel>): List<String> {
        return menuList.map { it.title }
    }

    // Fungsi untuk mendapatkan array MenuModel (gantilah dengan data sesuai kebutuhan)
    private fun getMenuList(): List<MenuModel> {
        return arrayListOf(
            MenuModel(R.drawable.a, "Spaghetti alla Carbonara", "Spaghetti alla Carbonara adalah hidangan pasta klasik Italia yang terkenal dengan kesederhanaan dan cita rasa kaya yang gurih."),
            MenuModel(R.drawable.b, "Special Shrimp Fried Rice", "Special Shrimp Fried Rice adalah hidangan lezat yang menggabungkan cita rasa nasi yang dimasak sempurna, udang yang lezat, serta beragam sayuran segar dan rempah-rempah aromatik. "),
            MenuModel(R.drawable.c, "Salmon Brokoli Grilled", "Salmon Brokoli Grilled adalah hidangan lezat yang menghadirkan paduan sempurna antara kelezatan salmon panggang dan kehijauan brokoli. "),
            MenuModel(R.drawable.d, "Salmon Sunshine Poke Salad", "Salmon Sunshine Poke Salad adalah hidangan segar yang menggabungkan cita rasa lezat salmon dengan keceriaan dan kesehatan salad poke."),
            MenuModel(R.drawable.m1, "Berry Bliss Crepes", "Berry Bliss Crepes dengan Crepes yang tipis dan lembut diisi dengan kombinasi buah beri, seperti stroberi, dan raspberry."),
            MenuModel(R.drawable.m2, "ChocoPaw Delight", "Terinspirasi oleh kelezatan cokelat dan kehangatan persahabatan, makanan ini menggambarkan harmoni cita rasa cokelat yang lezat."),
            MenuModel(R.drawable.m3, "Lemon Bliss Tartlet", "Dengan paduan rasa segar dan manis yang tak tertandingi, tartlet ini menghadirkan keceriaan rasa dari perpaduan lemon yang menyegarkan. "),
            MenuModel(R.drawable.j, "Chilled Orange Bliss", "Dengan sentuhan segar dan manis dari jeruk, minuman ini adalah penyegar sempurna untuk melepas dahaga. "),
            MenuModel(R.drawable.i, "Oreo Bliss Shake", "Dengan sentuhan unik dari remah Oreo yang tercampur rata dalam gigitan setiap tegukan, minuman ini memberikan pengalaman yang menyenangkan dan memuaskan bagi para pecinta Oreo. "),
            MenuModel(R.drawable.h, "Refreshing Citrus Iced Tea", "Minuman menyegarkan yang menggabungkan kesegaran teh es dengan sentuhan beraroma jeruk yang segar.")
        )
    }





    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RateFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
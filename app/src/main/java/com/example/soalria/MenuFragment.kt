package com.example.soalria

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyclerView: RecyclerView

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

        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        //recomend
        recyclerView = view.findViewById(R.id.recyclerViewMenu)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val data = arrayListOf<MenuModel>()
        data.add(MenuModel(R.drawable.a, "Spaghetti alla Carbonara", "Spaghetti alla Carbonara adalah hidangan pasta klasik Italia yang terkenal dengan kesederhanaan dan cita rasa kaya yang gurih. "))
        data.add(MenuModel(R.drawable.b, "Special Shrimp Fried Rice", "Special Shrimp Fried Rice adalah hidangan lezat yang menggabungkan cita rasa nasi yang dimasak sempurna, udang yang lezat, serta beragam sayuran segar dan rempah-rempah aromatik. "))
        data.add(MenuModel(R.drawable.c, "Salmon Brokoli Grilled", "Salmon Brokoli Grilled adalah hidangan lezat yang menghadirkan paduan sempurna antara kelezatan salmon panggang dan kehijauan brokoli. "))
        data.add(MenuModel(R.drawable.d, "Salmon Sunshine Poke Salad", "Salmon Sunshine Poke Salad adalah hidangan segar yang menggabungkan cita rasa lezat salmon dengan keceriaan dan kesehatan salad poke."))
        data.add(MenuModel(R.drawable.m1, "Berry Bliss Crepes", "Berry Bliss Crepes dengan Crepes yang tipis dan lembut diisi dengan kombinasi buah beri, seperti stroberi, dan raspberry."))
        data.add(MenuModel(R.drawable.m2, "ChocoPaw Delight", "Terinspirasi oleh kelezatan cokelat dan kehangatan persahabatan, makanan ini menggambarkan harmoni cita rasa cokelat yang lezat."))
        data.add(MenuModel(R.drawable.m3, "Lemon Bliss Tartlet", "Dengan paduan rasa segar dan manis yang tak tertandingi, tartlet ini menghadirkan keceriaan rasa dari perpaduan lemon yang menyegarkan. "))
        data.add(MenuModel(R.drawable.j, "Chilled Orange Bliss", "Dengan sentuhan segar dan manis dari jeruk, minuman ini adalah penyegar sempurna untuk melepas dahaga. "))
        data.add(MenuModel(R.drawable.i, "Oreo Bliss Shake", "Dengan sentuhan unik dari remah Oreo yang tercampur rata dalam gigitan setiap tegukan, minuman ini memberikan pengalaman yang menyenangkan dan memuaskan bagi para pecinta Oreo. "))
        data.add(MenuModel(R.drawable.h, "Refreshing Citrus Iced Tea", "Minuman menyegarkan yang menggabungkan kesegaran teh es dengan sentuhan beraroma jeruk yang segar."))

        recyclerView.adapter = AdapterMenu(data)


        return view
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            MenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
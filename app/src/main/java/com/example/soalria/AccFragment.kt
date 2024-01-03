package com.example.soalria

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.soalria.AdapterRating

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var textNama2: TextView
    private lateinit var textEmail: TextView
    private lateinit var textNama: TextView
    private lateinit var textTelp: TextView
    private lateinit var textPassword: TextView

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
        val view = inflater.inflate(R.layout.fragment_acc, container, false)

        //instance
        textNama2 = view.findViewById(R.id.textViewAcc)
        textEmail = view.findViewById(R.id.textViewAccEmail2)
        textNama = view.findViewById(R.id.textViewAccPerson2)
        textTelp = view.findViewById(R.id.textViewAccPhone2)
        textPassword = view.findViewById(R.id.textViewAccPass2)

        //set data
        textNama2.text = username
        textEmail.text = email
        textNama.text = username
        textTelp.text = telephone
        textPassword.text = password


        // Inisialisasi tombol edit akun
        val buttonEditAcc: Button = view.findViewById(R.id.buttonEditAcc)
        buttonEditAcc.setOnClickListener {
            val accEditFragment = AccEditFragment()
            fragmentManager?.beginTransaction()
                ?.replace(R.id.FrameLayoutAcc, accEditFragment)
                ?.addToBackStack(null)
                ?.commit()
        }

        // Inisialisasi tombol hapus akun
        val btnDeleteAccount: Button = view.findViewById(R.id.buttonDeleteAcc)
        btnDeleteAccount.setOnClickListener {
            // Panggil fungsi untuk menghapus akun dan logout
            deleteAccountAndLogout()
        }



        return view
    }


    private fun deleteAccountAndLogout() {
        val userEmail = email
        val databaseHelper = DatabaseHelper(requireContext())

        val isDeleted = databaseHelper.deleteAccount(userEmail)

        if (isDeleted) {
            // Akun berhasil dihapus, lakukan logout
            logoutUser(this)
        } else {
            // Gagal menghapus akun
            // Tambahkan pesan atau tindakan lain sesuai kebutuhan
            Toast.makeText(requireContext(), "Gagal menghapus akun", Toast.LENGTH_SHORT).show()
        }
    }


    private fun logoutUser() {
        // Tambahkan logika logout sesuai kebutuhan aplikasi Anda
        // Misalnya, kembalikan pengguna ke layar login atau lakukan tindakan lain
    }


    companion object {
        // Variabel statis untuk menyimpan data pengguna
        var email = "tes@gmail.com"
        var username = "Tes nama"
        var telephone = "tes phone"
        var password = "password"


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        private fun logoutUser(accFragment: AccFragment) {
            // Hapus data pengguna dari penyimpanan lokal (contoh: Shared Preferences)
            val sharedPrefs = accFragment.requireContext()
                .getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.clear()
            editor.apply()

            // Mulai aktivitas login
            val loginIntent = Intent(accFragment.requireContext(), LoginActivity::class.java)
            accFragment.startActivity(loginIntent)
            accFragment.requireActivity().finish() // Tutup aktivitas saat ini
        }
    }
}
package com.example.soalria

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.soalria.AccFragment.Companion.email
import com.example.soalria.AccFragment.Companion.password
import com.example.soalria.AccFragment.Companion.telephone
import com.example.soalria.AccFragment.Companion.username

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccEditFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_acc_edit, container, false)

        //instance
        val textNama2: TextView = view.findViewById(R.id.EdittextViewAcc)
        val editTextEmail: TextView = view.findViewById(R.id.EdittextViewAccEmail3)
        val editTextNama: EditText = view.findViewById(R.id.EdittextViewAccPerson2)
        val editTextTelp: EditText = view.findViewById(R.id.EdittextViewAccPhone2)
        val editTextPassword: EditText = view.findViewById(R.id.EdittextViewAccPass2)
        val buttonSave: Button = view.findViewById(R.id.buttonSaveAcc)


        //set data
        textNama2.text = AccFragment.username
        editTextEmail.text = email
        editTextNama.setText(username)  // Menggunakan setText untuk EditText
        editTextTelp.setText(telephone)
        editTextPassword.setText(password)

        buttonSave.setOnClickListener {
            //object class databaseHelper
            val databaseHelper = DatabaseHelper(requireContext())

            //declare data
            val updatedEmail = editTextEmail.text.toString().trim()
            val updatedUsername = editTextNama.text.toString().trim()
            val updatedTelephone = editTextTelp.text.toString().trim()
            val updatedPassword = editTextPassword.text.toString().trim()

            //update user account
            databaseHelper.updateAccount(updatedEmail, updatedUsername, updatedTelephone, updatedPassword)

            // Memanggil setResult untuk memberi tahu fragment induk bahwa edit selesai
            targetFragment?.onActivityResult(
                targetRequestCode,
                Activity.RESULT_OK,
                Intent()
            )

            // Perbarui tampilan dengan data yang baru
            editTextNama.setText(updatedUsername)
            editTextTelp.setText(updatedTelephone)
            editTextPassword.setText(updatedPassword)

            // Menampilkan pesan sukses
            Toast.makeText(requireContext(), "Update data Success, silahkan log in ulang untuk melihat perubahan", Toast.LENGTH_SHORT).show()

            // Kembali ke fragment_acc.xml setelah menyimpan
            val fragmentManager = requireActivity().supportFragmentManager
            fragmentManager.popBackStack()
        }


        return view
    }

    companion object {


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
            AccEditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
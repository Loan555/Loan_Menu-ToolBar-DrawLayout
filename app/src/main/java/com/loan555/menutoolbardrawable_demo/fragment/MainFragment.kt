package com.loan555.menutoolbardrawable_demo.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast
import com.loan555.menutoolbardrawable_demo.R
import com.loan555.menutoolbardrawable_demo.activity.Test2Activity
import kotlinx.android.synthetic.main.fragment_main.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

class MainFragment : Fragment(), PopupMenu.OnMenuItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_fragment1.setOnClickListener {
            Toast.makeText(this.context, "Other activity!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this.context,Test2Activity::class.java)
            startActivity(intent)
        }
        registerForContextMenu(bt_contrext_menu)
        registerForContextMenu(bt_fragment1)

        bt_popup_menu.setOnClickListener {
            showPopup(it)
        }
    }

    private fun showPopup(v: View) {
        var popup = PopupMenu(this.context, v)
        popup.setOnMenuItemClickListener(this)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.action, popup.menu)
        popup.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search -> {
                Toast.makeText(this.context, "Search in fragment1", Toast.LENGTH_SHORT).show()
                Log.d("aaa", "chayj den day ko")// khong chay den day
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Context menu")
        val inflater: MenuInflater? = activity?.menuInflater
        inflater?.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
//        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo // chi dung khi nhan vao adapter cuar maays cai list,..
        return when (item.itemId) {
            R.id.edit -> {
//                edit(info.id) // lam gi do khi nhan vao nhung adapter
                Toast.makeText(this.context, "Edit", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.delete -> {
                Toast.makeText(this.context, "Delete", Toast.LENGTH_SHORT).show()
                true
            }
            else ->
                return super.onContextItemSelected(item)
        }
    }

    private fun edit(itemId: Long) {
        Toast.makeText(this.context, "Edit $itemId", Toast.LENGTH_SHORT).show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.popup1 -> {
                Toast.makeText(this.context, "popup 1", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.popup2 -> {
                Toast.makeText(this.context, "popup 2", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }
}
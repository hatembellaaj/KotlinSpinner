package tn.univ.graphic
import android.os.Bundle
import android.util.Log
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var selectedItem: MutableList<ListItem>? = mutableListOf()
    private var spinnerListItem: ArrayList<ListItem> ?= ArrayList()
    private var spinner : Spinner ?= null
    private var name : TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner =  findViewById(R.id.spinner)
        name =  findViewById(R.id.head)

        spinnerListItem?.add(ListItem("One"))
        spinnerListItem?.add(ListItem("Two"))
        spinnerListItem?.add(ListItem("Three"))
        spinnerListItem?.add(ListItem("Four"))

        selectedItem!!.clear()
        val adapter = MultiSelectSpinnerAdapter(
            this,
            spinnerListItem!!,
            selectedItem!!
        )
        spinner?.adapter = adapter

        adapter.setOnItemSelectedListener(object :
            MultiSelectSpinnerAdapter.OnItemSelectedListener {
            override fun onItemSelected(
                selectedItems: List<ListItem>,
                pos: Int,
            ) {
                if (selectedItems.isNullOrEmpty()){
                    name?.text = "Codewenation"
                }
                else{
                    name?.text = selectedItems.joinToString(", ") { it.name }
                }
                Log.e("getSelectedItems", selectedItems.toString())
                Log.e("getSelectedItems", selectedItems.size.toString())
            }
        }
        )
    }

}

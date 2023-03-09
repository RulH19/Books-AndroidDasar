package com.example.books

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ActionMenuView.OnMenuItemClickListener
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBooks: RecyclerView
    private val list = ArrayList<Books>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBooks = findViewById(R.id.rv_buku)
        rvBooks.setHasFixedSize(true)

        list.addAll(getListBooks())
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

//percabngan jika salah satu togle menu di tekan
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about_page ->{
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListBooks(): ArrayList<Books> {
        val nameBooks = resources.getStringArray(R.array.name_books)
        val dataSinopsis = resources.getStringArray(R.array.sinopsis_books)
        val photoBooks = resources.obtainTypedArray(R.array.photo_books)
        val listBooks = ArrayList<Books>()
        for (i in nameBooks.indices) {
            val book = Books(nameBooks[i], dataSinopsis[i], photoBooks.getResourceId(i, -1))
            listBooks.add(book)
        }
        return listBooks
    }
    private fun showSelectedBook(book: Books) {
        Toast.makeText(this, "Kamu memilih " + book.name, Toast.LENGTH_SHORT).show()

    }
    private fun showRecyclerList() {
        rvBooks.layoutManager = LinearLayoutManager(this)
        val listBooksAdapter= ListBooksAdapter(list)
        rvBooks.adapter = listBooksAdapter

        listBooksAdapter.setOnItemClickCallback(object : ListBooksAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Books) {

                val intentDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentDetail.putExtra("DETAIL", data)
                showSelectedBook(data)
                startActivity(intentDetail)
            }
        })
    }
}



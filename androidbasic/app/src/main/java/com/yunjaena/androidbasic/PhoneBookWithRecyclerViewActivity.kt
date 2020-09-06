package com.yunjaena.androidbasic

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yunjaena.androidbasic.phonebook.answer.Person
import com.yunjaena.androidbasic.phonebook.answer.PhoneBook
import com.yunjaena.androidbasic.phonebook.answer.PhoneBookAnswerDetailActivity
import kotlinx.android.synthetic.main.activity_phone_book_with_recycler_view.*

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)
//        val phoneBookRecyclerViewAdapter = PhoneBookRecyclerAdapter(
//            phoneBookList = createFakePhoneBook(fakeNumber = 30),
//            inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
//            activity = this@PhoneBookWithRecyclerViewActivity
//        )
//        phonebook_recycler_view.adapter = phoneBookRecyclerViewAdapter
//        phonebook_recycler_view.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)

        with(phonebook_recycler_view){
            this.adapter = PhoneBookRecyclerAdapter(
                phoneBookList = createFakePhoneBook(fakeNumber = 30),
                inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
                activity = this@PhoneBookWithRecyclerViewActivity
            )
            this.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
        }
    }


    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(
                Person(name = "$i 번째 사람", number = "$i 번째 사라의 전화 번호")
            )
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phoneBookList: PhoneBook,
    val inflater: LayoutInflater,
    val activity : Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView

        init {
            personName = itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener {
                val intent = Intent(activity, PhoneBookAnswerDetailActivity::class.java)
                intent.putExtra("name", phoneBookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phoneBookList.personList.get(adapterPosition).number)
                activity.startActivity(intent)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.phonebook_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return phoneBookList.personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text = phoneBookList.personList.get(position).name
    }
}
package com.yunjaena.clonecoding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_out_stagram_my_post_list.*
import kotlinx.android.synthetic.main.activity_outstagram_post_list.my_list
import kotlinx.android.synthetic.main.activity_outstagram_post_list.upload
import kotlinx.android.synthetic.main.activity_outstagram_post_list.user_info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OutStagramMyPostListActivity : AppCompatActivity() {
    lateinit var glide: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_my_post_list)
        glide = Glide.with(this)
        createList()

        user_info.setOnClickListener {
            startActivity(Intent(this, OutStagramUserInfo::class.java))
        }
        all_list.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OutstagramPostListActivity::class.java
                )
            )
        }
        upload.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OutStagramUploadActivity::class.java
                )
            )
        }
    }

    fun createList() {
        (application as MasterApplication).service.getUserPostList().enqueue(
            object : Callback<ArrayList<Post>> {
                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ArrayList<Post>>,
                    response: Response<ArrayList<Post>>
                ) {
                    if (response.isSuccessful) {
                        val postList = response.body()
                        val adapter = MyPostAdapter(
                            postList!!,
                            LayoutInflater.from(this@OutStagramMyPostListActivity),
                            glide
                        )
                        my_post_recycler_view.adapter = adapter
                        my_post_recycler_view.layoutManager =
                            LinearLayoutManager(this@OutStagramMyPostListActivity)
                    }
                }
            }
        )
    }

    class MyPostAdapter(
        var postList: ArrayList<Post>,
        val inflater: LayoutInflater,
        val glide: RequestManager
    ) : RecyclerView.Adapter<MyPostAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val postOwener: TextView
            val postImage: ImageView
            val postContent: TextView

            init {
                postOwener = itemView.findViewById(R.id.post_owner)
                postImage = itemView.findViewById(R.id.post_img)
                postContent = itemView.findViewById(R.id.post_content)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.outstagrma_item_view, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return postList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.postOwener.text = postList.get(position).owner
            holder.postContent.text = postList.get(position).content
            glide.load(postList.get(position).image).into(holder.postImage)
        }
    }
}

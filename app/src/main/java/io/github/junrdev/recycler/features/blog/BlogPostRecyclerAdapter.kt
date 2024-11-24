package io.github.junrdev.recycler.features.blog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.dala.local.DemoDataRepo
import io.github.junrdev.recycler.databinding.BlogpostItemBinding
import io.github.junrdev.recycler.databinding.HorizontalBlogpostItemBinding
import io.github.junrdev.recycler.domain.model.BlogPostItem

class BlogPostRecyclerAdapter(
    val context: Context,
    @LayoutRes val layout: Int,
    val blogs: List<BlogPostItem> = DemoDataRepo.blogPosts
) : RecyclerView.Adapter<BlogPostRecyclerAdapter.VH>() {


    inner class VH(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(x: BlogPostItem) {
            // binding
            when (layout) {
                R.layout.horizontal_blogpost_item -> {
                    HorizontalBlogpostItemBinding.bind(view).apply {


                        textView12.text = if (x.content.length > 100)
                            x.content.substring(0, 80)
                        else
                            x.content

                        Glide.with(context)
                            .load(x.imageLink)
                            .into(imageView6)
                    }
                }

                R.layout.blogpost_item -> {
                    BlogpostItemBinding.bind(view).apply {

                        Glide.with(context)
                            .load(x.imageLink)
                            .into(imageView6)

                        textView12.text = if (x.content.length > 80)
                            x.content.substring(0, 50)
                        else
                            x.content
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int = blogs.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindItem(blogs[position])
    }

}
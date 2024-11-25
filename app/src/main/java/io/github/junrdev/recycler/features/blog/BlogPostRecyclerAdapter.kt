package io.github.junrdev.recycler.features.blog

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.dala.local.DemoDataRepo
import io.github.junrdev.recycler.databinding.BlogpostItemBinding
import io.github.junrdev.recycler.databinding.HorizontalBlogpostItemBinding
import io.github.junrdev.recycler.domain.model.BlogPostItem

class BlogPostRecyclerAdapter(
    val context: Context,
    @LayoutRes val layout: Int,
    val blogs: List<BlogPostItem> = DemoDataRepo.blogPosts,
    val onClick : (BlogPostItem) -> Unit
) : RecyclerView.Adapter<BlogPostRecyclerAdapter.VH>() {


    inner class VH(private val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(x: BlogPostItem) {
            // binding
            when (binding) {
                is HorizontalBlogpostItemBinding -> {
                    binding.apply {
                        blog =x
                        textView12.text = if (x.content.length > 100)
                            x.content.substring(0, 80)
                        else
                            x.content

                        Glide.with(context)
                            .load(x.imageLink)
                            .into(imageView6)
                    }
                }

                is BlogpostItemBinding -> {
                    binding.apply {
                        blog =x
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

            //click listener
            binding.root.setOnClickListener{
                onClick(x)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = when (layout) {
            R.layout.horizontal_blogpost_item -> HorizontalBlogpostItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )

            R.layout.blogpost_item -> BlogpostItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )

            else -> throw IllegalArgumentException("Unsupported layout")
        }
        return VH(binding)
    }

    override fun getItemCount(): Int = blogs.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindItem(blogs[position])
    }

}
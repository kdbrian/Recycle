package io.github.junrdev.recycler.features.recycle.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.junrdev.recycler.R
import io.github.junrdev.recycler.databinding.WasteMaterialItemBinding
import io.github.junrdev.recycler.domain.model.WasteCategory

class WasteCategoriesAdapter(
    private val context: Context,
    private val wasteCategories: List<WasteCategory>,
    val onclick : (WasteCategory) -> Unit
)  : RecyclerView.Adapter<WasteCategoriesAdapter.VH>(){

    inner class VH(private val binding : WasteMaterialItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindItem(x : WasteCategory){
            binding.apply {

                category=x

                x.image?.let {
                    Glide.with(context)
                        .load(it)
                        .into(imageView19)
                }


                x.imageUrl?.let {
                    Glide.with(context)
                        .load(it)
                        .into(imageView19)
                }

                root.setOnClickListener {
                    onclick(x)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.waste_material_item, parent, false)
        return VH(WasteMaterialItemBinding.bind(view))
    }

    override fun getItemCount(): Int = wasteCategories.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bindItem(wasteCategories[position])
    }
}
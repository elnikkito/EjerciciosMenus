package com.example.menuejer2


import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.widget.RecyclerView
import com.example.menuejer2.databinding.ItemGalleryImageBinding

class GalleryAdapter(private val imageList: List<Int>, private val titleList: List<String>) : RecyclerView.Adapter<GalleryAdapter.ImageViewHolder>() {


    inner class ImageViewHolder(private val binding: ItemGalleryImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageResId: Int, title: String) {
            binding.imageView.setImageResource(imageResId)
            binding.textoMostrar.text = title

            binding.imageView.setOnCreateContextMenuListener { menu, v, menuInfo ->
                menu.add("Eliminar")
                menu.add("Editar")
                menu.add("Compartir")
            }


            binding.button3.setOnClickListener {
                Toast.makeText(binding.root.context, "Aceptar:  ${title}", Toast.LENGTH_SHORT).show()
            }

            binding.button4.setOnClickListener {
                Toast.makeText(binding.root.context, "Cancelar:  ${title}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemGalleryImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position], titleList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}


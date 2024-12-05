package com.example.menuejer2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.menuejer2.databinding.FragmentNavGalleryBinding

class nav_gallery : Fragment() {

    private lateinit var binding: FragmentNavGalleryBinding
    private lateinit var galleryRecyclerView: RecyclerView
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentNavGalleryBinding.inflate(inflater, container, false)

        galleryRecyclerView = binding.galleryRecyclerView
        galleryRecyclerView.layoutManager=StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val imageList = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9
        )

        val titleList = imageList.indices.map { index -> "Card ${index + 1}" }

        galleryAdapter = GalleryAdapter(imageList, titleList)

        galleryRecyclerView.adapter = galleryAdapter

        return binding.root
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.title) {
            "Editar" -> {
                Toast.makeText(requireContext(), "Opción Editar seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            "Eliminar" -> {
                Toast.makeText(requireContext(), "Opción ELiminar seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            "Compartir" -> {
                Toast.makeText(requireContext(), "Opción Compartir seleccionada", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}

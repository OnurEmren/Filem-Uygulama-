package com.onuremren.tarif.view.fragment

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import com.onuremren.tarif.database.EatDao
import com.onuremren.tarif.database.EatDatabase
import com.onuremren.tarif.databinding.FragmentMyRecipeBinding
import com.onuremren.tarif.model.Eat
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.io.ByteArrayOutputStream
import java.io.IOException


class MyRecipeFragment : Fragment() {

    private var _binding: FragmentMyRecipeBinding? = null
    private val binding get() = _binding!!
    var selectedPicture: Uri? = null
    var selectedBitmap: Bitmap? = null
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    private val mDisposable = CompositeDisposable()
    private lateinit var eatDao: EatDao
    private lateinit var eatDatabase: EatDatabase
    var eatFromMain: Eat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerLauncher()
        eatDatabase =
            Room.databaseBuilder(requireContext(), EatDatabase::class.java, "Recipes").build()
        eatDao = eatDatabase.eatDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyRecipeBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener { saveRecipes(view) }
        binding.deleteButton.setOnClickListener { deleteRecipes(view) }
        binding.imageView.setOnClickListener { selectImage(view) }

        arguments?.let {
            val info = MyRecipeFragmentArgs.fromBundle(it).info
            if (info == "new") {
                binding.saveButton.visibility = View.VISIBLE
                binding.deleteButton.visibility = View.GONE

                binding.malzemeText.setText("")
                binding.titleText.setText("")
                binding.tarifText.setText("")
            } else {
               binding.deleteButton.visibility = View.VISIBLE
                binding.saveButton.visibility = View.GONE
                val selectedId = MyRecipeFragmentArgs.fromBundle(it).id
                mDisposable.add(
                    eatDao.getEatById(selectedId)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::handleResponseWithOldEat)
                )
            }
        }
    }

    private fun handleResponseWithOldEat(eat: Eat) {
        eatFromMain = eat
        binding.titleText.setText(eat.title)
        binding.malzemeText.setText(eat.malzeme)
        binding.tarifText.setText(eat.tarif)

        eat.image?.let {
            val bitmap = BitmapFactory.decodeByteArray(it, 0, it.size)
            binding.imageView.setImageBitmap(bitmap)

        }
    }


    private fun deleteRecipes(view: View) {
        eatFromMain?.let {
            mDisposable.add(eatDao.delete(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse))
        }

    }

    fun saveRecipes(view: View) {
        val title = binding.titleText.text.toString()
        val malzeme = binding.malzemeText.text.toString()
        val tarif = binding.tarifText.text.toString()


        if (selectedBitmap != null) {
            val smallBitmap = makeSmallerBitmap(selectedBitmap!!, 300)

            val outputStream = ByteArrayOutputStream()
            smallBitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStream)
            val byteArray = outputStream.toByteArray()

            val recipes = Eat(title, malzeme, tarif, byteArray)

            mDisposable.add(eatDao.insert(recipes)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse))


        }
    }

    private fun handleResponse(){
        val action = MyRecipeFragmentDirections.actionMyRecipeFragmentToListFragment()
        Navigation.findNavController(requireView()).navigate(action)
    }


    private fun makeSmallerBitmap(image: Bitmap, maximumSize: Int): Bitmap {
        var width = image.width
        var height = image.height

        val bitmapRatio: Double = width.toDouble() / height.toDouble()
        if (bitmapRatio > 1) {
            width = maximumSize
            val scaledHeight = width / bitmapRatio
            height = scaledHeight.toInt()
        } else {
            height = maximumSize
            val scaledWidth = height * bitmapRatio
            width = scaledWidth.toInt()
        }

        return Bitmap.createScaledBitmap(image, width, height, true)

    }



    fun selectImage(view: View) {

        activity?.let {
            if(ContextCompat.checkSelfPermission(requireActivity().applicationContext, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    Snackbar.make(view, "Permission needed for gallery", Snackbar.LENGTH_INDEFINITE).setAction("Give Permission",
                        View.OnClickListener {
                            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                        }).show()
                } else {
                    permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                }
            } else {
                val intentToGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)

            }

        }

    }

    private fun registerLauncher() {
        activityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == AppCompatActivity.RESULT_OK) {
                val intentFromResult = result.data
                if (intentFromResult != null) {
                    selectedPicture = intentFromResult.data
                    try {
                        if (Build.VERSION.SDK_INT >= 28) {
                            val source = ImageDecoder.createSource(
                                requireActivity().contentResolver,
                                selectedPicture!!
                            )
                            selectedBitmap = ImageDecoder.decodeBitmap(source)
                            binding.imageView.setImageBitmap(selectedBitmap)
                        } else {
                            selectedBitmap = MediaStore.Images.Media.getBitmap(
                                requireActivity().contentResolver,
                                selectedPicture
                            )
                            binding.imageView.setImageBitmap(selectedBitmap)
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }
        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { result ->
            if (result) {
                //permission granted
                val intentToGallery =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                activityResultLauncher.launch(intentToGallery)
            } else {
                //permission denied
                Toast.makeText(requireContext(), "Permisson needed!", Toast.LENGTH_LONG)
                    .show()
            }
        }
}
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
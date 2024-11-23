package io.github.junrdev.recycle.features.home.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.QrCodeScanner
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.junrdev.recycle.R
import io.github.junrdev.recycle.domain.model.RecycleCategoryItem
import io.github.junrdev.recycle.ui.composables.CardComposables
import io.github.junrdev.recycle.ui.theme.cardo

class RecyclerContent : Fragment() {

    private val openCameraDialog: () -> Unit = {
        findNavController().navigate(R.id.action_homeScreen_to_scannerScreen)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                RecyclerContentImpl()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    private fun RecyclerContentImpl() {


        var query by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        val scrollState = rememberScrollState()


        MaterialTheme {
            Scaffold(
                containerColor = colorResource(R.color.background_dark),
                modifier = Modifier.fillMaxSize(),
            ) { padding ->
                Column(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                ) {

                    //top row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Select category or scan items.",
                            fontSize = 30.sp,
                            color = Color.White,
                            fontFamily = cardo,
                            modifier = Modifier.weight(1f)

                        )

                        IconButton(
                            onClick = openCameraDialog,
                            modifier = Modifier.border(
                                width = 1.dp,
                                color = Color.White,
                                shape = CircleShape
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.QrCodeScanner,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }


                    //category items
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentPadding = PaddingValues(12.dp),
                    ) {
                        items(items = RecycleCategoryItem.getCategories()) {
                            CardComposables
                                .PopularSearchItem(
                                    categoryItem = it,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )

                        }
                    }

                }
            }
        }
    }
}
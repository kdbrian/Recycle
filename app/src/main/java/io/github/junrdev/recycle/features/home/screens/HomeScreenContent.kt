package io.github.junrdev.recycle.features.home.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import io.github.junrdev.recycle.R
import io.github.junrdev.recycle.databinding.HomeScreenContentBinding
import io.github.junrdev.recycle.ui.composables.FeaturedContentHorizontalList
import io.github.junrdev.recycle.ui.composables.TextWithButtonText

class HomeScreenContent : Fragment() {

    private var binding: HomeScreenContentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return HomeScreenContentBinding.inflate(inflater, container, false)
            .also {
                binding = it
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as AppCompatActivity).setSupportActionBar(binding?.toolbar)
        setHasOptionsMenu(true)
        binding?.apply {
            composeView.apply {
                setContent {
                    MaterialTheme {
                        HomeScreenImpl()
                    }
                }
            }
        }
    }

    @Composable
    fun HomeScreenImpl(modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.background_dark))
            ) {

                TextWithButtonText {

                }

                Spacer(Modifier.height(12.dp))

                //featured content
                FeaturedContentHorizontalList(modifier = Modifier.padding(horizontal = 16.dp))


            }
        }
    }

    @Preview
    @Composable
    fun HomeScreenImplPrev(modifier: Modifier = Modifier) {
        MaterialTheme {
            HomeScreenImpl()
        }
    }

}
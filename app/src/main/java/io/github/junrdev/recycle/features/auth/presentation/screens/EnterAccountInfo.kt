package io.github.junrdev.recycle.features.auth.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.junrdev.recycle.R
import io.github.junrdev.recycle.ui.composables.spacer12Dp
import io.github.junrdev.recycle.ui.theme.plusjakartasans
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class EnterAccountInfo : Fragment() {

    val navigateToHome = {
            findNavController().navigate(R.id.action_enterAccountInfo2_to_homeScreen)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                var logginLoading by remember { mutableStateOf(false) }

                val onPhoneNumberLogin: (String) -> Unit = { phone ->
                    println("it -> $phone")
                    CoroutineScope(Dispatchers.Main).launch {
                        logginLoading = true
                        delay(1200)
                        logginLoading = false
                    }
                }

                val onGoogleLogin: () -> Unit = {
                    println("invoked G")
                    CoroutineScope(Dispatchers.Main).launch {
                        logginLoading = true
                        delay(1200)
                        logginLoading = false
                        navigateToHome()
                    }
                }

                MaterialTheme {
                    EnterAccountInfoImpl(
                        onPhoneNumberLogin = onPhoneNumberLogin,
                        onGoogleLogin = onGoogleLogin,
                        isLoading = logginLoading
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    private fun EnterAccountInfoImplPrev() {
        MaterialTheme {
            EnterAccountInfoImpl(
                onPhoneNumberLogin = { println("it -> $it") },
                isLoading = false
            ) {}
//            EnterPhoneNumberBottomDialog {}
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EnterAccountInfoImpl(
        modifier: Modifier = Modifier,
        isLoading: Boolean,
        onPhoneNumberLogin: (String) -> Unit,
        onGoogleLogin: () -> Unit,
    ) {

        val scope = rememberCoroutineScope()
        var showSheet by remember { mutableStateOf(false) }
        val sheetState = rememberModalBottomSheetState()

        val showBottomSheet: () -> Unit = {
            showSheet = true
        }

        Scaffold(
            modifier = Modifier,
        ) { paddingValues ->

            if (showSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showSheet = false },
                    sheetState = sheetState
                ) {
                    EnterPhoneNumberBottomDialog(isLoading = isLoading) {
                        scope.launch {
                            println("phone : $it")
                            delay(1200)
                            onPhoneNumberLogin(it)
                            showSheet = false
                        }
                    }
                }
            }


            if (isLoading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    CircularProgressIndicator(color = Color.DarkGray)
                }
            } else
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .padding(16.dp),
                ) {

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        OutlinedButton(
                            onClick = onGoogleLogin,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(R.drawable.google),
                                    contentDescription = "Continue with Google",
                                    modifier = Modifier.size(15.dp)
                                )

                                Spacer(modifier = Modifier.width(30.dp))

                                Text(
                                    text = "Continue with email",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontFamily = plusjakartasans
                                    )

                                )
                            }
                        }

                        Text(
                            text = "Or",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontFamily = plusjakartasans
                            ),
                            modifier = Modifier
                        )

                        OutlinedButton(
                            onClick = { showBottomSheet() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Rounded.Phone,
                                    contentDescription = "Continue with phone number"
                                )

                                Spacer(modifier = Modifier.width(30.dp))

                                Text(
                                    text = "Continue with phone number",
                                    style = MaterialTheme.typography.bodyMedium.copy(
                                        fontFamily = plusjakartasans
                                    )
                                )
                            }

                        }
                    }

                    Text(
                        text = "All terms and conditions reserved",
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 12.dp),
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.LightGray
                        )
                    )

                }
        }

    }


    @Composable
    fun EnterPhoneNumberBottomDialog(
        modifier: Modifier = Modifier,
        isLoading: Boolean = false,
        onCreateAccount: (String) -> Unit
    ) {
        var phoneNumber by remember {
            mutableStateOf("")
        }

        val Kb = LocalSoftwareKeyboardController.current

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Text(text = "Enter phone number", style = MaterialTheme.typography.titleLarge)

            Spacer(Modifier.height(spacer12Dp))

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text(text = "phone number") },
                leadingIcon = {
                    Icon(
                        contentDescription = null,
                        imageVector = Icons.Rounded.Phone,
                        modifier = Modifier
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(),
                shape = RoundedCornerShape(30.dp),
                keyboardActions = KeyboardActions(
                    onSend = {
                        Kb?.hide()
                    }
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Send,
                    keyboardType = KeyboardType.Phone
                )
            )

            Spacer(Modifier.height(24.dp))

            Button(onClick = {
                onCreateAccount(phoneNumber)
            }, modifier = Modifier.fillMaxWidth()) {

                when (isLoading) {
                    false -> {
                        Text(
                            style = MaterialTheme.typography.bodyLarge,
                            text = "SignIn/Sign Up",
                            modifier = Modifier.padding(8.dp),
                            fontFamily = plusjakartasans
                        )
                    }

                    true -> {
                        CircularProgressIndicator(
                            modifier = Modifier.size(30.dp),
                            color = Color.White
                        )

                    }
                }
            }


        }
    }

}
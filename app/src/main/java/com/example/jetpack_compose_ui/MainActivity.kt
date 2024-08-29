package com.example.jetpack_compose_ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.ColumnScopeInstance.align

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_ui.ui.theme.BackGround
import com.example.jetpack_compose_ui.ui.theme.DeepGreen
import com.example.jetpack_compose_ui.ui.theme.JetpackBlue
import com.example.jetpack_compose_ui.ui.theme.Jetpack_Compose_UITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_Compose_UITheme {
                Login_Page()


            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Login_Page(color: Color=DeepGreen,
               color1:Color=JetpackBlue,
               color2:Color=BackGround) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier
            .size(width = 380.dp, height = 690.dp)
            .padding(start = 20.dp, end = 20.dp, top = 60.dp, bottom = 140.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(15.dp)){
                Text(
                    "Jetpack Compose",fontSize = 30.sp, color = color1
                )
            }
            // Jetpack Compose Logo
            Image(
                painter = painterResource(id = R.drawable.jetpack_logo),
                contentDescription = "Jetpack Compose Logo",
                modifier = Modifier
                    .size(100.dp)
                    .background(color = color2)

            )

            // Login Text
            Text(
                "Login",
                fontStyle = FontStyle.Normal,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Start),
                color=color
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Email Input
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email ID or Mobile Number") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Input
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = if (passwordVisibility) {
                                Icons.Filled.VisibilityOff
                            } else {
                                Icons.Filled.Visibility
                            },
                            contentDescription = if (passwordVisibility) "Hide password"
                            else "Show password"
                        )
                    }
                }


            )

            Spacer(modifier = Modifier.height(3.dp))

            // Forgot Password Link
            Box(modifier = Modifier.align(Alignment.End)) {
                TextButton(onClick = { /* Handle Forgot Password */ }) {
                    Text(text = "Forgot Password?")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            // Login Button
            Button(
                onClick = { /* Handle Login */ },
                modifier = Modifier
                    .align(Alignment.Start)
                    .size(width = 110.dp, height = 50.dp)
            ) {
                Text(text = "Login")
            }

        }

    }
    Row(modifier = Modifier.padding(start = 60.dp, top = 550.dp, end = 15.dp, bottom = 20.dp)) {
        Text( "Don't have an account? ",modifier = Modifier.align(Alignment.CenterVertically))

        TextButton(onClick = { /* Handle Register */ }) {
            Text(text = " Register")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun Login_PagePreview() {
    Jetpack_Compose_UITheme {
        Login_Page()
    }
}
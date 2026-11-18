
package com.echo.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Ink = Color(0xFF172033)
private val Gold = Color(0xFFE9B65B)
private val Paper = Color(0xFFF7F5F0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EchoQuotesApp()
        }
    }
}

@Composable
fun EchoQuotesApp() {
    var selectedTab by remember { mutableStateOf("Home") }

    MaterialTheme {
        Scaffold(
            containerColor = Paper,
            bottomBar = {
                NavigationBar(
                    containerColor = Color.White
                ) {
                    listOf("Home", "Explore", "Favorites", "Settings")
                        .forEach { tab ->
                            NavigationBarItem(
                                selected = selectedTab == tab,
                                onClick = { selectedTab = tab },
                                icon = {
                                    Text(
                                        when (tab) {
                                            "Home" -> "⌂"
                                            "Explore" -> "⌕"
                                            "Favorites" -> "♡"
                                            else -> "⚙"
                                        },
                                        fontSize = 22.sp
                                    )
                                },
                                label = { Text(tab) }
                            )
                        }
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 22.dp)
            ) {
                Spacer(Modifier.height(28.dp))

                Text(
                    "ECHO",
                    color = Ink,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 5.sp
                )

                Text(
                    "WORDS THAT STAY WITH YOU.",
                    color = Color.Gray,
                    fontSize = 10.sp,
                    letterSpacing = 2.sp
                )

                Spacer(Modifier.height(35.dp))

                when (selectedTab) {
                    "Home" -> HomeScreen()
                    "Explore" -> SimpleScreen("Explore", "Find words that move you.")
                    "Favorites" -> SimpleScreen("Your Favorites", "Your saved quotes will appear here.")
                    else -> SimpleScreen("Settings", "Make ECHO Quotes your own.")
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Text(
        "YOUR DAILY REMINDER",
        color = Color(0xFF9A783F),
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 2.sp
    )

    Spacer(Modifier.height(14.dp))

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Ink)
    ) {
        Column(
            modifier = Modifier.padding(25.dp)
        ) {
            Text(
                "✦  TODAY'S QUOTE",
                color = Gold,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(Modifier.height(28.dp))

            Text(
                "Great things are built one small step at a time.",
                color = Color.White,
                fontSize = 25.sp,
                lineHeight = 35.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(Modifier.height(22.dp))

            Text(
                "— ECHO Original",
                color = Gold,
                fontSize = 13.sp
            )

            Spacer(Modifier.height(28.dp))

            HorizontalDivider(color = Color.White.copy(alpha = 0.2f))

            Spacer(Modifier.height(16.dp))

            Text(
                "A little progress every day adds up.",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
    }

    Spacer(Modifier.height(30.dp))

    Text(
        "A MOMENT FOR YOU",
        color = Ink,
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.sp
    )

    Spacer(Modifier.height(14.dp))

    Text(
        "You don't need to have it all figured out. Just keep moving forward.",
        color = Color(0xFF555B68),
        fontSize = 16.sp,
        lineHeight = 25.sp
    )
}

@Composable
fun SimpleScreen(title: String, subtitle: String) {
    Spacer(Modifier.height(25.dp))
    Text(title, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = Ink)
    Spacer(Modifier.height(10.dp))
    Text(subtitle, fontSize = 15.sp, color = Color.Gray)
}

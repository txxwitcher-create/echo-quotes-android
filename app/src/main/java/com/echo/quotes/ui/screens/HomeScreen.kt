
package com.echo.quotes.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val EchoInk = Color(0xFF172033)
private val EchoGold = Color(0xFFE9B65B)
private val EchoPaper = Color(0xFFF7F5F0)

@Composable
fun HomeScreen(
    onExploreClick: () -> Unit = {},
    onFavoritesClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(EchoPaper)
            .padding(horizontal = 22.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "ECHO",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 5.sp,
            color = EchoInk
        )

        Text(
            text = "WORDS THAT STAY WITH YOU.",
            fontSize = 10.sp,
            letterSpacing = 2.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "YOUR DAILY REMINDER",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp,
            color = Color(0xFF9A783F)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = EchoInk
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = "✦  TODAY'S QUOTE",
                    color = EchoGold,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "Great things are built one small step at a time.",
                    color = Color.White,
                    fontSize = 25.sp,
                    lineHeight = 35.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(22.dp))

                Text(
                    text = "— ECHO Original",
                    color = EchoGold,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "A little progress every day adds up.",
                    color = Color.LightGray,
                    fontSize = 13.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "A MOMENT FOR YOU",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp,
            color = EchoInk
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "You don't need to have it all figured out. Just keep moving forward.",
            fontSize = 16.sp,
            lineHeight = 25.sp,
            color = Color(0xFF555B68)
        )

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = onExploreClick,
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = EchoInk
                ),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Explore")
            }

            Button(
                onClick = onFavoritesClick,
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = EchoGold,
                    contentColor = EchoInk
                ),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Favorites")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "TAKE WHAT YOU NEED. CARRY IT WITH YOU.",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 9.sp,
            letterSpacing = 1.sp,
            color = Color.Gray
        )
    }
}

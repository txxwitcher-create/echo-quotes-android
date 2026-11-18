
package com.echo.quotes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    darkTheme: Boolean = false,
    onThemeChange: (Boolean) -> Unit = {},
    remindersEnabled: Boolean = false,
    onRemindersChange: (Boolean) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Customize your ECHO Quotes experience.",
            style = MaterialTheme.typography.bodyMedium
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Dark Theme",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Use a darker appearance.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Switch(
                    checked = darkTheme,
                    onCheckedChange = onThemeChange
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Daily Reminders",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Get a daily motivational reminder.",
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Switch(
                    checked = remindersEnabled,
                    onCheckedChange = onRemindersChange
                )
            }
        }

        Spacer(modifier = Modifier.width(1.dp))

        Text(
            text = "ECHO Quotes",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = "Version 1.0",
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = "Stay inspired. Keep moving forward.",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

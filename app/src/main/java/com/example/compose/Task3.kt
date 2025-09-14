package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Issue(
    val title: String,
    val description: String,
    val createdAt: String,
    val status: String
)

class Task3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IssuesScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IssuesScreen() {
    val issues = listOf(
        Issue("Bump pyarrow from 7...", "NONE", "2023-11-9, 23:0 PM", "Open"),
        Issue("Français", "NONE", "2023-11-2, 9:38 AM", "Open"),
        Issue("Bump werkzeug from ...", "NONE", "2023-10-25, 18:52 PM", "Open"),
        Issue("Bump urllib3 from 1.2...", "NONE", "2023-10-17, 22:59 PM", "Open"),
        Issue("ORQA fine tuning with...", "NONE", "2023-10-9, 15:3 PM", "Open"),
        Issue("Bump pillow from 9.2...", "NONE", "2023-10-4, 0:35 AM", "Open"),
        Issue("Bump requests from 2.28...", "NONE", "2023-10-5, 14:12 PM", "Open"),
        Issue("Bump Django from 4.1...", "NONE", "2023-10-6, 19:45 PM", "Open"),
    )


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Issues",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentPadding = PaddingValues(
                start = 0.dp,
                end = 0.dp,
                top = paddingValues.calculateTopPadding(),
                bottom = 0.dp
            )
        ) {
            items(issues) { issue ->
                IssueItem(issue)
            }
        }
    }
}


@Composable
fun IssueItem(issue: Issue) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 8.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .size(28.dp)
                    .padding(end = 8.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = issue.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = issue.description,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray,
                                fontSize = 12.sp
                            )
                        ) {
                            append("Created At: ")
                        }
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Normal,
                                color = Color.DarkGray,
                                fontSize = 12.sp
                            )
                        ) {
                            append(issue.createdAt)
                        }
                    }
                )

            }
            Text(
                text = issue.status,
                color = Color(0xFF0288D1),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
    }
}


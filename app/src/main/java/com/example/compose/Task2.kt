package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Task2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubRepositoriesScreen()
        }
    }
}

data class GithubRepository(
    val owner: String,
    val name: String,
    val description: String,
    val stars: Int,
    val imageUrl: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GithubRepositoriesScreen() {
    val repositories = listOf(
        GithubRepository(
            owner = "less.js",
            name = "less",
            description = "Less. The dynamic stylesheet language.",
            stars = 16971,
            imageUrl = R.drawable.less_logo
        ),
        GithubRepository(
            owner = "ruby",
            name = "ruby",
            description = "The Ruby Programming Language",
            stars = 20981,
            imageUrl = R.drawable.ruby_logo
        ),
        GithubRepository(
            owner = "rust-lang",
            name = "rust",
            description = "Empowering everyone to build reliable and efficient software.",
            stars = 87181,
            imageUrl = R.drawable.rust_logo
        ),
        GithubRepository(
            owner = "JuliaLang",
            name = "julia",
            description = "The Julia Programming Language",
            stars = 43541,
            imageUrl = R.drawable.julia_logo
        ),
        GithubRepository(
            owner = "tolmasky",
            name = "language",
            description = "A fast PEG parser written in JavaScript with first class errors",
            stars = 411,
            imageUrl = R.drawable.tolmasky_avatar
        ),
        GithubRepository(
            owner = "JetBrains",
            name = "kotlin",
            description = "The Kotlin Programming Language",
            stars = 46289,
            imageUrl = R.drawable.kotlin_logo
        )
    )

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Github Repositories",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(Color.White)
        ) {
            items(repositories) { repo ->
                RepositoryCard(repo = repo)
            }
        }
    }
}

@Composable
fun RepositoryCard(repo: GithubRepository) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                containerColor = Color.White
                )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = repo.imageUrl),
                contentDescription = "${repo.name} logo",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = repo.owner,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = repo.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = repo.description,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = repo.stars.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star icon",
                    tint = Color(0xFFFDD835),
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

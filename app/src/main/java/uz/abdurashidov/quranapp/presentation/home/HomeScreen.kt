@file:OptIn(ExperimentalMaterial3Api::class)

package uz.abdurashidov.quranapp.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import cafe.adriel.voyager.core.screen.Screen
import uz.abdurashidov.quranapp.R
import uz.abdurashidov.quranapp.data.remote.model.surahs.Data
import uz.abdurashidov.quranapp.presentation.theme.QuranAppTheme
import uz.abdurashidov.quranapp.presentation.theme.boldTextColorBlack
import uz.abdurashidov.quranapp.presentation.theme.boldTextColorPurple
import uz.abdurashidov.quranapp.presentation.theme.cardColor
import uz.abdurashidov.quranapp.presentation.theme.mainBackgroundColor

@Composable
fun HomeScreen(
    navController:NavHostController
) {

    val homeScreenViewModel = viewModel<HomeScreenViewModel>()

    Column(
        modifier = Modifier
            .background(mainBackgroundColor)
            .fillMaxSize()
            .padding(10.dp)
    ) {
        CustomAppBar()
        Spacer(modifier = Modifier.height(10.dp))
        DescriptionSection(name = "Saydullo")
        Spacer(modifier = Modifier.height(20.dp))
        CardSection(surahName = "Al-Fatiha", ayahNumber = 1) {}
        Spacer(modifier = Modifier.height(30.dp))
        MainSection(homeScreenViewModel.allQuranSurahs.collectAsState().value)
    }

}

@Composable
fun CustomAppBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.spacedBy(50.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.burger_menu),
            contentDescription = null,
            modifier = Modifier.size(25.dp)
        )
        Text(
            text = "Quran App",
            color = boldTextColorBlack,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
}


@Composable
fun DescriptionSection(name: String) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "Assalomu alaykum!!!",
            color = boldTextColorPurple,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = name,
            color = boldTextColorBlack,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardSection(
    surahName: String,
    ayahNumber: Int,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor)
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ) {
            Column(
                modifier = Modifier.weight(.7f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(id = R.drawable.cache_small1),
                        null,
                        Modifier.size(20.dp)
                    )
                    Text(text = "Last Read", fontWeight = FontWeight.Medium, fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = surahName, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                Text(text = "Ayah no.$ayahNumber", fontSize = 13.sp, fontWeight = FontWeight.Normal)
            }
            Image(
                painter = painterResource(id = R.drawable.cache_large1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 20.dp)
                    .size(60.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainSection(
    list: List<Data>
) {
    LazyColumn {
        items(list.size) {
            SurahItem(data = list[it]) {

            }
        }
    }
}

@Composable
fun SurahItem(data: Data, onClick: () -> Unit) {
    Column(
        modifier = Modifier.clickable {
            onClick
        }
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = data.englishName,
                    fontWeight = FontWeight.Bold,
                    color = boldTextColorBlack,
                    fontSize = 14.sp
                )
                Text(
                    text = "Verse ${data.numberOfAyahs}",
                    fontWeight = FontWeight.Normal,
                    color = boldTextColorBlack,
                    fontSize = 11.sp
                )
                Text(
                    text = "(${data.englishNameTranslation})",
                    fontWeight = FontWeight.Normal,
                    color = boldTextColorBlack,
                    fontSize = 11.sp
                )
            }

            Text(text = data.name, fontSize = 20.sp)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(cardColor)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    QuranAppTheme {
        SurahItem(
            data = Data(
                englishName = "Al-Fatiha",
                englishNameTranslation = "The Opener",
                name = "ةحَتِافَلْا",
                number = 1,
                numberOfAyahs = 7,
                revelationType = ""
            )
        ) {}
    }
}

package uz.abdurashidov.quranapp.presentation.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.abdurashidov.quranapp.R
import uz.abdurashidov.quranapp.data.remote.model.alldata.Ayah
import uz.abdurashidov.quranapp.presentation.theme.QuranAppTheme
import uz.abdurashidov.quranapp.presentation.theme.boldTextColorBlack
import uz.abdurashidov.quranapp.presentation.theme.cardColor
import uz.abdurashidov.quranapp.presentation.theme.mainBackgroundColor

@Composable
fun DetailScreen(
    navController: NavHostController,
    argument: Int?,
    detailScreenViewModel: DetailScreenViewModel,
) {
    if (argument != null) {
        detailScreenViewModel.getAllSurahDetails(argument + 1)
    } else {
        detailScreenViewModel.getAllSurahDetails(1)
    }

    val ayahs by detailScreenViewModel.ayahs.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainBackgroundColor)
            .padding(20.dp)
    ) {
        CustomAppBar(navController = navController)
        Spacer(modifier = Modifier.height(30.dp))
        DescriptionSection(
            ayahName = ayahs?.data?.get(0)?.englishName ?: "",
            ayahVerse = ayahs?.data?.get(0)?.ayahs?.size ?: 0,
            ayahEnglishName = ayahs?.data?.get(0)?.englishNameTranslation ?: ""
        )
        MainSection(
            ayahsAr = ayahs?.data?.get(0)?.ayahs ?: emptyList(),
            ayahEng = ayahs?.data?.get(2)?.ayahs ?: emptyList()
        )
    }
}

@Composable
fun CustomAppBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.detailback),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp)
                .padding(5.dp)
                .clickable {
                    navController.popBackStack()
                }
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
fun DescriptionSection(
    ayahName: String,
    ayahVerse: Int,
    ayahEnglishName: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp)
    ) {
        Column {
            Text(
                text = ayahName,
                color = boldTextColorBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            Text(
                text = "Verse $ayahVerse",
                color = boldTextColorBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = "($ayahEnglishName)",
                color = boldTextColorBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

        }
        Image(
            painter = painterResource(id = R.drawable.detailplay),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.CenterVertically)
        )
    }
}


@Composable
fun MainSection(ayahsAr: List<Ayah>, ayahEng: List<Ayah>) {
    if (ayahsAr.isNotEmpty() && ayahEng.isNotEmpty()) {
        LazyColumn {
            items(ayahsAr.zip(ayahEng)) { (ayahAr, ayahEng) ->
                AyahItem(ayahAr = ayahAr.text, ayahEng = ayahEng.text)
            }
        }
    }
}

@Composable
fun AyahItem(ayahAr: String, ayahEng: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(2.dp)
                .background(cardColor)
        )
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            Text(text = ayahAr, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = ayahEng)
    }
}


@Preview
@Composable
private fun DetailScreenPreview() {
    QuranAppTheme {

    }
}
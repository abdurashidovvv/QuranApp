package uz.abdurashidov.quranapp.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.abdurashidov.quranapp.R
import uz.abdurashidov.quranapp.data.remote.model.ayahs_ar.Ayah
import uz.abdurashidov.quranapp.presentation.theme.QuranAppTheme
import uz.abdurashidov.quranapp.presentation.theme.boldTextColorBlack
import uz.abdurashidov.quranapp.presentation.theme.cardColor
import uz.abdurashidov.quranapp.presentation.theme.mainBackgroundColor

@Composable
fun DetailScreen(
    navController: NavHostController,
    argument: Int?,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(mainBackgroundColor)
            .padding(20.dp)
    ) {
        CustomAppBar()
        Spacer(modifier = Modifier.height(30.dp))
        DescriptionSection(ayahName = "Al-Fatiha", ayahVerse = 7, ayahEnglishName = "The Opener")
        MainSection(list = Data.ayahs)
    }
}

@Composable
fun CustomAppBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.detailback),
            contentDescription = null,
            modifier = Modifier.size(30.dp)
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
        modifier = Modifier.fillMaxWidth()
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
fun MainSection(list: List<Map<String, String>>) {
    LazyColumn {
        items(list.size) {
            AyahItem(ayah = list[it])
        }
    }
}

@Composable
fun AyahItem(ayah: Map<String, String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(2.dp)
            .background(cardColor))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd){
            Text(text = ayah.keys.elementAt(0), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = ayah.values.elementAt(0))
    }
}

object Data {
    val ayahs = listOf(
        mapOf("مِيحِرَّلٱ نِٰـمَحْرَّلٱ هِلَّلٱ مِسْبِ" to "In the Name of Allah-the Most Compassionate, Most Merciful"),
        mapOf("مِيحِرَّلٱ نِٰـمَحْرَّلٱ هِلَّلٱ مِسْبِ" to "In the Name of Allah-the Most Compassionate, Most Merciful"),
        mapOf("مِيحِرَّلٱ نِٰـمَحْرَّلٱ هِلَّلٱ مِسْبِ" to "In the Name of Allah-the Most Compassionate, Most Merciful"),
        mapOf("مِيحِرَّلٱ نِٰـمَحْرَّلٱ هِلَّلٱ مِسْبِ" to "In the Name of Allah-the Most Compassionate, Most Merciful"),
    )
}

@Preview
@Composable
private fun DetailScreenPreview() {
    QuranAppTheme {
        DetailScreen(navController = rememberNavController(), argument = 1)
    }
}
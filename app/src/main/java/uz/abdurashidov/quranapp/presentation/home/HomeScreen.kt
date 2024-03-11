package uz.abdurashidov.quranapp.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import uz.abdurashidov.quranapp.R

@Composable
fun HomeScreen() {
    Column {
        CustomAppBar()
    }
}

@Composable
fun CustomAppBar(
    modifier: Modifier = Modifier
) {
    Row {
        Image(painter = painterResource(id = R.drawable.burger_menu), contentDescription = null)
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {

}
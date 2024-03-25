package uz.abdurashidov.quranapp.presentation.navigation

enum class Screen{
    HOME,
    DETAIL,
    SETTINGS
}

sealed class NavigationItem(val route:String){
     object Home:NavigationItem(Screen.HOME.name)
     object Detail:NavigationItem(Screen.DETAIL.name, )
     object Settings:NavigationItem(Screen.SETTINGS.name)
}
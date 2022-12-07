package com.example.bottomnavigationproject.ui.compose

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavigationproject.R
import com.example.bottomnavigationproject.model.Routes
import com.example.bottomnavigationproject.model.sampleNavigationItemData

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun BottomNavBar() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                })
        },
        content = { BottomNavSetup(navController) },
        bottomBar = { BottomBar(navController) }
    )
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun BottomNavSetup(
    navController: NavHostController
){
    NavHost( navController = navController, startDestination = Routes.Notifications.route ){
        composable(Routes.Notifications.route){
            Notifications()
        }
        composable(Routes.Settings.route){
            Settings()
        }
        composable(Routes.Account.route){
            Account()
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currRoute = backStackEntry?.destination?.route

        sampleNavigationItemData.forEach { navItem ->
            BottomNavigationItem(
                selected = (currRoute == navItem.route),
                onClick = { navController.navigate(navItem.route){
                                launchSingleTop = true
                                }
                          },

                label = {
                    Text(text = navItem.description)
                },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = "")
                }
            )
        }

    }
}
package com.nafaskarya.muslimdaily.presentation.guestUser.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nafaskarya.muslimdaily.presentation.core.components.guest.GuestBodyContent
import com.nafaskarya.muslimdaily.presentation.core.state.GuestScreenState
import com.nafaskarya.muslimdaily.presentation.search.SearchScreen

@Composable
fun GuestNavGraph(
    bottomNavController: NavHostController,
    rootNavController: NavController,
    state: GuestScreenState,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = bottomNavController,
        startDestination = "home",
        modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable("home") {
            GuestBodyContent(
                state = state,
                navController = rootNavController,
                paddingValues = PaddingValues(top = paddingValues.calculateTopPadding())
            )
        }

        composable("search") {
            SearchScreen(navController = rootNavController)
        }

        composable("library") { }
        composable("premium") { }
        composable("create") { }
    }
}
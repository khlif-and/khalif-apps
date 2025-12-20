package com.nafaskarya.muslimdaily.presentation.core.shared.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.ProfileBackground
import com.nafaskarya.muslimdaily.presentation.core.constant.ColorConstant.TextWhite
import com.nafaskarya.muslimdaily.presentation.core.constant.ProfileText
import com.nafaskarya.muslimdaily.presentation.core.shared.profile.part.*
import com.nafaskarya.muslimdaily.presentation.core.utils.windows.rememberWindowDimensions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileAccountScreen(
    onBackClick: () -> Unit,
    onLogoutConfirmed: () -> Unit
) {
    val dimen = rememberWindowDimensions()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var showLogoutDialog by remember { mutableStateOf(false) }

    val accountSettings = remember {
        listOf(
            MenuOption(ProfileText.MENU_PERSONAL_INFO, Icons.Default.Person),
            MenuOption(ProfileText.MENU_NOTIFICATIONS, Icons.Outlined.Notifications),
            MenuOption(ProfileText.MENU_PRIVACY, Icons.Outlined.Security),
            MenuOption(ProfileText.MENU_DATA_SAVER, Icons.Default.DataUsage)
        )
    }

    val appInfoSettings = remember {
        listOf(
            MenuOption(ProfileText.MENU_ABOUT, Icons.Default.Info),
            MenuOption(ProfileText.MENU_RATE, Icons.Default.Star)
        )
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = Color(0xFF121212),
                drawerShape = androidx.compose.ui.graphics.RectangleShape,
                modifier = Modifier.fillMaxWidth(0.85f)
            ) {
                ProfileSidebar()
            }
        }
    ) {
        Scaffold(
            containerColor = ProfileBackground,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = ProfileText.TITLE_PROFILE,
                            style = MaterialTheme.typography.titleMedium.copy(
                                color = TextWhite,
                                fontWeight = FontWeight.Bold,
                                fontSize = dimen.getResponsiveTextSize(0.045f, max = 20f).value.sp
                            )
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = TextWhite
                            )
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = ProfileBackground
                    )
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = dimen.width * 0.05f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item(key = "header", contentType = "header") {
                    ProfileHeaderSection(
                        dimen = dimen,
                        onProfileClick = {
                            scope.launch { drawerState.open() }
                        }
                    )
                    Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.03f)))
                }

                item(key = "premium_card", contentType = "card") {
                    PremiumPlanCard(dimen)
                    Spacer(modifier = Modifier.height(dimen.getResponsiveHeight(0.03f)))
                }

                item(key = "title_account", contentType = "section_title") {
                    SettingsGroupTitle(ProfileText.GROUP_ACCOUNT)
                }

                items(
                    items = accountSettings,
                    key = { "acc_${it.title}" },
                    contentType = { "menu_item" }
                ) { item ->
                    ProfileMenuItem(dimen, item.icon, item.title, item.action)
                }

                item(key = "spacer_middle") {
                    Spacer(modifier = Modifier.height(24.dp))
                }

                item(key = "title_app_info", contentType = "section_title") {
                    SettingsGroupTitle(ProfileText.GROUP_APP_INFO)
                }

                items(
                    items = appInfoSettings,
                    key = { "app_${it.title}" },
                    contentType = { "menu_item" }
                ) { item ->
                    ProfileMenuItem(dimen, item.icon, item.title, item.action)
                }

                item(key = "spacer_bottom") {
                    Spacer(modifier = Modifier.height(24.dp))
                }

                item(key = "logout_section", contentType = "footer") {
                    LogoutButton(dimen) {
                        showLogoutDialog = true
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = ProfileText.APP_VERSION,
                        style = MaterialTheme.typography.labelSmall.copy(
                            color = Color.Gray
                        )
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }

            if (showLogoutDialog) {
                LogoutConfirmationDialog(
                    onDismiss = { showLogoutDialog = false },
                    onConfirm = {
                        showLogoutDialog = false
                        onLogoutConfirmed()
                    }
                )
            }
        }
    }
}
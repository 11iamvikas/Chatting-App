package com.example.chatapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.Screens.LoginScreen
import com.example.chatapp.ui.theme.ChatAppTheme
import androidx.navigation.compose.composable
import com.example.chatapp.Screens.ChatListScreen
import com.example.chatapp.Screens.ProfileScreen
import com.example.chatapp.Screens.SignUpScreen
import com.example.chatapp.Screens.SingleChatScreen
import com.example.chatapp.Screens.SingleStatusScreen
import com.example.chatapp.Screens.StatusScreen
import dagger.hilt.android.AndroidEntryPoint

sealed class DestinationScreen(var route: String) {
    object SignUp : DestinationScreen(route = "signup")
    object Login : DestinationScreen(route = "login")
    object Profile : DestinationScreen(route = "profile")
    object ChatList : DestinationScreen(route = "chatList")
    object SingleChat : DestinationScreen(route = "singleChat/{chatID}") {
        fun createRoute(id: String) = "singleChat/$id"
    }

    object StatusList : DestinationScreen(route = "statusList")
    object SingleStatus : DestinationScreen("singleStatus/{userId}") {
        fun createRoute(userId: String) = "singleStatus/$userId"
    }
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatAppNavigation()
                }
            }
        }
    }
    @Preview
    @Composable
    fun ChatAppNavigation(){
        val navController = rememberNavController()
        var vm = hiltViewModel<LCViewModel>()
        NavHost(navController = navController, startDestination = DestinationScreen.SignUp.route){
            composable(DestinationScreen.SignUp.route){
                SignUpScreen(navController,vm)
            }
            composable(DestinationScreen.Login.route){
                LoginScreen(navController = navController, vm = vm)
            }
             composable(DestinationScreen.ChatList.route){
                ChatListScreen(navController= navController, vm=vm)
            }
            composable(DestinationScreen.SingleChat.route){
                val chatId=it.arguments?.getString("chatId")
                SingleChatScreen(navController = navController, vm =vm, chatId = "chatId")
            }
            composable(DestinationScreen.StatusList.route){
                StatusScreen(navController= navController, vm=vm)
            }
            composable(DestinationScreen.Profile.route){
                ProfileScreen(navController= navController, vm=vm)
            }
            composable(DestinationScreen.SingleStatus.route){
                val userId= it.arguments?.getString("userId")
                userId?.let {
                    SingleStatusScreen(navController= navController, vm= vm, userId = it)
                }
            }
        }
    }

}

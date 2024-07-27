# ChatApp

A modern chat application built with Kotlin and Jetpack Compose, utilizing Firebase services for authentication, real-time database, and storage. The app is structured following the MVVM (Model-View-ViewModel) architecture, ensuring a clear separation of concerns and enhancing maintainability and testability.

## Features

- **User Authentication**: Sign up and login using Firebase Authentication.
- **Chat List**: View a list of recent chats.
- **Status List**: View statuses posted by users.
- **Profile Management**: Edit profile details and update profile picture.
- **Single Chat**: Exchange messages in real-time with other users.
- **Single Status**: View detailed status updates from users.

## Tech Stack

- **Language**: Kotlin
- **UI Toolkit**: Jetpack Compose
- **Firebase Services**:
  - **Authentication**: Firebase User Authentication for secure login and registration.
  - **Database**: Firestore for real-time data storage and synchronization.
  - **Storage**: Firebase Storage for uploading and managing media files.

## Architecture

The app is developed using the MVVM (Model-View-ViewModel) architecture, which offers several benefits:

- **Separation of Concerns**: Different layers handle different responsibilities, making the app more modular and easier to maintain.
- **Testability**: ViewModels can be tested independently of the UI, leading to more reliable code.
- **Lifecycle Awareness**: ViewModels are lifecycle-aware, preventing memory leaks and unnecessary updates.

## Getting Started

1. Clone the repository:
   ```sh
   git clone https://github.com/11iamvikas/Chatting-App.git
2. Open the project in Android Studio.
3. Connect your Firebase project to the app:
-  Follow the steps to set up Firebase in your Android project here.
-  Add the google-services.json file to your project's app directory.
4. Build and run the app on an emulator or physical device.

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

##Contact
For any inquiries, please contact vikaspant990@gmail.com .


# GitHub User List

An Android app built with Jetpack Compose and Material 3 that allows users to search GitHub profiles and view their public repositories.

---

## Features

- **User Search**
  - Search GitHub users by username.
  - Instant search results with avatar and username.

- **User Detail**
  - Display user's full name, avatar, followers, and following count.

- **Repositories**
  - List all **non-forked** public repositories.
  - Show programming language, star count, and description.
  - Tap to open the repository directly on GitHub.

---

## Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **MVVM Architecture**
- **Modularization** (e.g., `core-ui`, `app`)
- **Koin** (Dependency Injection)
- **Ktor Client** (Network requests)
- **Kotlinx Serialization** (JSON parsing)
- **Coil** (Image loading)
- **Coroutines** (Asynchronous programming)
- **Navigation Compose** (Screen navigation)
- **Lifecycle Libraries** (State management and lifecycle awareness)

---

## How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/github-user-viewer.git
2. Open with Android Studio Hedgehog or newer (Developed with Android Studio Merkat 2025.1.1 Canary).
3. Run the project on an emulator or device running Android 8.0 (API 26) or higher.


## Project Highlights

- Koin-based Dependency Injection
- Provides lightweight and scalable dependency management across modules.
- Clean UDF Implementation
- Well-structured ViewModel with clear event and state handling.
- Composable Modular Screens
- Separated UI components for better scalability and readability.
- Modern Folder Structure
- Organized feature-based modularization for ease of maintenance.
- Network Layer with Ktor
- Efficient, non-blocking network calls with built-in JSON serialization and logging.

Only open-source libraries are used.

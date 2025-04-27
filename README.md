# GitHub User

An Android app built with Jetpack Compose and Material 3 that allows users to search GitHub profiles and view their public repositories.

---

## Features

- **User Search**
  - Search GitHub users by username.
  - Instant result list with avatar and username.
  
- **User Detail**
  - Displays full name, avatar, followers & following count.
  
- **Repositories**
  - Lists all **non-forked** public repositories.
  - Shows language, stars, and description.
  - Tap to open the repository on GitHub.

---

## Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Coil** (Image loading)
- **GitHub REST API v3**
- **MVVM Architecture**
- **Modularization** (e.g., `core-ui`, `app`)

---

## How to Run

1. Clone this repo:
   ```bash
   git clone https://github.com/your-username/github-user-viewer.git

2. Open with Android Studio Hedgehog or newer
   (Built with Android Studio Merkat 2025.1.1 Canary)

3. Run the project on an emulator or device running Android 8.0 (API 26) or higher.

## Project Highlights

Initialized Koin D.I — Easy, clean dependency injection.
ViewModel Setup — ViewModel ready with clean event/state management.
UI Assembled — Composable screens modularized for scalability.
Enhanced Folder Structure — Feature-based modularization for better maintenance.

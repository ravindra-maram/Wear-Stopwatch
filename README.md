# ⌚ Android Wear Stopwatch App

A lightweight, visually appealing **Stopwatch App** built specifically for **Wear OS** using Java and ViewBinding. This application is optimized for round smartwatch screens, supporting clear UI states and smooth animations.

---

## 📸 Screenshots

| Running Timer | Stopped Timer | Reset Timer |
|---------------|---------------|-------------|
| ![Running](img2.png) | ![Stopped](img4.png) | ![Reset](img5.png) |

> Make sure these images (`img2.png`, `img4.png`, `img5.png`) are in your repository root or adjust paths accordingly.

---

## 🚀 Features

- ✅ Start, Stop, and Reset stopwatch functionality
- ✅ Clear color-coded button states (active/disabled)
- ✅ Animated button scaling for click feedback
- ✅ Uses `Handler` for efficient time tracking
- ✅ Rounded buttons with customized colors
- ✅ Optimized for small round Wear OS screens

---

## 🎯 Functional Requirements Met

| Requirement | Status |
|------------|--------|
| Start timer on button click | ✅ |
| Disable "Start" when running | ✅ |
| Stop the timer | ✅ |
| Disable "Stop" when paused | ✅ |
| Reset to 00:00:00 | ✅ |
| Disable "Reset" until stopped | ✅ |
| Chronometer updates in HH:MM:SS | ✅ |
| Button color and state updates | ✅ |
| Uses `Handler` instead of Chronometer listener | ✅ |
| Buttons respond with UI animations | ✅ |

---

## 🧠 Architecture & Technologies

- **Language:** Java
- **UI Framework:** ViewBinding
- **Layout:** Single Activity, XML-based UI
- **Wear OS Support:** Android 11+ (minSdk 30)
- **Time Handling:** `Handler` for 1-second updates
- **Animations:** `ObjectAnimator` for scale effect
- **UI Feedback:** Colors update based on enable/disable state

---

## 📂 Project Structure

```
.
├── MainActivity.java                  # Main stopwatch logic & UI
├── res/
│   ├── layout/activity_main.xml       # Layout with Chronometer + Buttons
│   ├── values/colors.xml              # Custom colors for states
│   ├── values/strings.xml             # App labels
│   ├── values/dimens.xml              # Responsive sizing
│   └── drawable/
│       ├── rounded_button_start.xml
│       ├── rounded_button_stop.xml
│       └── rounded_button_reset.xml
```

---

## 🛠️ Setup Instructions

1. Clone or download the project.
2. Open with **Android Studio**.
3. Run on:
    - A **Wear OS Emulator**, or
    - A **physical Wear OS device** with Android 11+
4. Ensure the following `build.gradle` config:
```groovy
defaultConfig {
    minSdk 30
    targetSdk 35
}
```

---

## 🎮 How It Works

- **Start:** Stopwatch begins, "Start" disables, "Stop" + "Reset" enable.
- **Stop:** Stopwatch pauses, "Stop" disables, "Start" + "Reset" enable.
- **Reset:** Stopwatch resets to zero, "Reset" disables, "Start" + "Stop" enable.
- Button colors reflect state:
    - 🟢 Green = Active Start
    - 🟠 Orange = Active Stop
    - 🔵 Blue = Active Reset
    - ⚪ Gray = Disabled

---

## 🧪 Demo Checklist (Instructor Use)

- [x] All buttons functional and animate on click
- [x] Handler updates time per second
- [x] Buttons change color based on state
- [x] Uses ViewBinding (No findViewById)
- [x] No hardcoded text/colors/dimensions
- [x] Clean UI for small round screens
- [x] Interface listener implemented at class level (✔️ if OnChronometerTickListener used earlier)

---

## 🙋‍♂️ Author

**Name:** Ravindra Reddy Maram  
**Program:** Mobile Solutions Development  
**Institution:** Conestoga College  
**Assignment:** Assignment 1 - Android Wear Stopwatch  
**Submitted On:** October 15, 2023

---

## 📘 Academic Integrity

> This project is my own original work. No part of the code is copied or reused from online repositories or classmates. This submission complies with all academic integrity guidelines of Conestoga College.

---

## 📄 License

This project is for **educational use only** and not licensed for production use.

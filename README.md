# Simple Diary
This repository is created for the purpose of the final exam in the **Introduction to Mobile Development** course. The project involves developing an Android Diary App specifically designed for tablets, adhering to the provided guidelines and requirements.

## Project Description
The app is designed to allow users to maintain a diary with functionalities including user authentication, diary entry management, and web browsing. It consists of 7 activities with specific layout and functionality requirements.

## PROJECT DETAILS
* Name: Diary
* Language: Java
* Android Version: Koala | 2024.1.1 RC 2
* Minimum SDK: API 23 ("Marshmallow"; Android 6.0)
* Build Configuration Language: Groovy DSL (build.gradle)

### Activities Overview
1. **Settings (First Launch)**  
   - Set up user name and password on the first use.
   - Validates password length (minimum 4 digits).
   - Navigates to the Login page upon successful setup.

2. **Login**  
   - Allows users to log in using their password.
   - Displays a greeting message with the current date.
   - Incorrect password shows an error message.

3. **Welcome Animation**  
   - Displays an animation and a message showing the duration since the app was first used.
   - Automatically navigates to the Diary Input page after 5 seconds.

4. **Diary Input**  
   - Allows users to write or update diary entries for the current day.
   - Saves the entry and navigates to the Browser page.

5. **Browser**  
   - Enables users to view diary entries for specific dates.
   - Option to proceed to a web browsing activity.

6. **Web Browser**  
   - Provides a simple web browsing interface (default: YouTube homepage).
   - Navigates to the updated Settings page.

7. **Settings (Again)**  
   - Similar to the first settings page but allows updating existing credentials.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/TechSavvyCoder/Simple-Diary.git
   ```

## Contact
[Contact the developer](mailto:diegopinlac@gmail.com)

## License

This project is for educational purposes and is not intended for commercial use.

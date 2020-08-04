# Random dogs

> An Android app written in 100% Kotlin to play a little bit with `hilt-android` the new dagger library from google.


## Overview

Random dog is an app that shows you as the name already said, randam pictures of dogs. 


## Architecture
The purpose of this project isn't the architecture but the hilt DI, nevertheless I structured the project in the bellow architecture to make it easier to apply unit test.

MVI - User interaction with the UI is processed by business logic which brings change in the state. This new state is rendered on view and this newly updated view is shown to the user. This leads to a Unidirectional and Circular Data Flow.



## ScreenShots
Soon

## Knowledge Stack

This project leverages on

- 100% powered by AndroidX 
- RxJava2 for end-to-end reactive programming
- Hilt for Dependency Injection
- Retrofit/Okhttp for network calls
- Gson for serialize objects






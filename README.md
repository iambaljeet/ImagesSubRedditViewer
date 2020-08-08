# ImagesSubRedditViewer

**ImagesSubRedditViewer** is a demo application for showcasing a basic imageloader library for loading network images ti imageview and caching them in both Memory and Disk.


# Features

Below are some of the features of this demo library.
- Ability to load images from network into ImageView. 
- Ability to cache loaded iamges to both Memory and Disk.
- Ability to clear cache or cancel any request anytime.

# Decisions

While starting this demo i have dome some research on the way how mage loading can be done by keeping in mind about caching mechanism and some of the best apporaches for caching. I landed to some articles 
and got to knew about DiskLruCache provided by [Jake wharton](https://github.com/JakeWharton). Which is optimised library even most of the methods were matching to AOSP's DiskLruCache.
Other than that there is defaul LruCache availalbe as a part of Java lang itself which is best optimised Memory caching mechanism which i used in this application.

I have to stick to a clean architecture so this demo can be maintainable in future and can be optimised and bugs/issues can be resolved so i stick yo MVVM and followed HILT as 
dependency injection library because it is highly compatible with other Jetpack's libraries. Also, it is really easy to maintain and use.

I choose kotlin as primary language for this demo because Kotlin have a lot more features than Java like null safety, extension functions, named parameters etc which enforces code reusability and reduced the number of LOC.

# Usage

1. First import the library as a module to your app.

2. Create an instance of ImageLoader
```
    val imageLoader = ImageLoader.getInstance(context)
```

2. Simply pass imageUrl and a optional placeholder
```
    imageLoader.loadImage(fileUrl = url, imageView = imageView, placeholder = placeHolder)
```

That's it.

Note: This is a not very well optimised/finished demo app. It containes bugs and UI logs while scrolling.

## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

## Built With
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-jetpack) - Dependency injection library for Android.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [DiskLruCache](https://github.com/JakeWharton/DiskLruCache) - Library used for caching on Local Disk.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
- [Gson](https://github.com/google/gson) - A JSON library for Kotlin and Java.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.

[![JitPack - SuperView](https://img.shields.io/badge/JitPack-SuperView-2ea44f?style=for-the-badge)](https://jitpack.io/#doxart/SuperView) [![License - MIT](https://img.shields.io/badge/License-MIT-3454D1?style=for-the-badge)](https://github.com/doxart/SuperView/blob/master/LICENSE)

# SuperView Library

SuperView is a lightweight Android library that simplifies and speeds up animations on views. With SuperView, you can easily add animations to your Android app's views without the complexity of manual animation handling.

![SuperView Demo](https://github.com/doxart/SuperView/blob/master/demo--0.gif)
![SuperView Demo-1](https://github.com/doxart/SuperView/blob/master/demo--1.gif)

## Features

- **Ease of Use:** Simple and intuitive API for adding animations to views.
- **Lightweight:** Minimal overhead on your app's resources.
- **Customizable:** Easily customize animation parameters such as duration, easing, and more.
- **Compatibility:** Compatible with a wide range of Android versions.

## Installation

To use SuperView in your Android project, add the following dependency to your app's `build.gradle` file:

```gradle
implementation "com.github.doxart:SuperView:0.8"
```

## Usage

#### Basic Animation

```java
SuperAnim anim = new SuperAnim(context, SuperAnim.FADE_IN).apply();

SuperView.getInstance(context).into(binding.myAnimatedView).with(anim).show();
```
Also you can hide view:

```java
SuperAnim anim = new SuperAnim(context, SuperAnim.FADE_IN).apply();

SuperView.getInstance(context).into(binding.myAnimatedView).with(anim).hide();
```

#### Custom Animation

```java
SuperAnim anim = new SuperAnim(context, new AnimationType("MyCustomAnimation", R.anim.custom_fade_in).apply();

SuperView.getInstance(context).into(binding.myAnimatedView).with(anim).show();
```

#### Advanced Animation

```java
SuperAnim anim = new SuperAnim(context, SuperAnim.FADE_IN)
        .setAutoStart(true)
        .setDuration(6000)
        .setAnimFillAfter(false)
        .setAnimRepeatCount(2)
        .setAnimRepeatMode(Animation.RESTART)
        .setDurationTickTolerance(100)
        .apply();

SuperView.getInstance(context)
        .into(binding.myAnimatedView)
        .with(anim)
        .listener(new AnimationListener() {
            @Override
            public void onStart() {
                Log.d(TAG, "onStart: " + binding.myAnimatedView.getId());
            }

            @Override
            public void onFinish() {
                Log.d(TAG, "onFinish: " + binding.myAnimatedView.getId());
            }

            @Override
            public void onError(String e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onTick(int tick) {
                Log.d(TAG, "onTick: " + tick);
            }
        })
        .show();
```


## License

This project is licensed under the MIT License - [LICENSE](https://github.com/doxart/SuperView/blob/master/LICENSE) see the  file for details.


## Contributing

Contributions are welcome! Fork the repository, make your changes, and submit a pull request.


## Support

For any questions or issues, please open an issue on [GitHub](https://github.com/doxart/SuperView/issues).

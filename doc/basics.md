# 起動方法

Android Studio の使用を前提としている。

## Android

Configuration android を選択して、Run

## iOS

Configuration ios-moe を選択して、Run

## HTML

Terminal で `./gradlew html:jettyRun`

もしくは

Preference > Tools > External Tools に jettyRun を追加

- Program: `./gradlew`
- Parameters: `html:jettyRun`
- Working Directory: `$ProjectFileDir$`

## Desktop

Configuration desktop を追加

- Main class: `org.anyspirit.learning.gdx.desktop.DesktopLauncherKt`
- Working Directory: `android/assets` or `core/assets`
- Use classpath of module: `desktop`

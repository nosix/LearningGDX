# LearningGDX
libGDX sample project that can run on Android, iOS, web and desktop.

Install Dragome SDK

```
$ git clone https://github.com/nosix/dragome-sdk.git
$ cd dragome-sdk
$ mvn clean install
```

Install GDX Dragome backend

```
$ git clone https://github.com/nosix/gdx-dragome-backend.git
$ cd gdx-dragome-backend/backends/gdx-backend-dragome
$ mvn clean install
```

Clone LearningGDX

```
$ git clone https://github.com/nosix/LearningGDX.git
```

## Run web application

```
$ cd LearningGDX
$ ./gradlew html:jettyRun
```

## Run Android application

Select `android` configuration and run.

## Run iOS application

Select `ios-moe` configuration and run.

## Run desktop application

Add new Kotlin configuration, select configuration and run.

Configuration

- Main class : org.anyspirit.learning.gdx.desktop.DesktopLauncherKt
- Working directory : android/assets
- Use classpath of module : desktop

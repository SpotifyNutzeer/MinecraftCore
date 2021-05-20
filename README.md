# MinecraftCore

![CodeFactor](https://www.codefactor.io/repository/github/spotifynutzeer/minecraftcore/badge)
[![Java CI with Maven](https://github.com/SpotifyNutzeer/MinecraftCore/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/SpotifyNutzeer/MinecraftCore/actions/workflows/maven.yml)

<h2>Repository & Dependency</h2>
Maven

````XML
<repositories>
    ...
    <!-- MinecraftCore Repo -->
    <repository>
        <id>minecraftcore-repo</id>
        <url>https://repo.spotifynutzer.xyz/artifactory/MinecraftCore/</url>
    </repository>
    ...
</repositories>
````

````XML
<dependencies>
    ...
    <!-- Minecraft Core -->
    <dependency>
        <groupId>xyz.spotifynutzer</groupId>
        <artifactId>MinecraftCore</artifactId>
        <version>VERSION</version>
    </dependency>
    ...
</dependencies>
````

Gradle
````Gradle
repositories {
    …
    maven 'https://repo.spotifynutzer.xyz/artifactory/MinecraftCore'
    …
}
````

````Gradle
dependencies {
    …
    compileOnly 'xyz.spotifynutzer:MinecraftCore:VERSION'
    …
}
````


<a href="https://github.com/SpotifyNutzeer/MinecraftCore/wiki">Wiki</a>

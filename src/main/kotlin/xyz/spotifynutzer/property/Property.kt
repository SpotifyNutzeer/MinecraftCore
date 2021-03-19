package xyz.spotifynutzer.property

import xyz.spotifynutzer.annotations.DatabaseExclude

class Property<T : Any>(
    value: T
): IProperty<T> {

    @DatabaseExclude
    fun
}
package xyz.spotifynutzer.property

interface IProperty<T: Any> {

    /**
     * @return the value of this property.
     */
    fun getValue(): T

    /**
     * @return the value of this property converted to a json string.
     */
    fun getValueAsString(): T
}
package xyz.spotifynutzer.property

interface IPropertyMap {

    /**
     * @return all properties.
     */
    fun getProperties(): Map<String, IProperty<*>>

    /**
     * @return the property by the specified name.
     */
    fun <T : Any> getProperty(name: String): IProperty<T>? = getProperties()[name] as IProperty<T>?

    /**
     * Sets the specified value as property linked to the specified name.
     * @return the created property
     */
    fun <T : Any> setProperty(name: String, value: T): IProperty<T>

    /**
     * Clears all set properties
     */
    fun clearProperties()

    /**
     * Removes the Property found by the specified name.
     */
    fun removeProperty(name: String)

    /**
     * @return whether this player has the specified property
     */
    fun hasProperty(property: String) = getProperties().keys.contains(property)

    private fun getNewerProperty(propertyOne: IProperty<*>, propertyTwo: IProperty<*>): IProperty<*> {
        propertyOne as Property<*>
        propertyTwo as Property<*>

        return if (propertyOne.lastUpdateTimeStamp > propertyTwo.lastUpdateTimeStamp) {
            propertyOne
        } else {
            propertyTwo
        }
    }

    fun getMapWithNewestProperties(compareMap: Map<String, IProperty<*>>): HashMap<String, IProperty<*>> {
        val ownMap = getProperties()
        val allKeys = ownMap.keys.union(ownMap.keys)
        val map = HashMap<String, IProperty<*>>()
        for (key in allKeys) {
            val valueOne= ownMap[key] as Property<*>
            val valueTwo = compareMap[key] as Property<*>

            val valueOneLastUpdate = valueOne?.lastUpdateTimeStamp ?: 0
            val valueTwoLastUpdate = valueTwo?.lastUpdateTimeStamp ?: 0
            map[key] = if (valueOneLastUpdate > valueTwoLastUpdate) valueOne!! else valueTwo!!
        }

        return map
    }

}
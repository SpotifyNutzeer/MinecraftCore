package xyz.spotifynutzer.property

import eu.thesimplecloud.jsonlib.JsonLib
import eu.thesimplecloud.jsonlib.JsonLibExclude
import xyz.spotifynutzer.annotations.DatabaseExclude

class Property<T : Any>(
    value: T,
) : IProperty<T> {

    @JsonLibExclude
    @DatabaseExclude
    @Volatile
    private var savedValue: T? = value


    private val className: String = value::class.java.name

    @Volatile
    private var valueAsString: String = JsonLib.fromObject(value).getAsJsonString()

    @DatabaseExclude
    @JsonLibExclude
    var lastUpdatetimeStamp = 0L
        private set

    init {
        setLastUpdateToNow()
    }

    @Synchronized
    override fun getValue(): T {
        if (savedValue == null) {
            val clazz = propertyClassFindFunction(className) as Class<T>
            savedValue = JsonLib.fromJsonString(valueAsString).getObject(clazz)
        }
        return savedValue!!
    }

    fun resetValue() {
        this.savedValue = null
    }

    fun setLastUpdateToNow() {
        this.lastUpdatetimeStamp = System.currentTimeMillis()
    }

    override fun getValueAsString(): String {
        return this.valueAsString
    }

    fun setStringValue(string: String) {
        this.valueAsString = string
    }

    companion object {
        @Volatile
        var propertyClassFindFunction: (String) -> Class<*> = {
            Class.forName(it, true, Property::class.java.classLoader)
        }
    }


}
package xyz.spotifynutzer.database

import org.bson.Document
import xyz.spotifynutzer.MinecraftCore

class DatabaseManager {

    /**
     * @param path          path to Document
     * @param key           name of value
     * @param value         the value to set
     * @param collection    collection to update String
     * @param database      database which contains collection
     */
    fun updateString(path: String, key: String, value: String, collection: String, database: String) {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            val updateValue = Document(key, value)
            val updateOperation = Document("\$set", updateValue)
            MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
                .updateOne(found, updateOperation)
        }
    }

    /**
     * @param path          path to Document
     * @param key           name of value
     * @param value         the value to set
     * @param collection    collection to update String
     */
    fun updateString(path: String, key: String, value: String, collection: String) {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            val updateValue = Document(key, value)
            val updateOperation = Document("\$set", updateValue)
            MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
                .updateOne(found, updateOperation)
        }
    }

    /**
     * @return String
     * @param path          path to Document
     * @param key           name of value
     * @param collection    collection to get String out
     * @param database      database which contains collection
     */
    fun getString(path: String, key: String, collection: String, database: String): String? {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            return found.getString(key)
        }

        return null
    }

    /**
     * @return String
     * @param path          path to Document
     * @param key           name of value
     * @param collection    collection to get String out
     */
    fun getString(path: String, key: String, collection: String): String? {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            return found.getString(key)
        }

        return null
    }

    /**
     * @param path          path to Document
     * @param key           name of value
     * @param value         the value to set
     * @param collection    collection to update String
     * @param database      database which contains collection
     */
    fun updateInt(path: String, key: String, value: Int, collection: String, database: String) {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            val updateValue = Document(key, value)
            val updateOperation = Document("\$set", updateValue)
            MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
                .updateOne(found, updateOperation)
        }
    }

    /**
     * @param path          path to Document
     * @param key           name of value
     * @param value         the value to set
     * @param collection    collection to update String
     */
    fun updateInt(path: String, key: String, value: Int, collection: String) {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            val updateValue = Document(key, value)
            val updateOperation = Document("\$set", updateValue)
            MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
                .updateOne(found, updateOperation)
        }
    }

    /**
     * @return int
     * @param path          path to Document
     * @param key           name of value
     * @param collection    collection to get String out
     * @param database      database which contains Collection
     */
    fun getInt(path: String, key: String, collection: String, database: String): Int {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            return Integer.valueOf(found.getString(key))
        }

        return 0
    }

    /**
     * @return int
     * @param path          path to Document
     * @param key           name of value
     * @param collection    collection to get String out
     */
    fun getInt(path: String, key: String, collection: String): Int {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            return Integer.valueOf(found.getString(key))
        }

        return 0
    }

    /**
     * @param path          path to Document
     * @param key           name of value
     * @param value         the value to set
     * @param collection    collection to update String
     * @param database      database which contains collection
     */
    fun updateLong(path: String, key: String, value: Long, collection: String, database: String) {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            val updateValue = Document(key, value)
            val updateOperation = Document("\$set", updateValue)
            MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
                .updateOne(found, updateOperation)
        }
    }

    /**
     * @param path          path to Document
     * @param key           name of value
     * @param value         the value to set
     * @param collection    collection to update String
     */
    fun updateLong(path: String, key: String, value: Long, collection: String) {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            val updateValue = Document(key, value)
            val updateOperation = Document("\$set", updateValue)
            MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
                .updateOne(found, updateOperation)
        }
    }

    /**
     * @return long
     * @param path          path to Document
     * @param key           name of value
     * @param collection    collection to get String out
     * @param database      database which contains Collection
     */
    fun getLong(path: String, key: String, collection: String, database: String): Long {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            return java.lang.Long.valueOf(found.getString(key))
        }

        return 0L
    }

    /**
     * @return long
     * @param path          path to Document
     * @param key           name of value
     * @param collection    collection to get String out
     */
    fun getLong(path: String, key: String, collection: String): Long {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            return java.lang.Long.valueOf(found.getString(key))
        }

        return 0L
    }

    /**
     * @param path          path to Document
     * @param key           name of value
     * @param value         the value to set
     * @param collection    collection to update String
     * @param database      database which contains collection
     */
    fun updateDouble(path: String, key: String, value: Double, collection: String, database: String) {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            val updateValue = Document(key, value)
            val updateOperation = Document("\$set", updateValue)
            MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
                .updateOne(found, updateOperation)
        }
    }

    /**
     * @param path          path to Document
     * @param key           name of value
     * @param value         the value to set
     * @param collection    collection to update String
     */
    fun updateDouble(path: String, key: String, value: Double, collection: String) {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            val updateValue = Document(key, value)
            val updateOperation = Document("\$set", updateValue)
            MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
                .updateOne(found, updateOperation)
        }
    }

    /**
     * @return double
     * @param path          path to Document
     * @param key           name of value
     * @param collection    collection to get String out
     * @param database      database which contains Collection
     */
    fun getDouble(path: String, key: String, collection: String, database: String): Double {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase(database).getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            return java.lang.Double.valueOf(found.getString(key))
        }

        return java.lang.Double.valueOf("0")
    }

    /**
     * @return double
     * @param path          path to Document
     * @param key           name of value
     * @param collection    collection to get String out
     */
    fun getDouble(path: String, key: String, collection: String): Double {
        val found: Document = MinecraftCore.getInstance().getMongoAPI().getDatabase().getCollection(collection)
            .find(Document("path", path)).first()

        if (found != null) {
            return java.lang.Double.valueOf(found.getString(key))
        }

        return java.lang.Double.valueOf("0")
    }
}
package xyz.spotifynutzer.database

import com.mongodb.*
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase
import java.net.InetSocketAddress
import java.util.*

class MongoAPI {

    private val ip: String
    private val port: String
    private val userName: String
    private val password: String
    private var passwordCharArray: CharArray
    private val authDatabase: String
    private val database: String
    private lateinit var mongoDatabase: MongoDatabase
    private lateinit var mongoClient: MongoClient

    constructor(ip: String, port: String, userName: String, password: String, authDatabase: String, database: String) {
        this.ip = ip
        this.port = port
        this.userName = userName
        this.password = password
        this.passwordCharArray = password.toCharArray()
        this.authDatabase = authDatabase
        this.database = database
    }

    constructor(
        inetSocketAddress: InetSocketAddress,
        userName: String,
        password: String,
        authDatabase: String,
        database: String
    ) {
        this.ip = inetSocketAddress.address.hostAddress
        this.port = inetSocketAddress.port.toString()
        this.userName = userName
        this.password = password
        this.passwordCharArray = password.toCharArray()
        this.authDatabase = authDatabase
        this.database = database
    }

    fun openConnection() {
        val mongoCredential: MongoCredential =
            MongoCredential.createCredential(userName, authDatabase, passwordCharArray)

        val mongoClientSettings: MongoClientSettings = MongoClientSettings.builder().credential(mongoCredential).applyToClusterSettings { builder ->
            run {
                builder.hosts(Collections.singletonList(ServerAddress(ip, Integer.valueOf(port))))
            }
        }.build()


        mongoClient = MongoClients.create(mongoClientSettings)
        mongoDatabase = mongoClient.getDatabase(database)

    }

    fun getDatabase(): MongoDatabase {
        return mongoDatabase
    }

    fun getDatabase(database: String): MongoDatabase {
        return mongoClient.getDatabase(database)
    }

    fun isConnected(): Boolean {
        return mongoDatabase != null
    }

    fun disconnect() {
        mongoClient.close()
    }


}
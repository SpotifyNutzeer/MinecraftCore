package xyz.spotifynutzer.database

import com.mongodb.MongoClientException
import com.mongodb.MongoClientSettings
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
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

    /**
     * @param ip            ip of the server
     * @param port          port of the server
     * @param userName      username for login
     * @param password      password for login
     * @param authDatabase  authentication database
     * @param database      main database
     */
    constructor(ip: String, port: String, userName: String, password: String, authDatabase: String, database: String) {
        this.ip = ip
        this.port = port
        this.userName = userName
        this.password = password
        this.passwordCharArray = password.toCharArray()
        this.authDatabase = authDatabase
        this.database = database
    }

    /**
     * @param userName      username for login
     * @param password      password for login
     * @param authDatabase  authentication database
     * @param database      main database
     */
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

    /**
     * @throws MongoClientException
     */
    fun openConnection() {
        val mongoCredential: MongoCredential =
            MongoCredential.createCredential(userName, authDatabase, passwordCharArray)

        val mongoClientSettings: MongoClientSettings =
            MongoClientSettings.builder().credential(mongoCredential).applyToClusterSettings { builder ->
                run {
                    builder.hosts(Collections.singletonList(ServerAddress(ip, Integer.valueOf(port))))
                }
            }.build()


        mongoClient = MongoClients.create(mongoClientSettings)
        mongoDatabase = mongoClient.getDatabase(database)

    }

    /**
     * @return          the main database
     */
    fun getDatabase(): MongoDatabase {
        return mongoDatabase
    }

    /**
     * @return          database out of mongo server
     */
    fun getDatabase(database: String): MongoDatabase {
        return mongoClient.getDatabase(database)
    }

    /**
     * @return          connection state
     */
    fun isConnected(): Boolean {
        return mongoDatabase != null
    }

    /**
     * closes the Mongo Connection
     */
    fun disconnect() {
        mongoClient.close()
    }


}
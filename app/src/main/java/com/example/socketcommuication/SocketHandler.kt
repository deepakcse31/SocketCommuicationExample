package com.example.socketcommuication

import android.system.Os.socket
import com.example.socketcommuication.SocketHandler.msocket
import io.socket.client.IO
import io.socket.client.IO.socket
import io.socket.client.Socket
import java.net.URISyntaxException

object SocketHandler {

    lateinit var msocket: Socket

    @Synchronized
    fun setSocket() {
        try {
            // httpiZ.8.2.23S00015 the network your Androld emulator must use to jo1n the locaLhost network on your computer
            //http:Zaocalhost:š8R8/ wilt not work
            //If you want to use your physical phone you could use the your ip address plus : 3080
            //This will allow your Android Emulator and physical device at your home to connect to the server
            msocket = IO.socket("http://192.168.102.141:3003")
        } catch (e: URISyntaxException) {

        }
    }

    @Synchronized
    fun getSocket(): Socket {
        return msocket
    }

    @Synchronized
    fun establishConnection() {
        msocket.connect()
    }

    @Synchronized
    fun closeConnection() {
        msocket.disconnect()
    }
}
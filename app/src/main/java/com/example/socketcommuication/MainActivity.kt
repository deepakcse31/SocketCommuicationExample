package com.example.socketcommuication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.socketcommuication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        SocketHandler.setSocket()
        var msocket=SocketHandler.getSocket()
        msocket.connect()
        Log.e("connecterror","connecterror"+msocket.connect())
        binding?.textdata?.setOnClickListener {
            msocket.emit("counter",)
        }
        msocket.on("counter") { args ->
            if (args[0] != null) {
                val counter = args[0] as Int
                runOnUiThread {
                    binding?.textdata?.setText("Count->"+counter.toString())
                    Log.e("counterdata","counterdata"+counter.toString())
                    //countTextView.text = counter.toString()
                }
            }
        }
    }
}
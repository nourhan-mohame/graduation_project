package com.example.cic19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class chat_main : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tv1: TextView
    private lateinit var messageTv: EditText
    private lateinit var sendBtt: ImageButton
    private lateinit var messageList: MutableList<chat_message>
    private lateinit var messageAdapter:chat_message_adpter

    private val JSON = "application/json; charset=utf-8".toMediaType()
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_main)

        messageList = mutableListOf()
        recyclerView = findViewById(R.id.recycler)
        tv1 = findViewById(R.id.tv_1)
        messageTv = findViewById(R.id.message_tv)
        sendBtt = findViewById(R.id.send_btt)

        messageAdapter = chat_message_adpter(messageList)
        recyclerView.adapter = messageAdapter
        val llm = LinearLayoutManager(this)
        llm.stackFromEnd = true
        recyclerView.layoutManager = llm

        sendBtt.setOnClickListener {
            val question = messageTv.text.toString().trim()
            addtochat(question, chat_message.sent_by_me)
            messageTv.setText("")
            callAPI(question)
            tv1.visibility = View.GONE
        }
    }

    private fun addtochat(message: String, sentBy: String) {
        runOnUiThread {
            messageList.add(chat_message(message, sentBy))
            messageAdapter.notifyDataSetChanged()
            recyclerView.smoothScrollToPosition(messageAdapter.itemCount)
        }
    }

    private fun addResponse(response: String) {
        addtochat(response, chat_message.sent_by_bot)
    }

    private fun callAPI(question: String) {
        val jsonBody = JSONObject().apply {
            put("model", "text-davinci-003")
            put("prompt", question)
            put("max_tokens", 4000)
            put("temperature", 0)
        }

        val body = jsonBody.toString().toRequestBody(JSON)
        val request = Request.Builder()
            .url("https://api.openai.com/v1/completions")
            .header("Authorization", "Bearer secret key")
            .post(body)
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                addResponse("Failed to load response due to ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    try {
                        val jsonObject = JSONObject(response.body?.string())
                        val jsonArray = jsonObject.getJSONArray("choices")
                        val result = jsonArray.getJSONObject(0).getString("text")
                        addResponse(result.trim())
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                } else {
                    addResponse("Failed to load response due to ${response.body.toString()}")
                }
            }
        })
    }

}
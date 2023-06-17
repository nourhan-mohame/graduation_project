package com.example.cic19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class chat_message_adpter (private val messageList: List<chat_message>) :
    RecyclerView.Adapter<chat_message_adpter.MyViewHolder>() {

    // Create the view holder by inflating the chat_item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val chatView = LayoutInflater.from(parent.context).inflate(R.layout.chat, parent, false)
        return MyViewHolder(chatView)
    }

    // Bind the data to the view holder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val message = messageList[position]

        if (message.sentby == chat_message.sent_by_me) {
            holder.leftChat.visibility = View.GONE
            holder.rightChat.visibility = View.VISIBLE
            holder.rightChatText.text = message.message
        } else {
            holder.rightChat.visibility = View.GONE
            holder.leftChat.visibility = View.VISIBLE
            holder.leftChatText.text = message.message
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    // Define the view holder that holds the views within the chat_item layout
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var leftChat: LinearLayout = itemView.findViewById(R.id.left_chat)
        var rightChat: LinearLayout = itemView.findViewById(R.id.right_chat)
        var leftChatText: TextView = itemView.findViewById(R.id.left_chat_text)
        var rightChatText: TextView = itemView.findViewById(R.id.right_chat_text)

    }
}

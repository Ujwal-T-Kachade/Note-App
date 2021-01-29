package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val context : Context, private val recall : click) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    //passing data to Recycler View
    val allNotes = ArrayList<MyNote>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // our view holder has two  things text and delete button
        // ass both of them here

        val textView = itemView.findViewById<TextView>(R.id.note)
        val deleteButton = itemView.findViewById<ImageView>(R.id.DeleteButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
           val viewHolder = NoteViewHolder( LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
            viewHolder.deleteButton.setOnClickListener{
                recall.onItemClick(allNotes[viewHolder.adapterPosition])
            }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
            val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<MyNote>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}

//handling clicks
interface click{
    fun onItemClick(note : MyNote)
}
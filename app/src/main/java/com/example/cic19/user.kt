package com.example.cic19

data class user(
    val userid: String,
    val firstname:String,
    val lastname:String,
    val email:String,
    var imagepath:String=""
)
{
    constructor():this("","","","","")
}
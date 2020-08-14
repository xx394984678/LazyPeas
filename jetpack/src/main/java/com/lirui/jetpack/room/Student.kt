package com.lirui.jetpack.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
class Student(id: Int, name: String, age: String, sex: String?) {

    constructor(name: String, age: String, sex: String) : this(0, name, age, sex)

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id",typeAffinity = ColumnInfo.INTEGER)
    var id: Int = 0

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    var name: String? = null

    @ColumnInfo(name = "age",typeAffinity = ColumnInfo.TEXT)
    var age: String? = null

    @ColumnInfo(name = "sex",typeAffinity = ColumnInfo.TEXT)
    var sex: String? = null

    init {
        this.id = id
        this.name = name
        this.age = age
        this.sex = sex
    }
}
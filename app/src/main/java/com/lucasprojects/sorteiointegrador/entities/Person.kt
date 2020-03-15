package com.lucasprojects.sorteiointegrador.entities

data class Person(val id: Int, val idGit: Int, val name: String) {

    override fun toString(): String {
        return name
    }
}
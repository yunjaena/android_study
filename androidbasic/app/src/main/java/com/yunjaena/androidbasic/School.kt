package com.yunjaena.androidbasic

import io.realm.RealmObject

open class School : RealmObject() {
    var name: String? = null
    var location: String? = null
}
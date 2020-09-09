package com.yunjaena.androidbasic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance()
        button_save.setOnClickListener {
            realm.executeTransaction {
                // A테이블에서 데이터를 가져온다.
                // B테이블에서 데이터를 가져온다.
                // C테이블에서 데이터를 가져온다.
                // 조합을 한다.
                // D테이블에 저장을 한다.
                with(it.createObject(School::class.java)) {
                    this.name = "어떤 대학교"
                    this.location = "서울"
                }
            }
        }
        button_load.setOnClickListener {
            realm.executeTransaction {
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa", "data : $data")
            }
        }
        button_delete.setOnClickListener {
            realm.executeTransaction {
                //it.where(School::class.java).findAll().deleteAllFromRealm()
                it.where(School::class.java).findFirst().deleteFromRealm()
            }
        }
    }
}

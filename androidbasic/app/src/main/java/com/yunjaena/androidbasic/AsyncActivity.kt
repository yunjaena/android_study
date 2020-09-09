package com.yunjaena.androidbasic

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_async.*

class AsyncActivity : AppCompatActivity() {
    var task: BackgroundAsyncTask? = null
    // var task1 : BackgroundAsyncTask? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        start.setOnClickListener {
            task = BackgroundAsyncTask(progress_bar, ment)
            // task1 = BackgroundAsyncTask(progress_bar, ment)
            task?.execute()
            // task1?.execute()
        }

        stop.setOnClickListener {
            task?.cancel(true)
            //startActivity(Intent(this, Intent2::class.java))
        }
    }

    override fun onPause() {
        task?.cancel(true)
        super.onPause()
    }
}

class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText: TextView
) : AsyncTask<Int, Int, Int>() {
    // params -> doINBackground 에서 사용할 타입
    // progress -> onProgressUpdate 에서 사용할 타입
    // result -> onPostExecute 에서 사용할 타입
    var percent: Int = 0

    override fun onPreExecute() {
        super.onPreExecute()
        percent = 0
        progressBar.setProgress(percent)
    }

    override fun doInBackground(vararg params: Int?): Int {
        while (!isCancelled) {
            percent++
            Log.d("async", "value : $percent")
            if (percent > 100) {
                break
            } else {
                publishProgress(percent)
            }
            try {
                Thread.sleep(100)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return percent
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressBar.setProgress(values[0] ?: 0)
        progressText.setText("퍼센트 : ${values[0]}")
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) {
        super.onPostExecute(result)
        progressText.setText("작업이 완료되었습니다.")
    }

    override fun onCancelled() {
        super.onCancelled()
        progressBar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
    }
}

package com.example.newsly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.newsly.databinding.ActivityDetailsBinding
import com.example.newsly.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("URL")
        if(url!= null){
            binding.detailWebView.settings.javaScriptEnabled = true
            binding.detailWebView.settings.userAgentString = "Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"
            binding.detailWebView.webViewClient =  object: WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressBar2.visibility = View.GONE
                    binding.detailWebView.visibility = View.VISIBLE
                }
            }
        }

        if (url != null) {
            binding.detailWebView.loadUrl(url)
        }
    }
}
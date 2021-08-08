package com.example.scrapper.whatsapp

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.scrapper.util.Utils
import java.net.URLEncoder

object WhatsAppService {

    private const val WHATSAPP = "com.whatsapp"
    private const val TEL = "+79031797722"
    private var url = "https://api.whatsapp.com/send?phone=$TEL&text=${
        URLEncoder.encode(
            "HERE WILL BE A CODE IN THE NEAR FUTURE",
            "UTF-8"
        )
    }"

    fun sendMessage() {
        val context = Utils.context()
        if (Utils.isPackageInstalled(WHATSAPP)) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setPackage(WHATSAPP)
            context.startActivity(intent)
        } else {
            Toast.makeText(Utils.context(), "$WHATSAPP is not installed", Toast.LENGTH_LONG).show()
        }
    }
}
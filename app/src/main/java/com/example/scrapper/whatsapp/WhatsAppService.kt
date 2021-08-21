package com.example.scrapper.whatsapp

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import com.example.scrapper.util.Utils
import java.net.URLEncoder

object WhatsAppService {

    private const val WHATSAPP = "com.whatsapp"

    fun sendMessage(phone: MutableState<String>, message: MutableState<String>) {
        val context = Utils.context()
        if (phone.value.isEmpty() || message.value.isEmpty()) {
            Toast.makeText(context, "You phone number / message  is missing!", Toast.LENGTH_LONG).show()
        } else {
            val url = "https://api.whatsapp.com/send?phone=${phone.value}&text=${
                URLEncoder.encode(
                    message.value,
                    "UTF-8"
                )
            }"
            if (Utils.isPackageInstalled(WHATSAPP)) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.setPackage(WHATSAPP)
                context.startActivity(intent)
            } else {
                Toast.makeText(Utils.context(), "$WHATSAPP is not installed", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}
package com.semnazri.githubuserlist

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.net.toUri

fun openUrl(context: Context, url: String) {
    if (!url.isNullOrBlank() && (url.startsWith("http://") || url.startsWith("https://"))) {
        try {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = url.toUri()
            }
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "No browser found to open the link", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(context, "Failed to open link", Toast.LENGTH_SHORT).show()
        }
    } else {
        Toast.makeText(context, "Invalid URL", Toast.LENGTH_SHORT).show()
    }
}

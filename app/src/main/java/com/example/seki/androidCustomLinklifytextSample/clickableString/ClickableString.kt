package com.example.seki.androidCustomLinklifytextSample.clickableString


import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Toast
import java.util.regex.Pattern

class ClickableString {

    companion object {
        val SEPARATOR = ","
        fun create(clickableStrings: String?, text: String): Spannable {
            if (clickableStrings == null || clickableStrings.trim().isEmpty())
                SpannableStringBuilder().append(text)


            if (!clickableStrings!!.contains(SEPARATOR, ignoreCase = true))
                createSingle(clickableStrings, text)

            val builder = SpannableStringBuilder()
            builder.append(text)

            val clickables = clickableStrings.split(SEPARATOR)

            for (clickable in clickables) {
                val p = Pattern.compile(clickable)
                val m = p.matcher(text)

                while(m.find()) {
                    builder.setSpan(object: ClickableSpan() {
                        override fun onClick(widget: View) {
                            Toast.makeText(widget.context, clickable, Toast.LENGTH_SHORT).show()
                        }
                    }, m.start(), m.start() + clickable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                }
            }

            return builder
        }

        private fun createSingle(clickableString: String, text: String): Spannable {
            val builder = SpannableStringBuilder()
            val clickableStringPosition = text.indexOf(clickableString)
            if (clickableStringPosition == -1) {
                builder.append(text)
            }

            builder.append(text)
                    .setSpan(object: ClickableSpan() {
                        override fun onClick(widget: View) {
                            Toast.makeText(widget.context, clickableString, Toast.LENGTH_SHORT).show()
                        }
                    }, clickableStringPosition, clickableStringPosition + clickableString.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            return builder
        }
    }
}

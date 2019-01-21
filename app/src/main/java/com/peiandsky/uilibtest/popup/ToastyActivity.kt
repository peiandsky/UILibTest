package com.peiandsky.uilibtest.popup

import android.os.Bundle
import com.peiandsky.base.BaseActivity
import es.dmoral.toasty.Toasty
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_toasty.*
import android.text.Spannable
import android.graphics.Typeface.BOLD_ITALIC
import android.text.style.StyleSpan
import android.text.SpannableStringBuilder
import com.peiandsky.uilibtest.R


class ToastyActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toasty)

        button_error_toast.setOnClickListener {
            Toasty.error(this@ToastyActivity, R.string.error_message, Toast.LENGTH_SHORT, true).show()
        }

        button_success_toast.setOnClickListener {
            Toasty.success(this@ToastyActivity, R.string.success_message, Toast.LENGTH_SHORT, true).show()
        }

        button_info_toast.setOnClickListener {
            Toasty.info(this@ToastyActivity, R.string.info_message, Toast.LENGTH_SHORT, true).show()
        }

        button_warning_toast.setOnClickListener {
            Toasty.warning(this@ToastyActivity, R.string.warning_message, Toast.LENGTH_SHORT, true).show()
        }

        button_normal_toast_wo_icon.setOnClickListener {
            Toasty.normal(this@ToastyActivity, R.string.normal_message_without_icon).show()
        }

        button_normal_toast_w_icon.setOnClickListener {
            val icon = resources.getDrawable(R.drawable.ic_pets_white_48dp)
            Toasty.normal(this@ToastyActivity, R.string.normal_message_with_icon, icon).show()
        }

        button_custom_config.setOnClickListener {
            Toasty.info(this@ToastyActivity, getFormattedMessage()).show()
        }
    }

    private fun getFormattedMessage(): CharSequence {
        val prefix = "Formatted "
        val highlight = "bold italic"
        val suffix = " text"
        val ssb = SpannableStringBuilder(prefix).append(highlight).append(suffix)
        val prefixLen = prefix.length
        ssb.setSpan(StyleSpan(BOLD_ITALIC),
                prefixLen, prefixLen + highlight.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return ssb
    }
}
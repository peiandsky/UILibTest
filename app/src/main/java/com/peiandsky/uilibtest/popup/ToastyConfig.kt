package com.peiandsky.uilibtest.popup

import es.dmoral.toasty.Toasty

object ToastyConfig {
    fun config() {
        Toasty.Config.getInstance()
                .setTextSize(24)
                .apply()
    }
}
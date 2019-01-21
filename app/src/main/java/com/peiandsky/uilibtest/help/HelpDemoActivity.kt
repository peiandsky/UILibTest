package com.peiandsky.uilibtest.help

import android.graphics.Rect
import android.os.Bundle
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetSequence
import com.peiandsky.base.BaseActivity
import com.peiandsky.uilibtest.R
import android.support.v4.content.ContextCompat
import es.dmoral.toasty.Toasty


class HelpDemoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        val droid = ContextCompat.getDrawable(this, R.drawable.ic_pets_white_48dp)
        val droidTarget = Rect(0, 0, droid!!.intrinsicWidth * 2, droid!!.intrinsicHeight * 2)

        val tapSequence = TapTargetSequence(this).targets(
                TapTarget.forView(findViewById(R.id.btn_login), "点击按钮登录系统，前提是输入账户和密码"),
                TapTarget.forView(findViewById(R.id.tv_forget), "如果忘记了密码，可以点击"),
                TapTarget.forView(findViewById(R.id.tv_label), "这是本页的大标题"),
                TapTarget.forBounds(droidTarget, "退出", "这是详细描述")
                        .cancelable(false)
                        .icon(droid)
                        .id(4)

        ).listener(object : TapTargetSequence.Listener {
            override fun onSequenceCanceled(lastTarget: TapTarget?) {
                Toasty.normal(this@HelpDemoActivity, "onSequenceFinish").show()
            }

            override fun onSequenceFinish() {
                Toasty.normal(this@HelpDemoActivity, "onSequenceFinish").show()
            }

            override fun onSequenceStep(lastTarget: TapTarget, targetClicked: Boolean) {
                Toasty.normal(this@HelpDemoActivity, "onSequenceStep：" + lastTarget.toString()).show()
            }
        })

        tapSequence.start()

    }
}
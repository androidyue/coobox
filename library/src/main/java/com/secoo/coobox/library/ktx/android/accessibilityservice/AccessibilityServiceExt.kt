package com.secoo.coobox.library.ktx.android.accessibilityservice

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.graphics.Rect
import android.os.Build
import android.view.ViewConfiguration
import androidx.annotation.RequiresApi
import com.secoo.coobox.library.ktx.android.graphics.rect.middleHorizontally
import com.secoo.coobox.library.ktx.android.graphics.rect.middleVertically
import com.secoo.coobox.library.logger.smartLogD

@RequiresApi(Build.VERSION_CODES.N)
fun AccessibilityService.dispatchClick(rect: Rect?) {
    rect ?: return
    val x = rect.middleVertically()
    val y = rect.middleHorizontally()
    dispatchClick(x, y)
}

@RequiresApi(Build.VERSION_CODES.N)
fun AccessibilityService.dispatchClick(x: Float, y: Float) {
    val path = Path()
    path.moveTo(x, y)
    smartLogD {
        "dispatchClick x=$x y=$y"
    }
    path.lineTo(x + 1, y)

    val builder = GestureDescription.Builder()
    builder.addStroke(GestureDescription.StrokeDescription(path, 0,
        ViewConfiguration.getTapTimeout().toLong()
    ))
    this.dispatchGesture(builder.build(), null, null)
}
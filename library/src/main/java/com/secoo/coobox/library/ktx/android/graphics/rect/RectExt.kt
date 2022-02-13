package com.secoo.coobox.library.ktx.android.graphics.rect

import android.graphics.Rect

fun Rect.middleVertically(): Float {
    return (this.left + this.right) / 2.0f
}

fun Rect.middleHorizontally(): Float {
    return (this.top + this.bottom) / 2.0f
}
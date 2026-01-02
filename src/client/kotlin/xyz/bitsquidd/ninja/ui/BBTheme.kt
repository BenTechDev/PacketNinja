package xyz.bitsquidd.ninja.ui

import com.noxcrew.sheeplib.theme.DefaultTheme
import com.noxcrew.sheeplib.theme.Theme
import com.noxcrew.sheeplib.util.opacity

object BBTheme : Theme by DefaultTheme {
    private val PRIMARY = 0x0F142D opacity 64
    private val SECONDARY = 0x10152D opacity 128

    override val theme: Theme = this
    override val dialogBorders: Boolean = true
    override val colors = object : Theme.Colors by DefaultTheme.colors {
        override val dialogBackground: Int = PRIMARY
        override val dialogBackgroundAlt: Int = SECONDARY
        override val widgetBackgroundPrimary: Int = PRIMARY
        override val widgetBackgroundSecondary: Int = SECONDARY
        override val border: Int = 0x070A19
    }

    override val dimensions = Theme.Dimensions(
        buttonWidth = 70,
        buttonHeight = 14,
        paddingInner = 3,
        paddingOuter = 5,
    )
}
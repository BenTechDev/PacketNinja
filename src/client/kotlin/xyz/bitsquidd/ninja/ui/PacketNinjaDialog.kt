package xyz.bitsquidd.ninja.ui

import com.noxcrew.sheeplib.dialog.Dialog
import com.noxcrew.sheeplib.theme.Themed
import net.minecraft.client.Minecraft

abstract class PacketNinjaDialog(x: Int, y: Int, private val key: String) : Dialog(x, y), Themed by BBTheme {
    protected val font = Minecraft.getInstance().font;
    protected val minecraftClient = Minecraft.getInstance();
    open fun refresh() {
        super.init()
    }

    override fun onClose() {
        DialogManager.close(key)
        super.onClose();
    }
}
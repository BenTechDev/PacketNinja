package xyz.bitsquidd.ninja.ui

import com.noxcrew.sheeplib.DialogContainer

object DialogManager {
    private val openedDialogs = hashMapOf<String, PacketNinjaDialog>()

    fun open(key: String, dialog: PacketNinjaDialog) {
        if (key in openedDialogs) return
        DialogContainer += dialog
        openedDialogs[key] = dialog
    }

    fun close(key: String) {
        if (key !in openedDialogs) return;
        openedDialogs[key]?.let {
            openedDialogs.remove(key)
            it.close()
        }
    }

    fun refresh(key: String) {
        if (key !in openedDialogs) return
        openedDialogs[key]?.refresh()
    }
}
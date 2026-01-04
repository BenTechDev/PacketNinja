package xyz.bitsquidd.ninja.ui.menus

import com.noxcrew.sheeplib.dialog.title.TextTitleWidget
import com.noxcrew.sheeplib.layout.grid
import com.noxcrew.sheeplib.util.ComponentBuilder
import net.minecraft.client.gui.components.Button
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.TextColor
import xyz.bitsquidd.ninja.PacketRegistry
import xyz.bitsquidd.ninja.handler.PacketCategory
import xyz.bitsquidd.ninja.handler.PacketHandler
import xyz.bitsquidd.ninja.ui.PacketNinjaDialog

class PacketMenu : PacketNinjaDialog(200, 400, "packet_menu") {

    override val title = TextTitleWidget(this, Component.literal("Packets Menu"))

    override fun layout() = grid {
        val packetMap: Map<PacketCategory, List<PacketHandler<*>>> = PacketRegistry.getAllHandlersCategorised()
        var yLoc: Int = 1;
        for ((category, handlers) in packetMap) {
            Button.builder(Component.literal(category.name + " (" + handlers.size + ")"), {
                minecraftClient.gui.chat.addMessage(
                    ComponentBuilder.literal("Opening " + category.name + " packets...") {
                        color = TextColor.fromRgb(0xFFFF00)
                    }
                )
            }).size(16, 100).build()
                .at(yLoc, 0)
            yLoc += 1
        }
    }
}
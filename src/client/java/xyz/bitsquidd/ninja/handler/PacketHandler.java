package xyz.bitsquidd.ninja.handler;

import net.minecraft.network.protocol.Packet;
import org.jspecify.annotations.NullMarked;

import xyz.bitsquidd.ninja.format.PacketInfoBundle;

import java.util.List;

@NullMarked
public abstract class PacketHandler<T extends Packet<?>> {
    protected static final int MAX_DISPLAYED_ENTRIES = 5;


    protected final Class<T> packetClass;

    protected final String friendlyName;
    protected final String description;
    protected final PacketType packetType;
    protected final List<PacketCategory> categories;

    public PacketHandler(Class<T> packetClass, String friendlyName, String description, PacketType packetType) {
        this.packetClass = packetClass;
        this.friendlyName = friendlyName;
        this.description = description;
        this.packetType = packetType;
        this.categories = List.of(PacketCategory.MISC);
    }
    public PacketHandler(Class<T> packetClass, String friendlyName, String description, PacketType packetType, List<PacketCategory> categories) {
        this.packetClass = packetClass;
        this.friendlyName = friendlyName;
        this.description = description;
        this.packetType = packetType;
        this.categories = categories;
    }

    public final Class<T> getPacketClass() {
        return packetClass;
    }

    public final String getFriendlyName() {
        return friendlyName;
    }

    public final String getDescription() {
        return description;
    }

    public final List<PacketCategory> getCategories() {
        return categories;
    }

    public final boolean canHandle(Packet<?> packet) {
        return packetClass.isInstance(packet);
    }

    @SuppressWarnings("unchecked")
    public final PacketInfoBundle getPacketInfo(Packet<?> packet) {
        if (!canHandle(packet)) {
            throw new IllegalArgumentException("Cannot handle packet of type: " + packet.getClass().getSimpleName());
        }

        return getPacketInfoInternal((T)packet);
    }

    protected abstract PacketInfoBundle getPacketInfoInternal(T packet);

}
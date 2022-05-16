package com.wenhanlee.goofygoober.capabilities.tomfoolery.cooldownCounter;

import com.wenhanlee.goofygoober.capabilities.ModCapabilities;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TomfooleryCooldownCounterProvider implements ICapabilitySerializable<CompoundTag> {

    private final TomfooleryCooldownCounter tomfooleryCooldownCounter = new TomfooleryCooldownCounter();
    private final LazyOptional<ITomfooleryCooldownCounter> tomfooleryCooldownCounterLazyOptional = LazyOptional.of(() -> tomfooleryCooldownCounter);

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return ModCapabilities.TOMFOOLERY_COOLDOWN_COUNTER_CAPABILITY.orEmpty(cap, tomfooleryCooldownCounterLazyOptional);
    }

    @Override
    public CompoundTag serializeNBT() {
        if (ModCapabilities.TOMFOOLERY_COOLDOWN_COUNTER_CAPABILITY == null) {
            return new CompoundTag();
        }
        CompoundTag nbt = new CompoundTag();
        nbt.putInt("tomfoolery_cooldown_counter", tomfooleryCooldownCounter.counter);
        nbt.putBoolean("tomfoolery_cooldown_on", tomfooleryCooldownCounter.cooldown);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if (ModCapabilities.TOMFOOLERY_COOLDOWN_COUNTER_CAPABILITY != null) {
            tomfooleryCooldownCounter.counter = nbt.getInt("tomfoolery_cooldown_counter");
            tomfooleryCooldownCounter.cooldown = nbt.getBoolean("tomfoolery_cooldown_on");
        }
    }

    public void invalidate() { tomfooleryCooldownCounterLazyOptional.invalidate(); }

}

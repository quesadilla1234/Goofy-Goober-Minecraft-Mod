package com.wenhanlee.goofygoober.capabilities;

import com.wenhanlee.goofygoober.capabilities.ambient.IAmbientCounter;
import com.wenhanlee.goofygoober.capabilities.tomfoolery.cooldownCounter.ITomfooleryCooldownCounter;
import com.wenhanlee.goofygoober.capabilities.tomfoolery.scallywag.ITomfooleryScallywag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class ModCapabilities {

    public static Capability<IAmbientCounter> AMBIENT_COUNTER_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});

    public static Capability<ITomfooleryCooldownCounter> TOMFOOLERY_COOLDOWN_COUNTER_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});

    public static Capability<ITomfooleryScallywag> TOMFOOLERY_SCALLYWAG_CAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});

}

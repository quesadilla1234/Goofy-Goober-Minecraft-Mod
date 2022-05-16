package com.wenhanlee.goofygoober.capabilities.ambient;

import com.wenhanlee.goofygoober.sounds.ModSounds;
import net.minecraft.sounds.SoundEvent;

import java.util.Random;

public class AmbientCounter implements IAmbientCounter {

    public int counter;
    public int limit;
    public SoundEvent sleepingNoise;

    public AmbientCounter() {
        this.counter = 0;
        rollLimit();
        rollSleepingNoise();
    }

    @Override
    public void incrementCounter() {
        this.counter++;
        if (this.counter < 0) this.counter = 200;
    }

    @Override
    public void resetCounter() { this.counter = 0; }

    @Override
    public void rollLimit() {
        // adds randomness to how long it takes for the mob to make another noise
        Random random = new Random();
        this.limit = random.nextInt(100) + 100;
    }

    @Override
    public void rollSleepingNoise() {
        Random random = new Random();
        int randInt = random.nextInt(3);
        this.sleepingNoise = ModSounds.SNORE_LOUD.get();
        if (randInt == 1) this.sleepingNoise = ModSounds.SNORE_MIMIMI.get();
        if (randInt == 2) this.sleepingNoise = ModSounds.SNORE_WHISTLE.get();
    }

}

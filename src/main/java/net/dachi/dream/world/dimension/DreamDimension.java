package net.dachi.dream.world.dimension;

import net.dachi.dream.Dream;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber
public class DreamDimension {
    public static final ResourceKey<Level> DREAM = ResourceKey.create(Registry.DIMENSION_REGISTRY,
            new ResourceLocation(Dream.MOD_ID, "dream"));
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Fixers {
        @SubscribeEvent
        @OnlyIn(Dist.CLIENT)
        public static void registerDimensionSpecialEffects(FMLClientSetupEvent event) {
            //you can change the clouds to any level insted of NaN but i think they are annoying then we are setting SkyType to NONE
            DimensionSpecialEffects specialEffects = new DimensionSpecialEffects(Float.NaN, true, DimensionSpecialEffects.SkyType.NONE, false, false) {
                @Override
                public Vec3 getBrightnessDependentFogColor(Vec3 color, float sunHeight) {
                    return new Vec3(0.2, 1, 1);
                }

                @Override
                public boolean isFoggyAt(int x, int y) {
                    return false;
                }
            };
            //then we have an enqueue work putting the effects.
            event.enqueueWork(() -> DimensionSpecialEffects.EFFECTS.put(DREAM.location(), specialEffects));
        }
    }
}

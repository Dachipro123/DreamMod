package net.dachi.dream.entity;

import net.dachi.dream.Dream;
import net.dachi.dream.entity.custom.NightmareBlazeEntity;
import net.dachi.dream.entity.custom.NightmareBossEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Dream.MOD_ID);

    public static final RegistryObject<EntityType<NightmareBlazeEntity>> NIGHTMARE_BLAZE =
            ENTITY_TYPES.register("nightmare_blaze",
                    () -> EntityType.Builder.of(NightmareBlazeEntity::new,
                                    MobCategory.MONSTER).sized(0.5f, 1f)
                            .build(new ResourceLocation(Dream.MOD_ID, "nightmare_blaze").toString()));

    public static final RegistryObject<EntityType<NightmareBossEntity>> NIGHTMARE_BOSS =
            ENTITY_TYPES.register("nightmare_boss",
                    () -> EntityType.Builder.of(NightmareBossEntity::new,
                                    MobCategory.MONSTER).sized(0.5f, 2f)
                            .build(new ResourceLocation(Dream.MOD_ID, "nightmare_boss").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

// TODO: make option to not drop TNT for creepers

package com.cemerson.logicaldrops.entity;

import java.util.Random;

import com.cemerson.logicaldrops.LogicalDrops;

import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.EnumCreatureType;
//import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
//import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
//import net.minecraft.world.chunk.Chunk.EnumCreateEntityType;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


// http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/2389704-realistic-animal-products-and-drops-mod-updates
// Realistic Survival Mod! : https://www.youtube.com/watch?v=hQ9Ii9AZg78

// helpful!
// http://www.minecraftupdates.com/summon-command
// https://www.digminecraft.com/generators/summon_mob.php

public class RealisticEntityBehaviorHandler {
    
    // public static RealismItem item_bone_cow;
                
    @SubscribeEvent
    public void playerKilledCow(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityCow) && (isNotServerWorld))
        {
            //String chatMsg = "LogicalDrops.intCowMeatMax=" + LogicalDrops.intCowMeatMax;              
            //Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
            
            int boneCount = getRandom(LogicalDrops.intCowBoneMin,LogicalDrops.intCowBoneMax);
            int meatCount = getRandom(LogicalDrops.intCowMeatMin,LogicalDrops.intCowMeatMax); // 30 lbs steaks super minimum!           
            int leatherCount = getRandom(LogicalDrops.intCowLeatherMin,LogicalDrops.intCowLeatherMax);
            ItemStack bones = new ItemStack(Items.BONE,0);
            ItemStack meat = new ItemStack(Items.BEEF,0);
            ItemStack leather = new ItemStack(Items.LEATHER,0);
            bones.setCount(boneCount);
            meat.setCount(meatCount);
            leather.setCount(leatherCount);
            
            if(LogicalDrops.intCowBoneMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
            if(LogicalDrops.intCowMeatMax > 0) event.getEntityLiving().entityDropItem(meat, 0);
            /* leather! duh!!*/
            if(LogicalDrops.intCowLeatherMax > 0) event.getEntityLiving().entityDropItem(leather, 0);
        
        }               
    }
    
    @SubscribeEvent
    public void playerKilledHorse(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityHorse) && (isNotServerWorld))
        {
            
            int boneCount = getRandom(LogicalDrops.intHorseBoneMin,LogicalDrops.intHorseBoneMax);
            int meatCount = getRandom(LogicalDrops.intHorseMeatMin,LogicalDrops.intHorseMeatMax); // 30 lbs steaks super minimum!           
            int leatherCount = getRandom(LogicalDrops.intHorseLeatherMin,LogicalDrops.intHorseLeatherMax);
            ItemStack bones = new ItemStack(Items.BONE,0);
            ItemStack meat = new ItemStack(Items.BEEF,0);
            ItemStack leather = new ItemStack(Items.LEATHER,0);
            bones.setCount(boneCount);
            meat.setCount(meatCount);
            leather.setCount(leatherCount);
            
            if(LogicalDrops.intHorseBoneMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
            if(LogicalDrops.intHorseMeatMax > 0) event.getEntityLiving().entityDropItem(meat, 0);
            /* leather! duh!!*/
            if(LogicalDrops.intHorseLeatherMax > 0) event.getEntityLiving().entityDropItem(leather, 0);
        
        }               
    }

    @SubscribeEvent
    public void playerKilledLlama(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityLlama) && (isNotServerWorld))
        {
            
            int boneCount = getRandom(LogicalDrops.intLlamaBoneMin,LogicalDrops.intLlamaBoneMax);
            int meatCount = getRandom(LogicalDrops.intLlamaMeatMin,LogicalDrops.intLlamaMeatMax); // 30 lbs steaks super minimum!           
            int leatherCount = getRandom(LogicalDrops.intLlamaLeatherMin,LogicalDrops.intLlamaLeatherMax);
            ItemStack bones = new ItemStack(Items.BONE,0);
            ItemStack meat = new ItemStack(Items.BEEF,0);
            ItemStack leather = new ItemStack(Items.LEATHER,0);
            bones.setCount(boneCount);
            meat.setCount(meatCount);
            leather.setCount(leatherCount);
            
            if(LogicalDrops.intLlamaBoneMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
            if(LogicalDrops.intLlamaMeatMax > 0) event.getEntityLiving().entityDropItem(meat, 0);
            /* leather! duh!!*/
            if(LogicalDrops.intLlamaLeatherMax > 0) event.getEntityLiving().entityDropItem(leather, 0);
            
        }               
    }
    
    
    
    @SubscribeEvent
    public void playerKilledEnderman(LivingDeathEvent event)
    {                   
         // String chatMsg = "Did player kill a cow?!";             
        // Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityEnderman) && (isNotServerWorld))
        {           
            if(LogicalDrops.intEndermanPearlMax > 0) event.getEntityLiving().func_145779_a(Items.ENDER_PEARL, getRandom(LogicalDrops.intEndermanPearlMin,LogicalDrops.intEndermanPearlMax));
            ItemStack blackWool = new ItemStack(Blocks.field_150325_L, 1, 15); // black wool
            blackWool.setCount(LogicalDrops.intEndermanWoolCount);
            event.getEntityLiving().entityDropItem(blackWool,0);
            PotionType potionType = PotionTypes.NIGHT_VISION;
            ItemStack potionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), potionType);
            potionStack.setCount(1);
            event.getEntityLiving().entityDropItem(potionStack,0);          
        }               
    }   
    
    @SubscribeEvent
    public void playerKilledChicken(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityChicken) && (isNotServerWorld))
        {
            int featherCount = getRandom(LogicalDrops.intChickenFeatherMin,LogicalDrops.intChickenFeatherMax);
            int meatCount = getRandom(LogicalDrops.intChickenMeatMin,LogicalDrops.intChickenMeatMax); // 30 lbs steaks super minimum!           
            ItemStack bones = new ItemStack(Items.BONE,0);
            ItemStack meat = new ItemStack(Items.CHICKEN,0);
            ItemStack feathers = new ItemStack(Items.FEATHER,0);
            bones.setCount(1);
            meat.setCount(meatCount);           
            feathers.setCount(featherCount);
                        
            if(LogicalDrops.intChickenFeatherMax > 0) event.getEntityLiving().entityDropItem(feathers, 0);
            if(LogicalDrops.intChickenMeatMax > 0) event.getEntityLiving().entityDropItem(meat,0);
            event.getEntityLiving().entityDropItem(bones,0);
        }               
    }   
    
    @SubscribeEvent
    public void playerKilledSheep(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntitySheep) && (isNotServerWorld))
        {
            
            int boneCount = getRandom(LogicalDrops.intSheepBoneMin,LogicalDrops.intSheepBoneMax);
            int meatCount = getRandom(LogicalDrops.intSheepMeatMin,LogicalDrops.intSheepMeatMax); // 30 lbs steaks super minimum!           
            ItemStack bones = new ItemStack(Items.BONE,0);
            ItemStack meat = new ItemStack(Items.MUTTON,0);
            bones.setCount(boneCount);
            meat.setCount(meatCount);
                                
            if(LogicalDrops.intSheepBoneMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
            if(LogicalDrops.intSheepMeatMax > 0) event.getEntityLiving().entityDropItem(meat, 0);
        }               
    }       
    
    @SubscribeEvent
    public void playerKilledZombie(LivingDeathEvent event)
    {                   
        // if(event.getEntityLiving() instanceof EntityCreeper) return;     
        
        // problem: firing two times!?
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
         if(isNotServerWorld){
             ItemStack zombieHead;
             if((event.getEntityLiving() instanceof EntityPigZombie)){
                 // plain skull
                zombieHead = new ItemStack(Items.field_151144_bL, 1);
                ItemStack meat = new ItemStack(Items.PORKCHOP,0);
                meat.setCount(getRandom(LogicalDrops.intPigZombiePorkchopMin,LogicalDrops.intPigZombiePorkchopMax));
                if(LogicalDrops.intPigZombiePorkchopMax > 0) event.getEntityLiving().entityDropItem(meat, 0);
                dropZombieStuff(event, zombieHead);
             }else if((event.getEntityLiving() instanceof EntityZombie)){
                 // zombie head
                zombieHead = new ItemStack(Items.field_151144_bL, 1, 2);                            
                // zombie shirt/pants
//              ItemStack stackShirt = new ItemStack(Items.leather_chestplate, 1);
//              ((ItemArmor) stackShirt.getItem()).setColor(stackShirt, 2651799); //15790320);          
//              event.getEntityLiving().func_145779_a(stackShirt, 1);                           
//              ItemStack stack = new ItemStack(Items.leather_leggings, 1);
//              ((ItemArmor) stack.getItem()).setColor(stack, 8073150); //15790320);            
//              event.getEntityLiving().func_145779_a(stack, 1);                
                dropZombieStuff(event, zombieHead);
             } 
         }      
    }       
    
    private void dropZombieStuff(LivingDeathEvent event, ItemStack headToDrop){     
    	
        int boneCount = getRandom(LogicalDrops.intZombieBonesMin,LogicalDrops.intZombieBonesMax);
        ItemStack bones = new ItemStack(Items.BONE,0);
        bones.setCount(boneCount);    	
    	
         if(LogicalDrops.intZombieBonesMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
         if(LogicalDrops.boolZombieAlwaysDropHead && skullRandomDropSuccess()){
             event.getEntityLiving().entityDropItem(headToDrop, 0); // .dropItemWithOffset(Items.skull, 1, 2); //Items.skull, 1, 2); // .dropItem(Items.skull, size) Blocks.skull.getBlock.getBlockById() Items.skull., 1); //144
         }
         enemyBowCheck(event.getEntityLiving());
    }
    
    private Boolean skullRandomDropSuccess(){
        Boolean willDrop = false;
        int percentChanceSkullDrops = (100-LogicalDrops.intHeadDropPercentChance); // 60  100-60
        willDrop = (getRandom(1,100) >= percentChanceSkullDrops);
        return willDrop;
    }
    
    // PIG
    @SubscribeEvent
    public void playerKilledPig(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityPig) && (isNotServerWorld))
        {
            
            int boneCount = getRandom(LogicalDrops.intPigBoneMin,LogicalDrops.intPigBoneMax);
            int meatCount = getRandom(LogicalDrops.intPigMeatMin,LogicalDrops.intPigMeatMax); // 30 lbs steaks super minimum!           
            ItemStack bones = new ItemStack(Items.BONE,0);
            ItemStack meat = new ItemStack(Items.PORKCHOP,0);
            bones.setCount(boneCount);
            meat.setCount(meatCount);           
            
            if(LogicalDrops.intPigMeatMax > 0) event.getEntityLiving().entityDropItem(meat, 0);
            if(LogicalDrops.intPigBoneMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
        }               
    }
    
    // WITCH
    @SubscribeEvent
    public void playerKilledWitch(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityWitch) && (isNotServerWorld))
        {
            ItemStack purpleWool = new ItemStack(Blocks.field_150325_L, 1, 10); // purple wool
            purpleWool.setCount(LogicalDrops.intWitchWoolCount);
            event.getEntityLiving().entityDropItem(purpleWool, 0);          
                    
            PotionType witchPotionType = PotionTypes.HEALING;
            ItemStack healPotionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), witchPotionType);
            event.getEntityLiving().entityDropItem(healPotionStack,0);
            
//          ItemBook boo
//          Enchantment ench = new Enchantment();
//          
//          EnchantedBook bookType = PotionTypes.healing;
//          ItemStack healPotionStack = (ItemStack) PotionUtils.addPotionToItemStack(new ItemStack(Items.potionitem), witchPotionType);
//          event.getEntityLiving().func_145779_a(healPotionStack,1);           
        
            if(LogicalDrops.intWitchBonesMax > 0) event.getEntityLiving().entityDropItem(new ItemStack(Items.BONE), getRandom(LogicalDrops.intWitchBonesMin,LogicalDrops.intWitchBonesMax)); // human, 8 bones
            
        }               
    }   
    
    // CREEPER
    @SubscribeEvent
    public void playerKilledCreeper(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityCreeper) && (isNotServerWorld))
        {
            // event.getEntityLiving().entityDropItem(new ItemStack(Blocks.TNT),0); // TNT!
            // ItemStack greenWool = new ItemStack(Blocks.field_150325_L, 1, 5);
            // greenWool.setCount(getRandom(LogicalDrops.intCreeperWoolMin,LogicalDrops.intCreeperWoolMax));
            // if(LogicalDrops.intCreeperWoolMax > 0) event.getEntityLiving()
            //  .entityDropItem(greenWool,0);
            
            ItemStack creeperHead = new ItemStack(Items.field_151144_bL, 1, 4);
            creeperHead.setCount(1);
            if(LogicalDrops.boolCreeperAlwaysDropHead && skullRandomDropSuccess()) event.getEntityLiving()
            .entityDropItem(creeperHead,0);
            
            ItemStack leaves = new ItemStack(Blocks.field_150362_t, 1, 0);
            leaves.setCount(getRandom(LogicalDrops.intCreeperLeavesMin,LogicalDrops.intCreeperLeavesMax));
            if(LogicalDrops.intCreeperLeavesMax > 0) event.getEntityLiving()
                .entityDropItem(leaves ,0);         
        }               
    }

//  public RealisticPlayerWakeUpEvent(EntityPlayer player){
//  super(player);
////  this.wakeImmediatly = wakeImmediatly;
////  this.updateWorld = updateWorld;
////  this.setSpawn = setSpawn;
//  
//}     
    
//  public void playerKilledT(LivingDeathEvent event){
//      
//      event.getEntity().pla
//      
//  }
    
    // SKELETONS
    @SubscribeEvent
    public void playerKilledSkeleton(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);         
        if((event.getEntityLiving() instanceof EntitySkeleton) && (isNotServerWorld))
        {           
            ItemStack skellieHead = new ItemStack(Items.field_151144_bL, 1, 0);
            skellieHead.setCount(1);
            
            ItemStack bones = new ItemStack(Items.BONE,0);
            bones.setCount(getRandom(LogicalDrops.intSkeletonBonesMin,LogicalDrops.intSkeletonBonesMax));
            
            if(LogicalDrops.boolWitherSkeletonAlwaysDropHead && skullRandomDropSuccess()) 
                event.getEntityLiving().entityDropItem(skellieHead, 0);                     
            if(LogicalDrops.intSkeletonBonesMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
            
            enemyBowCheck(event.getEntityLiving());                                             
        }               
        
        // add spider riding to drop saddle?
        ///summon Spider ~ ~ ~ {Passengers:[{id:Skeleton}]}
    }   
    
    // WITHER SKELETONS
    @SubscribeEvent
    public void playerKilledWitherSkeleton(LivingDeathEvent event)
    {                   
        Boolean isNotServerWorld = (!event.getEntity().world.isRemote);      
        if((event.getEntityLiving() instanceof EntityWitherSkeleton) && (isNotServerWorld))
        {       
            ItemStack witherHead = new ItemStack(Items.field_151144_bL, 1, 1);
            witherHead.setCount(1);
            
            ItemStack coal = new ItemStack(Items.COAL,0);
            coal.setCount(getRandom(LogicalDrops.intWitherCoalMin,LogicalDrops.intWitherCoalMax));
            
            ItemStack bones = new ItemStack(Items.BONE,0);
            bones.setCount(getRandom(LogicalDrops.intSkeletonBonesMin,LogicalDrops.intSkeletonBonesMax));
            
            if(LogicalDrops.boolSkeletonAlwaysDropHead && skullRandomDropSuccess()) 
                event.getEntityLiving().entityDropItem(witherHead,0); // wither skull!
            if(LogicalDrops.intWitherCoalMax > 0) event.getEntityLiving().entityDropItem(coal, 0);
            
            if(LogicalDrops.intSkeletonBonesMax > 0) event.getEntityLiving().entityDropItem(bones, 0);
            
            enemyBowCheck(event.getEntityLiving());                                             
        }                       
    }       
    
    public void enemyBowCheck(EntityLivingBase enemy){
        try{
            EntityMob mob = (EntityMob) enemy;
            mob.getActiveHand();
            Item mobWeapon = mob.getHeldItem(EnumHand.MAIN_HAND).getItem();
            Boolean enemyHasBow = (mobWeapon instanceof ItemBow);       
            ItemStack arrowStack = new ItemStack(Items.ARROW);
            arrowStack.setCount(getRandom(LogicalDrops.intBowEnemiesArrowMin,LogicalDrops.intBowEnemiesArrowMax));
            if(LogicalDrops.intBowEnemiesArrowMax > 0) if(enemyHasBow) enemy.entityDropItem(arrowStack, 0);
        } catch (Exception e) {        
            // System.err.println("ouch!");
        }               
    }
    
    
    // BLAZE
    @SubscribeEvent
    public void playerKilledBlaze(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityBlaze) && (isNotServerWorld))
        {           
                                                                            
            if(LogicalDrops.intBlazeFireChargeMax > 0){
                ItemStack blazeCharges = new ItemStack(Items.FIRE_CHARGE, 1);
                blazeCharges.setCount(getRandom(LogicalDrops.intBlazeFireChargeMin,LogicalDrops.intBlazeFireChargeMax));
                event.getEntityLiving().entityDropItem(blazeCharges,0);             
            }
            if(LogicalDrops.intBlazeRodMax > 0){
                ItemStack blazeRods = new ItemStack(Items.BLAZE_ROD,1);
                blazeRods.setCount(getRandom(LogicalDrops.intBlazeRodMin,LogicalDrops.intBlazeRodMax));
                event.getEntityLiving().entityDropItem(blazeRods,0);
            }
            
        }               
    }
    
    // SPIDER
    @SubscribeEvent
    public void playerKilledSpider(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntitySpider) && (isNotServerWorld))
        {           
            //TODO: web not dropping            
            // ItemStack spiderWebs = new ItemStack(Blocks.web, 1);
            ItemBlock spiderWeb = (ItemBlock) ItemBlock.getItemFromBlock(Blocks.field_150321_G);
            int numberOfWebs = getRandom(LogicalDrops.intSpiderWebMin,LogicalDrops.intSpiderWebMax);
            int numberOfString = getRandom(LogicalDrops.intSpiderStringMin,LogicalDrops.intSpiderStringMax);
            
            ItemStack webs = new ItemStack(Blocks.field_150321_G,0);
            webs.setCount(numberOfWebs);
            ItemStack strings = new ItemStack(Items.STRING,0);
            strings.setCount(numberOfString); 
            
            if(LogicalDrops.intSpiderWebMax > 0) event.getEntityLiving().entityDropItem(webs, 0);
            if(LogicalDrops.intSpiderStringMax > 0) event.getEntityLiving().entityDropItem(strings, 0);
        }               
    }   

    // RABBIT
    @SubscribeEvent
    public void playerKilledRabbit(LivingDeathEvent event)
    {                   
         Boolean isNotServerWorld = (!event.getEntity().world.isRemote);
        if((event.getEntityLiving() instanceof EntityRabbit) && (isNotServerWorld))
        {                       

            int hideCount = getRandom(LogicalDrops.intRabbitHideMin,LogicalDrops.intRabbitHideMax);
            int meatCount = getRandom(LogicalDrops.intRabbitMeatMin,LogicalDrops.intRabbitMeatMax); // 30 lbs steaks super minimum!         
            ItemStack bones = new ItemStack(Items.BONE,0);
            ItemStack meat = new ItemStack(Items.RABBIT,0);
            ItemStack hides = new ItemStack(Items.RABBIT_HIDE,0);
            ItemStack foots = new ItemStack(Items.RABBIT_FOOT,0);
            
            bones.setCount(1);
            meat.setCount(meatCount);           
            hides.setCount(hideCount);
            foots.setCount(getRandom(LogicalDrops.intRabbitFootMin,LogicalDrops.intRabbitFootMax));
                        
            if(LogicalDrops.intRabbitFootMax > 0) event.getEntityLiving().entityDropItem(foots, 0);
            if(LogicalDrops.intRabbitHideMax > 0) event.getEntityLiving().entityDropItem(hides, 0);
            if(LogicalDrops.intRabbitMeatMax > 0) event.getEntityLiving().entityDropItem(meat,0);
            event.getEntityLiving().entityDropItem(bones,0);
            
                
        }               
    }   
        
    private int getRandom(int low, int high){
        Random rand = new Random(); 

        if(low == 0 && high == 0) return 0;
        if(high == 0) return 0;
        if(low > high) return 0;
        
        int randomNum = rand.nextInt((high - low) + 1) + low;
        // int randomNum = rand.nextInt((high - low) + low)-1;
        
        //DEBUG
//      String chatMsg = "randomNum = (" + randomNum + ")";             
//      Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString(chatMsg));        
        
        return randomNum;       

    }
    
}

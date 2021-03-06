package top.theillusivec4.cherishedworlds.mixin.core;

import net.minecraft.client.gui.screen.MultiplayerScreen;
import net.minecraft.client.gui.screen.ServerSelectionList;
import net.minecraft.client.multiplayer.ServerList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.cherishedworlds.CherishedWorldsMod;
import top.theillusivec4.cherishedworlds.mixin.MixinHooks;

@Mixin(ServerSelectionList.NormalEntry.class)
public class ServerSelectionListNormalEntryMixin {

  @Shadow
  @Final
  private MultiplayerScreen owner;

  @Inject(at = @At("HEAD"), method = "func_228196_a_", cancellable = true)
  private void cherishedworld$swapServers(int pos1, int pos2, CallbackInfo ci) {

    if (MixinHooks.isNotValidSwap(this.owner.getServerList(), pos1, pos2)) {
      CherishedWorldsMod.LOGGER.info("invalid swap");
      ci.cancel();
    }
  }
}

package vswe.stevescarts.Fancy;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;


public class SkinHandler extends FancyPancyHandler {
    public SkinHandler() {
        super("Skin");
    }

    @Override
    public String getDefaultUrl(AbstractClientPlayer player) {
        return AbstractClientPlayer.getSkinUrl(StringUtils.stripControlCodes(player.getDisplayName()));
    }

    @Override
    public ResourceLocation getDefaultResource(AbstractClientPlayer player) {
        return AbstractClientPlayer.getLocationSkin(StringUtils.stripControlCodes(player.getDisplayName()));
    }

    @Override
    public ThreadDownloadImageData getCurrentTexture(AbstractClientPlayer player) {
        return player.getTextureSkin();
    }

    @Override
    public ResourceLocation getCurrentResource(AbstractClientPlayer player) {
        return player.getLocationSkin();
    }

    @Override
    public void setCurrentResource(AbstractClientPlayer player, ResourceLocation resource, String url) {
        ReflectionHelper.setPrivateValue(AbstractClientPlayer.class, player, resource, 3);
        ReflectionHelper.setPrivateValue(AbstractClientPlayer.class, player, tryToDownloadFancy(resource, url), 1);
    }

    @Override
    public LOAD_TYPE getDefaultLoadType() {
        return LOAD_TYPE.OVERRIDE;
    }

    @Override
    public String getDefaultUrl() {
        return "http://skins.minecraft.net/MinecraftSkins/";
    }


}

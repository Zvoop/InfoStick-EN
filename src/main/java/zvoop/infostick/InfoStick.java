package zvoop.infostick;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import cn.nukkit.block.Block;
import cn.nukkit.utils.TextFormat;
import cn.nukkit.event.player.PlayerInteractEvent.Action;

public class InfoStick extends PluginBase implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Item item = event.getItem();

        if(item.getId() == 280 && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getBlock();
            int blockID = block.getId();
            int blockMETA = block.getDamage();
            double blockCoordX = block.x;
            double blockCoordY = block.y;
            double blockCoordZ = block.z;
            String blockNAME = block.getName();
            String message = TextFormat.YELLOW + "-- Block info --" + TextFormat.GREEN  +
                    "\n ID: " + blockID +
                    "\n META: " + blockMETA +
                    "\n Name: " + blockNAME +
                    "\n Сoordinates: " + " " + blockCoordX + " " + blockCoordY + " " + blockCoordZ;
            player.sendMessage(message);
            event.setCancelled();
        }
    }
}
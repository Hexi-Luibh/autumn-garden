package net.runelite.client.plugins.autumngarden;

import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;

import javax.inject.Singleton;

@Singleton
public class ElementalCollisionDetector {

    public static final WorldPoint[] RUNTILES = {
            new WorldPoint(2908, 5461, 0), // start NPC start
            new WorldPoint(2904, 5459, 0), // 0 NPC 0
            new WorldPoint(2901, 5455, 0), // 1 NPC 1
            new WorldPoint(2901, 5451, 0), // 2 NPC 1
            new WorldPoint(2903, 5450, 0), // 3 NPC 1, 2
            new WorldPoint(2902, 5453, 0), // 4 NPC 3
            new WorldPoint(2908, 5456, 0), // 5 NPC 3, 4
            new WorldPoint(2913, 5454, 0), // 6 NPC 5
    };

    /**
     * This method returns true if the NPC's ID is within the bounds of Spring Elementals
     * @param npc The NPC to be tested
     * @return Boolean on if the NPC is a Spring Elemental or not
     */
    public static boolean isAutumnElemental(NPC npc) {
        return npc.getId() >= 5802 && npc.getId() <= 5807;
    }

    /**
     * This method takes a sorted NPC array and the index of the tile to be tested and returns true if the
     * NPC related to that tile is in the correct position.
     * @param npcs The sorted incrementing array of Elemental NPCs
     * @param runTileIndex The index of the tile that is being tested
     * @return Boolean of if the NPC related to the specific tile index is in the correct position
     */
    public boolean correctPosition(NPC[] npcs, int runTileIndex) {
        try {
            switch (runTileIndex) {
                case 0:
                    return true;
                case 1:
                    if (npcs[0].getOrientation() == 512 && npcs[0].getWorldLocation().getX() < 2906
                            && npcs[0].getWorldLocation().getX() > 2900)
                        return true;
                    break;
                case 2:
                    if (npcs[0].getOrientation() == 1536 && npcs[0].getWorldLocation().getX() < 2907
                            && npcs[0].getWorldLocation().getX() > 2904)
                        return true;
                    break;
                case 3:
                    if (npcs[1].getOrientation() == 0 && npcs[1].getWorldLocation().getY() < 5454)
                        return true;
                    break;
                case 4:
                    if ((npcs[1].getOrientation() == 1024
                            && npcs[1].getWorldLocation().getY() > 5451) &&
                       ((npcs[2].getOrientation() == 1536 && npcs[2].getWorldLocation().getX() < 2903)
                            && npcs[2].getWorldLocation().getX() > 2900))
                        return true;
                    break;
                case 5:
                    if (npcs[3].getWorldLocation().getY() > 5453)
                        return true;
                    break;
                case 6:
                    if ((npcs[3].getWorldLocation().getY() > 5452 && npcs[3].getWorldLocation().getX() > 2904) &&
                       (npcs[4].getOrientation() == 1536 && npcs[4].getWorldLocation().getX() < 2913))
                        return true;
                    break;
                case 7:
                    if (npcs[5].getOrientation() == 1536 && npcs[5].getWorldLocation().getX() < 2914
                        && npcs[5].getWorldLocation().getX() > 2910)
                        return true;
                    break;
            }
        } catch (Exception e) { return false; }
        return false;
    }
}

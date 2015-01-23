package in.twizmwaz.cardinal.module.modules.regions.type;

import in.twizmwaz.cardinal.module.modules.regions.parsers.CircleParser;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class CircleRegion extends CylinderRegion {

    public CircleRegion(String name, double centerx, double centerz, double radius) {
        super(name, centerx, 0, centerz, radius, 256);
    }

    public CircleRegion(CircleParser parser) {
        super(parser.getName(), parser.getCenterX(), 0, parser.getCenterZ(), parser.getRadius(), 256);
    }

    @Override
    public List<Block> getBlocks() {
        List<Block> results = new ArrayList<>();
        CuboidRegion bound = new CuboidRegion(null, getCenterX() - getRadius(), 0, getBaseZ() - getRadius(), getBaseX() + getRadius(), 256, getBaseZ() + getRadius());
        for (Block block : bound.getBlocks()) {
            if (contains(new BlockRegion(null, block.getX(), block.getY(), block.getZ()))) results.add(block);
        }
        return results;
    }

    public double getCenterX() {
        return super.getBaseX();
    }

    public double getCenterZ() {
        return super.getBaseZ();
    }

    public double getRadius() {
        return super.getRadius();
    }

}
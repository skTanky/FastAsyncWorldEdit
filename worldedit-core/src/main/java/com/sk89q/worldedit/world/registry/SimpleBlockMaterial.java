/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.world.registry;

import com.fastasyncworldedit.core.nbt.FaweCompoundTag;
import com.sk89q.jnbt.CompoundTag;

import javax.annotation.Nullable;

class SimpleBlockMaterial implements BlockMaterial {

    private boolean isAir;
    private boolean fullCube;
    private boolean opaque;
    private boolean powerSource;
    private boolean liquid;
    private boolean solid;
    private float hardness;
    private float resistance;
    private float slipperiness;
    private int lightValue;
    private boolean fragileWhenPushed;
    private boolean unpushable;
    private boolean ticksRandomly;
    private boolean movementBlocker;
    private boolean burnable;
    private boolean toolRequired;
    private boolean replacedDuringPlacement;
    private boolean isTranslucent;
    private boolean hasContainer;
    //FAWE start
    private int lightOpacity;
    private int mapColor;
    private boolean isTile;
    private CompoundTag tile = null;
    //FAWE end

    @Override
    public boolean isAir() {
        return this.isAir;
    }

    //FAWE start
    @Override
    public int getMapColor() {
        return mapColor;
    }

    public void setMapColor(int mapColor) {
        this.mapColor = mapColor;
    }

    @Override
    public int getLightOpacity() {
        return lightOpacity;
    }

    public void setLightOpacity(int lightOpacity) {
        this.lightOpacity = lightOpacity;
    }
    //FAWE end

    public void setIsAir(boolean isAir) {
        this.isAir = isAir;
    }

    @Override
    public boolean isFullCube() {
        return fullCube;
    }

    public void setFullCube(boolean fullCube) {
        this.fullCube = fullCube;
    }

    @Override
    public boolean isOpaque() {
        return opaque;
    }

    public void setOpaque(boolean opaque) {
        this.opaque = opaque;
    }

    @Override
    public boolean isPowerSource() {
        return powerSource;
    }

    public void setPowerSource(boolean powerSource) {
        this.powerSource = powerSource;
    }

    @Override
    public boolean isLiquid() {
        return liquid;
    }

    public void setLiquid(boolean liquid) {
        this.liquid = liquid;
    }

    @Override
    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    @Override
    public float getHardness() {
        return hardness;
    }

    public void setHardness(float hardness) {
        this.hardness = hardness;
    }

    @Override
    public float getResistance() {
        return resistance;
    }

    public void setResistance(float resistance) {
        this.resistance = resistance;
    }

    @Override
    public float getSlipperiness() {
        return slipperiness;
    }

    public void setSlipperiness(float slipperiness) {
        this.slipperiness = slipperiness;
    }

    @Override
    public int getLightValue() {
        return lightValue;
    }

    public void setLightValue(int lightValue) {
        this.lightValue = lightValue;
    }

    @Override
    public boolean isFragileWhenPushed() {
        return fragileWhenPushed;
    }

    public void setFragileWhenPushed(boolean fragileWhenPushed) {
        this.fragileWhenPushed = fragileWhenPushed;
    }

    @Override
    public boolean isUnpushable() {
        return unpushable;
    }

    public void setUnpushable(boolean unpushable) {
        this.unpushable = unpushable;
    }

    @Override
    public boolean isTicksRandomly() {
        return ticksRandomly;
    }

    public void setTicksRandomly(boolean ticksRandomly) {
        this.ticksRandomly = ticksRandomly;
    }

    @Override
    public boolean isMovementBlocker() {
        return movementBlocker;
    }

    public void setMovementBlocker(boolean movementBlocker) {
        this.movementBlocker = movementBlocker;
    }

    @Override
    public boolean isBurnable() {
        return burnable;
    }

    public void setBurnable(boolean burnable) {
        this.burnable = burnable;
    }

    @Override
    public boolean isToolRequired() {
        return toolRequired;
    }

    public void setToolRequired(boolean toolRequired) {
        this.toolRequired = toolRequired;
    }

    @Override
    public boolean isReplacedDuringPlacement() {
        return replacedDuringPlacement;
    }

    public void setTranslucent(boolean isTranslucent) {
        this.isTranslucent = isTranslucent;
    }

    @Override
    public boolean isTranslucent() {
        return this.isTranslucent;
    }

    public void setReplacedDuringPlacement(boolean replacedDuringPlacement) {
        this.replacedDuringPlacement = replacedDuringPlacement;
    }

    @Override
    public boolean hasContainer() {
        return this.hasContainer;
    }

    //FAWE start
    public void setIsTile(boolean isTile) {
        this.isTile = isTile;
    }

    @Override
    public boolean isTile() {
        return isTile;
    }

    public void setDefaultTile(CompoundTag tile) {
        this.tile = tile;
    }

    @Override
    public @Nullable FaweCompoundTag defaultTile() {
        // this implementation is very lazy, but SimpleBlockMaterial isn't really used anyway
        if (tile != null) {
            return FaweCompoundTag.of(tile.toLinTag());
        }
        return null;
    }
    //FAWE end

    public void setHasContainer(boolean hasContainer) {
        this.hasContainer = hasContainer;
    }

}

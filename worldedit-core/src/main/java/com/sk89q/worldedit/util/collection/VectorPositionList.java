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

package com.sk89q.worldedit.util.collection;

import com.fastasyncworldedit.core.math.MutableBlockVector3;
import com.google.common.collect.AbstractIterator;
import com.sk89q.worldedit.math.BlockVector3;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;

import java.util.Iterator;

class VectorPositionList implements PositionList {

    private final IntList delegateX = new IntArrayList();
    private final IntList delegateY = new IntArrayList();
    private final IntList delegateZ = new IntArrayList();

    @Override
    public BlockVector3 get(int index) {
        return BlockVector3.at(
                delegateX.getInt(index),
                delegateY.getInt(index),
                delegateZ.getInt(index)
        );
    }

    @Override
    public void add(BlockVector3 vector) {
        delegateX.add(vector.x());
        delegateY.add(vector.y());
        delegateZ.add(vector.z());
    }

    @Override
    public int size() {
        return delegateX.size();
    }

    @Override
    public void clear() {
        delegateX.clear();
        delegateY.clear();
        delegateZ.clear();
    }

    @Override
    public Iterator<BlockVector3> iterator() {
        return new AbstractIterator<>() {

            private final IntIterator iteratorX = delegateX.iterator();
            private final IntIterator iteratorY = delegateY.iterator();
            private final IntIterator iteratorZ = delegateZ.iterator();
            private final MutableBlockVector3 mutable = new MutableBlockVector3();

            @Override
            protected BlockVector3 computeNext() {
                if (!iteratorX.hasNext()) {
                    return endOfData();
                }
                return mutable.setComponents(
                        iteratorX.nextInt(),
                        iteratorY.nextInt(),
                        iteratorZ.nextInt()
                );
            }
        };
    }

    @Override
    public Iterator<BlockVector3> reverseIterator() {
        return new AbstractIterator<BlockVector3>() {

            private final IntListIterator iteratorX = delegateX.listIterator(delegateX.size());
            private final IntListIterator iteratorY = delegateY.listIterator(delegateY.size());
            private final IntListIterator iteratorZ = delegateZ.listIterator(delegateZ.size());
            private final MutableBlockVector3 mutable = new MutableBlockVector3();

            @Override
            protected BlockVector3 computeNext() {
                if (!iteratorX.hasPrevious()) {
                    return endOfData();
                }
                return mutable.setComponents(
                        iteratorX.previousInt(),
                        iteratorY.previousInt(),
                        iteratorZ.previousInt()
                );
            }
        };
    }

}

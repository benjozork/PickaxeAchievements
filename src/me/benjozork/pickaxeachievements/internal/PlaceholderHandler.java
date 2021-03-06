package me.benjozork.pickaxeachievements.internal;

import me.clip.placeholderapi.external.EZPlaceholderHook;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

/**
 Looks like you decompiled my code :) Don't worry, you have to right to do so.

 The MIT License (MIT)

 Copyright (c) 2016 Benjozork

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF
 CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR
 THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 **/

public class PlaceholderHandler extends EZPlaceholderHook {

    public PlaceholderHandler(Plugin plugin, AchievementHandler handlerInstance) {
        super(plugin, "pickaxeachievements");
        this.aHandler = handlerInstance;
    }

    private AchievementHandler aHandler;

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        if (player == null) return null;

        if (Objects.equals(identifier, "level")) {
            return aHandler.getCurrentLevel(player) + "";
        } else if (Objects.equals(identifier, "next_level")) {
            return aHandler.getNextLevel(player) + "";
        } else if (Objects.equals(identifier, "remaining")) {
            return aHandler.getRemainingBlocks(player) + "";
        }

        return null;
    }

}

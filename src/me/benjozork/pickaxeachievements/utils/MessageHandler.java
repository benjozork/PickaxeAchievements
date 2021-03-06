package me.benjozork.pickaxeachievements.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

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

public class MessageHandler {

    private FileConfiguration config;

    public MessageHandler(FileConfiguration config) {
        this.config = config;
    }

    public String getMessage(String identifier) {
        String message = config.getString("prefix") + " " + config.getString(identifier);
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String getRawMessage(String identifier) {
        String message = config.getString(identifier);
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public void sendLevelUpMessage(Player p, int level) {
        String levelup = config.getString("prefix") + " " + config.getString("levelup")
                .replace("%level%", level + "");

        p.sendMessage(levelup);
    }

    public void updateConfigs(FileConfiguration newConfig) {
        this.config = newConfig;
    }
}

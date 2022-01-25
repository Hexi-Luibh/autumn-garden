package com.ailieluibh.autumngarden;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class AutumnGardenPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(AutumnGardenPlugin.class);
		RuneLite.main(args);
	}
}
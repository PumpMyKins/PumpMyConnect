package fr.pmc.utils;

import net.md_5.bungee.config.Configuration;

public interface IConnectable {

	public String getName();
	
	public void writeConfiguration(Configuration conf);
	public void readConfiguration(Configuration conf);
	
}

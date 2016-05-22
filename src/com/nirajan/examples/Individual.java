package com.nirajan.examples;

import java.util.Arrays;

public class Individual {
	private static final int GENE_LENGTH = 64;
	private byte[] genes=new byte[GENE_LENGTH];
	private int fitness=0;
	
	public void generateIndividual() {
		for(int i=0;i<geneSize();i++) {
			byte gene=(byte)Math.round(Math.random());
			genes[i]=gene;
		}
	}
	
	public int geneSize() {
		return GENE_LENGTH;
	}
	
	public byte getGene(int index) {
		return genes[index];
	}
	
	public void setGene(int index,byte value) {
		genes[index]=value;
		fitness=0;
	}

	public int getFitness() {
		if(fitness==0) {
			fitness=FitnessCalc.getFitness(this);
		}
		
		return fitness;
	}

	@Override
	public String toString() {
		return "Individual [Gene: " + Arrays.toString(genes) + "]";
	}
}


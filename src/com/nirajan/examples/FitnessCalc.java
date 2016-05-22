package com.nirajan.examples;

public class FitnessCalc {
	private static final int GENE_LENGTH = 64;
	private static byte[] solution;
	
	public static void setSolution(byte[] newSolution) {
		solution=new byte[GENE_LENGTH];
		solution=newSolution;
	}
	
	public static void setSolution(String newSolution) {
		solution=new byte[newSolution.length()];
		
		for(int i=0;i<newSolution.length();i++) {
			Character ch=newSolution.charAt(i);
			if(ch.compareTo('0')==0 || ch.compareTo('1')==0) {
				solution[i]=Byte.parseByte(ch.toString());
			}
		}
	}
	
	public static int getFitness(Individual individual) {
		int fitness=0;
		for(int i=0;i<individual.geneSize();i++) {
			if(individual.getGene(i)==solution[i]) {
				fitness++;
			}
		}
		
		return fitness;
	}
	
	public static int getMaxFitness() {
		int maxFitness=solution.length;
		return maxFitness;
	}
}

package com.nirajan.examples;

public class GA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FitnessCalc.setSolution("1111000000000000001000000000100000000000000000100000000000001111");
		
		Population pop=new Population(50,true);
		int generation=0;
		while(pop.getFittest().getFitness()<FitnessCalc.getMaxFitness()) {
			generation++;
			System.out.println("Generation: "+generation+"\tFittest: "+pop.getFittest().getFitness());
			pop=Algorithm.evolvePopulation(pop);
		}
		
		System.out.println("Solution found...");
		System.out.println("Generation: "+generation);
		System.out.println("Genes:");
		System.out.println(pop.getFittest());
		
	}

}

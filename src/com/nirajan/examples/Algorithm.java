package com.nirajan.examples;

public class Algorithm {
	private static final double uniformRate=0.5;
	private static final double mutationRate=0.015;
	private static final int tournamentSize=5;
	private static final boolean elitism=true;
	
	public static Population evolvePopulation(Population pop) {
		Population newPopulation=new Population(pop.size(),false);
		if(elitism) {
			newPopulation.setIndividual(0, pop.getFittest());
		}
		
		int elitismOffset;
		if(elitism) {
			elitismOffset=1;
		}
		else {
			elitismOffset=0;
		}
		
		for(int i=elitismOffset;i<pop.size();i++) {
			Individual indiv1=tournamentSelection(pop);
			Individual indiv2=tournamentSelection(pop);
			
			Individual newIndiv=crossover(indiv1,indiv2);
			newPopulation.setIndividual(i, newIndiv);
		}
		
		for(int i=elitismOffset;i<newPopulation.size();i++) {
			mutate(newPopulation.getIndividual(i));
		}
		return newPopulation;
	}
	
	private static Individual crossover(Individual indiv1,Individual indiv2) {
		Individual newIndiv=new Individual();
		for(int i=0;i<indiv1.geneSize();i++) {
			if(Math.random()<=uniformRate) {
				newIndiv.setGene(i, indiv1.getGene(i));
			}
			
			else {
				newIndiv.setGene(i, indiv2.getGene(i));
			}
		}
		
		return newIndiv;
	}
	
	private static void mutate(Individual indiv) {
		for(int i=0;i<indiv.geneSize();i++) {
			if(Math.random()<=mutationRate) {
				byte gene=(byte)Math.round(Math.random());
				indiv.setGene(i,gene);
			}
		}
	}
	
	private static Individual tournamentSelection(Population pop) {
		Population tournament=new Population(tournamentSize,false);
		for(int i=0;i<tournamentSize;i++) {
			Individual randomIndiv=pop.getIndividual((int)(Math.random()*pop.size()));
			tournament.setIndividual(i, randomIndiv);
		}
		
		Individual fittest=tournament.getFittest();
		return fittest;
	}

}

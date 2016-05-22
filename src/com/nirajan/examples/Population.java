package com.nirajan.examples;

public class Population {
	private Individual[] individuals;
	
	public Population(int populationSize,boolean initialize) {
		individuals=new Individual[populationSize];
		if(initialize) {
			for(int i=0;i<size();i++) {
				Individual newIndividual=new Individual();
				newIndividual.generateIndividual();
				individuals[i]=newIndividual;
			}
		}
	}
	
	public int size() {
		return individuals.length;
	}
	
	public Individual getIndividual(int index) {
		return individuals[index];
	}
	
	public void setIndividual(int index,Individual individual) {
		individuals[index]=individual;
	}
	
	public Individual getFittest() {
		Individual fittest=individuals[0];
		for(int i=0;i<size();i++) {
			if(getIndividual(i).getFitness()>=fittest.getFitness()) {
				fittest=getIndividual(i);
			}
		}
		
		return fittest;
	}
}

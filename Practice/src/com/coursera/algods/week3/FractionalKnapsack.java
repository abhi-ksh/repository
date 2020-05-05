package com.coursera.algods.week3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class FractionalKnapsack {
	public static class Item {
		public Item(int value, int weight, double rate) {
			super();
			this.value = value;
			this.weight = weight;
			this.rate = rate;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
		private int value;
		private int weight;
		private double rate;
	}

	private static double getOptimalValue(int capacity, ArrayList<Item> iList) {
		double value = 0;
		Collections.sort(iList, new Comparator<Item>() {

			@Override
			public int compare(Item arg0, Item arg1) {
				if (arg0.getRate() > arg1.getRate()) {
					return -1;
				}
				if (arg0.getRate() == arg1.getRate()) {
					return 0;
				}
				return 1;
			}

		});

		for (Item i : iList) {
			if(capacity == 0) {
				break;
			}
			if (i.getWeight() > capacity) {
				value += capacity * i.getRate();
				capacity = 0;
			} else {
				value += i.getValue();
				capacity -= i.getWeight();
			}
		}

		return value;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		ArrayList<Item> iList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
			iList.add(new Item(values[i], weights[i], (double) values[i] / (double) weights[i]));
		}
		System.out.println(String.format("%.4f", getOptimalValue(capacity, iList)));
		scanner.close();
	}
}

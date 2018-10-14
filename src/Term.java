import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdOut;

public class Term implements Comparable<Term>
{
	
	private String query;
	private double weight;
	
	public Term( String query, double weight)
	{
		if(query == null)
		{
			throw new NullPointerException();
		}
		if(weight < 0)
		{
			throw new IllegalArgumentException();
		}
		this.query = query;
		this.weight = weight;
	}
	
	public static Comparator<Term> byReverseWeightOrder()
	{
		return (first, second) -> Double.compare(second.weight,first.weight);

		
	}
	
	public static Comparator<Term> byPrefixOrder(int r)
	{
		if (r < 0)
		{
			throw new IllegalArgumentException();
		}
		return (first, second) -> {
            String one = first.query.substring(0, Math.min(first.query.length(), r));
            String two = second.query.substring(0, Math.min(second.query.length(), r));

            return one.compareTo(two);
        };
	}
	
	@Override
	public int compareTo(Term that)
	{
		return this.query.compareTo(that.query);
	}
	
	@Override
	public String toString()
	{
		return String.format("%-3.02f\t%s", weight, query);
	}
	
	public static void main (String[] args)
	{
		Term[] states = {
			new Term("California", 15000000),
			new Term("Maryland", 1240000),
			new Term("New Jersey", 5400000),
			new Term("Alaska", 1000000),
			new Term("Alabama", 5400000)
		};
		
		Arrays.sort(states);
		
		StdOut.println("State Name Order: ");
		
		for(Term curr : states)
		{
			StdOut.println(curr);
		}
		
		StdOut.println(" ");
		StdOut.println("Reverse Weight Order: ");
		
		Arrays.sort(states, byReverseWeightOrder());
		
		for(Term curr : states)
		{
			StdOut.println(curr);
		}
		
		StdOut.println(" ");
		StdOut.println("Prefix R Order: ");
		
		Arrays.sort(states, byPrefixOrder(25));
		
		for(Term curr : states)
		{
			StdOut.println(curr);
		}
	}
	
	
	
}

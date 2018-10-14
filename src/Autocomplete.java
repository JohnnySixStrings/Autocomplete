import java.util.Arrays;

public class Autocomplete
{
    private static Term[] copy;

    // Initialize the data structure from the given array of terms.
    public Autocomplete(Term[] terms)
    {
        if (terms == null)
        {
            throw new java.lang.NullPointerException();
        }

        copy = new Term[terms.length-1];
        System.arraycopy(terms,0,copy,0,terms.length-1);
        Arrays.sort(copy);
    }

    // Return all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix)
    {
        if (prefix == null)
        {
            throw new java.lang.NullPointerException();
        }

        Term key = new Term(prefix, 0);

        int first = BinarySearchDeluxe.firstIndexOf(copy, key, Term.byPrefixOrder(prefix.length()));
        int last = BinarySearchDeluxe.lastIndexOf(copy, key, Term.byPrefixOrder(prefix.length()));

        if (!(last<0))
        {
            Term[] temp = Arrays.copyOfRange(copy, first, last);
        Arrays.sort(temp,Term.byReverseWeightOrder());
        return temp;
        }
        else {
            return new Term[0];
        }
    }

    // Return the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix)
    {
        if (prefix == null)
        {
            throw new java.lang.NullPointerException();
        }

        Term key = new Term(prefix, 0);

        int first = BinarySearchDeluxe.firstIndexOf(copy, key, Term.byPrefixOrder(prefix.length()));
        int last = BinarySearchDeluxe.lastIndexOf(copy, key, Term.byPrefixOrder(prefix.length()));

        return (last - first)+1;
    }
}

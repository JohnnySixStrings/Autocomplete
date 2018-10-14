import java.util.Comparator;

public class BinarySearchDeluxe 
{
	public static <T> int firstIndexOf(T[] a, T key, Comparator<T> comparator)
	{
		int low = 0;
		int high = a.length - 1;
		int mid;
		int index = -1;
		if(a == null ||key == null || comparator== null)
		{
			throw new java.lang.NullPointerException();
		}
		while(low <= high)
		{
			mid = (low + high)/2;
			if (comparator.compare(a[mid], key) < 0)
			{
				low = mid + 1;
			}
			if (comparator.compare(a[mid], key) > 0)
			{
				high = mid - 1;
			}
			if (comparator.compare(a[mid], key) == 0)
			{
				index = mid;
				high = mid - 1;
			}
		}
		return index;
	}
	
	public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
		int low = 0;
		int high = a.length - 1;
		int mid;
		int index = -1;
        if(a == null ||key == null || comparator== null)
        {
            throw new java.lang.NullPointerException();
        }
		while(low <= high)
		{
			mid = (low + high)/2;
			if (comparator.compare(a[mid], key) < 0)
			{
				low = mid + 1;
			}
			if (comparator.compare(a[mid], key) > 0)
			{
				high = mid - 1;
			}
			if (comparator.compare(a[mid], key) == 0)
			{
				index = mid;
				low = mid + 1;
			}
		}
		return index;
	}
	
	
	public static void main (String[] args)
	{
		
	}
	
}

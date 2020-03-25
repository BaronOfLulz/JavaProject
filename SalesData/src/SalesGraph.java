import java.util.Stack; 

	

	interface FilterFlavor
	{
		public void filterByFlavor(); 
	}
	
	interface FilterType
	{
		public void filterByType();
	}
	
	
	public abstract class SalesGraph
	{
	public Stack<SnackItem> items; 
	public Stack<Integer> sales; 
	
		SalesGraph() 
		{
		this.items = new Stack<SnackItem>(); 
		this.sales = new Stack<Integer>(); 
		
		}
		
		public void addItem(SnackItem item, Integer sale)
		{
			items.push(item);
			sales.push(sale); 
		}

		
		public void popItem(SnackItem item,Integer sale)
		{
		item = items.pop();
		sale = sales.pop();	
		}
		public int itemsAmount() {return items.size();}
			
		public abstract void filter(); 
	}

	



public class SalesGraphCreator
{
	
	public SalesGraphCreator() { }
	
	public static SalesGraph getSalesGraph(SalesGraphType t,String type,String flavor) 
	{
		switch(t)
		{
		case FLAVOR:
			return new SalesGraphFilterFlavor(flavor);
		case TYPE:
			return new SalesGraphFilterType(type);
		case REGULAR:
			return new SalesGraphRegular();	
		default:
			return null;
		
		
		}
	
	}
	

}

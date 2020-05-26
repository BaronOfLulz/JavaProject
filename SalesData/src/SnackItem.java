/**
 * 
 */

/**
 * @author AFQ343
 *
 */
public class SnackItem
{
String name;
String flavor; 
String type;
    SnackItem()
    {
    	this.name = this.flavor = this.type ="?"; 
    }

	SnackItem(String name, String flavor, String type)
	{
		this.name = name;
		this.flavor = flavor;
		this.type = type; 
	}
	
	String getName() {return this.name;}
	String getFlavor() {return this.flavor;}
	String getType() {return this.type;}
}

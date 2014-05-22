import ccj.*;

/* fill in your program comments here */

public class Relatives
{
  public static void main (String[] args)
  {
    giveIntro();
    FamilyInfo family = new FamilyInfo();
    System.out.print("What is the input file? ");
    String FileName = Console.in.readLine();
    TextInputStream input = new TextInputStream(FileName);
    System.out.println();

    family.read(input);
    showInfo(family);
  }

  public static void giveIntro()
       /* Program explained to the user */
  {
    System.out.println("This program will show you all of the ancestors");
    System.out.println("and descendants of a person.");
    System.out.println();
  }

  public static void showInfo(FamilyInfo list)
       /* user prompted for name of person to show info for; info shown */
  {
    String name;
    System.out.print("Whom do you want to see info for ('quit' to end)? ");
    name = Console.in.readLine();
    System.out.println();
    Person next = list.getPerson(name);
    if (next == null)
      System.out.println("No match.");
    else
      showRelatives(next);
  }

  public static void showRelatives(Person current)
       /* fill in this function to show the user all ancestors and
	* descendants of the given person.
	*
	* You will write two extra functions called by ShowRelatives that will
	* do the recursive searching (one for ancestors, one for descendants).
	*/
  {
    /* fill in your definition of ShowRelatives here */
    System.out.println("Ancestors:");
    showAncestors(current, 1);
    System.out.println();
    System.out.println("Descendants:");
    showDescendants(current, 1);
    System.out.println();
  }

  public static void showAncestors(Person current, int level)
       /* Shows paternal ancestors for given person */
  {
    if (current != null) {
      for (int i = 0; i < level; i++)
	System.out.print("    ");
      System.out.println(current.getName());
      showAncestors(current.getMother(), level + 1);
      showAncestors(current.getFather(), level + 1);
    }
  }

  public static void showDescendants(Person current, int level)
       /* Shows children for given person */
  {
    if (current != null) {
      for (int i = 0; i < level; i++)
	System.out.print("    ");
      System.out.println(current.getName());
      for (int i = 1; i <= current.numKids(); i++)
	showDescendants(current.nthKid(i), level + 1);
    }
  }
}

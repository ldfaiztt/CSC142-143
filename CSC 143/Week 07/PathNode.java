/**
 * PathNode is used as the LinkedList's node in the Path class. 
 * A PathNode contains the longitude and latitude of the location 
 * and the reference to the next PathNode.
 * @author Chun-Wei Chen
 * @version 02/27/12
 */
public class PathNode
{
  public double lon; // the longitude of the location
  public double lat; // the latitude of the location
  public PathNode next; // the next path object
  
  /**
   * Construct a PathNode with the specified starting location and next path.
   * @param lon longitude of the location
   * @param lat latitude of the location
   * @param next next path object
   * @throws IllegalArgumentException if either lon < -180, lon > 180, 
   * or lat < -90 or lat > 90
   */
  public PathNode(double lon, double lat, PathNode next) {
    if (lon < -180 || lon > 180 || lat < -90 || lat > 90)
      throw new IllegalArgumentException ("Longitude must be a number between -180 " +
                                          "degrees and +180 degrees, and latitude must be" +
                                          " a number between -90 degrees and +90 degrees.");
    this.lon = lon;
    this.lat = lat;
    this.next = next;
  }
}
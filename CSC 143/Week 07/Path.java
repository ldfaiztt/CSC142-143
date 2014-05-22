/**
 * This class models a path consisting of a sequence of map locations 
 * represented by GPS coordinates (longitude and latitude).
 * @author Chun-Wei Chen
 * @version 02/27/12
 */
public class Path
{
  public static final double RADIUS = 6371.0; // the radius of the earth
  
  private int size; // the total number of locations
  private PathNode start; // the first location of the path
  private PathNode last; // the last location of the path
  
  /**
   * Constructs a Path with the specified starting location.
   * @param lon longitude of the location
   * @param lat latitude of the location
   * @throws IllegalArgumentException if either lon < -180, lon > 180, 
   * or lat < -90 or lat > 90
   */
  public Path(double lon, double lat) {
    start = new PathNode(lon, lat, null);
    last = start;
    size = 1;
  }
  
  /**
   * Constructs a Path that is a duplicate (a deep copy) of 
   * the one provided without modifying p.
   * @param p original script of the path
   * @throws IllegalArgumentException if p references to null
   */
  public Path(Path p) {
    if (p == null)
      throw new IllegalArgumentException("Path provided cannot be null.");
    start = new PathNode(p.start.lon, p.start.lat, null);
    last = start;
    size = 1;
    PathNode p0 = p.start;
    PathNode p1 = start;
    while (p0.next != null) {
      p1.next = new PathNode(p0.next.lon, p0.next.lat, null);
      p0 = p0.next;
      p1 = p1.next;
      last = p1;
      size++;
    }
  }
  
  /**
   * Returns the number of locations (stops) on this Path.
   * @return the number of locations (stops) on this Path
   */
  public int locations() {
    return size;
  }
  
  /**
   * Checks if the longitude and the latitude of the location is valid.
   * @param lon longitude of the location
   * @param lat latitude of the location
   * @throws IllegalArgumentException if either lon < -180, lon > 180, 
   * or lat < -90 or lat > 90
   */
  private void checkLonAndLat(double lon, double lat) {
    if (lon < -180 || lon > 180 || lat < -90 || lat > 90)
      throw new IllegalArgumentException ("longitude must be a number between -180 " +
                                          "degrees and +180 degrees, and latitude must be" +
                                          " a number between -90 degrees and +90 degrees.");
  }
  
  /**
   * Checks if two locations are equal. The definition for equal: the difference of
   * two locations' longitudes and latitudes are less than 0.001.
   * @param lon1 longitude of the first location
   * @param lat1 latitude of the first location
   * @param lon2 longitude of the second location
   * @param lat2 latitude of the second location
   * @return true if two locations are considered to be equal by definition
   */
  private boolean checkEqual(double lon1, double lat1, double lon2, double lat2) {
    return (Math.abs(lon1 - lon2) < 0.001 && Math.abs(lat1 - lat2) < 0.001);
  }
  
  /**
   * Calculates the distance between two locations.
   * @param lon1 longitude of the first location
   * @param lat1 latitude of the first location
   * @param lon2 longitude of the second location
   * @param lat2 latitude of the second location
   * @return distance between two locations
   */
  private double calcDistance(double lon1, double lat1, double lon2, double lat2) {
    return RADIUS * Math.acos(Math.sin(lat1 / 180) * Math.sin(lat2 / 180) + 
                              Math.cos(lat1 / 180) * Math.cos(lat2 / 180) * 
                              Math.cos((lon2 - lon1) / 180));
  }
  
  /**
   * Adds a new location to the end of this Path. Doesnt't add if 
   * the location would be an adjacent duplicate. Throws exception if
   * the argument is not legal.
   * @param lon longitude of the location
   * @param lat latitude of the location
   * @return true if the location is added to the path
   * @throws IllegalArgumentException if either lon < -180, lon > 180, 
   * or lat < -90 or lat > 90
   */
  public boolean appendLocation(double lon, double lat) {
    checkLonAndLat(lon, lat); // Check if the lon and lat provides are valid
    if (checkEqual(last.lon, last.lat, lon, lat))
      return false;
    last.next = new PathNode(lon, lat, null);
    last = last.next;
    size++;
    return true;
  }
  
  /**
   * Adds a new location to this Path.  The new location should be inserted in the 
   * sequence such that it creates the smallest possible increase in total path length.
   * @param lon longitude of the location
   * @param lat latitude of the location
   * @return true if the location is added to the path
   * @throws IllegalArgumentException if either lon < -180, lon > 180, 
   * or lat < -90 or lat > 90
   */
  public boolean insertLocation(double lon, double lat) {
    checkLonAndLat(lon, lat); // Check if the lon and lat provides are valid
    if (size == 1) {
      if (checkEqual(start.lon, start.lat, lon, lat))
        return false;
      start.next = new PathNode(lon, lat, null);
      last = start.next;
      size++;
      return true;
    }
    PathNode minChange = start;
    double minDisDif = calcDistance(start.lon, start.lat, lon, lat) + 
                       calcDistance(start.next.lon, start.next.lat, lon, lat) - 
                       calcDistance(start.lon, start.lat, start.next.lon, start.next.lat);
    PathNode p = start.next;
    while (p.next != null) {
      double disDif = calcDistance(p.lon, p.lat, lon, lat) + 
                      calcDistance(p.next.lon, p.next.lat, lon, lat) - 
                      calcDistance(p.lon, p.lat, p.next.lon, p.next.lat);
      if (disDif < minDisDif) {
        minDisDif = disDif;
        minChange = p;
      }
      p = p.next;
    }
    
    // Determine if inserting the new location at the 
    // last position increase the smallest total length
    double disDif2 = calcDistance(p.lon, p.lat, lon, lat);
    if (disDif2 < minDisDif) {
      minDisDif = disDif2;
      minChange = p;
    }
    
    // If inserting the new location at the last position increase the 
    // smallest total length, insert the new location at the last position
    if (minChange.next == null) {
      if (checkEqual(minChange.lon, minChange.lat, lon, lat))
        return false;
      minChange.next = new PathNode(lon, lat, null);
      last = minChange.next;
      size++;
      return true;
    }
    
    // Don't insert the location if that location is alreasy exist in the Path
    if (checkEqual(minChange.lon, minChange.lat, lon, lat) || 
        checkEqual(minChange.next.lon, minChange.next.lat, lon, lat))
      return false;
    
    PathNode newLoc = new PathNode(lon, lat, null);
    newLoc.next = minChange.next;
    minChange.next = newLoc;
    size++;
    return true;
  }
  
  /**
   * If a location with the specified longitude and latitude exists in this Path, 
   * delete that location. Return true if the path was changed, otherwise false.
   * @param lon longitude of the location
   * @param lat latitude of the location
   * @return true if the path was changed
   */
  public boolean deleteLocation(double lon, double lat) {
    if (lon < -180 || lon > 180 || lat < -90 || lat > 90)
      return false;
    
    // If the size of the Path is 1, don't delete any location 
    if (size == 1)
      return false;
    
    // Delete the first location if the lon and lat of the 
    // first location are equal to the lon and lat provided
    if (checkEqual(start.lon, start.lat, lon, lat)) {
      start = start.next;
      size--;
      return true;
    }
    
    PathNode p = start;
    if (p.next != null) {
      while (p.next.next != null) {
        if (checkEqual(p.next.lon, p.next.lat, lon, lat)) {
          // Delete the location and the location after that if there will be 
          // two identical locations at the adjacent position after deleting
          // the location specified.
          if (checkEqual(p.lon, p.lat, p.next.next.lon, p.next.next.lat)) {
            p.next = p.next.next.next;
            size -= 2;
            return true;
          }
          p.next = p.next.next;
          size--;
          return true;
        }
        p = p.next;
      }
    }
    
    // Delete the last location if the lon and lat of the 
    // last location are equal to the lon and lat provided
    if (checkEqual(p.next.lon, p.next.lat, lon, lat)) {
      p.next = p.next.next;
      last = p;
      size--;
      return true;
    }
    return false;
  }
  
  /**
   * Returns the total distance traveled by following this Path in kilometers.
   * @return the total distance traveled by following this Path in kilometers.
   */
  public double totalPathLength() {
    PathNode p = start;
    double distance = 0;
    
    // Sum up the distance between every two locations
    while (p.next != null) {
      distance += calcDistance(p.lon, p.lat, p.next.lon, p.next.lat);
      p = p.next;
    }
    return distance;
  }
  
  /**
   * Finds the stop on this Path that is closest to the location provided as a 
   * parameter and return the distance between the location and that stop in kilometers.
   * @param lon longitude of the location
   * @param lat latitude of the location
   * @return the distance between the location and the closest location in the Path
   * @throws IllegalArgumentException if either lon < -180, lon > 180, 
   * or lat < -90 or lat > 90
   */
  public double distanceToClosestStop(double lon, double lat) {
    checkLonAndLat(lon, lat); // Check if the lon and lat provides are valid
    
    double minDis = calcDistance(start.lon, start.lat, lon, lat);
    PathNode p = start.next;
    while (p != null) {
      double dis = calcDistance(p.lon, p.lat, lon, lat);
      if (dis < minDis)
        minDis = dis;
      p = p.next;
    }
    return minDis;
  }
  
  /**
   * Returns true if the object provided as a parameter is the same as this path.
   * @param o an Object
   * @return true if o is the same as this path
   */
  public boolean equals(Object o) {
    if (this == o)
      return true;
    
    // If the object references to null or is not instance of Path, then return false
    if (o == null || !(o instanceof Path))
      return false;
    
    Path path = (Path) o;
    if (path.size != size)
      return false;
    
    PathNode p0 = start;
    PathNode p1 = path.start;
    
    // Go throught two Paths to see if each location is the same 
    while(p0 != null) {
      if (!checkEqual(p0.lon, p0.lat, p1.lon, p1.lat))
        return false;
      p0 = p0.next;
      p1 = p1.next;
    }
    return true;
  }
  
  /**
   * Returns a new Path object that represents this path with 
   * all locations visited in reverse order.
   * @return the new Path object with the reverse order
   */
  public Path createReversePath() {
    return createReversePath(start); // Call the private version
  }
  
  /**
   * Private createReversePath method.
   * @param p a PathNode
   * @return the new Path object with the reverse order
   */
  private Path createReversePath(PathNode p) {
    Path reverse;
    
    // Let the last location in the original Path be the first one in this Path
    if (p.next == null)
      return new Path(p.lon, p.lat);
    else {
      // Use recusive call util find the last location in the original Path
      reverse = createReversePath(p.next); 
      reverse.appendLocation(p.lon, p.lat);
      return reverse;
    }
  }
    
  /**
   * Represnts the Path as a sequence of GPS locations in String.
   * @return String representation of the Path
   */
  public String toString() {
    String result = "{";
    result += "" + Math.round(1000 * (start.lon < 0 ? -start.lon : start.lon)) / 1000. + 
              ((char)176) + (start.lon < 0 ? "W" : "E") + ", " + 
              Math.round(1000 * (start.lat < 0 ? -start.lat : start.lat)) / 1000. + 
              ((char)176) + (start.lat < 0 ? "S" : "N");
    PathNode p = start.next;
    while (p != null) {
      result += " -> " + Math.round(1000 * (p.lon < 0 ? -p.lon : p.lon)) / 1000. + 
                ((char)176) + (p.lon < 0 ? "W" : "E") + ", " + 
                Math.round(1000 * (p.lat < 0 ? -p.lat : p.lat)) / 1000. + 
                ((char)176) + (p.lat < 0 ? "S" : "N");
      p = p.next;
    }
    result += "}";
    return result;
  }
  
  /**
   * Returns a new Path that contains the sequence of locations in Path 'a' 
   * followed by those in Path 'b' without modifying a or b.
   * @param a the first Path
   * @param b the second Path
   * @return the new Path object contains all the locations in Path 'a' 
   * followed by all the locations in Path 'b' without modifying a or b
   * @throws IllegalArgumentException if either a or b references to null
   */
  public static Path joinPaths(Path a, Path b) {
    if (a == null || b == null)
      throw new IllegalArgumentException("Paths provided cannot be null.");
    Path newPath1 = new Path(a);
    Path newPath2 = new Path(b);
    newPath1.last.next = newPath2.start;
    return newPath1;
  }
}
package programmingtest.figures;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Point implements Comparable<Point>{

	private Integer x;
	private Integer y;

	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public int compareTo(Point other) {
        if (other == null) {
            throw new NullPointerException();
        }
        
        if (this.x == other.x && this.y == other.y) {
            return 0;
        }
        //less
        if (this.y < other.y || (this.y == other.y && this.x < other.x)) {
            return -1;
        }
        //bigger
        return 1;
	}

	
}

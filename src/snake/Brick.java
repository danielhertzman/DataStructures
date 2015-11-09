package snake;


public class Brick {
	private boolean visited, isObstacle;
	
	public void setIsObstacle(boolean isObstacle){
		this.isObstacle = isObstacle;
	}
	
	public boolean getIsObstacle(){
		return isObstacle;
	}
	
	public void setVisited(boolean visited){
		this.visited = visited;
	}
	
	public boolean getVisited(){
		return visited;
	}
}
package games.examples.Ship;

class Schiff{
	  private int size;
	  private int[] x;
	  private int[] y;
	  private int hit_count;
	  private boolean versenkt;

	  Schiff(int x, int y,int size){
		  this.x = new int[1];
		  this.y = new int[1];
		  this.hit_count = 0;
		  this.x[0] = x;
		  this.y[0] = y;
		  this.size = size;
		  this.versenkt = false;
	  }
	  Schiff(int x, int y,int x2,int y2,int size){
		  this.x = new int[2];
		  this.y = new int[2];
		  this.hit_count = 0;
		  this.x[0] = x;
		  this.y[0] = y;
		  this.x[1] = x2;
		  this.y[1] = y2;
		  this.size = size;
		  this.versenkt = false;

	  }
	  Schiff(int x, int y,int x2,int y2,int x3,int y3,int size){
		  this.x = new int[3];
		  this.y = new int[3];
		  this.hit_count = 0;
		  this.x[0] = x;
		  this.y[0] = y;
		  this.x[1] = x2;
		  this.y[1] = y2;
		  this.x[2] = x3;
		  this.y[2] = y3;
		  this.size = size;
		  this.versenkt = false;

	  }
	  Schiff(int x, int y,int x2,int y2,int x3,int y3,int x4,int y4,int size){
		  this.x = new int[4];
		  this.y = new int[4];
		  this.hit_count = 0;
		  this.x[0] = x;
		  this.y[0] = y;
		  this.x[1] = x2;
		  this.y[1] = y2;
		  this.x[2] = x3;
		  this.y[2] = y3;
		  this.x[3] = x4;
		  this.y[3] = y4;
		  this.size = size;
		  this.versenkt = false;

	  }
	  
	  int[]getXPositions(){
		  return this.x; 
	  }
	  int[]getYPositions(){
		  return this.y; 
	  }
	  
	  void hit() {
		  this.hit_count++;
	  }
	  
	  int getHit() {
		  return this.hit_count;
	  }
	  int getSize() {
		  return this.size;
	  }
	  
	  void setVersenkt(boolean a) {
		  this.versenkt = a;
	  }
	  
	  boolean getVersenkt(){
		  return this.versenkt;
	  }
	 
	}

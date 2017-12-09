package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {

    @Override
    public int minimumPairwiseDistance(int[] values) {
        throw new UnsupportedOperationException();
    }
    class LL implements Runnable{
    	private int smallestSoFar = Integer.MAX_VALUE;
    	private int [] values;
    	public LL (int[] arr, int smallest) {
    		this.smallestSoFar = smallest;
    		this.values = arr;
    		
    	}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
    	
    }
    class LR implements Runnable{
    	private int smallestSoFar = Integer.MAX_VALUE;
    	private int [] values;
    	public LR (int[] arr, int smallest) {
    		this.smallestSoFar = smallest;
    		this.values = arr;
    		
    	}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
    	
    }
    class UL implements Runnable{
    	private int smallestSoFar = Integer.MAX_VALUE;
    	private int [] values;
    	public UL (int[] arr, int smallest) {
    		this.smallestSoFar = smallest;
    		this.values = arr;
    		
    	}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
    	
    }
    class UR implements Runnable{
    	private int smallestSoFar = Integer.MAX_VALUE;
    	private int [] values;
    	public UR (int[] arr, int smallest) {
    		this.smallestSoFar = smallest;
    		this.values = arr;
    		
    	}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
    	
    }
}
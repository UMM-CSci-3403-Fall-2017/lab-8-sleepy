package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
	private static int globalResult = Integer.MAX_VALUE;
	public void updateGlobalResult(int localResult) {
		if (localResult < globalResult) {
			globalResult = localResult;
		}
	}

    @Override
    public int minimumPairwiseDistance(int[] values) {
    
        
        Thread lowerLeft = new Thread(new LowerLeft(values, Integer.MAX_VALUE));
		Thread bottomRight = new Thread(new BottomRight(values, Integer.MAX_VALUE));
		Thread topRight = new Thread(new TopRight(values, Integer.MAX_VALUE));
		Thread center = new Thread(new Center(values, Integer.MAX_VALUE));

		lowerLeft.start();
		bottomRight.start();
		topRight.start();
		center.start();
		

		try {
			lowerLeft.join();
			bottomRight.join();
			topRight.join();
			center.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

		return globalResult;
    }
    
    class LowerLeft implements Runnable{
    	private int localresult;
    	private int [] values;
    	public LowerLeft (int[] arr, int smallest) {
    		this.localresult = smallest;
    		this.values = arr;
    		
    	}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int n = values.length;
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < i; j++) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < localresult){
						localresult = diff;
					}
				}
			}
			
			updateGlobalResult(localresult);
		}

			
		}
    	
    
    class BottomRight implements Runnable{
    	private int localresult;
    	private int [] values;
    	public BottomRight (int[] arr, int smallest) {
    		this.localresult = smallest;
    		this.values = arr;
    		
    	}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int n = values.length;
			for (int i = n/2; i < n; i++) {
				for (int j = 0; j < i - (n/2); j++) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < localresult){
						localresult = diff;
					}
				}
			}
			
			updateGlobalResult(localresult);
			
		}
    	
    }
    class Center implements Runnable{
    	private int localresult;
    	private int [] values;
    	public Center (int[] arr, int smallest) {
    		this.localresult = smallest;
    		this.values = arr;
    		
    	}
		@Override
		public void run() {
			// TODO Auto-generated method stub
	
			int n = values.length;
			for (int i = n/2; i < n; i++) {
				for (int j = i - (n/2); j < n / 2; j++) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < localresult){
						localresult = diff;
					}
				}
			}
			
			updateGlobalResult(localresult);
		}
			
		}
    	
    
    class TopRight implements Runnable{
    	private int localresult;
    	private int [] values;
    	public TopRight (int[] arr, int smallest) {
    		this.localresult = smallest;
    		this.values = arr;
    		
    	}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			int n = values.length;
			for (int i = n/2; i < n; i++) {
				for (int j = n/2; j < i; j++) {
					int diff = Math.abs(values[i] - values[j]);
					if (diff < localresult){
						localresult = diff;
					}
				}
			}
			
			updateGlobalResult(localresult);
			
		}
    	
    }
}

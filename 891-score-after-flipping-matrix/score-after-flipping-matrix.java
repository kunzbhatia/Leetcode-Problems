class Solution {
	public int matrixScore(int[][] a) {
		int ans=0;
		for(int i=0;i<a.length;i++){
			if(a[i][0]==0){
				//0th element of any array is the biggest number so, it must be 1 
				//for eg 011 is 3 but 100 is 4
			   a=row(a,i);
			}
		}
		for(int i=0;i<a[0].length;i++){
			//if in a column there are more number of 1 ,we will be getting a bigger number 
			if(columnf(a,i)<=a.length/2){
				//it check number of 1s in a column
			   a= column(a,i);
			}
		}

		for(int i=0;i<a.length;i++){
			String s ="";
			for(int j=0;j<a[0].length;j++){
				s=s+Integer.toString(a[i][j]);
			}
			ans=ans+Integer.valueOf(s,2);
		}
		return ans;
	}

	public int columnf(int[][]a , int x){
		//count number of 1 in xth column
		int count=0;
		for(int i=0;i<a.length;i++){
			if(a[i][x]==1){
				count++;
			}
		}
		return count;
	}
	public int[][] row(int[][]a , int x){
		//interchange 0 to 1 and vice versa in xth row
		for(int i=0;i<a[x].length;i++){
			if(a[x][i]==1){
				a[x][i]=0;
			}else{
				a[x][i]=1;
			}
		}
		return a;
	}
	public int[][] column(int[][]a , int x){
		//interchange 0 to 1 and vice versa in xth column
		for(int i=0;i<a.length;i++){
			if(a[i][x]==1){
				a[i][x]=0;
			}else{
				a[i][x]=1;
			}
		}
		return a;
	}
}
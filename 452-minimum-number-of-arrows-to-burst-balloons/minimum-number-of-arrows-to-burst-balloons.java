class Solution {

public int findMinArrowShots(int[][] points) 
{
    if(points.length==0)
    {
        return 0;
    }
    Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); //TO SORT 2D ARRAY
    long arrowPos=points[0][1]; //end point of first range
    int arrowCount=1; //initial arrows
    for(int i=1;i<points.length;i++)
    {
        if(arrowPos<(long)points[i][0]) //if endpoint is less than to next range start (OVERLAP)
        {
        arrowCount++;
        arrowPos=(long)points[i][1]; //changing to end point of next range
        }
    }
    return arrowCount++;
    
}



    // public int findMinArrowShots(int[][] points) 
    // {
    //     int n=points.length;
    //     Map<Integer,Integer> mpp=new HashMap<>();
    //     for(int i=0;i<n;i++)
    //     {
    //         for(int j=points[i][0];j<=points[i][1];j++)
    //         {
    //             mpp.put(j,mpp.getOrDefault(j,0)+1);
    //             if(mpp.getOrDefault(j,0)==2)
    //             {
    //                 break;
    //             }
    //         }
    //     }
    //     int count=0;

    //     for(Map.Entry<Integer,Integer> ele: mpp.entrySet())
    //     {
    //         if(ele.getValue()==2)
    //         {
    //             count++;
    //         }
    //     }
    //     if(count==0)
    //     return n;
    //     else
    //     return count;
        
    // }
}
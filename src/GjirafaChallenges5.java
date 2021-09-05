import java.util.*;

public class GjirafaChallenges5 {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
     
        Scanner a = new Scanner(System.in);
        int nrPoints = a.nextInt();
        int nrRect = 0;
        if(nrPoints<4){
            System.out.println(0);
            return;
        }
        a.nextLine();
        int[][] points = new int[nrPoints][2];
        for (int i = 0; i < nrPoints; i++) {
            String[] s = a.nextLine().split(",");
            int[] point = new int[2];
            for (int j = 0; j < 2; j++) {
                point[j] = Integer.parseInt(s[j]);
            }
            points[i] = point;
        }
                boolean sorted=false;
        while(!sorted) {
            sorted=true;
            for(int i=0;i<nrPoints-1;i++) {
                if(points[i][0]>points[i+1][0]) {
                    int[] temp= {points[i][0],points[i][1]};
                    points[i]=points[i+1];
                    points[i+1]=temp;
                    sorted=false;
                }
            }
        }
        for(int i=0;i<nrPoints-3;i++){
            for(int k=i+1;k<nrPoints-2;k++){
            if(points[i][0]==points[k][0]){
                for(int j=k+1;j<nrPoints-1;j++){
                    for(int l=j+1;l<nrPoints;l++){
                    if(points[j][0]==points[l][0]){
                        if ((points[i][1] == points[j][1] && points[k][1] == points[l][1])
                                    || (points[i][1] == points[l][1] && points[j][1] == points[k][1]))
                                nrRect++;
                    }
                        else{
                            break;
                        }
                    }
                }
            }
                else{
                    break;
                }
            }
            
        }
        System.out.println(nrRect);
        
    }
}
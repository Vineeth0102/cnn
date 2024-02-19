import java.util.Scanner;

public class Belmanford{

    private int data[];
    private int nodes;
    public static final int max_value=999;
    public Belmanford(int n){
    this.nodes=n;
    data=new int[nodes+1];
    }
    public void shortest(int source,int arr[][]){
        for(int i=1;i<=nodes;i++){
        data[i]=max_value;
        }
        data[source]=0;
        for(int k=1;k<=nodes-1;k++){
            for(int i=1;i<=nodes;i++){
                for(int j=1;j<=nodes;j++){
                    if(arr[i][j]!=max_value){
                        if(data[j]>data[i]+arr[i][j])
                        data[j]=data[i]+arr[i][j];
                        }
                    }
                }
            }
        for (int i=1;i<=nodes;i++){
            for (int j=1;j<=nodes;j++){
                if(arr[i][j]!=max_value){
                    if(data[j]>data[i]+arr[i][j]){
                        System.out.println("the graph contains -ve edge cycle");
                        }   
                    }
                }
            }
        for (int i=1;i<=nodes;i++){
            System.out.println("distance of source "+source+" to "+i+" is "+data[i]);
            }
        }

    public static void main(String[] args){
        int nodes=0,source;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes : ");
        nodes = sc.nextInt();
        int arr[][] = new int[nodes+1][nodes+1];
        System.out.println("Enter the weighted matrix : ");
        for(int i = 1; i<=nodes ; i++){
            for(int j = 1 ; j<= nodes ; j++){
                arr[i][j] = sc.nextInt();
                if(i==j){
                    arr[i][j]=0;
                    continue;
                    }
                if(arr[i][j]==0){
                    arr[i][j]=max_value;
                }
            }
        }
        System.out.println("Enter source vertex : ");
        source = sc.nextInt();
        Belmanford bel = new Belmanford(nodes);
        bel.shortest(source,arr);
        sc.close();
    }
}

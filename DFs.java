import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;


public class DFs
{
   static Queue<Integer> q = new LinkedList<Integer>();  
    static  int parents[];
    static String color[];
    static int discoveryTime[];
    static int finishedTime[];
    static int time=0;
    static int v;
   static  String Discovered_Nodes = "";
 static String Processed_Nodes = "";

    public static void main(String[] args)
    {
        BufferedReader obj= null;
        try {
            String str;
            FileReader fr = new FileReader("E:\\cse221\\Lab01\\input1.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            v = Integer.parseInt(str);
//            System.out.print(v);
            int graph[][]= new int[v][v];
            while ((str = obj.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(str," ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                graph[token1][token2]=1;
            }
                  parents= new int[v];
        color= new String[v];
        discoveryTime= new int[v];
        finishedTime=new int[v];
        for(int u=0;u<v;u++){
            parents[u]= 0;
            color[u]="white";
            discoveryTime[u]=0;
            finishedTime[u]=0; 
        }
        for(int u=0;u<v;u++){
            if(color[u]=="white"){
                DfsVisit(graph,u);
            }
        }
        }
         catch (IOException e) {
            
            e.printStackTrace();
        }
}
        
  
    
    public static void DfsVisit(int[][] graph,int u){

            if(color[u]=="white"){
       Discovered_Nodes = Discovered_Nodes + u + " ";
       System.out.println("Discovered_Nodes : "+ Discovered_Nodes);
                 System.out.println();
        
        color[u] = "gray";
       time=time+1;
        discoveryTime[u] = time;
        System.out.print("discoverytime"+" "+time);
        System.out.println();
        for (int j = 0; j < graph.length; j++) {
            if (graph[u][j] == 1 && color[j] == "white") {
                parents[j] = u;
                DfsVisit(graph, j);
            }
        }
        color[u] = "black";
        Processed_Nodes = Processed_Nodes + u + " ";
        System.out.println("Processed_Nodes :"+ Processed_Nodes);
                 System.out.println();
        finishedTime[u] = time++;
           System.out.print("finishedTime"+" "+time);
 System.out.println();
        }
        System.out.println(); 
    }
}

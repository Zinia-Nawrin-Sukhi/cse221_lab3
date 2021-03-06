import java.util.LinkedList; 
import java.util.Queue;
import java.io.*;
import java.util.*;
public class BFS
{
    public static void main(String[]args)
    {
        BufferedReader obj= null;
        try {
            String str;
            FileReader fr = new FileReader("E:\\cse221\\Lab01\\input1.txt");
            obj = new BufferedReader(fr);
            str = obj.readLine();
            int v = Integer.parseInt(str);
            System.out.println(v);
            Queue<Integer> q = new LinkedList<Integer>();      
            int  graph[][]=new int[v][v];
            String[]color=new String[v];
            int[]parent=new int[v];
            int[]level=new int[v];
            while ((str = obj.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(str," ");
                int token1 = Integer.parseInt(st.nextToken());
                int token2 = Integer.parseInt(st.nextToken());
                graph[token1][token2]=1;   
            }
            int s=0;
            for(int i=0; i<v;i++)
            {
                color[i]="white";
                parent[i]=-100;
                level[i]=-500;
            }
            int u=0;
            q.add(s);
            while (q.size()!=0)
            {
                u=  q.remove();
                System.out.print(u+" ");
                for(int i=0; i<v; i++)
                {
                    if(graph[u][i]==1)
                    {
                        if(color[i]=="white")
                        {
                            color[i]="grey";
                            level[i]=level[u]+1;
                            parent[i]=u;
                            q.add(i);
                        }
                    }
                }
                color[u]="black";
            }
        }
        catch (IOException e) {
            e.printStackTrace(); 
        }
        
    }
}
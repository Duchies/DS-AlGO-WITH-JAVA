
import java.io.*;
import java.util.*;

public class DSU {
        public static void main (String[] args) {
	
         int n = 8;

        DisjointUnionSets dsu = new DisjointUnionSets(n);

        dsu.union(1,2);
        dsu.union(2,3);
        dsu.union(4,5);
        dsu.union(6,7);
        dsu.union(1,6);
        
        System.out.println(dsu.find(7));


        }

}
class DisjointUnionSets{

                int[] rank,parent;
                int n;

                public DisjointUnionSets(int n)
                {
                        rank = new int[n];
                        parent = new int[n];
                        this.n = n;
                        makeSet();
                }

               void makeSet(){

                    for (int i = 0; i < n; i++) 
                         parent[i] = i;
         
                }

                int find(int x){

                     if(x == parent[x]){
                             return x;

                     }   

                     return parent[x] = find(parent[x]);

                }       

                void union(int u,int v){

                        u = find(u);
                        v = find(v);

                        if(rank[u]<rank[v]){
                                parent[u] = v;
                        }else if(rank[v]<rank[u]){
                                parent[v] = u;
                        }
                        else{
                                parent[v] = u;
                                rank[u]++;
                        }

                }


        }
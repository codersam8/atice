package atice;

import java.util.Scanner;

class Dijkstra
{
     public static void main(String[] args)
     {
          Dijkstra dk = new Dijkstra();
          dk.begin();
     }

     void begin()
     {
          Scanner sc = new Scanner(System.in);
          GraphAL grph =new GraphAL();
          ArrayList[] al= grph.createGraph();
          Vertex[] ver = new Vertex[al.length];
          int glen = ver.length;
          int locs[] = new int[glen];
          for(int i =0;i<glen;i++)
          {
               locs[i]=i;
          }
          int hlen = glen;
          Graph g = new Graph();
          System.out.println("enter the source you wanted");
          int src = sc.nextInt();
          g.initSingSource(ver,src);
          //System.out.println("after ininting");
          //System.out.println("vertices");
          //display(ver);
          //System.out.println("locs");
	  //display(locs);
          g.makeHeap(ver,locs,glen);
          for(int i = 0;i<glen;i++)
          {
               //ver = g.
               int u = ver[0].id;//gives the one with shortest dist form last vertex
               int dist = ver[0].d;
               System.out.println("before relaxing");
               display(ver);
               //System.out.println("locs");
               //new JavaL().display(locs);

               for(LinkdNode<Vertex> tmp = al[u].li.head;tmp!=null;tmp = tmp.next)
               {    
                    g.relax(ver,locs[tmp.ele.id],u,dist,tmp.ele.d);
               }
               System.out.println("after relaxing");
               display(ver);
               hlen--;
               Vertex tmp = ver[0];
               int tloc = locs[ver[0].id];
               int floc = locs[ver[hlen].id];
               locs[tloc]=hlen;
               locs[floc]=0;
               ver[0]=ver[hlen];
               ver[hlen]=tmp;
	       System.out.println("after deleting");
	       System.out.println("vertices");
	       display(ver);
	       System.out.println("locs");
	       display(locs);
               g.makeHeap(ver,locs,hlen);
	       System.out.println("after heapify");
	       display(ver);
          }
	  //display(ver);
     }

     void display(Vertex[] Arr) {
	  for (int trk = 0; trk < Arr.length; trk++) {
	       System.out.println((Arr[trk].id+1) + " "+Arr[trk].d);
	  }
     }

     void display(int[] Arr) {
	  for (int trk = 0; trk < Arr.length; trk++) {

	       System.out.println((trk+1) +" "+(Arr[trk]+1 )+ " ");
	  }
     }

}

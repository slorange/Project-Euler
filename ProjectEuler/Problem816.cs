using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Reflection;
using System.Runtime.Serialization.Formatters;

namespace ProjectEuler
{
    /*
    We create an array of points P_n in a two dimensional plane using the following random number generator:
    s_0 = 290797
    s_n+1 = s_n^2 mod 50515093
    P_n = (s_2n, s_2n+1)

    Let d(k) be the shortest distance of any two (distinct) points among P_0,...,P_k-1.
    E.g. d(14) = 546446.466846479
    Find d(2000000). Give your answer rounded to 9 places after the decimal point.
     */
	 
    class Problem816
    {
        //long n = 14;// 546446.466846479
        //long n = 30000; //644.131197816097
        long n = 2000000;
        public Problem816(long n = 2000000)
        {
            this.n = n;
            var stopwatch = Stopwatch.StartNew();
            long k = (long)Math.Sqrt(n);
            var grid = new List<Point>[k,k];
            for(long i = 0; i < k; i++)
            {
                for(long j = 0; j < k; j++)
                {
                    grid[i, j] = new List<Point>();
                }
            }

            for (long i = 0; i < n; i++)
            {
                Point p = NextP();
                long x = p.x * k / 50515093;
                long y = p.y * k / 50515093;
                grid[x, y].Add(p);
            }

            double minD = double.MaxValue;

            for (long i = 0; i < k; i++)
            {
                //Console.WriteLine(i);
                for (long j = 0; j < k; j++)
                {
                    var neighbors = new List<Point>();
                    neighbors.AddRange(grid[i, j]);
                    if(i < k-1) neighbors.AddRange(grid[i + 1, j]);
                    if (j < k - 1) neighbors.AddRange(grid[i,j+1]);
                    if (i < k - 1 && j < k - 1) neighbors.AddRange(grid[i + 1, j+1]);

                    foreach (var p1 in grid[i, j])
                    {
                        foreach(var p2 in neighbors)
                        {
                            long distance = p1.Distance(p2);
                            if (distance == 0 || distance > minD) continue;
                            minD = distance;
                            //Console.WriteLine(Math.Sqrt(minD));
                        }
                    }
                }
            }
            Console.WriteLine(Math.Sqrt(minD));
            Console.WriteLine($"done {stopwatch.ElapsedMilliseconds}");
        }

        void Brute() { 
            List<Point> points = new List<Point>();
            for (int i = 0; i < n; i++)
            {
                points.Add(NextP());
            }
            double minD = double.MaxValue;
            for (int i = 0; i < n; i++)
            {
                Point p1 = points[i];
                for(int j = 0; j < i; j++)
                {
                    long distance = p1.Distance(points[j]);
                    if (distance > minD) continue;
                    minD = distance;
                }
            }
            Console.WriteLine(Math.Sqrt(minD));
        }

        long currentS = 290797;
        long m = 50515093;
        long NextS()
        {
            long ret = currentS;
            currentS = currentS * currentS % m;
            return ret;
        }

        Point NextP()
        {
            long x = NextS();
            long y = NextS();
            return new Point(x, y);
        }

        struct Point
        {
            internal long x, y;
            internal Point(long x, long y)
            {
                this.x = x;
                this.y = y;
            }
            internal long Distance(Point p2)
            {
                long distX = x - p2.x;
                long distY = y - p2.y;
                return distX * distX + distY * distY;
            }
        }
    }
}
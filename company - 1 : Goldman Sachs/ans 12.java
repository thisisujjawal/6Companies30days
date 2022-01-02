import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution {
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int ni() { 
			return Integer.parseInt(next());
		}

		long nl() {
			return Long.parseLong(next());
		}

		double nd() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	// MAIN FUNCTION
	public static void main(String[] args) throws java.lang.Exception {
 		FastReader fr = new FastReader();
 		PrintWriter out = new PrintWriter(System.out);
 		int t = fr.ni();
		while(t-->0) {
			long n = fr.nl();
			long ans = (n*(n+1)*((2*n)+1))/6;
			out.println(ans);
			
		}
		out.close();
	}
}

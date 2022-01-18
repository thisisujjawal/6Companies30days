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
 		//I am assuming that if the string is empty then it is the least recent version
 		int t = fr.ni();
		while(t-->0) {
			String a = fr.nextLine();
			String b = fr.nextLine();
			if(a.equals(b)) {
				out.println(a);
				continue;
			}
			if(a.equals("")) {
				out.println(b);
				continue;
			}
			else if(b.equals("")) {
				out.println(a);
				continue;
			}
			int n = a.length();
			int m = b.length();
			boolean found = false;
			int i = 0 , j = 0;
			while(i < n && j < m){
				StringBuilder sb = new StringBuilder();
				while(i < n && a.charAt(i) != '.') {
					sb.append(a.charAt(i));
					i++;
				}
				i++;
				int x = Integer.valueOf(sb.toString());
				sb = new StringBuilder();
				while(j < m && b.charAt(j) != '.') {
					sb.append(b.charAt(j));
					j++;
				}
				j++;
				int y = Integer.valueOf(sb.toString());
				if(x == y)continue;
				else if(x > y) {
					found = true;
					out.println(a);
					break;
				}else {
					found = true;
					out.println(b);
					break;
				}
			}
			if(found)continue;
			else {
				if(n > m)out.println(a);
				else out.println(b);
			}
		}
		out.close();
	}
}
